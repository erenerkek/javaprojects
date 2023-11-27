import java.awt.Graphics;

public class Elipse extends Shape {
	
	@Override
	public void filling(Graphics g) {
		g.fillOval(getX(), getY(), getWidth(), getHeight());
	}

	@Override
	public void drawShape(Graphics g) {
		g.drawOval(getX(), getY(), getWidth(), getHeight());
	}

	
	

}
