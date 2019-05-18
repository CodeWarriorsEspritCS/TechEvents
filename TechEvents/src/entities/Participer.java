package entities;

/**
 *
 * @author Linda
 */
  
public class Participer  {

    private Integer idPart;
    
    private int idEvent;
    
    private int idUtilisateur;
    
    private int nbParticipant;

    public Participer() {
    }

    public Participer(Integer idPart) {
        this.idPart = idPart;
    }

    public Participer(Integer idPart, int idEvent, int idUtilisateur, int nbParticipant) {
        this.idPart = idPart;
        this.idEvent = idEvent;
        this.idUtilisateur = idUtilisateur;
        this.nbParticipant = nbParticipant;
    }

    public Integer getIdPart() {
        return idPart;
    }

    public void setIdPart(Integer idPart) {
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
    public int hashCode() {
        int hash = 0;
        hash += (idPart != null ? idPart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participer)) {
            return false;
        }
        Participer other = (Participer) object;
        if ((this.idPart == null && other.idPart != null) || (this.idPart != null && !this.idPart.equals(other.idPart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Participer_1[ idPart=" + idPart + " ]";
    }
    
}
