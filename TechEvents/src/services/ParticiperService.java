/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import GUI.staticVars;
import entities.Categorieevenement;
import entities.Evenement;
import entities.Participer;
import entities.Utilisateur;
import interfaces.IParticiperService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import utils.BdTechEvents;

/**
 *
 * @author Linda
 */
public class ParticiperService implements IParticiperService {

    Connection cnx;
    EvenementService es = new EvenementService();
    int count = 0;

    public ParticiperService() {
        cnx = BdTechEvents.getInstance().getCnx();

    }

    @Override
    public void SinscrireEvenement(int id) throws SQLException {

        Evenement e = es.ChercherEvenementById(id);
        String req = "INSERT INTO `participer` (`idPart`, `idEvent`, `idUtilisateur`, `nbParticipant`)"
                + "VALUES (NULL, ?, ?, ?)";
        PreparedStatement pst = cnx.prepareStatement(req);
        pst.setInt(1, id);
        pst.setInt(2, staticVars.currentUser.getIdUser());
        System.out.println("*******************Participer***********************");
        String req2 = "SELECT count(*) FROM `participer` where `idEvent` like " + id;
        //PreparedStatement pst2 = cnx.prepareStatement(req2);
        //ResultSet rst = pst2.executeQuery();
        Statement st = cnx.createStatement();
        ResultSet res = st.executeQuery(req2);
        while (res.next()) {
            count = res.getInt(1);
            if (count == 0) {
                pst.setInt(3, count + 1);
            } else {
                pst.setInt(3, count);

            }

        }
        System.out.println("Number of row:" + count);
        //Evenement c = null;

        pst.executeUpdate();

    }

    @Override
    public void DésinscrireEvenement(Evenement e, Utilisateur u) throws SQLException {
    }

    public Evenement getEvenbyId(int id) throws SQLException {
        PreparedStatement pst = cnx.prepareStatement("SELECT * FROM evenement where id_event like " + id);
        System.out.println(pst);
        ResultSet rst = pst.executeQuery();
        Evenement c = null;

        while (rst.next()) {
            Date debutEvent = rst.getDate(2);
            Date finEvent = rst.getDate(3);
            String intitule = rst.getString(4);
            int nbplace = rst.getInt(5);
            int prix = rst.getInt(6);
            String description = rst.getString(7);

            String adresseEven = rst.getString(10);
            c = new Evenement(debutEvent, finEvent, intitule, nbplace, prix, description, adresseEven);
        }
        return c;
    }

    public ResultSet AfficherparEvenement(int id) throws SQLException {
        Statement st = cnx.createStatement();
        String req = "select * from participer where id=" + id;
        ResultSet rs = st.executeQuery(req);
        return rs;

    }

    public Participer AfficherparUtilisateur(int id) throws SQLException {

        PreparedStatement pst = cnx.prepareStatement("SELECT * FROM participer c WHERE c.idUtilisateur like" + id);
        ResultSet rst = pst.executeQuery();
        Participer part = null;
        while (rst.next()) {
            int idPart = rst.getInt(1);
            int idEvent = rst.getInt(2);
            int idUtilisateur = rst.getInt(3);
            int nbParticipant = rst.getInt(4);
            part = new Participer(idPart, idEvent, idUtilisateur, nbParticipant);
        }
        return part;
    }

    public ArrayList<Evenement> getAllEvenementbyEvenId(int id) throws SQLException {
        ParticiperService su = new ParticiperService();
        ArrayList<Evenement> l = new ArrayList<Evenement>();
        PreparedStatement pt = cnx.prepareStatement("select * from participer where idEvent=?");
        pt.setInt(1, id);
        ResultSet rs = pt.executeQuery();
        rs.beforeFirst();
        while (rs.next()) {
            l.add(su.getEvenbyId(rs.getInt(1)));
        }
        return l;
    }

    public void supprimerEvenement(int id) {

        try {
            PreparedStatement pt = cnx.prepareStatement("delete from participer where idEvent like " + id);
            //pt.setInt(1, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Participer> ConsulterParticiper() throws SQLException {
        PreparedStatement pst = cnx.prepareStatement("SELECT * FROM participer where idUtilisateur like " + staticVars.currentUser.getIdUser());
        System.out.println(pst);
        ResultSet rst = pst.executeQuery();
        ArrayList<Participer> listeTable = new ArrayList();
        Participer c = null;
        while (rst.next()) {
            int idPart = rst.getInt(1);
            int idEvent = rst.getInt(2);

            int idUtilisateur = rst.getInt(3);

            int nbParticipant = rst.getInt(4);

            
    


        c = new Participer(idPart, idEvent, idUtilisateur, nbParticipant);

        listeTable.add(c);

    }
    return listeTable ;
}

}
