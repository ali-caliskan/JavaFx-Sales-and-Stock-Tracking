package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.sql.*;

import com.Mysql.Util.VeritabaniAyarlari;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class sifremiunuttumController {
    
	
	Connection connection;
	  
    PreparedStatement statement;
    public sifremiunuttumController() {
		connection=VeritabaniAyarlari.Connect();
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnsifredegistir;

    @FXML
    private TextField kullaniciaditxt;

    @FXML
    private TextField sifretxt;
    
    @FXML
    private TextField yenisfiretxt;
    
    @FXML
    private ImageView cikisimage;
    
    @FXML
    private TextField sifreonay;
    
    @FXML
    private Label lbleskisifre;

    @FXML
    private Label lblkullaniciadi;

    @FXML
    private Label lblonaysifre;

    
    
    @FXML
    void cikissifre(MouseEvent event) {
    	cikisimage.getScene().getWindow().hide();
    }


    @FXML
    void degistirclick(ActionEvent event) {
     
     String  kullaniciadi,eskisifre,yenisifre;
     kullaniciadi = kullaniciaditxt.getText();
     eskisifre = VeritabaniAyarlari.MD5Encryption(sifretxt.getText());
     yenisifre = VeritabaniAyarlari.MD5Encryption( yenisfiretxt.getText());
     String yenisifre2= VeritabaniAyarlari.MD5Encryption( sifreonay.getText());
     
     String sql ="select * from uyeler where kullanici_adi=?";
     String sql1 ="update uyeler set parola=?  where kullanici_adi='"+kullaniciadi+"'";
   
     
    
     
     try {
    	 statement = connection.prepareStatement(sql);
    	 statement.setString(1, kullaniciadi);
		 ResultSet rs= statement.executeQuery();
		 
		 if(rs.next()) {
			 
			 if(rs.getString("parola").equals(eskisifre)) {
				  
				
				 
				  if(yenisifre.equals(yenisifre2)) {
					  
					  statement=connection.prepareStatement(sql1);
					  statement.setString(1, yenisifre);
					  statement.executeUpdate();
					  
					  Alert alert2=new Alert(AlertType.INFORMATION);
					  alert2.setTitle("Þifre Onay");
					  alert2.setHeaderText("Þifre Baþarýyla Deðiþtirildi.");
					  alert2.showAndWait();
				  }
				  else {
					  lblonaysifre.setText("Confirm Password Does Not Match");
					  sifreonay.requestFocus();
					  Alert alert2=new Alert(AlertType.WARNING);
					  alert2.setTitle("Þifre Onay");
					  alert2.setHeaderText("Þifre Uyuþmuyor!!.");
					  alert2.showAndWait();
					  
					  }
			 }
			 else {
				 Alert alert2=new Alert(AlertType.WARNING);
				  alert2.setTitle("Þifre Onay");
				  alert2.setHeaderText("Eski Þifre Yanlýþ!");
				  alert2.showAndWait();
				 sifretxt.requestFocus();
			 }
			 
		 }
		 else {
			 
			 kullaniciaditxt.requestFocus();
		 }
		 
	} catch (Exception e) {
		
	}
     
     
     
    }
        
    @FXML
    void initialize() {
        
    }

}
