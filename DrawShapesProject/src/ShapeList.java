import java.awt.Graphics;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ShapeList {
	private ArrayList<Shape> list = new ArrayList<Shape>();
	
	public void add(Shape s) {
		list.add(s);
	}
	public void draw(Graphics g) {
		list.forEach(s -> s.draw(g));
	}
	public void fill(Graphics g) {
		list.forEach(s -> s.fill(g));
		
	}
	
	public void save(ObjectOutputStream out) throws IOException {
		out.writeObject(list);
	}
	@SuppressWarnings("unchecked")
	public void load(ObjectInputStream in) throws ClassNotFoundException{
		list = ArrayList<Shape>.in.readObject();
	}
}
