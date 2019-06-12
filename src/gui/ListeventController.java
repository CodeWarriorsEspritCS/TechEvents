/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controller.GestionRecController;
import Controller.ModifierEvenementController;
import com.jfoenix.controls.JFXButton;
import entities.Evenement;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.EvenementService;

/**
 * FXML Controller class
 *
 * @author omayma
 */
public class ListeventController implements Initializable {

    @FXML
    private AnchorPane btnrec;
    @FXML
    private TableView<Evenement> tableevent;
     private TableColumn intituleCol;
    private TableColumn dateDebutCol;
    private TableColumn dateFinCol;
    private TableColumn prixCol;
    private TableColumn adresseCol;
     
    @FXML
    private Button butrec;
   
    @FXML
    private JFXButton retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
 
        intituleCol = new TableColumn("Intitule");
        dateDebutCol = new TableColumn("Debut");
        dateFinCol = new TableColumn("Fin");
        prixCol = new TableColumn("Prix");
        adresseCol = new TableColumn("Adresse");
           intituleCol.setCellValueFactory(new PropertyValueFactory("intitule"));
        dateDebutCol.setCellValueFactory(new PropertyValueFactory("debutEvent"));
        dateFinCol.setCellValueFactory(new PropertyValueFactory("finEvent"));
        prixCol.setCellValueFactory(new PropertyValueFactory("prix"));
        adresseCol.setCellValueFactory(new PropertyValueFactory("adresseEven"));
            tableevent.getColumns().addAll(intituleCol, dateDebutCol, dateFinCol, prixCol, adresseCol);

        EvenementService ev = new EvenementService();
        try {
            tableevent.setItems(FXCollections.observableArrayList(ev.ConsulterEvenements()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        // TODO

    @FXML
    private void Gorecommand(ActionEvent event) {
        
          try {if ( tableevent.getSelectionModel().getSelectedItem()!=null)
          { StaticVars.currentUser = new Utilisateur(1);
          StaticVars.currentEvent = new Evenement(1);
        
            Parent root;
              root = FXMLLoader.load(getClass().getResource("GestionRec.fxml"));
           Scene scene = new Scene(root);

            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            app_stage.setScene(scene);

            app_stage.show();}
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

   

    @FXML
    private void btnhome(ActionEvent event) {     try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuPrincipaleWithImageButton.fxml"));
            
            Parent root = loader.load();
            retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(GestionRecController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }    
    

