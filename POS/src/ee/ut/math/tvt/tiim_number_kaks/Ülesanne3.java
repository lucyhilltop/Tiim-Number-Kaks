package ee.ut.math.tvt.tiim_number_kaks;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Ülesanne3 extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Eesti lipp");
		Group juur = new Group();
		Canvas canvas = new Canvas(300,250);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		 drawShapes(gc);
		 juur.getChildren().add(canvas);
	     primaryStage.setScene(new Scene(juur));
	     primaryStage.show();
	}

	private void drawShapes(GraphicsContext gc) {
		gc.setStroke(Color.BLUE);
		gc.setLineWidth(50);
		gc.strokeLine(40, 40, 200, 40);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(50);
		gc.strokeLine(40, 90, 200, 90);
		
		// LIPU JALG
		gc.setLineWidth(10);
		gc.strokeLine(10,15, 10, 300);
		// JOONED LIPU ÜMBER
		gc.setLineWidth(6);
		gc.strokeLine(10, 13, 225, 13);
		gc.strokeLine(225, 13, 225, 165);
		gc.strokeLine(10, 165, 225, 165);
		// E TÄHT
		gc.strokeLine(30, 180, 70, 180);
		gc.strokeLine(30, 180, 30, 240);
		gc.strokeLine(30, 210, 50, 210);
		gc.strokeLine(30, 240, 70, 240);
		// E TÄHT
		gc.strokeLine(90, 180, 130, 180);
		gc.strokeLine(90, 180, 90, 240);
		gc.strokeLine(90, 210, 120, 210);
		gc.strokeLine(90, 240, 130, 240);
		// S TÄHT
		gc.strokeArc(150, 180, 30, 30, 20, 240, ArcType.OPEN);
		gc.strokeArc(150, 210, 30, 30, -150, 240, ArcType.OPEN);
		
		// T TÄHT
		gc.strokeLine(190, 180,  240, 180);
		gc.strokeLine(215, 180, 215, 240);
		
		// I TÄHT
		gc.strokeLine(260, 180, 260, 240);
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
