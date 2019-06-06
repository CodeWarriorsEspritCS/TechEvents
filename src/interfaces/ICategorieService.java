/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Categorieevenement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Linda
 */
public interface ICategorieService {

    public ArrayList<Categorieevenement> findAll() throws SQLException;

    public ArrayList<String> findAllLiblle() throws SQLException;

    public Categorieevenement findByIdCategorie(int id) throws SQLException;

    public Categorieevenement findByLibelle(String libelle) throws SQLException;

}
