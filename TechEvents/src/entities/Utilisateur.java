/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author Linda
 */
public class Utilisateur {

    private int idUser;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private Date dateNaissance;
    private String mobile;
    private String pseudo;
    private String pwd;
    private String role;

    public Utilisateur(String nom, String prenom, String adresse, String email, Date dateNaissance, String mobile, String pseudo, String pwd, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.mobile = mobile;
        this.pseudo = pseudo;
        this.pwd = pwd;
        this.role = role;
    }

    
    
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", email=" + email + ", dateNaissance=" + dateNaissance + ", mobile=" + mobile + ", pseudo=" + pseudo + ", pwd=" + pwd + ", role=" + role + '}';
    }

}
