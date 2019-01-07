import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
public class Map extends Application {
	double simonX,simonY;
	public static void main(String[] args) {
		launch(args);

	}

	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 500,500);
		simonX = 30;
		simonY = 30;
		scene.setFill(Color.TURQUOISE);
		Rectangle stage = new Rectangle(10,10,480,480);
		Rectangle end = new Rectangle(420,440,70,50);
		end.setFill(Color.GOLD);
		stage.setFill(Color.WHITE);
		Circle Simon = new Circle(simonX, simonY, 15);
		Simon.setFill(Color.BLACK);
		Line room1 = new Line(10,150,280,150);
		Line room1pt2 = new Line(360,150,490,150);
		Line keyroom = new Line(10,200,30,200);
		Line keyroompt2 = new Line(90,200,100,200);
		Line keyroompt3 = new Line(100,150,100,200);
		Line room2 = new Line(490,150,150,440);
		Line door = new Line(145,440,145,490);
		door.setFill(Color.GREEN);
		root.getChildren().addAll(stage,end,Simon,room1,room1pt2,keyroom,keyroompt2,keyroompt3,room2,door);
		
		
		
		primaryStage.setTitle("Anthropocene");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}