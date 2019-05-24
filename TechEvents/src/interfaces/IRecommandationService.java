/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Recommandation;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Linda
 */
public interface IRecommandationService {
    
    public void AjouterRecommandation(Recommandation e) throws SQLException;

    public void ModifierRecommandation(Recommandation e) throws SQLException;

    public void SupprimerRecommandation(Recommandation e) throws SQLException;

    //Trier Par ordre alphabétique 
    public ArrayList<Recommandation> ConsulterRecommandation() throws SQLException;

    public Recommandation ChercherRecommandationById(int id) throws SQLException;

    public Recommandation ChercherRecommandationByType(String typeRec) throws SQLException;





    
}
