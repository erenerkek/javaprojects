import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;

public abstract class Shape implements Serializable {
	private int x;
	private int y;
	private int width;
	private int height;
	private Color borderColor = Color.BLACK;
	private Color fillColor = Color.BLACK;
	
	public Color getFillColor() {
		return fillColor;
	}




	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}




	public Color getBorderColor() {
		return borderColor;
	}




	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
	public String toSVG() {
		
	}




	public abstract void drawShape(Graphics g);
	public abstract void filling(Graphics g);
	public void draw(Graphics g){
		g.setColor(borderColor);
		((Graphics2D)g).setStroke(new BasicStroke(10));
		drawShape(g);
		
	}
	public void fill(Graphics g){
		g.setColor(fillColor);
		filling(g);
		
	}
	
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
