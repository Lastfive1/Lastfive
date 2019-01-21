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
	double BaddyX;
	double BaddyY;
	double BaddyX2;
	double BaddyY2;
	double BaddyX3;
	double BaddyY3;
	double BaddyX4;
	double BaddyY4;
	private Circle Simon;
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
	private Boolean move = true;
	private Rectangle end;
	private Rectangle Baddy;
	private Rectangle Baddy2;
	private Rectangle Baddy3;
	private Rectangle Baddy4;
	private Boolean trapdeathmessage = false;
	private Boolean Dead = false;
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
		key = new ImageView(new Image("key.png"));
		masterdoor = new ImageView(new Image("door1.jpg"));
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
		masterdoor.setY(450);
		simonX = 30;
		simonY = 30;
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
		Simon = new Circle(simonX, simonY, 15);
		Simon.setFill(Color.BLACK);
		room1 = new Line(10, 150, 280, 150);
		room1pt2 = new Line(360, 150, 490, 150);
		Line keyroom = new Line(10, 200, 30, 200);
		Line keyroompt2 = new Line(90, 200, 100, 200);
		keyroompt3 = new Line(100, 150, 100, 200);
		room2 = new Line(360, 150, 360, 380);
		room2pt2 = new Line(360, 380, 150, 380);
		room2pt3 = new Line(150, 380, 150, 445);
		root.getChildren().addAll(stage, end, Simon, trap1, trap2, trap3, key, room1, room1pt2, keyroom, keyroompt2,
				keyroompt3, room2, room2pt2, room2pt3, masterdoor, Baddy, Baddy2, Baddy3, Baddy4);

		map.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.W && move == true)
					simonY -= 3;
				else if (event.getCode() == KeyCode.S && move == true)
					simonY += 3;
				else if (event.getCode() == KeyCode.D && move == true)
					simonX += +3;
				else if (event.getCode() == KeyCode.A && move == true)
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
		if (Simon.getBoundsInParent().intersects(room1.getBoundsInParent())) {
			simonY -= 5;
			Simon.setCenterY(simonY);
		}
		if (Simon.getBoundsInParent().intersects(room1pt2.getBoundsInParent())) {
			simonY -= 5;
			Simon.setCenterY(simonY);
		}
		if (Simon.getBoundsInParent().intersects(room2.getBoundsInParent())) {
			simonX -= 5;
			Simon.setCenterX(simonX);
		}
		if (Simon.getBoundsInParent().intersects(room2pt2.getBoundsInParent())) {
			simonY -= 5;
			Simon.setCenterY(simonY);
		}
		if (Simon.getBoundsInParent().intersects(room2pt3.getBoundsInParent())) {
			simonX -= 5;
			Simon.setCenterX(simonX);
		}
		if (Simon.getBoundsInParent().intersects(keyroompt3.getBoundsInParent())) {
			simonX += 5;
			Simon.setCenterX(simonX);
		}
		if (simonX - 15 <= 10) {
			simonX += 5;
			Simon.setCenterX(simonX);
		}
		if (simonX + 15 >= 490) {
			simonX -= 5;
			Simon.setCenterX(simonX);
		}
		if (simonY - 15 <= 10) {
			simonY += 5;
			Simon.setCenterY(simonY);
		}
		if (simonY + 15 >= 490) {
			simonY -= 5;
			Simon.setCenterY(simonY);
		}
		Baddy.setY(BaddyY);
		Baddy2.setX(BaddyX2);
		Baddy3.setX(BaddyX3);
		Baddy4.setY(BaddyY4);
		Win(simonX, simonY);
		Keyroom(simonY);
		Trap(simonX, simonY);
		Baddy(simonX, simonY);
		Baddy2(simonX, simonY);
		Baddy3(simonX, simonY);
		Baddy4(simonX, simonY);
	}

	public void Win(double simonX, double simonY) {
		if (!Win_zone)
			if (Simon.getBoundsInParent().intersects(end.getBoundsInParent())) {
				Win_zone = true;
				System.out.println("Victory Royale");
			}
	}

	public void Keyroom(double simonY) {
		if (!Key_touching)
			if (Simon.getBoundsInParent().intersects(key.getBoundsInParent())) {
				Key_touching = true;
				System.out.println("got the key");
				root.getChildren().get(6).setVisible(false);
			}
		if (Simon.getBoundsInParent().intersects(masterdoor.getBoundsInParent())) {
			if (Key_touching == true) {
				door_passing = true;
				root.getChildren().get(15).setVisible(false);
			} else if (!door_passingmessage)
				if (door_passing == false) {
					door_passingmessage = true;
					System.out.println("get a key");
					move = false;
					simonX -= 10;
					move = true;
					door_passingmessage = false;
				}
		}
	}

	public void Trap(double simonX, double simonY) {
		if (!trapdeathmessage)
			if (Simon.getBoundsInParent().intersects(trap1.getBoundsInParent())) {
				trapdeathmessage = true;
				System.out.println("You're dead");
				Dead= true;
				root.getChildren().get(2).setVisible(false);

			}
		if (!trapdeathmessage)
			if (Simon.getBoundsInParent().intersects(trap2.getBoundsInParent())) {
				trapdeathmessage = true;
				System.out.println("You're dead");
				Dead = true;
				root.getChildren().get(2).setVisible(false);

			}
		if (!trapdeathmessage)
			if (Simon.getBoundsInParent().intersects(trap3.getBoundsInParent())) {
				trapdeathmessage = true;
				System.out.println("You're dead");
				Dead = true;
				root.getChildren().get(2).setVisible(false);

			}
	}

	public void Baddy(double simonX, double Y) {

		if ((BaddyY + 25) <= 150) {
			BaddyY += 1;
		} else {
			BaddyY -= 125;
			Baddy.setY(BaddyY);
		}
		if (!Baddymessage)
			if (Simon.getBoundsInParent().intersects(Baddy.getBoundsInParent())) {
				Baddymessage = true;
				System.out.println("Your're dead");
				Dead = true;
				root.getChildren().get(2).setVisible(false);
			}
	}

	public void Baddy2(double simonX, double simonY) {
		if ((BaddyX2 + 50) <= 490) {
			BaddyX2 += myArray[n];
		} else {
			BaddyX2 -= 440;
			Baddy2.setX(BaddyX2);
			if (!Baddymessage)
				if (Simon.getBoundsInParent().intersects(Baddy2.getBoundsInParent())) {
					Baddymessage = true;
					System.out.println("Your're dead");
					Dead = true;
					root.getChildren().get(2).setVisible(false);
				}
		}
	}

	public void Baddy3(double simonX, double Y) {

		if ((BaddyX3) >= 10) {
			BaddyX3 -= myArray[n];
		} else {
			BaddyX3 += 430;
			Baddy3.setX(BaddyX3);
		}
		if (!Baddymessage)
			if (Simon.getBoundsInParent().intersects(Baddy3.getBoundsInParent())) {
				Baddymessage = true;
				System.out.println("Your're dead");
				Dead = true;
				root.getChildren().get(2).setVisible(false);
			}
	}

	public void Baddy4(double simonX, double Y) {

		if ((BaddyY4 + 50) <= 490) {
			BaddyY4 += myArray[n];
		} else {
			BaddyY4 -= 440;
			Baddy4.setY(BaddyY4);
		}
		if (!Baddymessage)
			if (Simon.getBoundsInParent().intersects(Baddy4.getBoundsInParent())) {
				Baddymessage = true;
				System.out.println("Your're dead");
				Dead = true;
				root.getChildren().get(2).setVisible(false);
			}
	}
}
