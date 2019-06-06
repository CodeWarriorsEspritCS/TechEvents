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
    public void GetInstanceEvenement (int id) throws SQLException;

    public void AjouterEvenement(Evenement e) throws SQLException;

    public void ModifierEvenement(Evenement e) throws SQLException;

    public void SupprimerEvenement(Evenement e) throws SQLException;

    //Trier Par ordre alphabétique 
    public ArrayList<Evenement> ConsulterEvenements() throws SQLException;

    public Evenement ChercherEvenementById(int id) throws SQLException;

    public ArrayList<Evenement> ChercherEvenementByType(String typeEven) throws SQLException;

    public ArrayList<Evenement> ChercherEvenementByDate(Date dateEven) throws SQLException;
    
   public ArrayList<String> nomevent() throws SQLException;

}
