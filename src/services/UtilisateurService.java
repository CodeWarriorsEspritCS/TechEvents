/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Utilisateur;
import interfaces.IUtilisateurService;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Linda
 */
public class UtilisateurService implements IUtilisateurService{

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

    
}
