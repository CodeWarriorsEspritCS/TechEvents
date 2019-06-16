package entities;

/**
 *
 * @author Linda
 */
  
public class Participer  {

    private int idPart;
    
    private int idEvent;
    
    private int idUtilisateur;
    
    private int nbParticipant;

    public Participer() {
    }

    public Participer(int idPart) {
        this.idPart = idPart;
    }

    public Participer(int idPart, int idEvent, int idUtilisateur, int nbParticipant) {
        this.idPart = idPart;
        this.idEvent = idEvent;
        this.idUtilisateur = idUtilisateur;
        this.nbParticipant = nbParticipant;
    }

    public int getIdPart() {
        return idPart;
    }

    public void setIdPart(int idPart) {
        this.idPart = idPart;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public int getNbParticipant() {
        return nbParticipant;
    }

    public void setNbParticipant(int nbParticipant) {
        this.nbParticipant = nbParticipant;
    }

   
    @Override
    public String toString() {
        return "entities.Participer_1[ idPart=" + idPart + " ]";
    }
    
}
