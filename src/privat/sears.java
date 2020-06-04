/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import privat.datas.product_data;
import privat.datas.user_data;
import privat.table.table_to_obj_matrx.user_table;

/**
 *
 * @author Dávid
 */
public class sears {
    
    public  static  void  kereses(TableView tableview, TextField filterField, ObservableList dataList){
         // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<user_data> filteredData = new FilteredList<>(dataList, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(employee -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (employee.getNev().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (employee.getCim().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (employee.getElso_talalkozo().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (employee.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (employee.getSzuletesi_ido().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (employee.getTargy().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (employee.getTars().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (employee.getTeloszam().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                else if (String.valueOf(employee.getNev()).indexOf(lowerCaseFilter)!=-1)
				   return true;
				else if (String.valueOf(employee.getCim()).indexOf(lowerCaseFilter)!=-1)
				   return true;
				else if (String.valueOf(employee.getElso_talalkozo()).indexOf(lowerCaseFilter)!=-1)
				   return true;
				else if (String.valueOf(employee.getEmail()).indexOf(lowerCaseFilter)!=-1)
				   return true;
				else if (String.valueOf(employee.getSzuletesi_ido()).indexOf(lowerCaseFilter)!=-1)
				   return true;
				else if (String.valueOf(employee.getTars()).indexOf(lowerCaseFilter)!=-1)
				   return true;
				else   if (String.valueOf(employee.getTars()).indexOf(lowerCaseFilter)!=-1)
				   return true;
                                else if (String.valueOf(employee.getTeloszam()).indexOf(lowerCaseFilter)!=-1)
				   return true;
				else  if (String.valueOf(employee.getId()).indexOf(lowerCaseFilter)!=-1)
				   return true;
				else  
                                    return false; // Does not match.
			});
                        
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<user_data> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableview.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableview.setItems(sortedData);
                
                
                
    }
    
    public  static  void  kereses_term(TableView tableview, TextField filterField, ObservableList dataList){
         // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<product_data> filteredData = new FilteredList<>(dataList, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(employee -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (employee.getNev().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} /*else if (employee.getTermek().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}*/else if (employee.getDatum().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (employee.getMikor_hivjam().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (employee.getTargy().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (employee.getMegjegyzes().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                else if (String.valueOf(employee.getNev()).indexOf(lowerCaseFilter)!=-1)
				   return true;
				else if (String.valueOf(employee.getTermek()).indexOf(lowerCaseFilter)!=-1)
				   return true;
				else if (String.valueOf(employee.getDatum()).indexOf(lowerCaseFilter)!=-1)
				   return true;
				else if (String.valueOf(employee.getMikor_hivjam()).indexOf(lowerCaseFilter)!=-1)
				   return true;
				else if (String.valueOf(employee.getTargy()).indexOf(lowerCaseFilter)!=-1)
				   return true;
				else if (String.valueOf(employee.getMegjegyzes()).indexOf(lowerCaseFilter)!=-1)
				   return true;
                                else if (String.valueOf(employee.getId()).indexOf(lowerCaseFilter)!=-1)
				   return true;
				else  
                                    return false; // Does not match.
			});
                        
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<product_data> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableview.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableview.setItems(sortedData);
                
                
                
    }
}
