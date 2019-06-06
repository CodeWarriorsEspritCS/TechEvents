/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Evenement;
import entities.Utilisateur;
import interfaces.IParticiperService;
import java.sql.SQLException;

/**
 *
 * @author Linda
 */
public class ParticiperService implements IParticiperService{

    @Override
    public void SinscrireEvenement(Evenement e, Utilisateur u) throws SQLException {
    }

    @Override
    public void DésinscrireEvenement(Evenement e, Utilisateur u) throws SQLException {
    }
    
    @Override
    public void EffacerReservation(Evenement e) throws SQLException {
    }
     
    
    @Override
    public void ChercherReservation(Evenement e) throws SQLException {
    }
    
}
