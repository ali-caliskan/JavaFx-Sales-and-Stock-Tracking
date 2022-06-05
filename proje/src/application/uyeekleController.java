package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.Mysql.Util.VeritabaniAyarlari;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class uyeekleController {
	
	Connection connection;
	PreparedStatement statement;
	public uyeekleController() {
		connection=VeritabaniAyarlari.Connect();
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnKaydet;
    
    @FXML
    private Button cýkýs;

    @FXML
    private TextField txtisim;

    @FXML
    private TextField txtkullanii_adi;

    @FXML
    private PasswordField txtparola;

    @FXML
    private TextField txtposta;

    @FXML
    private TextField txtsoyisim;
    
    @FXML
    private CheckBox checkbox1;

    
    @FXML
    void checkbox1click(ActionEvent event) {

    }

    @FXML
    void Kaydet(ActionEvent event) {

    	ekle();
    }
    public void ekle()
    {
    	
    	if (checkbox1.isSelected()) {
			
		
    	try{
    	       
            String sql="INSERT INTO uyeler(isim,soyisim,kullanici_adi,parola,posta) VALUES (?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,txtisim.getText().trim());
            statement.setString(2,txtsoyisim.getText().trim());
            statement.setString(3,txtkullanii_adi.getText().trim());
           
            statement.setString(4,VeritabaniAyarlari.MD5Encryption(txtparola.getText()));
            statement.setString(5,txtposta.getText());
           
            statement.executeUpdate();
    }catch (SQLException exception){
    	System.out.println(exception.getMessage().toString());
    }
    	   Alert uyari=new Alert(AlertType.INFORMATION);
    	   uyari.setTitle("Kayýt Ol");
    	   uyari.setHeaderText("Baþarýyla kayýt oldunuz");
    	   uyari.showAndWait();
    	   btnKaydet.getScene().getWindow().hide();
    }
    	else {
    		Alert uyari=new Alert(AlertType.WARNING);
     	   uyari.setTitle("Satýþ Stok Otomasyonu");
     	   uyari.setHeaderText("Lutfen Sozlesmeyi kabul ediniz");
     	   uyari.showAndWait();
		}
    }

 
    @FXML
    void cýkýsclick(ActionEvent event) {
    	cýkýs.getScene().getWindow().hide();
    }
    
    

    @FXML
    void initialize() {
        

    }

}
