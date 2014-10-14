package ee.ut.math.tvt.tiim_number_kaks;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IntroUI extends Application {

	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
		//Failist lugemine:
		ArrayList<String> list1 = new ArrayList<String>();
		java.io.File fail = new java.io.File("application.properties");
		Scanner sc = new Scanner(fail);
		while (sc.hasNextLine()) {
		    String rida = sc.nextLine();
		    list1.add(rida);
		}
		sc.close();
		
		for(int i = 0; i< list1.size(); i++){
	    	System.out.print(list1.get(i) + "\n");
	    } 
		    
		primaryStage.setTitle("Tiim number 2");
		Group juur = new Group();
		Text Tiim= new Text();
		Tiim.setX(10);
		Tiim.setY(20);
		Tiim.setCache(true);
        Tiim.setText(list1.get(1));
        
        Image logo = new Image(getClass().getResourceAsStream("number.png"));
        ImageView iv1 = new ImageView();
        iv1.setImage(logo);
		
		Text Juht= new Text();
		Juht.setX(10);
		Juht.setY(40);
		Juht.setCache(true);
        Juht.setText(list1.get(3));
        
		Text Juhi_email= new Text();
		Juhi_email.setX(10);
		Juhi_email.setY(60);
		Juhi_email.setCache(true);
		Juhi_email.setText(list1.get(5));
		
		Text Liikmed= new Text();
		Liikmed.setX(10);
		Liikmed.setY(80);
		Liikmed.setCache(true);
		Liikmed.setText(list1.get(7));
		
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
		HBox box = new HBox();
		box.setLayoutX(230);
        box.getChildren().add(iv1);
        juur.getChildren().add(box);        
	    primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
