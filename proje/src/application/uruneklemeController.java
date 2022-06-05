package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import com.Mysql.Util.VeritabaniAyarlari;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class uruneklemeController {
	
	Connection connection;
	  
    PreparedStatement statement;
    public uruneklemeController() {
    	connection=VeritabaniAyarlari.Connect();
    	}

    @FXML
    private TableColumn<tablo_urunler, Integer> ID;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<tablo_urunler, String> aciklama;

    @FXML
    private TextArea aciklamatxt;

    @FXML
    private TableColumn<tablo_urunler, Integer> adet;

    @FXML
    private TextField adettxt;

    @FXML
    private Button arabtn;

    @FXML
    private TableColumn<tablo_urunler, String> beden;

    @FXML
    private TextField bedentxt;

    @FXML
    private TextField filtreletxt;

    @FXML
    private TableColumn<tablo_urunler, Integer> fiyat;

    @FXML
    private TextField fiyattxt;

    @FXML
    private Button guncellebtn;

    @FXML
    private TableColumn<tablo_urunler, String> kategori;

    @FXML
    private TextField kategoritxt;

    @FXML
    private TableColumn<tablo_urunler, String> renk;

    @FXML
    private TextField renktxt;

    @FXML
    private Button silbtn;

    @FXML
    private TableColumn<tablo_urunler, String> urunadi;

    @FXML
    private TextField urunaditxt;

    @FXML
    private TableView<tablo_urunler> tableview;
    @FXML
    private Button uruneklebtn;
    
    @FXML
    private Button cikis;

    @FXML
    void araclick(ActionEvent event) {
    	ara();
    }

    @FXML
    void guncelleclick(ActionEvent event) {
    	guncelle(urunaditxt.getText(), kategoritxt.getText(), bedentxt.getText(), renktxt.getText(), Integer.parseInt( fiyattxt.getText()), Integer.parseInt( adettxt.getText()), aciklamatxt.getText());
    	degerlerGetir(tableview, "select * from urunler");
    }

    @FXML
    void silclick(ActionEvent event) {
    	sil();
    	degerlerGetir(tableview, "select * from urunler");
    }

    @FXML
    void urunekleclick(ActionEvent event) {
    	ekle();
    	degerlerGetir(tableview, "select * from urunler");
    }
   public void sil() {
	   Alert uyari=new Alert(AlertType.CONFIRMATION);
	   uyari.setTitle("Ürünü Silmek Üzeresiniz!");
	   uyari.setHeaderText("Ürünü Silmek Ýstiyor Musunuz ?");
	    
	   Optional<ButtonType> result= uyari.showAndWait();
	   	if (result.isPresent() && result.get()==ButtonType.OK)
	   	{
	   	  tablo_urunler record= new tablo_urunler();
			record=(tablo_urunler) tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
	   	String sql="delete from urunler where ID=? ";
	   	try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1,record.getID());
				statement.executeUpdate();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	   	
	   	}
	   	
	 
   }
   public void ara() {
	   String sql="select * from urunler where urun_adi like '%"+filtreletxt.getText()+ "%' or kategori like+	'%"+filtreletxt.getText()+ "%' ";
	   degerlerGetir(tableview, sql);
   }
   public void ekle() {
	   try{
	       
           String sql="INSERT INTO urunler(urun_adi,kategori,beden,renk,fiyat,adet,aciklama) VALUES (?,?,?,?,?,?,?)";
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
   	   uyari.setTitle("Ürün Ekliyorsunuz!");
   	   uyari.setHeaderText("Ürün Baþarýyla Eklendi.");
   	   uyari.showAndWait();
   	   
   }
   public void guncelle(String urun_adi,String kategori,String beden,String renk,int fiyat , int adet,String aciklama) {
	   
	   tablo_urunler record= new tablo_urunler();
		record=(tablo_urunler) tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
   	
        try{
           
            String sql = "UPDATE  `urunler` SET "
           		 + "`urun_adi`=?,"
           		 + "`kategori`=?,"
           		 + "`beden`=?,"
           		 + "`renk`=?,"
           		 + "`fiyat`=?,"
           		 + "`adet`=?,"
           		 + "`aciklama`=? WHERE ID = '"+record.getID()+"'";
            	
            statement = connection.prepareStatement(sql);
            statement.setString(1,urun_adi);
            statement.setString(2,kategori);
            statement.setString(3,beden);
            statement.setString(4,renk);
            statement.setInt(5,fiyat);
            statement.setInt(6,adet); 
            statement.setString(7,aciklama);
            
            System.out.println(record);
           
            statement.executeUpdate();
            
        }catch (SQLException exception){
            System.out.println(exception.getMessage().toString());
        }
        Alert uyari=new Alert(AlertType.INFORMATION);
    	   uyari.setTitle("Ürünü Güncelliyorsunuz!");
    	   uyari.setHeaderText("Ürün Baþarýyla Güncellendi.");
    	   uyari.showAndWait();
	   
   }
   public void temizle() {
	   urunaditxt.clear();
	   kategoritxt.clear();
	   bedentxt.clear();
	   renktxt.clear();
	   fiyattxt.clear();
	   adettxt.clear();
	   aciklamatxt.clear();
	   
   }
   public void degerlerGetir(TableView tablo,String sql) {
	   ObservableList<tablo_urunler> veri=FXCollections.observableArrayList();
		try {
			 statement = connection.prepareStatement(sql);
			 ResultSet rs=statement.executeQuery();
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
			 ID.setCellValueFactory(new PropertyValueFactory<>("ID") );
			 urunadi.setCellValueFactory(new PropertyValueFactory<>("urun_adi") );
			 kategori.setCellValueFactory(new PropertyValueFactory<>("kategori") );
			 beden.setCellValueFactory(new PropertyValueFactory<>("beden") );
			 renk.setCellValueFactory(new PropertyValueFactory<>("renk") );
			 fiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat") );
			 adet.setCellValueFactory(new PropertyValueFactory<>("adet") );
			 aciklama.setCellValueFactory(new PropertyValueFactory<>("aciklama"));
			
			 tableview.setItems(veri);
			 
			 
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
   }
   public void textDoldur() {
		
   	tableview.setOnMouseClicked((MouseEvent event) -> {
           if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
               tablo_urunler record= new tablo_urunler();
       		record=(tablo_urunler) tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
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
   
   @FXML
   void cikisclick(ActionEvent event) {
//	   cikis yapma 
   cikis.getScene().getWindow().hide();
   }

    @FXML
    void initialize() {
      degerlerGetir(tableview, "select * from urunler");
      textDoldur();
      
      uruneklebtn.setTooltip(new Tooltip("Ürün Ekle"));
      Tooltip tip=new Tooltip();
      Tooltip tip1=new Tooltip();
      tip1.setText("Ürün Silmek Üzeresiniz");
      silbtn.setTooltip(tip1);
      tip.setText("Ürün Güncelleme  ");
      guncellebtn.setTooltip(tip);
    }

}
