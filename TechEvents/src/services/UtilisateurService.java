/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Utilisateur;
import interfaces.IUtilisateurService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.BdTechEvents;



/**
 *
 * @author Linda
 */
public class UtilisateurService implements IUtilisateurService{
    
    private static UtilisateurService instance;
    private Connection connection;
    private PreparedStatement ps;
    private int id;

       public UtilisateurService() {
        connection = BdTechEvents.getInstance().getCnx();
    }

    public static UtilisateurService getInstance() {
        if (instance == null) {
            instance = new UtilisateurService();
        }
        return instance;
    }
    
    @Override
    public void ajouterUtilisateur(Utilisateur u) throws SQLException {
    }

    @Override
    public void modifierUtilisateur(Utilisateur u) throws SQLException {
    }

    @Override
    public void supprimerUtilisateur(Utilisateur u) throws SQLException {
    }

    @Override
    public ArrayList<Utilisateur> ConsulterUtilisateur() throws SQLException {
        return null ;
    }

    @Override
    public Utilisateur chercherUtilisateurById(int id) throws SQLException {
                return null ;

    }

    @Override
    public Utilisateur chercherUtilisateurByPseudo(String Pseudo) throws SQLException {
        return null ;
    }

     public Utilisateur getById(Integer id) {
    
        String req = "Select * from fos_user where id=?";
        Utilisateur user = null;
        try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                user = new Utilisateur(resultSet.getInt("idUser"),resultSet.getString("nom"),resultSet.getString("prenom"));
        //(resultSet.getInt("idUser"),resultSet.getString("nom"),resultSet.getString("prenom"));
            }
        
        }catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    
        
    }
      public int getId() {
        return id;
    }
}
