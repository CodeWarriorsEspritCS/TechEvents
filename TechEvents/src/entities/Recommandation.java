package entities;

/**
 *
 * @author Linda
 */
public class Recommandation {

    private Integer idRec;

    private String description;

    private int note;

    private int evenement;

    private int utilisateur;

    public Recommandation() {
    }

    public Recommandation(Integer idRec) {
        this.idRec = idRec;
    }

    public Recommandation(Integer idRec, String description, int note, int evenement, int utilisateur) {
        this.idRec = idRec;
        this.description = description;
        this.note = note;
        this.evenement = evenement;
        this.utilisateur = utilisateur;
    }

    public Integer getIdRec() {
        return idRec;
    }

    public void setIdRec(Integer idRec) {
        this.idRec = idRec;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getEvenement() {
        return evenement;
    }

    public void setEvenement(int evenement) {
        this.evenement = evenement;
    }

    public int getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(int utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRec != null ? idRec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recommandation)) {
            return false;
        }
        Recommandation other = (Recommandation) object;
        if ((this.idRec == null && other.idRec != null) || (this.idRec != null && !this.idRec.equals(other.idRec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Recommandation{" + "idRec=" + idRec + ", description=" + description + ", Note=" + note + ", evenement=" + evenement + ", utilisateur=" + utilisateur + '}';
    }

}
