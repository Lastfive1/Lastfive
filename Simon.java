import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class Simon {
	private Circle circle;
	double simonX;
	double simonY;


	public Simon() {
		simonX = 30;
		simonY = 30;
		circle = new Circle(simonX, simonY, 15);
		circle.setFill(Color.BLACK);
	}
	
	public Simon(double x,double y,double r) {
		simonX = x;
		simonY = y;
		circle = new Circle(simonX, simonY, r);
		circle.setFill(Color.BLACK);
	}
	public double getSimonX() {
		return simonX;
	}


	public void setSimonX(double simonX) {
		this.simonX = simonX;
	}

	public double getSimonY() {
		return simonY;
	}


	public void setSimonY(double simonY) {
		this.simonY = simonY;
	}
	
	public void setColour(Color c) {
		circle.setFill(c);
	}
	
	public Circle getCircle() {
		return circle;
	}
}


