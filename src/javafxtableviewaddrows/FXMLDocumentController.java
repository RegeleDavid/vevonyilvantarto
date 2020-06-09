/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtableviewaddrows;


import java.awt.Insets;
import java.awt.Panel;
import privat.sears;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Callback;
import javax.swing.BorderFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import privat.sears;
import privat.sqlite.*;
import privat.insert.*;
import privat.datas.user_data;
import privat.table.button.*;
import excel.arraylist_to_obj_matrix.user_excel;
import excel.write.write_xlsx;
import java.io.File;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import privat.alert.alert;
import privat.datas.log_email;
import privat.datas.product_data;
import privat.mkdir.mkdir_folder;
import privat.table.builder.produst_bulider;
import privat.table.table_to_obj_matrx.user_table;
import privat.vbox.right_vbox;
import privat.vissza_allitas.vissza_allitas;
import privat.vissza_allitas.vissza_allitas_edit;
/**
 *
 * @author Cool IT Help
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private Label label, add_term_nev, add_term_id;
    @FXML public TextField filterField,filterField1,
            //user add
            nev_user_insert ,teloszam_user_insert, email_user_insert 
            ,cim_user_insert, 
            tars_user_insert, targy_user_insert,
            //edit user
            nev_user_insert1 ,teloszam_user_insert1, email_user_insert1 
            ,cim_user_insert1, 
            tars_user_insert1, targy_user_insert1, id_user_insert1,
            //add term
            add_term_targy
            ;
    @FXML private TextArea add_term_megyjegyzes;
    @FXML private DatePicker elsodatum_user_inserts, szuletesi_ido_user_insert,elsodatum_user_inserts1, szuletesi_ido_user_insert1, add_term_datum, add_term_mikor_hivjam;
    @FXML private TableView<user_data> tableview;
    @FXML private TableView<product_data> tableview1 ;
    @FXML private TableColumn<user_data, Integer> id_user;
    @FXML private TableColumn<user_data, String> empName, email, szul_nap, cim, elso_talalka, empEmail,tars,targy ;
    @FXML private TableColumn<product_data, String> nev_term1  , termek_term1, datum_term1, mikor_hivjam_term1,targy_term1, megjegyzes_term1 ;
    @FXML private TableColumn<product_data, Integer> id_term1;
    @FXML private ImageView img_foot, vissza_img_1;
    @FXML private  Circle circol_foot_1;
    @FXML private Pane panel_user_select;
    @FXML private AnchorPane anc_selct_user, anc_add_user, anc_add_term,anc_user_edit, anc_term_select, anc_beallitas;
    @FXML private VBox vbox, term_select_most;
    @FXML
    private AnchorPane anc_log;
       @FXML
    private TableColumn<log_email, String> LogEmailDatum;

    @FXML
    private TableColumn<log_email, String> LogEmailNev;

    @FXML
    private TableColumn<log_email, Integer> LogEmailId;

    @FXML
    private TableView<log_email> LogEmailTable;

    @FXML
    private TableColumn<log_email, String> LogEmailEmail;

   ;
    
    private  TextField[] newField=new TextField[10];
    private  ArrayList<TextField> input=new ArrayList<>();
    private  int input_text=0;
    //observalble list to store data
    private final ObservableList<user_data> dataList = FXCollections.observableArrayList();
    private ObservableList<product_data> dataList_tem = FXCollections.observableArrayList();
    private ObservableList<log_email> dataList_log_email = FXCollections.observableArrayList();

    private  String letoltes=new mkdir_folder().dectopnew_mkdir_new_folder("vevonyilvantarto");
    
    
    @FXML
    private void ButtonUserAbba(ActionEvent event) throws Exception {
        select_user();
               
    }
    @FXML
    private void ButtonBeallitas(ActionEvent event) throws Exception {
        
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File(new mkdir_folder().asztal()));
        File f=directoryChooser.showDialog(null);
        if(null!=f){
            new Delete().letoltes();
            new Insert().letoltes_inser(f.getPath());
            
        }
    }
    @FXML
    private void BuutonChooret(ActionEvent event) throws Exception {
           
    }
    @FXML
    private void ButtonVissza1(ActionEvent event) throws Exception {
        visible_not();
        anc_selct_user.setVisible(true);
    }
    @FXML
    private void ButtonLog(ActionEvent event) {
        System.out.println("log");
        visible_not();
        LogEmailId.setCellValueFactory(new PropertyValueFactory<>("id"));
        LogEmailNev.setCellValueFactory(new PropertyValueFactory<>("nev")); 
        LogEmailDatum.setCellValueFactory(new PropertyValueFactory<>("datum")); 
        LogEmailEmail.setCellValueFactory(new PropertyValueFactory<>("email")); 
        dataList_log_email.clear();
        try {
            ResultSet rs=new select().select_email();
            while (rs.next()) {                
                dataList_log_email.add(new log_email(rs.getInt("id"), rs.getString("nev"), rs.getString("Email"),rs.getString("datetime")));
            }
            rs.close();
            LogEmailTable.setItems(dataList_log_email);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        anc_log.setVisible(true);
    }
    @FXML
    private void ButtonUserEditEditable(ActionEvent event) throws Exception {
        editeable_write();
        System.out.println("asd");
    }
    @FXML
    private void ButtonTermTabla(ActionEvent event) throws Exception {
        visible_not();
        anc_term_select.setVisible(true);
        product_builder();
        sears.kereses_term(tableview1, filterField1, dataList_tem);

    }
    
    @FXML
    private void ButtonUserAbb(ActionEvent event) throws Exception {
        visible_not();
        new vissza_allitas().user_add(nev_user_insert, email_user_insert,  cim_user_insert,   tars_user_insert,  teloszam_user_insert, szuletesi_ido_user_insert, elsodatum_user_inserts,targy_user_insert);
        anc_add_user.setVisible(true);   
        
    }
    @FXML
    private void ButtonProdAbb(ActionEvent event) throws Exception {
        visible_not();
        anc_add_term.setVisible(true);
        
        
    }
    
    @FXML
    private void ButtonTermAdd(ActionEvent event) throws Exception {
        array_add();
    }
    @FXML
    private void start(ActionEvent event) throws Exception {
        System.out.println("siker");
    }
    
    
    @FXML
    private void ButtonTermSelect(ActionEvent event) throws Exception {
        new term_inser(add_term_datum, add_term_mikor_hivjam, add_term_targy, add_term_id, add_term_megyjegyzes, input).insert();
        array_clear();     
        //ResultSet rs=new select().select_term_name();
        
        
        right();
    }
    
    @FXML
    private void ButtonUserInsert(ActionEvent event) throws Exception {
        new user_insert(nev_user_insert, cim_user_insert, tars_user_insert, targy_user_insert, teloszam_user_insert, email_user_insert, szuletesi_ido_user_insert, elsodatum_user_inserts).insert();
        //new select().select_user();
    }
    @FXML
    private void ButtonUserExcel(ActionEvent event) throws Exception {
        letoltes_select();
        user_excel u=new user_excel(dataList);
        Object[][] t=u.user_obj();
        write_xlsx w_x=new write_xlsx(new mkdir_folder().root_new_folder(letoltes, "vevonyilvantarto")+"/asd");
        w_x.ear("excel_1", t);
        w_x.write();
        new alert().excel();
        
    }
    
    @FXML
    private void ButtonUserExcel_1(ActionEvent event) throws Exception {
        letoltes_select();
        user_excel u=new user_excel(dataList);
        write_xlsx w_x=new write_xlsx(new mkdir_folder().root_new_folder(letoltes, "vevonyilvantarto")+"/asd");
        w_x.ear("excel_2", new user_table(tableview).sout_matrx());
        w_x.write();
        new user_table(tableview).sout_matrx();
        new alert().excel();
    }
    
    @FXML
    private void ButtonUserUpdate(ActionEvent event) throws Exception {
//        user_insert u_i=new user_insert(nev_user_insert, cim_user_insert, tars_user_insert, targy_user_insert, teloszam_user_insert, email_user_insert, szuletesi_ido_user_insert, elsodatum_user_inserts);
//        u_i.insert();
//        new select().select_user();
        user_update u_u=new user_update(nev_user_insert1, cim_user_insert1, tars_user_insert1, targy_user_insert1, teloszam_user_insert1,email_user_insert1, id_user_insert1, elsodatum_user_inserts1, szuletesi_ido_user_insert1);
        u_u.insert();
        System.out.println("qwe");
        editeable_write_not();
        //new vissza_allitas_edit().user_add(nev_user_insert1, email_user_insert1,  cim_user_insert1,   tars_user_insert1,  teloszam_user_insert1, szuletesi_ido_user_insert1, elsodatum_user_inserts1,targy_user_insert1);
        
        if(u_u.getTo_be_install()){
            new vissza_allitas_edit().user_add(nev_user_insert1, email_user_insert1, cim_user_insert1, tars_user_insert1, teloszam_user_insert1, szuletesi_ido_user_insert1, elsodatum_user_inserts1, targy_user_insert1);
            select_user();
        }
        
        
               
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        try {
            new Create().teremt();
        } catch (Exception e) {
             new alert().db(e);
        }
        
        new  button().addButtonToTable(tableview, anc_selct_user, anc_user_edit, nev_user_insert1,teloszam_user_insert1, email_user_insert1 ,cim_user_insert1, tars_user_insert1, targy_user_insert1,elsodatum_user_inserts1, szuletesi_ido_user_insert1, id_user_insert1);
        new button().addButtonProducts(tableview,anc_selct_user, anc_add_term, add_term_nev, add_term_id, add_term_datum);
        new button().addButtonMail(tableview);
        visible_not();
        
        
        right();
        letoltes_select();
        
        Image img=new Image("file:img/elitnyit.jpg");
        circol_foot_1.setFill(new ImagePattern(img));
        img=new Image("file:img/back.png");
        vissza_img_1.setImage(img);
     
        
        
    }
    void letoltes_select(){
        try {
            ResultSet rs=new select().letoltes();
            while (rs.next()) {                
                
                letoltes=rs.getString("szoveg");
            }
        } catch (Exception e) {
            new alert().db(e);
        }
    }
    void visible_not(){
        anc_selct_user.setVisible(false);
        anc_add_user.setVisible(false);
        anc_add_term.setVisible(false);
        anc_user_edit.setVisible(false);
        anc_term_select.setVisible(false);
        anc_beallitas.setVisible(false);
        anc_log.setVisible(false);
    }
    
    void  db() throws Exception{
        
        Create cre=new Create();
        cre.teremt();
        Insert ins=new Insert();
        ins.beszuras();
        select sel=new select();
        System.out.println(sel.valasz());
    }
    void  array_clear(){
        try {
            for (TextField textField : input) {
            vbox.getChildren().remove(textField);
        }
        input=null;
        input=new ArrayList<>();
        input_text=0;
        } catch (Exception e) {
            System.err.println("array");
        }
        
    }
    void  array_add(){
        Font font = new Font("SansSerif", 20);
        TextField a = new TextField();
        a.setFont(font);
        a.setStyle("margin: 10 20 10 20");
        
        input.add(a);
        vbox.getChildren().add(input.get(input_text));
        input_text++;
    }
    
    private void product_builder() throws Exception{
        id_term1.setCellValueFactory(new PropertyValueFactory<>("id"));       
        nev_term1.setCellValueFactory(new PropertyValueFactory<>("nev"));
        termek_term1.setCellValueFactory(new PropertyValueFactory<>("termek")); 
        datum_term1.setCellValueFactory(new PropertyValueFactory<>("datum")); 
        mikor_hivjam_term1.setCellValueFactory(new PropertyValueFactory<>("mikor_hivjam"));
        targy_term1.setCellValueFactory(new PropertyValueFactory<>("targy"));
        megjegyzes_term1.setCellValueFactory(new PropertyValueFactory<>("megjegyzes"));
        dataList_tem=new produst_bulider().table();
       
	
        
    }
    
    private void  user_builder(){
        id_user.setCellValueFactory(new PropertyValueFactory<>("id"));       
        empName.setCellValueFactory(new PropertyValueFactory<>("nev"));        
        empEmail.setCellValueFactory(new PropertyValueFactory<>("teloszam"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));        
        tars.setCellValueFactory(new PropertyValueFactory<>("tars"));
        szul_nap.setCellValueFactory(new PropertyValueFactory<>("szuletesi_ido"));
        cim.setCellValueFactory(new PropertyValueFactory<>("cim"));
        elso_talalka.setCellValueFactory(new PropertyValueFactory<>("elso_talalkozo"));
        targy.setCellValueFactory(new PropertyValueFactory<>("targy"));
        dataList.clear();
        try {
            select s=new select();
            ResultSet rs=s.select_user();
            while (rs.next()) {
                user_data user=new user_data( rs.getInt("id"),rs.getString("nev"), rs.getString("teloszam"), rs.getString("email"), rs.getString("tars"), rs.getString("szuletes_ido"), rs.getString("cim"), rs.getString("elso_tallkozas_datuma"), rs.getString("targy"));
                dataList.add(user);
            }
            System.out.println(dataList.size());
            rs.close();
            
        } catch (Exception e) {
            System.err.println(e.getMessage()); 
        } 
       
    }
    void  editeable_write(){
        nev_user_insert1.setEditable(true);
        teloszam_user_insert1.setEditable(true);
        email_user_insert1.setEditable(true); 
        cim_user_insert1.setEditable(true);
        tars_user_insert1.setEditable(true); 
        targy_user_insert1.setEditable(true);
        elsodatum_user_inserts1.setEditable(true);
        szuletesi_ido_user_insert1.setEditable(true);
        
        nev_user_insert1.setOpacity(1);
        teloszam_user_insert1.setOpacity(1);
        email_user_insert1.setOpacity(1);
        cim_user_insert1.setOpacity(1);
        tars_user_insert1.setOpacity(1);
        targy_user_insert1.setOpacity(1);
        elsodatum_user_inserts1.setOpacity(1);
        szuletesi_ido_user_insert1.setOpacity(1);
        
    }
    void  editeable_write_not(){
        nev_user_insert1.setEditable(false);
        teloszam_user_insert1.setEditable(false);
        email_user_insert1.setEditable(false); 
        cim_user_insert1.setEditable(false);
        tars_user_insert1.setEditable(false); 
        targy_user_insert1.setEditable(false);
        elsodatum_user_inserts1.setEditable(false);
        szuletesi_ido_user_insert1.setEditable(false);
        
    }
    
    void select_user(){
        user_builder();
        sears.kereses(tableview, filterField, dataList);
        
        //tableview.setItems(dataList);
        visible_not();
        anc_selct_user.setVisible(true);   
    }
    
    void right(){
        term_select_most.getChildren().removeAll(term_select_most.getChildren());
        try {
            new right_vbox(term_select_most).select();
        } catch (Exception e) {
            
        }
    }
    
    
}
