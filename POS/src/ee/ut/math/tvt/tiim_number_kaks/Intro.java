package ee.ut.math.tvt.tiim_number_kaks;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.stage.Stage;

public class Intro extends Application {

	final static IntroUI ui = new IntroUI();
	
	public void start(Stage primaryStage) throws FileNotFoundException {
		ui.start(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
