/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import services.CategorieService;
import entities.Evenement;
import services.EvenementService;

/**
 * FXML Controller class
 *
 * @author Linda
 */
public class ModifierEvenementController implements Initializable {

    @FXML
    private DatePicker dateDeb;
    @FXML
    private DatePicker dateFin;
    @FXML
    private TextArea nbPlace;
    @FXML
    private TextArea Txtprix;
    @FXML
    private TextArea txtDesc;
    @FXML
    private TextArea txtAdresse;
    @FXML
    private ComboBox<String> ListeCateg;
    CategorieService serviceCat = new CategorieService();
    List<String> catListe = new ArrayList<>();
    private ObservableList obs = FXCollections.observableArrayList();
    EvenementService service = new EvenementService();
    @FXML
    private TextArea txtIntitule;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }

    @FXML
    private void ModifierEvenements(ActionEvent event) {
    }

    @FXML
    private void RetourMenu(ActionEvent event) {
        try{
            
            //staticVars.currentUser = new Utilisateur(1);
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/ListerEvenements.fxml"));
            Scene scene = new Scene(root);
            Stage app_stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();

            app_stage2.setScene(scene);

            app_stage2.show();
        } catch (Exception ew) {
            System.out.println(ew.getMessage());
        }
    }
    void initData(Evenement e) {
        txtIntitule.setText(e.getIntitule());
              /*emptyIdproduit.setText(String.valueOf(p.getIdProduit()));
              tnom.setText(p.getNom());
              tprix.setText(String.valueOf(p.getPrix()));
              tstock.setText(p.getStock());
              combo.setValue(p.getCategorie().getId_Categorie());
              emptyimageName.setText(p.getNomImage());*/
   
              
                
     }

}
