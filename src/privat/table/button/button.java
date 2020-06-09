/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.table.button;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import privat.datas.user_data;
import javafx.scene.layout.AnchorPane;
import javax.swing.Icon;
import javax.swing.filechooser.FileSystemView;
import mail.pl.mail;
import static mail.pl.mail.mailto;
import privat.insert.log_inser;
import privat.sqlite.select;
import privat.vissza_allitas.vissza_allitas_edit;

/**
 *
 * @author Dávid
 */
public class button {
    public void addButtonToTable(TableView<user_data> tableview, AnchorPane not, AnchorPane to_be, TextField nev, TextField teloszam_user_insert1,TextField email_user_insert1 
            , TextField cim_user_insert1, TextField tars_user_insert1,TextField targy_user_insert1, DatePicker elsodatum_user_inserts1, DatePicker szuletesi_ido_user_insert1, TextField id_user_insert1) {
        TableColumn<user_data, Void> colBtn = new TableColumn("Edits");

        Callback<TableColumn<user_data, Void>, TableCell<user_data, Void>> cellFactory = new Callback<TableColumn<user_data, Void>, TableCell<user_data, Void>>() {
            @Override
            public TableCell<user_data, Void> call(final TableColumn<user_data, Void> param) {
                final TableCell<user_data, Void> cell = new TableCell<user_data, Void>() {

                    Image imageOk = new Image("file:img/edit.png");
                    
                    private final Button btn = new Button("", new ImageView(imageOk));

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            user_data data = getTableView().getItems().get(getIndex());
                            //System.out.println("selectedData: " + data.getV());
                            id_user_insert1.setText(String.valueOf(data.getId()));
                            nev.setText(data.getNev());
                            teloszam_user_insert1.setText(data.getTeloszam());
                            email_user_insert1.setText(data.getEmail()); ;
                            cim_user_insert1.setText(data.getCim());
                            tars_user_insert1.setText(data.getTars());
                            targy_user_insert1.setText(data.getTargy());
                            
                            nev.setOpacity(0.3);
                            teloszam_user_insert1.setOpacity(0.3);
                            email_user_insert1.setOpacity(0.3);
                            cim_user_insert1.setOpacity(0.3);
                            tars_user_insert1.setOpacity(0.3);
                            targy_user_insert1.setOpacity(0.3);
                            
                            new vissza_allitas_edit().user_add(nev, email_user_insert1, cim_user_insert1, tars_user_insert1, teloszam_user_insert1, szuletesi_ido_user_insert1, elsodatum_user_inserts1, targy_user_insert1);

                            
                            String[] a;
                            try {
                                a=data.getSzuletesi_ido().split("-");
                                System.out.println(a[0]);
                                szuletesi_ido_user_insert1.setValue(LocalDate.of(Integer.valueOf(a[0]), Integer.valueOf(a[1]), Integer.valueOf(a[2])));
                                szuletesi_ido_user_insert1.setOpacity(0.3);
                            } catch (Exception e) {
                            }
                           
                            a=data.getElso_talalkozo().split("-");
                            elsodatum_user_inserts1.setValue(LocalDate.of(Integer.valueOf(a[0]), Integer.valueOf(a[1]), Integer.valueOf(a[2])));
                            elsodatum_user_inserts1.setOpacity(0.3);
                            not.setVisible(false);
                            to_be.setVisible(true);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        tableview.getColumns().add(colBtn);

    }

     public void addButtonProducts(TableView<user_data> tableview, AnchorPane not, AnchorPane to_be, Label nev, Label id_user_insert1, DatePicker add_term_datum) {
        TableColumn<user_data, Void> colBtn = new TableColumn("Product(s)");

        Callback<TableColumn<user_data, Void>, TableCell<user_data, Void>> cellFactory = new Callback<TableColumn<user_data, Void>, TableCell<user_data, Void>>() {
            @Override
            public TableCell<user_data, Void> call(final TableColumn<user_data, Void> param) {
                final TableCell<user_data, Void> cell = new TableCell<user_data, Void>() {
                    
                    Image imageOk = new Image("file:img/edit.png");
                    
                    private final Button btn = new Button("+");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            user_data data = getTableView().getItems().get(getIndex());
                            //System.out.println("selectedData: " + data.getV());
                            id_user_insert1.setText(String.valueOf(data.getId()));
                            nev.setText(data.getNev());
                            add_term_datum.setValue(LocalDate.now());
                            not.setVisible(false);
                            to_be.setVisible(true);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                cell.setId("my_cell");
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        tableview.getColumns().add(colBtn);

    }
     public void addButtonMail(TableView<user_data> tableview) {
        TableColumn<user_data, Void> colBtn = new TableColumn("E-mail");
        
        Callback<TableColumn<user_data, Void>, TableCell<user_data, Void>> cellFactory = new Callback<TableColumn<user_data, Void>, TableCell<user_data, Void>>() {
            @Override
            public TableCell<user_data, Void> call(final TableColumn<user_data, Void> param) {
                final TableCell<user_data, Void> cell = new TableCell<user_data, Void>() {
                    Image imageOk = new Image("file:img/mail.png");
                    
                    private final Button btn = new Button("", new ImageView(imageOk));
                    

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            user_data data = getTableView().getItems().get(getIndex());
                            try {
                                new log_inser(data.getNev(), data.getEmail()).insert();
                                
                                mailto(Arrays.asList(data.getEmail()), "","");
                            } catch (IOException ex) {
                                Logger.getLogger(button.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (URISyntaxException ex) {
                                Logger.getLogger(button.class.getName()).log(Level.SEVERE, null, ex);
                            }catch(Exception e){
                                System.err.println(e.getMessage());
                            }
                            
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                cell.setId("my_cell");
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        tableview.getColumns().add(colBtn);

    }

}
