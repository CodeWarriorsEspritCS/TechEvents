package Controller;

import entities.Evenement;
import services.EvenementService;
import java.net.URL;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import services.CategorieService;
import entities.Categorieevenement;
import java.sql.SQLException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Linda
 */
public class AjouterEvenementController implements Initializable {

    @FXML
    private DatePicker dateDeb;
    @FXML
    private DatePicker dateFin;
    @FXML
    private TextArea nbPlace;
    @FXML
    private TextArea Txtprix;
    @FXML
    private TextArea txtIntitule;
    @FXML
    private TextArea txtDesc;
    @FXML
    private TextArea txtAdresse;
    @FXML
    private ComboBox<String> ListeCateg;
    private ObservableList obs = FXCollections.observableArrayList();
    Categorieevenement cat = new Categorieevenement();
    CategorieService serviceCat = new CategorieService();
    List<String> catListe = new ArrayList<>();
    EvenementService evser = new EvenementService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            catListe = serviceCat.findAllLiblle();
            System.out.println(catListe);
            obs = FXCollections.observableArrayList(catListe);
            ListeCateg.setItems(obs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static String dbDateConverter(String s) {
        String year = s.substring(6);
        String month = s.substring(3, 5);
        String day = s.substring(0, 2);
        String SQLDate = year + "-" + month + "-" + day;
        return SQLDate;
    }

    private void AjouterEvenets2(ActionEvent event) throws SQLException {

        try {
            Evenement e = new Evenement();
            String dateDebS = dateDeb.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String dateFinS = dateFin.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            e.setDebutEvent(new SimpleDateFormat("yyyy-MM-dd").parse(dateDebS));
            e.setFinEvent(new SimpleDateFormat("yyyy-MM-dd").parse(dateFinS));
            e.setIntitule(txtIntitule.getText());
            e.setNombrePlaceMax(Integer.parseInt(nbPlace.getText()));
            e.setPrix(Integer.parseInt(Txtprix.getText()));
            e.setDescriptionEvent(txtDesc.getText());
            e.setCategorie(serviceCat.findByLibelle(ListeCateg.getValue()));
//            System.out.println("\n\n\n*************************************\n\n\n" + e.getCategorie());

            e.setAdresseEven(txtAdresse.getText());

            evser.AjouterEvenement(e);

            String title = "Félicitation ! ";
            String message = "Vous avez ajouté votre évènement avec succés";
            NotificationType notification = NotificationType.SUCCESS;

            TrayNotification tray = new TrayNotification();
            tray.setTitle(title);
            tray.setMessage(message);
            tray.setNotificationType(notification);
            tray.showAndWait();

        } catch (ParseException ex) {
            System.out.println("#########################################Ereur Ajout##############################################");
            System.out.println(ex.getMessage());
        }
    }

    private void RetourMenu(ActionEvent event) {
        try {

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

}
