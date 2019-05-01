/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Evenement;
import interfaces.IEvenementService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Linda
 */
public class EvenementService implements IEvenementService{

    @Override
    public void AjouterEvenement(Evenement e) throws SQLException {
    }

    @Override
    public void ModifierEvenement(Evenement e) throws SQLException {
    }

    @Override
    public void SupprimerEvenement(Evenement e) throws SQLException {
    }

    @Override
    public ArrayList<Evenement> ConsulterEvenements() throws SQLException {
        return null;
    }

    @Override
    public Evenement ChercherEvenementById(int id) throws SQLException {
                return null;

    }

    @Override
    public Evenement ChercherEvenementByType(String typeEven) throws SQLException {
                return null;

    }

    @Override
    public Evenement ChercherEvenementByDate(Date dateEven) throws SQLException {
        return null;
    }

    
    
}
