package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

import com.Mysql.Util.VeritabaniAyarlari;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
  


public class loginController {
	
	
	public loginController() {
		connection=VeritabaniAyarlari.Connect();
	}

	Connection connection;
	PreparedStatement statement;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text baslik;

    @FXML
    private Button btnGiris;

   
    @FXML
    private Button btnregister;

    @FXML
    private TextField txtkulaniciadi;

    @FXML
    private PasswordField txtparola;
    
    @FXML
    private Label lbla;

    @FXML
    private Label lblb;

    @FXML
    private Label lblsonuc;
    
    @FXML
    private TextField guvenlik;
    
    @FXML
    private ImageView cikis;
    @FXML
    private CheckBox hatýrla;
   
    
    static int a;
    static int b;
    
    public void GuvenlikSorusu() {
    	
    	Random random = new Random();
    	 a = random.nextInt(100);
         b = random.nextInt(50);
        
         lbla.setText(String.valueOf(a));
         lblb.setText(String.valueOf(b));
       
         
         
    }
    public static int sifre;
    
    public int  giris(String kulaniciadi,String parola)
    {
    	 ResultSet resultSet;
         try{
         	
        	 	String sql="select * from uyeler where kullanici_adi=? and parola=?  ";
             statement = connection.prepareStatement(sql);
             statement.setString(1,kulaniciadi);
             statement.setString(2,VeritabaniAyarlari.MD5Encryption(parola));
             
             System.out.println(parola);
             
          
             resultSet = statement.executeQuery();
            
             
             
             if(resultSet.next()) {
                 return 0;
             } else {
                 return 1;
             }
         }catch (SQLException exception){
             System.out.println(exception.getMessage().toString());
             return 1;
         }
         
    }
    public static String kullaniciadi;
    @FXML
    void hatýrlacheck(ActionEvent event) {
              
    	
    }
    
    
    
    @FXML
    void Giris(ActionEvent event) {

    	int kontrol=giris(txtkulaniciadi.getText(),(txtparola.getText().trim()));
    	if(guvenlik.getText().trim().isEmpty()){
            Alert fail= new Alert(AlertType.INFORMATION);
            fail.setHeaderText("Baþarýsýz Giriþ");
            fail.setContentText("Güvenlik Kutusu Boþ Býrakýlamaz!");
            fail.showAndWait();
        } else {
            Alert alert1 = new Alert(AlertType.INFORMATION);
            alert1.setHeaderText("Baþarýlý");
            alert1.setContentText("Güvenlik Sorusu Dolduruldu!");
            alert1.showAndWait();
            
    	System.out.println(kontrol);
    	 if (Integer.parseInt(guvenlik.getText())==(a+b) ) 
         {
 			
 		
          
    	if (kontrol==0) {
    		try{
   			 
   			 Alert alert=new Alert(AlertType.INFORMATION);
   			 String alertTitle="Satýþ Stok Otomasyonu";
   			    String alertHeader= " Baþarýyla Giriþ yaptýnýz!";
   			    alert.setContentText("Sisteme Hoþ Geldiniz.");
   	    	 alert.setTitle(alertTitle);
   	    	 alert.setHeaderText(alertHeader);
   	    	Optional<ButtonType> result= alert.showAndWait();
   	    	if (result.isPresent() && result.get()==ButtonType.OK)
   	    	{
   	    		  Parent root = FXMLLoader.load(getClass().getResource("anamenu2.fxml"));
   	                Stage stage = new Stage();
   	                Scene scene = new Scene(root);
//   	            
   	             scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
   	                stage.setScene(scene);
   	                stage.show();
   	                

   	     	    if( hatýrla.isSelected()) {
   	     	    	kullaniciadi = txtkulaniciadi.getText();
   	               }
   	                
   	                
   	    	}
   	    
              
           }catch (IOException exception) {
               System.out.println("Hata Verildi000");
               System.out.println("Error : "+exception.getMessage());
           }
           Stage stage = (Stage)btnGiris.getScene().getWindow();
           stage.close();
       } 
    	else {
    		 Alert alert=new Alert(AlertType.WARNING);
   			 String alertTitle="Lütfen Doðru Giriniz.";
   			    String alertHeader= " Þifreniz Yanlýþ!";
   	    	 alert.setTitle(alertTitle);
   	    	 alert.setHeaderText(alertHeader);
   	    	 alert.showAndWait();
       }
         }
    	 
    	 else {
    		 Alert alert=new Alert(AlertType.WARNING);
   			 String alertTitle="Lütfen Doðru Giriniz.";
   			    String alertHeader= " Guvenlik Sorusu Yanlýþ!";
   	    	 alert.setTitle(alertTitle);
   	    	 alert.setHeaderText(alertHeader);
   	    	 alert.showAndWait();
		}}
    	 
    }

    @FXML
    void registerclick(ActionEvent event) {

    	 
    try {
		
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("uyeekle.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 600);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);	
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        stage.setTitle("Edit Personel");
        stage.setScene(scene);
        stage.show();
    } catch (Exception e) {
		e.printStackTrace();
	} }

            
    

    @FXML
    void sifremiunuttum(ActionEvent event) {
    	
		}
    
    @FXML
    void cikislogin(MouseEvent event) {
    		System.exit(0);
    }
    
   

    @FXML
    void initialize() {
      //
    	TranslateTransition translate= new TranslateTransition();
    	translate.setNode(baslik);
    	translate.setDuration(Duration.millis(1000));
    	translate.setCycleCount(TranslateTransition.INDEFINITE);
    	translate.setByY(100);
    	translate.setAutoReverse(true);
    	translate.play();
    	GuvenlikSorusu();
    	txtkulaniciadi.setText(kullaniciadi);
    }

}
