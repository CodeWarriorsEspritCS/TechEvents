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
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.EvenementService;

/**
 * FXML Controller class
 *
 * @author Ciro
 */
public class ReservationController implements Initializable {

    @FXML
    private TableColumn<Evenement, String> nomeven;
    @FXML
    private TableColumn<Evenement, String> localeven;
    @FXML
    private TableColumn<Evenement, String> dateeven;
    @FXML
    private TableColumn<Evenement, Double> prixeven;
    @FXML
    private TableColumn<Evenement, String> cateven;
    @FXML
    private TableColumn<Evenement,Integer> ideven;
    @FXML
    private Button retour;
    @FXML
    private Button imprime;
    @FXML
    private TextArea desc;
    @FXML
    private TableView<Evenement> tab;
    @FXML
    private TextArea chercher;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            EvenementService se=new EvenementService();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("acceuilevenmnt.fxml"));
            Parent root = loader.load();
            ReservationController irc = loader.getController();
            //ObservableList oblist=FXCollections.observableArrayList(se.getAllEvenementbyEvenId(id));
            cateven.setCellValueFactory(new PropertyValueFactory<>("categorie"));
            dateeven.setCellValueFactory(new PropertyValueFactory<>("debutEvent"));
            localeven.setCellValueFactory(new PropertyValueFactory<>("adresseEven"));
            nomeven.setCellValueFactory(new PropertyValueFactory<>("intitule"));
            prixeven.setCellValueFactory(new PropertyValueFactory<>("prix"));
           // tab.setItems(oblist);
        } catch (IOException ex) {
            Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

     public void remplirTab() throws IOException {
        tab.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                EvenementService se = new EvenementService();

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
    }

  
          

       
        
         
        
    

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
   
}

