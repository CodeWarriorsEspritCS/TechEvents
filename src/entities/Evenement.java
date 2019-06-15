package entities;

import java.util.Date;
import javafx.scene.control.Button;

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

    private Categorieevenement categorie;

    private int organisateur;

    private byte[] localisation;

    private String adresseEven;
    private Button btnModifier;
    private Button btnSupprimer;

    private Button btnParticiper;

    private Button btnDetailer;

    public Evenement(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public Evenement() {

    }

    public Evenement(String intitule) {
        this.intitule = intitule;
    }

    public Evenement(Date debutEvent, Date finEvent, String intitule, int nombrePlaceMax, Categorieevenement categorie, int prix, String descriptionEvent, int organisateur, String adresseEven) {
        this.btnModifier = new Button("Modifier");
        this.debutEvent = debutEvent;
        this.finEvent = finEvent;
        this.intitule = intitule;
        this.nombrePlaceMax = nombrePlaceMax;
        this.categorie = categorie;
        this.prix = prix;
        this.descriptionEvent = descriptionEvent;
        this.organisateur = organisateur;
        this.adresseEven = adresseEven;
    }

    public Evenement(String intitule, Date debutEvent, Date finEvent, int prix, String adresseEven) {
        this.debutEvent = debutEvent;
        this.finEvent = finEvent;
        this.intitule = intitule;
        this.prix = prix;
        this.adresseEven = adresseEven;
        /*this.btnModifier = new Button("Modifier");
        this.btnSupprimer = new Button("Supprimer");
        this.btnParticiper = new Button("Participer");
        this.btnDetailer = new Button("Détaile");*/

    }

    public Evenement(String intitule, Date debutEvent, Date finEvent, int prix, String adresseEven, Button btnModifier, Button btnSupprimer, Button btnParticiper, Button btnDetailer) {
        this.debutEvent = debutEvent;
        this.finEvent = finEvent;
        this.intitule = intitule;
        this.prix = prix;
        this.adresseEven = adresseEven;
        this.btnModifier = btnModifier;
        this.btnModifier.setText("Modifier");

        this.btnSupprimer = new Button("Supprimer");
        this.btnParticiper = new Button("Participer");
        this.btnDetailer = new Button("Détaile");

    }

    public Button getBtnModifier() {
        return btnModifier;
    }

    public void setBtnModifier(Button btnModifier) {
        this.btnModifier = btnModifier;
    }

    public Button getBtnSupprimer() {
        return btnSupprimer;
    }

    public void setBtnSupprimer(Button btnSupprimer) {
        this.btnSupprimer = btnSupprimer;
    }

    public Button getBtnParticiper() {
        return btnParticiper;
    }

    public void setBtnParticiper(Button btnParticiper) {
        this.btnParticiper = btnParticiper;
    }

    public Button getBtnDetailer() {
        return btnDetailer;
    }

    public void setBtnDetailer(Button btnDetailer) {
        this.btnDetailer = btnDetailer;
    }

    public Categorieevenement getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorieevenement categorie) {
        this.categorie = categorie;
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

    public String getDateDebutStr() {

        return debutEvent.getYear() + "-" + debutEvent.getMonth() + "-" + debutEvent.getDate();
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
        return  intitule;}

}
