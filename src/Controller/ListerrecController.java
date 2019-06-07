/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.fasterxml.jackson.core.format.InputAccessor.Std;
import org.apache.poi.openxml4j.opc.OPCPackage; 
import org.apache.xmlbeans.XmlOptions;
import org.dom4j.DocumentException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.Evenement;
import entities.Recommandation;
import gui.StaticVars;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import services.EvenementService;
import services.RecommandationService;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author omayma
 */
public class ListerrecController implements Initializable {

    @FXML
    private TableView<Recommandation> table;
            private TableColumn i;
      private TableColumn note;
        private TableColumn des;
        private TableColumn ma;
  
    final    ObservableList<Recommandation>tablef = FXCollections.observableArrayList();
    @FXML
    private JFXButton home;
    
    @FXML
    private JFXButton btnsupp;
    @FXML
    private JFXButton btnrep;
    @FXML
    private JFXButton excel;
    @FXML
    private JFXTextField filtr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        i= new TableColumn("idrec");
      
          note= new TableColumn("Note");
        des= new TableColumn("description");
      ma= new TableColumn("mail");

    i.setCellValueFactory(new PropertyValueFactory("idRec"));
          note.setCellValueFactory(new PropertyValueFactory("Note"));
            des.setCellValueFactory(new PropertyValueFactory("description"));
               ma.setCellValueFactory(new PropertyValueFactory("mail"));
           
          table.getColumns().addAll( i,des,note,ma);
                
                 RecommandationService us = new RecommandationService();
        try {
            table.setItems(FXCollections.observableArrayList(us.ConsulterRecommandation()));
  
        } catch (SQLException ex) {
              Logger.getLogger(Controller.ListerrecController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // TODO
    }    

 
   

    @FXML
    private void SupprimerRec(ActionEvent event) {
                        RecommandationService t2 = new RecommandationService();
         if (!table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Supprimer cette categorie");
            alert.setHeaderText("Etes vous sur de vouloir supprimer cette recommandation : " + table.getSelectionModel().getSelectedItem().getIdRec()+ " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                try {
                    Recommandation selectedP = table.getSelectionModel().getSelectedItem();
                    System.out.println(selectedP);
                    StaticVars.irecservice.
                            SupprimerRecommandation(selectedP.getIdRec());
                    table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
                          String title = "Recommandation Supprimée ! ";
            
   
        NotificationType notification = NotificationType.SUCCESS;
        
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        
        tray.setNotificationType(notification);
        tray.showAndWait();
                  
                } catch (SQLException ex) {
                    Logger.getLogger(ListerrecController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }}
    

    @FXML
    private void SendResponse(ActionEvent event) {
    }

    @FXML
    private void Gomenuu(ActionEvent event) {  try{
            
            //staticVars.currentUser = new Utilisateur(1);
            Parent root = FXMLLoader.load(getClass().getResource("/gui/MenuPrincipaleWithImageButton.fxml"));
            Scene scene = new Scene(root);
            Stage app_stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();

            app_stage2.setScene(scene);

            app_stage2.show();
        } catch (Exception ew) {
            System.out.println(ew.getMessage());
        }
    }

    @FXML
     void converttoexcel(ActionEvent event)throws ClassNotFoundException, SQLException,FileNotFoundException,  IOException {
        
        Class.forName("com.mysql.jdbc.Driver");
      Connection connect = DriverManager.getConnection( 
      "jdbc:mysql://localhost:3306/tech_events" , 
      "root" , 
      ""
      );
      Statement statement = connect.createStatement();
      ResultSet resultSet = statement
      .executeQuery("select idRec,description,Note,mail from recommandation");
     HSSFWorkbook workbook = new HSSFWorkbook(); 
     HSSFSheet spreadsheet = workbook
      .createSheet("recommandation");
      
      HSSFRow row=spreadsheet.createRow(1);
      HSSFCell cell;
      cell=row.createCell(1);
      cell.setCellValue("idRec");
      cell=row.createCell(2);
 cell.setCellValue("description");
   cell=row.createCell(3);
         cell.setCellValue("Note");
          cell=row.createCell(4);
         cell.setCellValue("mail");

      int i=2;
      while(resultSet.next())
      {
         row=spreadsheet.createRow(i);
         cell=row.createCell(1);
         cell.setCellValue(resultSet.getString("idRec"));
         cell=row.createCell(2);
         cell.setCellValue(resultSet.getString("description"));
        cell=row.createCell(3);
         cell.setCellValue(resultSet.getInt("Note"));
      cell=row.createCell(4);
         cell.setCellValue(resultSet.getString("mail"));

         i++;
      }
      FileOutputStream out = new FileOutputStream(
      new File("Listerecommandatio.xls"));
      workbook.write(out);
      out.close();
      System.out.println(
      "Listerecommandatio.xls written successfully");

     }

    @FXML
    private void chercherparmail(KeyEvent event) {
        try {
            RecommandationService us = new RecommandationService();
            FilteredList <Recommandation> f = new   FilteredList <>(FXCollections.observableArrayList(us.ConsulterRecommandation()),p->true);
            filtr.textProperty().addListener((observable, oldValue, newValue) -> {
                f.setPredicate(per->{
                    
                    if (newValue==null || newValue.isEmpty())
                    {      return true;           }
                    String h =     newValue.toLowerCase();
                    if (per.getMail().indexOf(h) != -1) {return true ;}
                    return false ;
         
                });
                SortedList <Recommandation> s = new SortedList<> (f);
                s.comparatorProperty().bind(table.comparatorProperty());
                table.setItems(s);
            });
        } catch (SQLException ex) {
            Logger.getLogger(ListerrecController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    
      
      
      
      
      
      
              
            
                   
                  
               
      
               
               
               
               
           
          
      
                
        
          
}
    

  
    

