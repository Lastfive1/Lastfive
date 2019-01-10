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
import javafx.scene.image.*;
public class Map extends Application {
	double simonX;
	double simonY;
	public Circle Simon;
	public Scene map;
	public ImageView key;
	public ImageView masterdoor;
	public ImageView trap1;
	public Boolean Key_touching;
	public Boolean door_touching;
	public Boolean Trapdeath;
	public Boolean Win_zone = false;
	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		map = new Scene(root, 500,500);
		key = new ImageView(new Image("key1.jpg"));
		masterdoor = new ImageView(new Image("door.jpg"));
		trap1 = new ImageView(new Image("sportnite.png"));
		trap1.setX(400);
		trap1.setY(100);
		key.setX(20);
		key.setY(160);
		masterdoor.setX(130);
		masterdoor.setY(442);
		simonX = 30;
		simonY = 30;
		map.setFill(Color.TURQUOISE);
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
		Line room2 = new Line(490,150,148,442);
		root.getChildren().addAll(stage,end,Simon,key,trap1,room1,room1pt2,keyroom,keyroompt2,keyroompt3,room2,masterdoor);
		map.setOnKeyPressed(new EventHandler<KeyEvent>() {
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
		primaryStage.setScene(map);
		primaryStage.show();
	}
	public void upDate(){
	Win(Win_zone,simonX,simonY);
	Simon.setCenterX(simonX);
	Simon.setCenterY(simonY);
	}
	public static void Win(Boolean Win_zone,double simonX,double simonY) {
	if(simonX >= 420 && simonY >= 440 ) {
	Win_zone = true;	
	}
	if(Win_zone == true) {
	System.out.println("Nice");
	Win_zone = false;
	}
	}
}
