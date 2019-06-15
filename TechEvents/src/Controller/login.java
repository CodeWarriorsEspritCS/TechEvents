package Controller;


import entities.Utilisateur;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import services.UtilisateurService;

public class login {

    public TextField ipFld;
    public TextField portFld;
    public TextField nameFld;
    public String sPort;




    public void onClickConn() throws IOException{
        ipFld.setText("localhost");
        ipFld.setDisable(true);
        ipFld.setVisible(false);
        data.ip = ipFld.getText();
        portFld.setText("10001");
        portFld.setDisable(true);
        portFld.setVisible(false);
        this.sPort = portFld.getText();
        Utilisateur user = new Utilisateur();
        int id = UtilisateurService.getInstance().getId();
        
        user = UtilisateurService.getInstance().getById(id);
        nameFld.setText(user.getPrenom());
        nameFld.setDisable(true);
        data.name = nameFld.getText();
        data.port = Integer.parseInt(sPort);

        System.out.println(data.ip + data.name + data.port);
        Stage stage;
        stage = (Stage) ipFld.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("/GUI/chatroom.fxml"));
        stage.setScene(new Scene(parent, 800  , 600));
        stage.setTitle(data.name);
        stage.show();
    }


}
