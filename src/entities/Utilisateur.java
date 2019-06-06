/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

public class Utilisateur {

    private Integer idUser;

    private String nom;

    private String prenom;

    private String adresse;
    private String email;
    private Date dateNaissance;
    private String mobile;
    private String pseudo;
    private String pwd;
    private String role;
    private String adresseSociete;

    private String numTelSocieté;

    private Date lastLogin;

    private boolean recycleBin;

    public Utilisateur() {
    }

    public Utilisateur(Integer idUser) {
        this.idUser = idUser;
    }

    public Utilisateur(Integer idUser, String nom, String prenom, String adresse, String email, String mobile, String pseudo, String pwd, String role, boolean recycleBin) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.mobile = mobile;
        this.pseudo = pseudo;
        this.pwd = pwd;
        this.role = role;
        this.recycleBin = recycleBin;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
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

    public String getAdresseSociete() {
        return adresseSociete;
    }

    public void setAdresseSociete(String adresseSociete) {
        this.adresseSociete = adresseSociete;
    }

    public String getNumTelSocieté() {
        return numTelSocieté;
    }

    public void setNumTelSocieté(String numTelSocieté) {
        this.numTelSocieté = numTelSocieté;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean getRecycleBin() {
        return recycleBin;
    }

    public void setRecycleBin(boolean recycleBin) {
        this.recycleBin = recycleBin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", email=" + email + ", dateNaissance=" + dateNaissance + ", mobile=" + mobile + ", pseudo=" + pseudo + ", pwd=" + pwd + ", role=" + role + ", adresseSociete=" + adresseSociete + ", numTelSociet\u00e9=" + numTelSocieté + ", lastLogin=" + lastLogin + ", recycleBin=" + recycleBin + '}';
    }

    

}
