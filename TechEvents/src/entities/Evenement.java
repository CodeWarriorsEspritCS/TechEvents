package entities;

import java.util.Date;

/**
 *
 * @author Linda
 */
public class Evenement {

    private int idEvent;
    private Date debutEvent;
    private Date finEvent;
    private String intitule;
    private int nombrePlaceMax;
    private int volumeHoraire ;
    private int prix;
    private String descriptionEvent;
    private Categorieevenement categorie;
    private int organisateur;
    private String adresseEven;

    public Evenement(String intitule) {
        this.intitule = intitule;
    }
   

    public Evenement(int idEvent) {
        this.idEvent = idEvent;
    }
//constructeur vide
    public Evenement() {

    }

    public Evenement(Date debutEvent, Date finEvent, String intitule, int nombrePlaceMax, Categorieevenement categorie, int prix, String descriptionEvent, int organisateur, String adresseEven) {
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
    }

    public Evenement(int idEvent,String intitule, Date debutEvent, Date finEvent,  int prix, String adresseEven) {
        this.idEvent = idEvent;
        this.debutEvent = debutEvent;
        this.finEvent = finEvent;
        this.intitule = intitule;
        this.prix = prix;
        this.adresseEven = adresseEven;
    }

    public Evenement(Date debutEvent, Date finEvent, String intitule, int nombrePlaceMax, int prix, String descriptionEvent, String adresseEven) {
        this.debutEvent = debutEvent;
        this.finEvent = finEvent;
        this.intitule = intitule;
        this.nombrePlaceMax = nombrePlaceMax;
        this.prix = prix;
        this.descriptionEvent = descriptionEvent;
        this.adresseEven = adresseEven;
    }

    public Evenement(Date debutEvent, String intitule, int prix, Categorieevenement categorie, String adresseEven) {
        this.debutEvent = debutEvent;
        this.intitule = intitule;
        this.prix = prix;
        this.categorie = categorie;
        this.adresseEven = adresseEven;
    }

    


    
    public Categorieevenement getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorieevenement categorie) {
        this.categorie = categorie;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public Date getDebutEvent() {
        return debutEvent;
    }

    public String getDateDebutStr() {

        return debutEvent.getYear() + "-" + debutEvent.getMonth() + "-" + debutEvent.getDate();
    }
public String getDateFintStr() {

        return finEvent.getYear() + "-" + finEvent.getMonth() + "-" + finEvent.getDate();
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

    public int getVolumeHoraire() {
        return volumeHoraire;
    }

    public void setVolumeHoraire(int volumeHoraire) {
        this.volumeHoraire = volumeHoraire;
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

   

    public String getAdresseEven() {
        return adresseEven;
    }

    public void setAdresseEven(String adresseEven) {
        this.adresseEven = adresseEven;
    }

    @Override
    public String toString() {
        return "Evenement{" + "idEvent=" + idEvent + ", debutEvent=" + debutEvent + ", finEvent=" + finEvent + ", intitule=" + intitule + ", nombrePlaceMax=" + nombrePlaceMax + ", prix=" + prix + ", descriptionEvent=" + descriptionEvent + ", categorie=" + categorie + ", organisateur=" + organisateur +  ", adresseEven=" + adresseEven + '}';
    }

}
