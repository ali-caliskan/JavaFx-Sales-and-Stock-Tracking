package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class anamenu2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private ImageView menu;
    
    @FXML
    private AnchorPane pane1;

    @FXML
    private AnchorPane pane2;

    @FXML
    private Button geribtn;

    @FXML
    private Button raporbtn;

    @FXML
    private Button satisbtn;

    @FXML
    private Button stokbtn;

    @FXML
    private Button uyebtn;
    @FXML
    private Button ayarlarbtn;
    
    
    @FXML
    void ayarlarclick(ActionEvent event) {
try {
    		
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("login.fxml"));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load()  );
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);	
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
            stage.setTitle("Edit Personel");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
			e.printStackTrace();
		}
    }
    @FXML
    void gericlick(ActionEvent event) {

try {
    		
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("sifremiunuttum.fxml"));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load()  );
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);	
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
            stage.setTitle("Edit Personel");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void raporclick(ActionEvent event) {
try {
    		
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("raporekrani.fxml"));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load(), 784, 620);
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
    void satisclick(ActionEvent event) {
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
    void uyeclick(ActionEvent event) {
try {
    		
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("uyeekle.fxml"));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
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
		}
    }

    @FXML
    void initialize() {
    	pane1.setVisible(false);

        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.5),pane1);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5),pane2);
        translateTransition.setByX(-600);
        translateTransition.play();

       menu.setOnMouseClicked(event -> {


            pane1.setVisible(true);

            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),pane1);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(0.15);
            fadeTransition1.play();

            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),pane2);
            translateTransition1.setByX(+600);
            translateTransition1.play();
        });

        pane1.setOnMouseClicked(event -> {



            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),pane1);
            fadeTransition1.setFromValue(0.15);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                pane1.setVisible(false);
            });


            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),pane2);
            translateTransition1.setByX(-600);
            translateTransition1.play();
        });
    }

    }


