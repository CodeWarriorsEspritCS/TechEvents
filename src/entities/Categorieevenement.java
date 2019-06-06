package entities;


/**
 *
 * @author Linda
 */
  
public class Categorieevenement {

   
    private Integer idCategorie;
    
    private String libelle;

    public Categorieevenement() {
    }

    public Categorieevenement(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Categorieevenement(Integer idCategorie, String libelle) {
        this.idCategorie = idCategorie;
        this.libelle = libelle;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    
    @Override
    public String toString() {
        return "entities.Categorieevenement[ idCategorie=" + idCategorie + " ]";
    }
    
}
