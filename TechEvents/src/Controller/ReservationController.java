/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.itextpdf.text.DocumentException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import entities.Evenement;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.EvenementService;
import services.ParticiperService;

/**
 * FXML Controller class
 *
 * @author Ciro
 */
public class ReservationController implements Initializable {

    private TableColumn intituleCol;
    private TableColumn dateDebutCol;
    private TableColumn dateFinCol;
    private TableColumn prixCol;
    private TableColumn adresseCol;
    @FXML
    private Button retour;
    @FXML
    private Button supp;
    @FXML
    private Button imprime;
    @FXML
    private TextArea desc;
    @FXML
    private TableView<Evenement> tab;
    @FXML
    private TextArea chercher;
    EvenementService ev = new EvenementService();

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
        //idCol.setCellValueFactory(new PropertyValueFactory("id_event"));
        intituleCol.setCellValueFactory(new PropertyValueFactory("intitule"));
        dateDebutCol.setCellValueFactory(new PropertyValueFactory("debutEvent"));
        dateFinCol.setCellValueFactory(new PropertyValueFactory("finEvent"));
        prixCol.setCellValueFactory(new PropertyValueFactory("prix"));
        adresseCol.setCellValueFactory(new PropertyValueFactory("adresseEven"));
        //EvenementListe.getColumns().addAll(intituleCol, dateDebutCol, dateFinCol, prixCol, adresseCol, editCol, supprimerColl, detailCol, participerCol);
        tab.getColumns().addAll(intituleCol, dateDebutCol, dateFinCol, prixCol, adresseCol);

        try {
            tab.setItems(FXCollections.observableArrayList(ev.ConsulterEvenementsInParticiper()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

//            // tab.setItems(oblist);
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());        }
    }

    public void remplirTab() throws IOException {
        tab.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                ParticiperService se = new ParticiperService();

                try {
                    ResultSet rs = se.AfficherparEvenement(tab.getSelectionModel().getSelectedItem().getIdEvent());
                    rs.next();
                    desc.setText(rs.getString("DESCRIPTION"));
                    desc.setEditable(false);

                } catch (SQLException ex) {
                    Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    @FXML
    private void retouracceuil(ActionEvent event) {
        try {
            //FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/GUI/Reservation.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/ListerEvenements.fxml"));
            Scene scene = new Scene(root);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            app_stage.setScene(scene);

            app_stage.show();
        } catch (Exception ew) {
            System.out.println(ew.getMessage());
        }
    }

    @FXML
    private void supprimerreco(ActionEvent event) throws IOException {
        if (tab.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Avertissement");
            alert.setHeaderText("Erreur de suppression de l'événement");
            alert.setContentText("Pour avoir la possibilité d'éffacer il faut selectionner l'evenement du tableau");
            alert.showAndWait();
        } else {
            Evenement e = new Evenement();
            int s = tab.getSelectionModel().getSelectedItem().getIdEvent();
            ParticiperService se = new ParticiperService();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Faites attention");
            alert.setHeaderText("Voulez vous supprimer votre Evenement");
            alert.setContentText("Comfirmer la suppression");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                se.supprimerEvenement(s);
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Succes");
                alert2.setHeaderText(null);
                alert2.setContentText("Votre participation a été bien supprimé");
                alert2.showAndWait();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/Reservation.fxml"));
                Parent root;
                root = loader.load();
                ReservationController irc = loader.getController();
                desc.getScene().setRoot(root);
            }
        }

    }

    @FXML
    private void imprimerreco(ActionEvent event) throws SQLException, DocumentException, IOException {
        if (tab.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Avertissement");
            alert.setHeaderText("Erreur d'imprission de l'évenement");
            alert.setContentText("Pour avoir la possibilité d'imprimer votre participation il faut selectionner l'evenement du tableau");
            alert.showAndWait();
        }
        EvenementService se = new EvenementService();
        se.Exporterpdf(tab.getSelectionModel().getSelectedItem().getIdEvent());
    }

    void filterEvenement(String oldValue, String newValue) throws SQLException {
        EvenementService es = new EvenementService();
        ObservableList<Evenement> filteredList = FXCollections.observableArrayList();
        if (chercher.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            // ObservableList<Evenement> listSalle= FXCollections.observableArrayList(es.AfficherparEvenement(id));
            //  tab.setItems(listSalle) ;
        } else {

            newValue = newValue.toUpperCase();

            for (Evenement e : tab.getItems()) {

                String filtertitre = e.getIntitule();

                if (filtertitre.toUpperCase().contains(newValue)) {
                    filteredList.add(e);
                }
            }
            tab.setItems(filteredList);
        }
    }

}
