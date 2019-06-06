/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Linda
 */
public class Recommandation {

    private int idRec;
    private String description;
    private int note ;
     private String mail;
    private Evenement Intituler ;
    private Utilisateur iduserr;

    public Recommandation() {
    }

    public Recommandation(int idRec) {
        this.idRec = idRec;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Recommandation(int idRec, String description, int note, String mail, Evenement Intituler, Utilisateur iduserr) {
        this.idRec = idRec;
        this.description = description;
        this.note = note;
        this.mail = mail;
        this.Intituler = Intituler;
        this.iduserr = iduserr;
    }

    public Recommandation(int idRec, String description, int note, Evenement Intituler, Utilisateur iduserr) {
        this.idRec = idRec;
        this.description = description;
        this.note = note;
        this.Intituler = Intituler;
        this.iduserr = iduserr;
    }

    public int getIdRec() {
        return idRec;
    }

    public int getNote() {
        return note;
    }

    public Evenement getIntituler() {
        return Intituler;
    }

    public Utilisateur getIduserr() {
        return iduserr;
    }

    @Override
    public String toString() {
        return "Recommandation{" + "idRec=" + idRec + ", description=" + description + ", note=" + note + ", mail=" + mail + ", Intituler=" + Intituler + ", iduserr=" + iduserr + '}';
    }

    public Recommandation(int idRec, String description, int note, String mail) {
        this.idRec = idRec;
        this.description = description;
        this.note = note;
        this.mail = mail;
    }

   

    public Recommandation(int idRec, String description, int note) {
        this.idRec = idRec;
        this.description = description;
        this.note = note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setIntituler(Evenement Intituler) {
        this.Intituler = Intituler;
    }

    public void setIduserr(Utilisateur iduserr) {
        this.iduserr = iduserr;
    }

  
    public void setIdRec(int idRec) {
        this.idRec = idRec;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
    
}