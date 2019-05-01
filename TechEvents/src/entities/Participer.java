/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;

/**
 *
 * @author Linda
 */
public class Participer {

    private int idPart;
    private ArrayList<Evenement> idEvent;
    private ArrayList<Utilisateur> idUtilisateur;
    private int nbParticipant;

    public Participer(ArrayList<Evenement> idEvent, ArrayList<Utilisateur> idUtilisateur, int nbParticipant) {
        this.idEvent = idEvent;
        this.idUtilisateur = idUtilisateur;
        this.nbParticipant = nbParticipant;
    }

    public int getNbParticipant() {
        return nbParticipant;
    }

    public void setNbParticipant(int nbParticipant) {
        this.nbParticipant = nbParticipant;
    }

    
}
