import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.animation.AnimationTimer;
public class helloshapes extends Application {	
	public static void main(String[] args) {
	launch(args);	
	}
	public void start(Stage primaryStage) throws Exception {
	int n = 10;
	int m = 2;
	Group root = new Group();
	Scene scene = new Scene(root,600,600);
	
	double Angle = Math.toRadians(360)/n;
	Circle circle1 = new Circle(300,300,250);
	circle1.setFill(Color.WHITE);
	circle1.setStroke(Color.BLACK);
	circle1.setStrokeWidth(5);
	root.getChildren().add(circle1);
	
	AnimationTimer timer = new AnimationTimer() {
		public void handle(long now) {
			upDate();
		}
	};
	timer.start();
	
	double[][] circle = new double[n][2];
	for(int i =0; i<circle.length;i++) {
		circle[i][0] = Math.cos(i*Angle)*250 + 300;
		circle[i][1] = Math.sin(i*Angle)*250 + 300;
		circle1 = new Circle(circle[i][0],circle[i][1],2);	
		circle1.setFill(Color.RED);
		root.getChildren().add(circle1);
	}
	
	//for(int i =0; i<circle.length;i++) {
		//Line line=new Line(circle[i][0], circle[i][1], circle[(i*m)%n][0], circle[(i*m)%n][1]);
		//root.getChildren().add(line);
	//}
	for (int i = 0;i < circle.length;i++) {
		Line line=new Line(circle[i][0], circle[i][1], circle[(i*m)%n][0], circle[(i*m)%n][1]);
		root.getChildren().add(line);
           Thread.sleep(1000000);
       }
	primaryStage.setTitle("Hello World");
	primaryStage.setScene(scene);
	primaryStage.show();
	
	}
	public void upDate()
	{
	
	}
}


