/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Evenement;
import entities.Utilisateur;
import java.sql.SQLException;

/**
 *
 * @author Linda
 */
public interface IParticiperService {

    public void SinscrireEvenement(Evenement e, Utilisateur u) throws SQLException;

    public void DésinscrireEvenement(Evenement e, Utilisateur u) throws SQLException;
    
    public void EffacerReservation(Evenement e) throws SQLException;
     
    public void ChercherReservation(Evenement e) throws SQLException;
    
    
    

}
