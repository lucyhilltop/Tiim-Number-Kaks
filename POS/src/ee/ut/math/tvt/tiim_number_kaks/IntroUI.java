package ee.ut.math.tvt.tiim_number_kaks;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IntroUI extends Application {
	
	public String getAppProps() throws IOException {
		String result = "";
		Properties prop = new Properties();
		
		InputStream inputStream = getClass().getResourceAsStream("application.properties");
		prop.load(inputStream);
		
		if (inputStream == null) {
			throw new FileNotFoundException("property file 'applications.properties' not found in the classpath");
		}
		
		String nimi = prop.getProperty("Tiim");
		String juht = prop.getProperty("Juht");
		String juhimeil = prop.getProperty("email");
		String liikmed = prop.getProperty("Liikmed");
		result = "Tiimi nimi: " + nimi + "\n" + "Tiimi juht: " + juht + "\n" + 
				"Juhi e-mail: " + juhimeil + "\n" + "Liikmed: " + liikmed;
		return result;
	}
	
	public String getVersionProps() throws IOException {
		String result = "";
		Properties prop = new Properties();
		String propFileName = "version.properties";
		
		InputStream inputStream = getClass().getResourceAsStream("version.properties");
		prop.load(inputStream);
		if (inputStream == null) {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		
		String major = prop.getProperty("build.major.number");
		String minor = prop.getProperty("build.minor.number");
		String build = prop.getProperty("build.number");
		result = major + "." + minor + "." + build;
		return result;
	}
	
	public void start(Stage primaryStage) throws IOException {
		primaryStage.setTitle("Tiim number 2");
		Group juur = new Group();
		Text Tiim= new Text();
		Tiim.setX(10);
		Tiim.setY(20);
		Tiim.setCache(true);
		IntroUI a_props = new IntroUI();
        Tiim.setText(a_props.getAppProps());
        
        Image logo = new Image(getClass().getResourceAsStream("number.png"));
        ImageView iv1 = new ImageView();
        iv1.setImage(logo);
		
		/*Text Juht= new Text();
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
		Liikmed.setText(list1.get(7));*/
		
		Text Software_version= new Text();
		Software_version.setX(10);
		Software_version.setY(100);
		Software_version.setCache(true);
		Software_version.setText(a_props.getVersionProps());
//		Software_version.setText(list2.get(list1.size()-3) + '.' + list1.get(list1.size()-1) + '.' + list1.get(lis));
		
		
		juur.getChildren().add(Tiim);
		/*juur.getChildren().add(Juht);
		juur.getChildren().add(Juhi_email);
		juur.getChildren().add(Liikmed);*/
		juur.getChildren().add(Software_version);
		
		
		primaryStage.setScene(new Scene(juur));
		HBox box = new HBox();
		box.setLayoutX(260);
        box.getChildren().add(iv1);
        juur.getChildren().add(box);        
	    primaryStage.show();
		
	}
}
