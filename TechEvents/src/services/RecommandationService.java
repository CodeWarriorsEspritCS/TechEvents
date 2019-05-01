/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Recommandation;
import interfaces.IRecommandationService;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Linda
 */
public class RecommandationService implements IRecommandationService {

    @Override
    public void AjouterRecommandation(Recommandation e) throws SQLException {
    }

    @Override
    public void ModifierRecommandation(Recommandation e) throws SQLException {
    }

    @Override
    public void SupprimerRecommandation(Recommandation e) throws SQLException {
    }

    @Override
    public ArrayList<Recommandation> ConsulterRecommandation() throws SQLException {
        return null;
    }

    @Override
    public Recommandation ChercherRecommandationById(int id) throws SQLException {
        return null;
    }

    @Override
    public Recommandation ChercherRecommandationByType(String typeRec) throws SQLException {
        return null;
    }

}
