/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.staticVars;
import entities.Evenement;
import entities.Utilisateur;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.EvenementService;
import services.UtilisateurService;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Linda
 */
public class ListerEvenementsController implements Initializable {

    @FXML
    private TextArea rechrcheZone;
    @FXML
    private TableView<Evenement> EvenementListe;
    private TableColumn idCol;
    private TableColumn intituleCol;
    private TableColumn dateDebutCol;
    private TableColumn dateFinCol;
    private TableColumn prixCol;
    private TableColumn adresseCol;
    public static int y;
    EvenementService ev = new EvenementService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //firstNameCol= new TableColumn("Nom");
        //idCol = new TableColumn("ID_Evènement");
        intituleCol = new TableColumn("Intitule");
        dateDebutCol = new TableColumn("Debut");
        dateFinCol = new TableColumn("Fin");
        prixCol = new TableColumn("Prix");
        adresseCol = new TableColumn("Adresse");
        //idCol.setCellValueFactory(new PropertyValueFactory("id_event"));
        intituleCol.setCellValueFactory(new PropertyValueFactory("intitule"));
        dateDebutCol.setCellValueFactory(new PropertyValueFactory("debutEvent"));
        dateFinCol.setCellValueFactory(new PropertyValueFactory("finEvent"));
        prixCol.setCellValueFactory(new PropertyValueFactory("prix"));
        adresseCol.setCellValueFactory(new PropertyValueFactory("adresseEven"));
        //EvenementListe.getColumns().addAll(intituleCol, dateDebutCol, dateFinCol, prixCol, adresseCol, editCol, supprimerColl, detailCol, participerCol);
        EvenementListe.getColumns().addAll(intituleCol, dateDebutCol, dateFinCol, prixCol, adresseCol);

        try {
            EvenementListe.setItems(FXCollections.observableArrayList(ev.ConsulterEvenements()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void GoToAjouter(ActionEvent event) {
        try {
            staticVars.currentUser = new Utilisateur(1);
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/AjouterEvenement.fxml"));
            Scene scene = new Scene(root);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            app_stage.setScene(scene);

            app_stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void ModifierRowSelected(ActionEvent event) {

        try {
            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/GUI/ModifierEvenement.fxml"));
            Stage stage2 = new Stage(StageStyle.TRANSPARENT);
            stage2.setScene(new Scene((AnchorPane) loader2.load()));
            int idEven = EvenementListe.getSelectionModel().getSelectedItem().getIdEvent();
            Evenement selectedEvent = ev.ChercherEvenementById(idEven);
            ModifierEvenementController controller = loader2.<ModifierEvenementController>getController();
            controller.initData(idEven, selectedEvent);
            stage2.show();
        } catch (Exception ew) {
            System.out.println(ew.getMessage());
        }
    }

    @FXML
    private void SupprimerRowSelected(ActionEvent event) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Etes vous sûr de supprimer cet événement");
            alert.showAndWait();
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                // ... user chose OK
                int idEven = EvenementListe.getSelectionModel().getSelectedItem().getIdEvent();
               // evser.ModifierEvenement(idEven);
               ev.SupprimerEvenement(idEven);

                String title = "Félicitation ! ";
                String message = "Vous ne verrez pas cet événement dans votre Liste.";
                NotificationType notification = NotificationType.SUCCESS;
                TrayNotification tray = new TrayNotification();
                tray.setTitle(title);
                tray.setMessage(message);
                tray.setNotificationType(notification);
                tray.showAndWait();
            } else {
                // ... user chose CANCEL or closed the dialog
                String title = "Opss ! ";
                String message = "Votre demande est annulé";
                NotificationType notification = NotificationType.ERROR;
                TrayNotification tray = new TrayNotification();
                tray.setTitle(title);
                tray.setMessage(message);
                tray.setNotificationType(notification);
                tray.showAndWait();
            }

        } catch (Exception ew) {
            System.out.println(ew.getMessage());
        }
    }

    @FXML
    private void DetailRowSelected(ActionEvent event) {
        try {
            int idEven = EvenementListe.getSelectionModel().getSelectedItem().getIdEvent();
            Evenement selectedEvent = ev.ChercherEvenementById(idEven);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            String Date=selectedEvent.getDebutEvent().toString();
            String Titre = selectedEvent.getIntitule();
            String adresse = selectedEvent.getAdresseEven();
            String Description = selectedEvent.getDescriptionEvent();
            //String DateEvent= selectedEvent.getDebutEvent().toString();
            int Organisateur = selectedEvent.getOrganisateur();
            UtilisateurService us = new UtilisateurService();
            Utilisateur organUser=us.chercherUtilisateurById(1);
            String nomOrganisateur =organUser.getNom() ;
            String telOrganisateur =organUser.getNumTelSocieté();
            String emailOrganisateur= organUser.getEmail();

            //int idUser= selectedEvent.get
            
            alert.setTitle("Information sur l'événement");
            alert.setHeaderText(null);
            //alert.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));
            alert.setContentText("Le :"+Date+"\n "+ Titre +"\n"+ adresse 
                    + "\n \n Detail \n"
                                     +Description+"\n \n \n Pour plus d'information : "
                                     + "Organisateur : "+nomOrganisateur 
                                     + "\n Mobile :"+ telOrganisateur
                                     + "\n Email: "+emailOrganisateur);
            alert.showAndWait();
           

        } catch (Exception ew) {
            System.out.println(ew.getMessage());
        }
    }

    @FXML
    private void ParticiperRowSelected(ActionEvent event) {
    }

}
