package application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.Mysql.Util.VeritabaniAyarlari;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class raporekraniController {

	
	
	Connection connection;
	  
    PreparedStatement statement;
    public raporekraniController() {
		connection=VeritabaniAyarlari.Connect();
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<tablo_satis, Integer> ID;

    @FXML
    private TableColumn<tablo_satis, String> aciklama;

    @FXML
    private TableColumn<tablo_satis, Integer> adet;

    @FXML
    private TableColumn<tablo_satis, String> beden;

    @FXML
    private Button cikisbtn;

    @FXML
    private Button degerbtn;

    @FXML
    private TableColumn<tablo_satis, Integer> fiyat;

    @FXML
    private TableColumn<tablo_satis, String> kategori;

    @FXML
    private Button kullanýcýeklebtn;

    @FXML
    private TableView<tablo_satis> raportableview;

    @FXML
    private TableColumn<tablo_satis, String> renk;

    @FXML
    private Button satýsbtn;

    @FXML
    private Button stokbtn;

    @FXML
    private Label tutarlbl;

    @FXML
    private TextField tutartxf;

    @FXML
    private TableColumn<tablo_satis, String> urunadi;

    @FXML
    void cikisclick(ActionEvent event) {
    	cikisbtn.getScene().getWindow().hide();
    }

    @FXML
    void degerclick(ActionEvent event) {
    	 tablo_satis record= new tablo_satis();
 		record=(tablo_satis) raportableview.getItems().get(raportableview.getSelectionModel().getSelectedIndex());
 		toplamtutar+=record.getAdet()*record.getFiyat();
 		tutartxf.setText(String.valueOf(toplamtutar));
 		dosyayazma(record.getUrun_adi(),record.getKategori(),String.valueOf(toplamtutar));
    	 
    }
    int toplamtutar;
    
    
    public void dosyayazma(String Adi,String kategori,String toplamSatisTutari) {
    	   
    		Writer r;
			try {
				r = new FileWriter("kayýtlar.txt");
				r.write("Urun adi="+Adi+"\n");
	    		r.write("Kategori="+kategori+"\n");
	    		r.write("ToplamTutar="+toplamSatisTutari+"\n");
	    		r.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
  				
  			
  			
  			 ID.setCellValueFactory(new PropertyValueFactory<>("ID") );
			 urunadi.setCellValueFactory(new PropertyValueFactory<>("urun_adi") );
			 kategori.setCellValueFactory(new PropertyValueFactory<>("kategori") );
			 beden.setCellValueFactory(new PropertyValueFactory<>("beden") );
			 renk.setCellValueFactory(new PropertyValueFactory<>("renk") );
			 fiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat") );
			 adet.setCellValueFactory(new PropertyValueFactory<>("adet") );
			 aciklama.setCellValueFactory(new PropertyValueFactory<>("aciklama"));
			
			 
  			 
  			
			 raportableview.setItems(data);
			 
  			
  			 
  		} catch (Exception e) {
  			System.out.println(e.getMessage().toString());
  		}
  		
}

    @FXML
    void ekleclick(ActionEvent event) {

    }

    @FXML
    void satýsclick(ActionEvent event) {
try {
    		
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("satisekrani.fxml"));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load(), 921, 782);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);	
			scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setTitle("Edit Personel");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void stokclick(ActionEvent event) {
try {
    		
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("urunekleme.fxml"));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load(), 924, 700);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);	
			scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
            stage.setTitle("Edit Personel");
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
    	degerlerGetirSatis(raportableview, "select * from satis");
    }

}
