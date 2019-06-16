package interfaces;

import entities.Evenement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Linda
 */
public interface IEvenementService {

    public void AjouterEvenement(Evenement e) throws SQLException;

    public void ModifierEvenement(int idE,Evenement e) throws SQLException;

    public void SupprimerEvenement(int idE) throws SQLException;

    //Trier Par ordre alphabétique 
    public ArrayList<Evenement> ConsulterEvenements() throws SQLException;

    public Evenement ChercherEvenementById(int id) throws SQLException;

    public ArrayList<Evenement> ChercherEvenementByType(String typeEven) throws SQLException;

    public ArrayList<Evenement> ChercherEvenementByDate(Date dateEven) throws SQLException;
    
   public ArrayList<String> nomevent() throws SQLException;


}
