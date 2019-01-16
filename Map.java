import javafx.application.Application;
import javafx.animation.AnimationTimer;
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
	private Circle Simon;
	private Scene map;
	private ImageView key;
	private ImageView masterdoor;
	private ImageView trap1;
	private Boolean Key_touching = false;
	private Boolean door_passing = false;
	private Boolean Trapdeath;
	private Boolean Win_zone = false;
	private Group root;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		root = new Group();
		map = new Scene(root, 500, 500);
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
		Rectangle stage = new Rectangle(10, 10, 480, 480);
		Rectangle end = new Rectangle(420, 440, 70, 50);
		end.setFill(Color.GOLD);
		stage.setFill(Color.WHITE);
		Simon = new Circle(simonX, simonY, 15);
		Simon.setFill(Color.BLACK);
		Line room1 = new Line(10, 150, 280, 150);
		Line room1pt2 = new Line(360, 150, 490, 150);
		Line keyroom = new Line(10, 200, 30, 200);
		Line keyroompt2 = new Line(90, 200, 100, 200);
		Line keyroompt3 = new Line(100, 150, 100, 200);
		Line room2 = new Line(490, 150, 148, 442);
		root.getChildren().addAll(stage, end, Simon, trap1, key, room1, room1pt2, keyroom, keyroompt2, keyroompt3,
				room2, masterdoor);

		map.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.W)
					simonY -= 3;
				else if (event.getCode() == KeyCode.S)
					simonY += 3;
				else if (event.getCode() == KeyCode.D)
					simonX += +3;
				else if (event.getCode() == KeyCode.A)
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

	public void upDate() {
		Simon.setCenterX(simonX);
		Simon.setCenterY(simonY);
		Win(simonX, simonY);
		Keyroom(simonX, simonY);
		Trap(simonX,simonY);
	}

	public void Win(double simonX, double simonY) {
		if (!Win_zone)
			if (simonX >= 420 && simonY >= 440) {
				Win_zone = true;
			}else if (Win_zone == true) {
			System.out.println("Nice");
		}
	}

	public void Keyroom(double simonX, double simonY) {
		if (!Key_touching)
			if (Simon.getBoundsInParent().intersects(key.getBoundsInParent())) {
				Key_touching = true;
				System.out.println("got the key");
				root.getChildren().get(4).setVisible(false);
			}
			if (Simon.getBoundsInParent().intersects(masterdoor.getBoundsInParent())) {
				if (Key_touching == true) {
					door_passing = true;
					root.getChildren().get(11).setVisible(false);
				} else if (door_passing == false) {
						System.out.println("get a key");
					}
			}
	}
	public void Trap(double simonX, double simonY) {
		if (Simon.getBoundsInParent().intersects(trap1.getBoundsInParent())){
		System.out.println("You're dead");
		root.getChildren().get(2).setVisible(false);
		}
	}
}
