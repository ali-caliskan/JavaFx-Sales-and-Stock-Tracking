package application;

import java.net.IDN;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.Mysql.Util.VeritabaniAyarlari;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class satisekraniController {
	Connection connection;
	  
    PreparedStatement statement;
    public satisekraniController() {
		connection=VeritabaniAyarlari.Connect();
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<tablo_urunler, String> aciklama;

    @FXML
    private TextField aciklamatxt;

    @FXML
    private TableColumn<tablo_urunler, Integer> adet;

    @FXML
    private TableColumn<tablo_satis, Integer> satýsid;
    @FXML
    private TableColumn<tablo_satis, Integer> satisadet;

    @FXML
    private TableColumn<tablo_satis, String> satisbeden;

    @FXML
    private TableColumn<tablo_satis, Integer> satisfiyat;

    @FXML
    private TableColumn<tablo_satis, String> satiskategori;

    @FXML
    private TableColumn<tablo_satis, String> satisrenk;

    @FXML
    private TableColumn<tablo_satis, String> satýsaciklama;
    
    @FXML
    private TableColumn<tablo_satis, String> satýsurunadi;
    @FXML
    private TextField adettxt;

   

    @FXML
    private TextField bedentxt;

    

    @FXML
    private TextField fiyattxt;

   

    @FXML
    private TextField kategoritxt;

    

    @FXML
    private TextField renktxt;

    @FXML
    private Button satýsarabtn;

    @FXML
    private TextField satýsaratxt;

    @FXML
    private Button satýsbtnn;

    @FXML
    private TableView<tablo_satis> satýstableview;

    @FXML
    private Button stokarabtn;

    @FXML
    private TextField stokaratxt;

    @FXML
    private TableView<tablo_urunler> stoktableview;
    
    @FXML
    private TableColumn<tablo_urunler, String> stokbeden;

    @FXML
    private TableColumn<tablo_urunler, Integer> stokfiyat;

    @FXML
    private TableColumn<tablo_urunler, String> stokkategori;

    @FXML
    private TableColumn<tablo_urunler, String> stokrenk;

    @FXML
    private TableColumn<tablo_urunler, String> stokurunadi;

    @FXML
    private TableColumn<tablo_urunler, Integer> stokýd;
    
    @FXML
    private TableColumn<tablo_urunler, String> stokaciklama;

    @FXML
    private TableColumn<tablo_urunler, Integer> stokadet;
   
    @FXML
    private TextField urunaditxt;
    
    @FXML
    private Button cikisbtn;


    @FXML
    void cikisclick(ActionEvent event) {
    	cikisbtn.getScene().getWindow().hide();
    }

    @FXML
    void clicksatýs(ActionEvent event) {
    	ekle();
    	degerlerGetir(satýstableview, "select * from urunler");
    }

    @FXML
    void satýsaraclick(ActionEvent event) {
    	 String sql="select * from satis where urun_adi like '%"+satýsaratxt.getText()+ "%' or kategori like+	'%"+satýsaratxt.getText()+ "%' ";
  	   degerlerGetirSatis(satýstableview, sql);
    }

    @FXML
    void stokaraclick(ActionEvent event) {
    	 String sql="select * from urunler where urun_adi like '%"+stokaratxt.getText()+ "%' or kategori like+	'%"+stokaratxt.getText()+ "%' ";
  	   degerlerGetir(stoktableview, sql);
    }
    public void degerlerGetir(TableView tablo,String sql) {
 	   ObservableList<tablo_urunler> veri=FXCollections.observableArrayList();
 	  
 		try {
 			 statement = connection.prepareStatement(sql);
 			 ResultSet rs= statement.executeQuery();
 			 while (rs.next()) {
 				 veri.add(new tablo_urunler(
 						 rs.getInt("ID"),
 						 rs.getString("urun_adi"),
 						 rs.getString("kategori"),
 						 rs.getString("beden"),
 						 rs.getString("renk"),
 						 rs.getInt("fiyat"),
 						 rs.getInt("adet"),
 						 rs.getString("aciklama")
 						 ));
 				
 				
 			}
 			 stokýd.setCellValueFactory(new PropertyValueFactory<>("ID") );
 			 stokurunadi.setCellValueFactory(new PropertyValueFactory<>("urun_adi") );
 			 stokkategori.setCellValueFactory(new PropertyValueFactory<>("kategori") );
 			 stokbeden.setCellValueFactory(new PropertyValueFactory<>("beden") );
 			 stokrenk.setCellValueFactory(new PropertyValueFactory<>("renk") );
 			 stokfiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat") );
 			 stokadet.setCellValueFactory(new PropertyValueFactory<>("adet") );
 			 stokaciklama.setCellValueFactory(new PropertyValueFactory<>("aciklama"));
 			 
 			
 			 
 			
 			stoktableview.setItems(veri);
 			
 			 
 		} catch (Exception e) {
 			System.out.println(e.getMessage().toString());
 		}
    }
    public void degerlerGetirSatis(TableView tableview,String sql) {
    	 ObservableList<tablo_satis> data=FXCollections.observableArrayList();
   	   
   		try {
   			 statement = connection.prepareStatement(sql);
   			 ResultSet rs= statement.executeQuery();
   			 while (rs.next()) {
   				data.add(new tablo_satis(
   						 rs.getInt("ID"),
   						 rs.getString("urun_adi"),
   						 rs.getString("kategori"),
   						 rs.getString("beden"),
   						 rs.getString("renk"),
   						 rs.getInt("fiyat"),
   						 rs.getInt("adet"),
   						 rs.getString("aciklama")
   						 ));
   				
   				
   			}
   			 satýsid.setCellValueFactory(new PropertyValueFactory<>("ID") );
			 satýsurunadi.setCellValueFactory(new PropertyValueFactory<>("urun_adi") );
			 satiskategori.setCellValueFactory(new PropertyValueFactory<>("kategori") );
			 satisbeden.setCellValueFactory(new PropertyValueFactory<>("beden") );
			 satisrenk.setCellValueFactory(new PropertyValueFactory<>("renk") );
			 satisfiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat") );
			 satisadet.setCellValueFactory(new PropertyValueFactory<>("adet") );
			 satýsaciklama.setCellValueFactory(new PropertyValueFactory<>("aciklama"));
			 
   			 
   			
   			 
   			
   			satýstableview.setItems(data);
   			
   			 
   		} catch (Exception e) {
   			System.out.println(e.getMessage().toString());
   		}
    }

    public void textDoldur() {
		
    	stoktableview.setOnMouseClicked((MouseEvent event) -> {
               if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                   tablo_urunler record= new tablo_urunler();
           		record=(tablo_urunler) stoktableview.getItems().get(stoktableview.getSelectionModel().getSelectedIndex());
           		adettxt.setText(String.valueOf(record.getAdet()));
           		fiyattxt.setText(String.valueOf(record.getFiyat()));
           		urunaditxt.setText((record.getUrun_adi()));
           		kategoritxt.setText(String.valueOf(record.getKategori()));
           		bedentxt.setText(String.valueOf(record.getBeden()));
           		aciklamatxt.setText(String.valueOf(record.getAciklama()));
           		renktxt.setText(String.valueOf(record.getRenk()));
               }
           });
       }
 
       
 
 public void ekle() {
	   try{
	       
         String sql="INSERT INTO satis(urun_adi,kategori,beden,renk,fiyat,adet,aciklama) VALUES (?,?,?,?,?,?,?)";
         statement = connection.prepareStatement(sql);
         statement.setString(1,urunaditxt.getText());
         statement.setString(2,kategoritxt.getText());
         statement.setString(3,bedentxt.getText());
         statement.setString(4,renktxt.getText());
         statement.setString(5,fiyattxt.getText());
         statement.setString(6,adettxt.getText());
         statement.setString(7,aciklamatxt.getText());
         
        
        
         statement.executeUpdate();
 }catch (SQLException exception){
 	System.out.println(exception.getMessage().toString());
 }
 	   Alert uyari=new Alert(AlertType.INFORMATION);
 	   uyari.setTitle("Satýþ Stok Otomasyonu");
 	   uyari.setHeaderText("Ürün Baþarýyla Satýldý.");
 	   uyari.showAndWait();
 	  tablo_urunler record= new tablo_urunler();
		record=(tablo_urunler) stoktableview.getItems().get(stoktableview.getSelectionModel().getSelectedIndex());
 	String sql="delete from urunler where ID=? ";
 	try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1,record.getID());
			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
 	degerlerGetir(stoktableview, "select * from  urunler");
 	degerlerGetirSatis(satýstableview, "select * from  satis");
 	   
 }
    @FXML
    void initialize() {
//    	degerlerGetir(satýstableview, "select * from urunler");
    	 degerlerGetir(stoktableview, "select * from urunler");
    	 degerlerGetirSatis(satýstableview, "select * from satis");

        textDoldur();
        

    }

}
