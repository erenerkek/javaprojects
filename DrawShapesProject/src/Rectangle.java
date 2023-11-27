import java.awt.Graphics;

public class Rectangle extends Shape {
	
	@Override
	public void filling(Graphics g) {
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	public void drawShape(Graphics g) {
		g.drawRect(getX(), getY(), getWidth(), getHeight());

	}

	

	



}
