package entities;


/**
 *
 * @author Linda
 */
public class Organisateur extends Utilisateur {

    public Organisateur(Integer idUser, String nom, String prenom, String adresse, String email, String mobile, String pseudo, String pwd, String role, boolean recycleBin) {
        super(idUser, nom, prenom, adresse, email, mobile, pseudo, pwd, role, recycleBin);
    }
    
 
}
