package entities;

/**
 *
 * @author Linda
 */
public class Participant extends Utilisateur{

    public Participant(Integer idUser, String nom, String prenom, String adresse, String email, String mobile, String pseudo, String pwd, String role, boolean recycleBin) {
        super(idUser, nom, prenom, adresse, email, mobile, pseudo, pwd, role, recycleBin);
    }
    
    
    
}
