/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import gui.StaticVars;
import entities.Categorieevenement;
import entities.Evenement;
import interfaces.IEvenementService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.C;
import utils.BdTechEvents;

/**
 *
 * @author Linda
 */
public class EvenementService implements IEvenementService {

    Connection cnx;

    public EvenementService() {
        cnx = BdTechEvents.getInstance().getCnx();

    }

    @Override
    public void AjouterEvenement(Evenement e) throws SQLException {
        String req = "INSERT INTO `evenement` (`id_event`, `debutEvent`, `finEvent`, `intitule`, `nombrePlaceMax`, `prix`, `descriptionEvent`,"
                + " `categorie`, `organisateur`, `adresseEven`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = cnx.prepareStatement(req);
        //PreparedStatement pstSelect = cnx.prepareStatement("SELECT * FROM Categorieevenement ");

        pst.setString(1, e.getDateDebutStr());
        pst.setString(2, e.getDateDebutStr());
        pst.setString(3, e.getIntitule());
        pst.setInt(4, e.getNombrePlaceMax());
        pst.setInt(5, e.getPrix());
        pst.setString(6, e.getDescriptionEvent());
        List<Categorieevenement> listeCate = new ArrayList<>();
        Categorieevenement cat = null;
        CategorieService catService = null;
        //ResultSet rst = pstSelect.executeQuery();
        /*while (rst.next()) {
            cat = catService.findByIdCategorie(rst.getInt(8));
            listeCate.add(cat);
        }*/
        System.out.println(e.getCategorie());
        pst.setInt(7, e.getCategorie().getIdCategorie());

        pst.setInt(8, StaticVars.currentUser.getIdUser());
        pst.setString(9, e.getAdresseEven());
        pst.executeUpdate();

    }

    @Override
    public void ModifierEvenement(Evenement e) throws SQLException {
        //Evenement evnt = ChercherEvenementById(e.getIdEvent());
        String req = "UPDATE `evenement` SET `debutEvent` = ?, `finEvent` = ?, `intitule` = ?, "
                + "`nombrePlaceMax` = ?, `prix` = ?,`descriptionEvent` = ?, "
                + "`adresseEven` = ? WHERE `id_event` like"+e.getIdEvent();

        PreparedStatement pst = cnx.prepareStatement(req);
        //PreparedStatement pstSelect = cnx.prepareStatement("SELECT * FROM Categorieevenement ");

        pst.setString(1, e.getDateDebutStr());
        pst.setString(2, e.getDateDebutStr());
        pst.setString(3, e.getIntitule());
        pst.setInt(4, e.getNombrePlaceMax());
        pst.setInt(5, e.getPrix());
        pst.setString(6, e.getDescriptionEvent());
        List<Categorieevenement> listeCate = new ArrayList<>();
        Categorieevenement cat = null;
        CategorieService catService = null;
       
        System.out.println(e.getCategorie());
        pst.setInt(7, e.getCategorie().getIdCategorie());

        pst.setInt(8, StaticVars.currentUser.getIdUser());
        pst.setString(9, e.getAdresseEven());
        pst.executeUpdate();

    }
public ResultSet AfficherparEvenement(int id) throws SQLException {
        Statement st = cnx.createStatement();
        String req = "select * from participer where id=" + id;
        ResultSet rs = st.executeQuery(req);
        return rs;

    }
 public void supprimerrEvenement(int id) {

        try {
            PreparedStatement pt = cnx.prepareStatement("delete from participer where ID=?");
            pt.setInt(1, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }}
    @Override
    public void SupprimerEvenement(Evenement e) throws SQLException {
        PreparedStatement pst = cnx.prepareStatement(" DELETE FROM `evenement` WHERE `id_event` Like ? ");
         pst.setInt(1, e.getIdEvent());
        System.out.println(pst);
        pst.executeUpdate();
    }

    @Override
    public ArrayList<Evenement> ConsulterEvenements() throws SQLException {
        PreparedStatement pst = cnx.prepareStatement("SELECT * FROM Evenement ");
        System.out.println(pst);
        ResultSet rst = pst.executeQuery();
        ArrayList<Evenement> listeTable = new ArrayList();
        Evenement c = null;

        while (rst.next()) {
            int id_event = rst.getInt(1);

            Date debutEvent = rst.getDate(2);
            Date finEvent = rst.getDate(3);
            String intitule = rst.getString(4);

            int prix = rst.getInt(6);
            String adresseEven = rst.getString(10);

            c = new Evenement(intitule, debutEvent, finEvent, prix, adresseEven);

            listeTable.add(c);

        }
        return listeTable;
    }

    @Override
    public Evenement ChercherEvenementById(int id) throws SQLException {
        PreparedStatement pst = cnx.prepareStatement("SELECT * FROM evenement where idEvent like " + id);
        System.out.println(pst);
        ResultSet rst = pst.executeQuery();
        Evenement c = null;

        while (rst.next()) {
            Date debutEvent = rst.getDate(2);
            Date finEvent = rst.getDate(3);
            String intitule = rst.getString(4);

            int prix = rst.getInt(6);
            String adresseEven = rst.getString(10);
            c = new Evenement(intitule, debutEvent, finEvent, prix, adresseEven);
        }
        return c;
    }

    @Override
    public ArrayList<Evenement> ChercherEvenementByType(String typeEven) throws SQLException {
        CategorieService catService = null;

        Categorieevenement idCategorie = catService.findByLibelle(typeEven);
        PreparedStatement pst = cnx.prepareStatement("SELECT * FROM Evenement where categorie like " + idCategorie);
        ResultSet rst = pst.executeQuery();
        ArrayList<Evenement> listeTableEvent = new ArrayList();
        Evenement c = null;

        while (rst.next()) {
            int id_event = rst.getInt(1);

            Date debutEvent = rst.getDate(2);
            Date finEvent = rst.getDate(3);
            String intitule = rst.getString(4);

            int prix = rst.getInt(6);
            String adresseEven = rst.getString(10);

            c = new Evenement(intitule, debutEvent, finEvent, prix, adresseEven);

            listeTableEvent.add(c);

        }
        return listeTableEvent;
    }

    @Override
    public ArrayList<Evenement> ChercherEvenementByDate(Date dateEven) throws SQLException {
        PreparedStatement pst = cnx.prepareStatement("SELECT * FROM Evenement where debutEvent like " + dateEven);
          ResultSet rst = pst.executeQuery();
        ArrayList<Evenement> listeTableEventbydate = new ArrayList();
        Evenement c = null;

        while (rst.next()) {
            int id_event = rst.getInt(1);

            Date debutEvent = rst.getDate(2);
            Date finEvent = rst.getDate(3);
            String intitule = rst.getString(4);

            int prix = rst.getInt(6);
            String adresseEven = rst.getString(10);

            c = new Evenement(intitule, debutEvent, finEvent, prix, adresseEven);

            listeTableEventbydate.add(c);

        }
        return listeTableEventbydate;
    }

    @Override
    public void GetInstanceEvenement(int id) throws SQLException {
    }

    @Override
    public ArrayList<String> nomevent() throws SQLException {
     PreparedStatement pst = cnx.prepareStatement("SELECT * FROM evenement  ");
        System.out.println(pst);
        ResultSet rst = pst.executeQuery();
        ArrayList<String> listeTable = new ArrayList();
        Evenement c = null;

        while (rst.next()) {
           
            String libelle = rst.getString(4);
            c = new Evenement( libelle);

            listeTable.add(c.getIntitule());

        }
        return listeTable;
    }  public void Exporterpdf(int id) throws SQLException, FileNotFoundException, DocumentException, IOException {
        String r = "";
        Statement st = cnx.createStatement();
        String req = "select * from  utilisateur where id = any(select idUtilisateur from participer where idEvent = " + id + ")";
        ResultSet rs = st.executeQuery(req);
        while (rs.next()) {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("participation1.pdf"));
            document.open();
            com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance("e:\\pdf3.jpg");
            document.add(image);

            document.add(new Paragraph("", FontFactory.getFont(FontFactory.TIMES_BOLD, 20, Font.BOLD, BaseColor.BLUE)));
            document.close();
            String[] parametres = new String[]{
                "C:\\Program Files (x86)\\Adobe\\Reader 11.0\\Reader\\AcroRd32.exe",
                "participation1.pdf"
            };
            Runtime runtime = Runtime.getRuntime();

            runtime.exec(parametres);

        }

    }
    }

   

