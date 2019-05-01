/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Linda
 */
public class Evenement {

    private int idEven;
    private String typeEven;
    private Date dateEven;
    //instance
    private int nombreMaxParticipant;

    /*
    Methode d'instance 
    public static int getNombreMaxParticipant() {
        return nombreMaxParticipant;
    }

    public static void setNombreMaxParticipant(int nombreMaxParticipant) {
        Evenement.nombreMaxParticipant = nombreMaxParticipant;
    }*/
    private String description;
    private ArrayList<Recommandation> recommandation ; 

    public Evenement(String typeEven, Date dateEven,  String description) {
        this.typeEven = typeEven;
        this.dateEven = dateEven;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Evenement{" + "typeEven=" + typeEven + ", dateEven=" + dateEven + ", description=" + description + '}';
    }

    
    public int getIdEven() {
        return idEven;
    }

    public void setIdEven(int idEven) {
        this.idEven = idEven;
    }

    public String getTypeEven() {
        return typeEven;
    }

    public void setTypeEven(String typeEven) {
        this.typeEven = typeEven;
    }

    public Date getDateEven() {
        return dateEven;
    }

    public void setDateEven(Date dateEven) {
        this.dateEven = dateEven;
    }

  

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
