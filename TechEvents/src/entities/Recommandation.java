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
    private String typeRec;

    public int getIdRec() {
        return idRec;
    }

    public Recommandation(String description, String typeRec) {
        this.description = description;
        this.typeRec = typeRec;
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

    public String getTypeRec() {
        return typeRec;
    }

    public void setTypeRec(String typeRec) {
        this.typeRec = typeRec;
    }
    
}
