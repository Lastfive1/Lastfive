import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
public class Map extends Application {
	double simonX,simonY;
	private Circle Simon;
	private Scene scene;
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		scene = new Scene(root, 500,500);
		simonX = 30;
		simonY = 30;
		scene.setFill(Color.TURQUOISE);
		Rectangle stage = new Rectangle(10,10,480,480);
		Rectangle end = new Rectangle(420,440,70,50);
		end.setFill(Color.GOLD);
		stage.setFill(Color.WHITE);
		Simon = new Circle(simonX, simonY, 15);
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
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.W)
					simonY -= 3;
				else if(event.getCode() == KeyCode.S)
					simonY += 3;
				else if(event.getCode() == KeyCode.D)
					simonX +=  +3;
				else if(event.getCode() == KeyCode.A)
					simonX -= 3;
			}
		});	
		
		AnimationTimer timer = new AnimationTimer() {
			public void handle(long arg0) {
				upDate();
			}
		};
		timer.start();
		
		primaryStage.setTitle("Anthropocene");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void upDate(){
	Simon.setCenterX(simonX);
	Simon.setCenterY(simonY);
	}
}
