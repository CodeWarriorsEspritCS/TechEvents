/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Evenement;
import entities.Utilisateur;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Linda
 */
public interface IEvenementService {

    public void AjouterEvenement(Evenement e) throws SQLException;

    public void ModifierEvenement(Evenement e) throws SQLException;

    public void SupprimerEvenement(Evenement e) throws SQLException;

    //Trier Par ordre alphabétique 
    public ArrayList<Evenement> ConsulterEvenements() throws SQLException;

    public Evenement ChercherEvenementById(int id) throws SQLException;

    public Evenement ChercherEvenementByType(String typeEven) throws SQLException;

    public Evenement ChercherEvenementByDate(Date dateEven) throws SQLException;


}
