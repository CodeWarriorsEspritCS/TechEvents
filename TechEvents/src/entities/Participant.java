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
public class Participant extends Utilisateur{
    
    public Participant(String nom, String prenom, String adresse, String email, Date dateNaissance, String mobile, String pseudo, String pwd, String role) {
        super(nom, prenom, adresse, email, dateNaissance, mobile, pseudo, pwd, role);
    }
    
}
