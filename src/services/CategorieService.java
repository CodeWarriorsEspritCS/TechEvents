/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Categorieevenement;
import interfaces.ICategorieService;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import utils.BdTechEvents;

/**
 *
 * @author Linda
 */
public class CategorieService implements ICategorieService {

    Connection cnx;

    public CategorieService() {
        cnx = BdTechEvents.getInstance().getCnx();
    }

    @Override
    public Categorieevenement findByIdCategorie(int id) throws SQLException {
        PreparedStatement pst = cnx.prepareStatement("SELECT c FROM Categorieevenement c WHERE c.idCategorie =" + id);
        ResultSet rst = pst.executeQuery();
        Categorieevenement CatE = null;
        while (rst.next()) {
            int id1 = rst.getInt(1);
            String libelle = rst.getString(2);
            System.out.println(id1 + " " + libelle + " ");
        }
        return CatE;
    }

    @Override
    public Categorieevenement findByLibelle(String libelle) throws SQLException {
        PreparedStatement pst = cnx.prepareStatement("SELECT * FROM Categorieevenement c WHERE c.libelle like '" + libelle + "'");
        ResultSet rst = pst.executeQuery();
        Categorieevenement catE = null;
        while (rst.next()) {
            catE = new Categorieevenement();
            int id1 = rst.getInt(1);
            String libelleC = rst.getString(2);
            
            catE.setIdCategorie(id1);
            catE.setLibelle(libelle);
            
            System.out.println(id1 + " " + libelleC + " ");
        }
        return catE;
    }

    @Override
    public ArrayList<Categorieevenement> findAll() throws SQLException {

        PreparedStatement pst = cnx.prepareStatement("SELECT * FROM Categorieevenement  ");
        System.out.println(pst);
        ResultSet rst = pst.executeQuery();
        ArrayList<Categorieevenement> listeTable = new ArrayList();
        Categorieevenement c = null;

        while (rst.next()) {
            int id1 = rst.getInt(1);
            String libelle = rst.getString(2);
            c = new Categorieevenement(id1, libelle);

            listeTable.add(c);

        }
        return listeTable;
    }

    @Override
    public ArrayList<String> findAllLiblle() throws SQLException {

        PreparedStatement pst = cnx.prepareStatement("SELECT * FROM Categorieevenement  ");
        System.out.println(pst);
        ResultSet rst = pst.executeQuery();
        ArrayList<String> listeTable = new ArrayList();
        Categorieevenement c = null;

        while (rst.next()) {
            int id1 = rst.getInt(1);
            String libelle = rst.getString(2);
            c = new Categorieevenement(id1, libelle);

            listeTable.add(c.getLibelle());

        }
        return listeTable;
    }
}
