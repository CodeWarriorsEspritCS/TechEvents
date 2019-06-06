/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Evenement;
import entities.Recommandation;
import entities.Utilisateur;
import interfaces.IRecommandationService;
import services.RecommandationService;
/**
 *
 * @author omayma
 */
public class StaticVars {
   public static Utilisateur currentUser ;   
   public static Evenement currentEvent ;  
 public static IRecommandationService irecservice =new RecommandationService();
public static Recommandation currentrec ;
}
