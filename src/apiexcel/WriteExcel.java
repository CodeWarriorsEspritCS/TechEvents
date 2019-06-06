/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiexcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Dell
 */
public class WriteExcel {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");
      Connection connect = DriverManager.getConnection( 
      "jdbc:mysql://localhost:3306/tech_events" , 
      "root" , 
      ""
      );
      Statement statement = connect.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from recommandation");
      XSSFWorkbook workbook = new XSSFWorkbook(); 
      XSSFSheet spreadsheet = workbook.createSheet("recommandation");
      XSSFRow row=spreadsheet.createRow(1);
      XSSFCell cell;
      cell=row.createCell(1);
      cell.setCellValue("idRecommandation");
      cell=row.createCell(2);
      cell.setCellValue("content");
      cell=row.createCell(3);
      cell.setCellValue("mark");
      cell=row.createCell(4);
    
      int i=2;
      while(resultSet.next())
      {
         row=spreadsheet.createRow(i);
         cell=row.createCell(1);
         cell.setCellValue(resultSet.getInt("idRec"));
         cell=row.createCell(2);
         cell.setCellValue(resultSet.getString("description"));
         cell=row.createCell(3);
         cell.setCellValue(resultSet.getString("4ote"));
         cell=row.createCell(4);
         cell.setCellValue(resultSet.getString("mail"));

         i++;
      }
      FileOutputStream out = new FileOutputStream(
      new File("recommandation.xlsx"));
      workbook.write(out);
      out.close();
      System.out.println(
      "recommandation.xlsx written successfully");
   }
    
}
