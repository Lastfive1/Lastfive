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
	// double simonX;
	private Simon simon;
	// double simonY;
	double BaddyX;
	double BaddyY;
	double BaddyX2;
	double BaddyY2;
	double BaddyX3;
	double BaddyY3;
	double BaddyX4;
	double BaddyY4;
	//private Circle Simon;
	private Scene map;
	private ImageView key;
	private ImageView masterdoor;
	private ImageView trap1;
	private ImageView trap2;
	private ImageView trap3;
	private Boolean Key_touching = false;
	private Boolean door_passing = false;
	private Boolean door_passingmessage = false;
	private Boolean Win_zone = false;
	private Boolean Baddymessage = false;
	private Group root;
	private Rectangle end;
	private Rectangle Baddy;
	private Rectangle Baddy2;
	private Rectangle Baddy3;
	private Rectangle Baddy4;
	private Boolean trapdeathmessage = false;
	private Line room1;
	private Line room1pt2;
	private Line room2;
	private Line room2pt2;
	private Line room2pt3;
	private Line keyroompt3;
	private int[] myArray = new int[5];
	private int n = (int) (Math.random() * 4);

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		root = new Group();
		map = new Scene(root, 500, 500);
		myArray[0] = 1;
		myArray[1] = 2;
		myArray[2] = 3;
		myArray[3] = 4;
		myArray[4] = 5;
		key = new ImageView(new Image("key1.jpg"));
		masterdoor = new ImageView(new Image("door.jpg"));
		trap1 = new ImageView(new Image("sportnite.png"));
		trap2 = new ImageView(new Image("sportnite.png"));
		trap3 = new ImageView(new Image("sportnite.png"));
		trap1.setX(300);
		trap1.setY(75);
		trap2.setX(350);
		trap2.setY(450);
		trap3.setX(30);
		trap3.setY(300);
		key.setX(20);
		key.setY(160);
		masterdoor.setX(130);
		masterdoor.setY(442);
		BaddyX = 150;
		BaddyY = 10;
		BaddyX2 = 10;
		BaddyY2 = 230;
		BaddyX3 = 440;
		BaddyY3 = 330;
		BaddyX4 = 400;
		BaddyY4 = 440;
		map.setFill(Color.TURQUOISE);
		Rectangle stage = new Rectangle(10, 10, 480, 480);
		Baddy = new Rectangle(BaddyX, BaddyY, 20, 20);
		Baddy2 = new Rectangle(BaddyX2, BaddyY2, 50, 10);
		Baddy3 = new Rectangle(BaddyX3, BaddyY3, 50, 10);
		Baddy4 = new Rectangle(BaddyX4, BaddyY4, 10, 50);
		end = new Rectangle(420, 440, 70, 50);
		end.setFill(Color.GOLD);
		stage.setFill(Color.WHITE);
		simon = new Simon(30, 30, 15);
		simon.setColour(Color.BLACK);
		room1 = new Line(10, 150, 280, 150);
		room1pt2 = new Line(360, 150, 490, 150);
		Line keyroom = new Line(10, 200, 30, 200);
		Line keyroompt2 = new Line(90, 200, 100, 200);
		keyroompt3 = new Line(100, 150, 100, 200);
		room2 = new Line(360, 150, 360, 380);
		room2pt2 = new Line(360, 380, 150, 380);
		room2pt3 = new Line(150, 380, 150, 445);
		root.getChildren().addAll(stage, end,simon.getCircle() , trap1, trap2, trap3, key, room1, room1pt2, keyroom, keyroompt2,
				keyroompt3, room2, room2pt2, room2pt3, masterdoor, Baddy, Baddy2, Baddy3, Baddy4);

		 map.setOnKeyPressed(new EventHandler<KeyEvent>() {
		 @Override
		 public void handle(KeyEvent event) {
		 if (event.getCode() == KeyCode.W)
			 simon.setSimonY(simon.getSimonY()-3);
		 else if (event.getCode() == KeyCode.S)
			 simon.setSimonY(simon.getSimonY()+3);
		else if (event.getCode() == KeyCode.D)
			simon.setSimonX(simon.getSimonX()+3);
		 else if (event.getCode() == KeyCode.A)
			 simon.setSimonX(simon.getSimonX()-3);
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
		Circle circle = simon.getCircle();
		circle.setCenterX(simon.getSimonX());
		circle.setCenterY(simon.getSimonY());
		if (circle.getBoundsInParent().intersects(room1.getBoundsInParent())) {
			simon.setSimonY(simon.getSimonY()-5);
			circle.setCenterY(simon.getSimonY());
		}
		if (circle.getBoundsInParent().intersects(room1pt2.getBoundsInParent())) {
			simon.setSimonY(simon.getSimonY()-5);
			circle.setCenterY(simon.getSimonY());
		}
		if (circle.getBoundsInParent().intersects(room2.getBoundsInParent())) {
			simon.setSimonX(simon.getSimonX()-5);
			circle.setCenterX(simon.getSimonX());
		}
		if (circle.getBoundsInParent().intersects(room2pt2.getBoundsInParent())) {
			simon.setSimonY(simon.getSimonY()-5);
			circle.setCenterY(simon.getSimonY());
		}
		if (circle.getBoundsInParent().intersects(room2pt3.getBoundsInParent())) {
			simon.setSimonX(simon.getSimonX()-5);
			circle.setCenterX(simon.getSimonX());
		}
		if (circle.getBoundsInParent().intersects(keyroompt3.getBoundsInParent())) {
			simon.setSimonX(simon.getSimonX()+5);
			circle.setCenterX(simon.getSimonX());
		}
		if (simon.getSimonX() - 15 <= 10) {
			simon.setSimonX(simon.getSimonX()+5);
			circle.setCenterX(simon.getSimonX());
		}
		if (simon.getSimonX() + 15 >= 490) {
			simon.setSimonX(simon.getSimonX()-5);
			circle.setCenterX(simon.getSimonX());
		}
		if (simon.getSimonY() - 15 <= 10) {
			simon.setSimonY(simon.getSimonX()+5);
			circle.setCenterY(simon.getSimonY());
		}
		if (simon.getSimonY() + 15 >= 490) {
			simon.setSimonY(simon.getSimonX()-5);
			circle.setCenterY(simon.getSimonY());
		}
		Baddy.setY(BaddyY);
		Baddy2.setX(BaddyX2);
		Baddy3.setX(BaddyX3);
		Baddy4.setY(BaddyY4);
		Win(simon.getSimonX(), simon.getSimonY());
		Keyroom(simon.getSimonY());
		Trap(simon.getSimonX(), simon.getSimonY());
		Baddy(simon.getSimonX(), simon.getSimonY());
		Baddy2(simon.getSimonX(), simon.getSimonY());
		Baddy3(simon.getSimonX(), simon.getSimonY());
		Baddy4(simon.getSimonX(), simon.getSimonY());
	}

	public void Win(double simonX, double simonY) {
		Circle circle = simon.getCircle();
		if (!Win_zone)
			if (circle.getBoundsInParent().intersects(end.getBoundsInParent())) {
				Win_zone = true;
				System.out.println("Victory Royale");
			}
	}

	public void Keyroom(double simonY) {
		Circle circle = simon.getCircle();
		if (!Key_touching)
			if (circle.getBoundsInParent().intersects(key.getBoundsInParent())) {
				Key_touching = true;
				System.out.println("got the key");
				root.getChildren().get(6).setVisible(false);
			}
		if (circle.getBoundsInParent().intersects(masterdoor.getBoundsInParent())) {
			if (Key_touching == true) {
				door_passing = true;
				root.getChildren().get(15).setVisible(false);
			} else if (!door_passingmessage)
				if (door_passing == false) {
					door_passingmessage = true;
					System.out.println("get a key");
					simon.setSimonX(simon.getSimonX()-10);
					door_passingmessage = false;
				}
		}
	}

	public void Trap(double simonX, double simonY) {
		Circle circle = simon.getCircle();
		if (!trapdeathmessage)
			if (circle.getBoundsInParent().intersects(trap1.getBoundsInParent())) {
				trapdeathmessage = true;
				System.out.println("You're dead");

				root.getChildren().get(2).setVisible(false);

			}
		if (!trapdeathmessage)
			if (circle.getBoundsInParent().intersects(trap2.getBoundsInParent())) {
				trapdeathmessage = true;
				System.out.println("You're dead");

				root.getChildren().get(2).setVisible(false);

			}
		if (!trapdeathmessage)
			if (circle.getBoundsInParent().intersects(trap3.getBoundsInParent())) {
				trapdeathmessage = true;
				System.out.println("You're dead");

				root.getChildren().get(2).setVisible(false);

			}
	}

	public void Baddy(double simonX, double Y) {
		Circle circle = simon.getCircle();
		if ((BaddyY + 25) <= 150) {
			BaddyY += 1;
		} else {
			BaddyY -= 125;
			Baddy.setY(BaddyY);
		}
		if (!Baddymessage)
			if (circle.getBoundsInParent().intersects(Baddy.getBoundsInParent())) {
				Baddymessage = true;
				System.out.println("Your're dead");

				root.getChildren().get(2).setVisible(false);
			}
	}

	public void Baddy2(double simonX, double simonY) {
		Circle circle = simon.getCircle();
		if ((BaddyX2 + 50) <= 490) {
			BaddyX2 += myArray[n];
		} else {
			BaddyX2 -= 440;
			Baddy2.setX(BaddyX2);
			if (!Baddymessage)
				if (circle.getBoundsInParent().intersects(Baddy2.getBoundsInParent())) {
					Baddymessage = true;
					System.out.println("Your're dead");

					root.getChildren().get(2).setVisible(false);
				}
		}
	}

	public void Baddy3(double simonX, double Y) {
		Circle circle = simon.getCircle();
		if ((BaddyX3) >= 10) {
			BaddyX3 -= myArray[n];
		} else {
			BaddyX3 += 430;
			Baddy3.setX(BaddyX3);
		}
		if (!Baddymessage)
			if (circle.getBoundsInParent().intersects(Baddy3.getBoundsInParent())) {
				Baddymessage = true;
				System.out.println("Your're dead");

				root.getChildren().get(2).setVisible(false);
			}
	}

	public void Baddy4(double simonX, double Y) {
		Circle circle = simon.getCircle();
		if ((BaddyY4 + 50) <= 490) {
			BaddyY4 += myArray[n];
		} else {
			BaddyY4 -= 440;
			Baddy4.setY(BaddyY4);
		}
		if (!Baddymessage)
			if (circle.getBoundsInParent().intersects(Baddy4.getBoundsInParent())) {
				Baddymessage = true;
				System.out.println("Your're dead");

				root.getChildren().get(2).setVisible(false);
			}
	}
}
