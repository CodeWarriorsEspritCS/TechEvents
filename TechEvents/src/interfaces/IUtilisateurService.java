/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Utilisateur;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Linda
 */
public interface IUtilisateurService {

    public void ajouterUtilisateur(Utilisateur u) throws SQLException;

    public void modifierUtilisateur(Utilisateur u) throws SQLException;

    public void supprimerUtilisateur(Utilisateur u) throws SQLException;

    //Pour les superAdmin
    public ArrayList<Utilisateur> ConsulterUtilisateur() throws SQLException;

    public Utilisateur chercherUtilisateurById(int id) throws SQLException;

    public Utilisateur chercherUtilisateurByPseudo(String Pseudo) throws SQLException;

}
