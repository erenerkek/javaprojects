import java.awt.Graphics;
import java.util.ArrayList;

public class RectangleList {
	private ArrayList<Rectangle> list = new ArrayList<Rectangle>();

	public void add(Rectangle r) {
		list.add(r);
	}
	
	public void draw(Graphics g) {
		list.forEach(r-> r.draw(g));
		
	}
}
