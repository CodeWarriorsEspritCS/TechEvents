/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import gui.StaticVars;
import entities.Evenement;
import entities.Utilisateur;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.EvenementService;

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
    private TableColumn intituleCol;
    private TableColumn dateDebutCol;
    private TableColumn dateFinCol;
    private TableColumn prixCol;
    private TableColumn adresseCol;
    public static int y;
    @FXML
    private AnchorPane btnrec;
    @FXML
    private JFXButton butrec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //firstNameCol= new TableColumn("Nom");
        intituleCol = new TableColumn("Intitule");
        dateDebutCol = new TableColumn("Debut");
        dateFinCol = new TableColumn("Fin");
        prixCol = new TableColumn("Prix");
        adresseCol = new TableColumn("Adresse");
        /*editCol = new TableColumn("Editer");
        supprimerColl = new TableColumn("Supprimer");
        detailCol = new TableColumn("Détaile");
        participerCol = new TableColumn("Participer");*/
        intituleCol.setCellValueFactory(new PropertyValueFactory("intitule"));
        dateDebutCol.setCellValueFactory(new PropertyValueFactory("debutEvent"));
        dateFinCol.setCellValueFactory(new PropertyValueFactory("finEvent"));
        prixCol.setCellValueFactory(new PropertyValueFactory("prix"));
        adresseCol.setCellValueFactory(new PropertyValueFactory("adresseEven"));
        /*editCol.setCellValueFactory(new PropertyValueFactory("btnModifier"));
       supprimerColl.setCellValueFactory(new PropertyValueFactory("btnSupprimer"));
       detailCol.setCellValueFactory(new PropertyValueFactory("btnDetailer"));
       participerCol.setCellValueFactory(new PropertyValueFactory("btnParticiper"));*/

        //EvenementListe.getColumns().addAll(intituleCol, dateDebutCol, dateFinCol, prixCol, adresseCol, editCol, supprimerColl, detailCol, participerCol);
        EvenementListe.getColumns().addAll(intituleCol, dateDebutCol, dateFinCol, prixCol, adresseCol);

        EvenementService ev = new EvenementService();
        try {
            EvenementListe.setItems(FXCollections.observableArrayList(ev.ConsulterEvenements()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void GoToAjouter(ActionEvent event) {
        try {
            StaticVars.currentUser = new Utilisateur(1);
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/AjouterEvenement.fxml"));
            Scene scene = new Scene(root);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            app_stage.setScene(scene);

            app_stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void ModifierRowSelected(ActionEvent event) {

        try {
            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/GUI/ModifierEvenement.fxml"));
            Stage stage2 = new Stage(StageStyle.TRANSPARENT);
            stage2.setScene(new Scene((AnchorPane) loader2.load()));
            Evenement selectedEvent = EvenementListe.getSelectionModel().getSelectedItem();
            ModifierEvenementController controller = loader2.<ModifierEvenementController>getController();
            controller.initData(selectedEvent);
            stage2.show();
        } catch (Exception ew) {
            System.out.println(ew.getMessage());
        }
    }

}
