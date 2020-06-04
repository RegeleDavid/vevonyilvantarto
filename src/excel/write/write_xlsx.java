/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excel.write;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Dávid
 */
public class write_xlsx {
    
    String name;
    XSSFWorkbook workbook;
    public write_xlsx(String name) {
        this.name = name;
        workbook = new XSSFWorkbook();
    }
    
    public void ear(String name, Object[][] t) throws Exception{
         
        Sheet sheet = workbook.createSheet(name);
        int rowCount = 0;
        for (Object[] aBook : t) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            for (Object field : aBook) {
                Cell cell = row.createCell(columnCount++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            } 
        }
    }
    public void write() {
        try (FileOutputStream outputStream = new FileOutputStream(this.name+".xlsx")) {
            workbook.write(outputStream);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
