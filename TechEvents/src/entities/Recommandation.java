/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Linda
 */

public class Recommandation {

    private static final long serialVersionUID = 1L;
    
    private Integer idRec;
    
    private String description;
    
    private int typeRec;
    
    private int evenement;
    
    private int utilisateur;

    public Recommandation() {
    }

    public Recommandation(Integer idRec) {
        this.idRec = idRec;
    }

    public Recommandation(Integer idRec, String description, int typeRec, int evenement, int utilisateur) {
        this.idRec = idRec;
        this.description = description;
        this.typeRec = typeRec;
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

    public int getTypeRec() {
        return typeRec;
    }

    public void setTypeRec(int typeRec) {
        this.typeRec = typeRec;
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
        return "Recommandation{" + "idRec=" + idRec + ", description=" + description + ", typeRec=" + typeRec + ", evenement=" + evenement + ", utilisateur=" + utilisateur + '}';
    }

   
    
}
