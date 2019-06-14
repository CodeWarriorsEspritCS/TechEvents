/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Evenement;
import entities.Recommandation;
import entities.Utilisateur;
import gui.StaticVars;
import interfaces.IEvenementService;
import interfaces.IRecommandationService;
import interfaces.IUtilisateurService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.BdTechEvents;

/**
 *
 * @author Linda
 */
public class RecommandationService implements IRecommandationService {

    Connection cnx;

    public RecommandationService() {
        cnx = BdTechEvents.getInstance().getCnx();
    }

    @Override
    public void AjouterRecommandation(Recommandation e) throws SQLException {
        PreparedStatement pst = cnx.prepareStatement("INSERT INTO `recommandation` (`idRec`, `description`, `Note`, `id-event`,`idUser`) VALUES (NULL, ?, ?,?,?)");
        ;

        pst.setString(1, e.getDescription());
        pst.setInt(2, e.getNote());

        pst.setInt(3, StaticVars.currentEvent.getIdEvent());
        pst.setInt(4, StaticVars.currentUser.getIdUser());

        System.out.println(pst);
        pst.executeUpdate();
    }

    @Override
    public void ModifierRecommandation(Recommandation e) throws SQLException {
        PreparedStatement pst = cnx.prepareStatement(" UPDATE `recommandation` SET `Note`=?  WHERE 'idRec' = ? ");
        pst.setInt(1, e.getIdRec());
        pst.setInt(3, e.getNote());
        System.out.println(pst);
        pst.executeUpdate();
    }

    @Override
    public void SupprimerRecommandation(int idRec) throws SQLException {
        PreparedStatement pst = cnx.prepareStatement(" DELETE FROM `recommandation` where idRec= ?");
        pst.setInt(1, idRec);
        System.out.println(pst);
        pst.executeUpdate();
    }

    @Override
    public ArrayList<Recommandation> ConsulterRecommandation() throws SQLException {

        PreparedStatement pst = cnx.prepareStatement("select *  from recommandation  ");
        System.out.println(pst);
        ResultSet rst = pst.executeQuery();

        ArrayList<Recommandation> listeTable = new ArrayList();
        Recommandation u = new Recommandation();
        EvenementService i = new EvenementService();
        UtilisateurService uss = new UtilisateurService();
        while (rst.next()) {
            int id = rst.getInt(1);
            String p1 = rst.getString(3);
            int not = rst.getInt(2);
            Evenement idEvent = i.ChercherEvenementByNom(rst.getInt(4));
           
            u = new Recommandation(id, p1, not,idEvent);

            listeTable.add(u);

        }
        return listeTable;
    }

    @Override
    public ResultSet ChercherRecommandationById(int id) throws SQLException {
        Statement st = cnx.createStatement();
        String req = "select * from recommandation where idRec=" + id;
        ResultSet rs = st.executeQuery(req);
        return rs;

    }

    @Override
    public Recommandation ChercherRecommandationByType(String typeRec) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Recommandation ChercherRecommandationByNom(String Nom) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
