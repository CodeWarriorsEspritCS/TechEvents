/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Recommandation;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.stage.Stage;
import services.EvenementService;
import services.RecommandationService;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author omayma
 */
public class GestionRecController implements Initializable {

    @FXML
    private ComboBox<String> combo;
    @FXML
    private Slider ss;
    @FXML
    private TextArea description;
    @FXML
    private Button ConfirmerRec;
    @FXML
    private Button annuler;
    @FXML
    private Button previous;
  private ObservableList obs = FXCollections.observableArrayList();
  EvenementService ess= new EvenementService();

  List <String> Listev = new ArrayList<>();
    @FXML
    private TextField idus;
  
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            
            Listev =ess.findAllLiblle();
            System.out.println(Listev);
            obs = FXCollections.observableArrayList(Listev);
            combo.setItems(obs);
            
            
            
            
            Image img = new Image (getClass().getResourceAsStream("previous.png"));
            previous.setGraphic(new ImageView(img));
        } catch (SQLException ex) {
            Logger.getLogger(GestionRecController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void ConfirmerRec(ActionEvent event) {
      
        try { RecommandationService rest = new RecommandationService();
              Recommandation r = new Recommandation() ;
                Utilisateur uss = new Utilisateur();
        r.setNote((int) ss.getValue());
      //   r.setIntituler(ess.ChercherEvenementByNom(combo.getValue()));
     
        r.setDescription(description.getText());
      
           rest.AjouterRecommandation(r);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       
        alert.setHeaderText("Votre Recommandation a été ajouté");
            alert.setTitle("Recommandation confirmée");
   
            alert.showAndWait();
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
    private void backpage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuPrincipale.fxml"));
            
            Parent root = loader.load();
            previous.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(GestionRecController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
     
    
}

