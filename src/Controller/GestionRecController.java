/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import com.twilio.type.PhoneNumber;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import entities.Evenement;
import entities.Recommandation;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import static java.time.temporal.TemporalAdjusters.previous;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.EvenementService;
import services.RecommandationService;
import services.UtilisateurService;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import com.teknikindustries.bulksms.SMS;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import javafx.event.EventHandler;
/**
 * FXML Controller class
 *
 * @author omayma
 */
public class GestionRecController implements Initializable {

    @FXML
    private ComboBox<String> combo;
    @FXML
    private JFXSlider ss;
    @FXML
    private TextArea description;
    @FXML
    private Button ConfirmerRec;
    @FXML
    private Button annuler;
   
  private ObservableList obs = FXCollections.observableArrayList();
  EvenementService ess= new EvenementService();

  List <String> Listev = new ArrayList<>();
    @FXML
    private JFXTextField a;
  
    @FXML
    private JFXButton buttonsms;
   
   
  
          
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            
            Listev =ess.nomevent();
            System.out.println(Listev);
            obs = FXCollections.observableArrayList(Listev);
            combo.setItems(obs);
                          
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionRecController.class.getName()).log(Level.SEVERE, null, ex);
        }
          

   
    }    

    @FXML
    private void ConfirmerRec(ActionEvent event) {
      
        try { 
            RecommandationService rest = new RecommandationService();
              Recommandation r = new Recommandation() ;
         
                r.setMail(a.getText());
        r.setNote((int) ss.getValue());
      //   r.setIntituler(ess.ChercherEvenementByNom(combo.getValue()));
     
        r.setDescription(description.getText());
      
           rest.AjouterRecommandation(r);
         
        
        String title = "Félicitation ! ";
        String message = "Vous avez ajouté votre Recommandation";
        NotificationType notification = NotificationType.SUCCESS;
        
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(notification);
        tray.showAndWait();
        
       /*  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       
        alert.setHeaderText("Votre Recommandation a été ajouté");
            alert.setTitle("Recommandation confirmée");
   
            alert.showAndWait();*/
        } catch (SQLException ex) {
            Logger.getLogger(GestionRecController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
    }

    @FXML
    private void AnnulerRec(ActionEvent event) {
  Stage stage = (Stage) annuler.getScene().getWindow();
    stage.close();
    }

 

   

  


    @FXML
    private void SendSMS(ActionEvent event) {
     SMS msg = new SMS();
     msg.SendSMS("oumayma", "tunisie2016", "Félicitation ! sore9 var  !!", "+21696808871", "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
   
    
    
    
    
    }


  
     
    
}

