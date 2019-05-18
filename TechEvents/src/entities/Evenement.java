package entities;

import java.util.Date;

/**
 *
 * @author Linda
 */

public class Evenement {

    
    private Integer idEvent;
    
    private Date debutEvent;
    
    private Date finEvent;
    
    private String intitule;
    
    private int nombrePlaceMax;
  
    private int prix;
   
    private String descriptionEvent;
   
    private int categorie;
  
    private int organisateur;
    
    private byte[] localisation;
    
    private String adresseEven;

    public Evenement() {
    }

    public Evenement(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public Evenement(Integer idEvent, Date debutEvent, Date finEvent, String intitule, int nombrePlaceMax, int prix, String descriptionEvent, int categorie, int organisateur, byte[] localisation, String adresseEven) {
        this.idEvent = idEvent;
        this.debutEvent = debutEvent;
        this.finEvent = finEvent;
        this.intitule = intitule;
        this.nombrePlaceMax = nombrePlaceMax;
        this.prix = prix;
        this.descriptionEvent = descriptionEvent;
        this.categorie = categorie;
        this.organisateur = organisateur;
        this.localisation = localisation;
        this.adresseEven = adresseEven;
    }

    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public Date getDebutEvent() {
        return debutEvent;
    }

    public void setDebutEvent(Date debutEvent) {
        this.debutEvent = debutEvent;
    }

    public Date getFinEvent() {
        return finEvent;
    }

    public void setFinEvent(Date finEvent) {
        this.finEvent = finEvent;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getNombrePlaceMax() {
        return nombrePlaceMax;
    }

    public void setNombrePlaceMax(int nombrePlaceMax) {
        this.nombrePlaceMax = nombrePlaceMax;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getDescriptionEvent() {
        return descriptionEvent;
    }

    public void setDescriptionEvent(String descriptionEvent) {
        this.descriptionEvent = descriptionEvent;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public int getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(int organisateur) {
        this.organisateur = organisateur;
    }

    public byte[] getLocalisation() {
        return localisation;
    }

    public void setLocalisation(byte[] localisation) {
        this.localisation = localisation;
    }

    public String getAdresseEven() {
        return adresseEven;
    }

    public void setAdresseEven(String adresseEven) {
        this.adresseEven = adresseEven;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvent != null ? idEvent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evenement)) {
            return false;
        }
        Evenement other = (Evenement) object;
        if ((this.idEvent == null && other.idEvent != null) || (this.idEvent != null && !this.idEvent.equals(other.idEvent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evenement{" + "idEvent=" + idEvent + ", debutEvent=" + debutEvent + ", finEvent=" + finEvent + ", intitule=" + intitule + ", nombrePlaceMax=" + nombrePlaceMax + ", prix=" + prix + ", descriptionEvent=" + descriptionEvent + ", categorie=" + categorie + ", organisateur=" + organisateur + ", localisation=" + localisation + ", adresseEven=" + adresseEven + '}';
    }

   
    
}
