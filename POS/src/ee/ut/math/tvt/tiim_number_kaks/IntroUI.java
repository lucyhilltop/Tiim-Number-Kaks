package ee.ut.math.tvt.tiim_number_kaks;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IntroUI extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Tiim number 2");
		Group juur = new Group();
		Text Tiim= new Text();
		Tiim.setX(10);
		Tiim.setY(20);
		Tiim.setCache(true);
        Tiim.setText("Tiim Number 2");
        
        Image logo = new Image("ee.ut.math.tvt.tiim_number_kaks/number 2.png");
        Rectangle kastl=new Rectangle(0, 400, 550, 125);
		kastl.setFill(new ImagePattern(logo, 0, 0, 1,1, true));
		Rectangle kasts=new Rectangle(0, 525, 550, 125);
		kasts.setFill(new ImagePattern(logo, 0, 0, 1,1, true));
		
		Text Juht= new Text();
		Juht.setX(10);
		Juht.setY(40);
		Juht.setCache(true);
        Juht.setText("Silver Pajum�e");
        
		Text Juhi_email= new Text();
		Juhi_email.setX(10);
		Juhi_email.setY(60);
		Juhi_email.setCache(true);
		Juhi_email.setText("silverpajumae@hotmail.com");
		
		Text Liikmed= new Text();
		Liikmed.setX(10);
		Liikmed.setY(80);
		Liikmed.setCache(true);
		Liikmed.setText("Liis M�eots, Mikk Tark, Silver Pajum�e");
		
		Text Software_version= new Text();
		Software_version.setX(10);
		Software_version.setY(100);
		Software_version.setCache(true);
		Software_version.setText("0.0.0");
		
		
		juur.getChildren().add(Tiim);
		juur.getChildren().add(Juht);
		juur.getChildren().add(Juhi_email);
		juur.getChildren().add(Liikmed);
		juur.getChildren().add(Software_version);
		
		
		primaryStage.setScene(new Scene(juur));
	    primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
