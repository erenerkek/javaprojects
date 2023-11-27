import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.IIOException;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JToolBar;

public class ShapeWindow extends JFrame {
	private Shape CurrentShape = null;
	private ShapeList list = new ShapeList();
	
	public  ShapeWindow() { setTitle("Draw rectangle application");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(1000,800);
	

	 initToolbar();
	 initMouselisteners();
	
}

private void initMouselisteners() {
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(CurrentShape != null) {	
				list.add(CurrentShape);
					CurrentShape = null;
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(CurrentShape != null) {
				CurrentShape.setX(e.getX());
				CurrentShape.setY(e.getY());
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				CurrentShape.setWidth(e.getX() - CurrentShape.getX());
				CurrentShape.setHeight(e.getY() - CurrentShape.getY());
				
				repaint();

			
			}});
}

private void initToolbar() {
	JToolBar toolbar = new JToolBar();
	
	JButton btn = new JButton("Add Rectangle");
	btn.addActionListener(new ActionListener() {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			CurrentShape = new Rectangle();
			
		}
	});
	
	btn = new JButton("Add Elipse");
	btn.addActionListener(new ActionListener() {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			CurrentShape = new Elipse();
			
		}
		
		
	});
	toolbar.add(btn);
	btn = new JButton("Border Color");
	btn.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(CurrentShape != null)
			CurrentShape.setBorderColor(JColorChooser.showDialog(null,"Dialog title", null));
	}});
	toolbar.add(btn);
	btn = new JButton("Filling Color");
	btn.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(CurrentShape != null)
			CurrentShape.setFillColor(JColorChooser.showDialog(null,"Dialog title", null));
	}});
	toolbar.add(btn);
	btn = new JButton("Save");
	btn.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		save();
		
	}});
	toolbar.add(btn);
	add(toolbar, BorderLayout.PAGE_START);
	
	
	
}
public void save() {
	try {
	ObjectOutputStream out = new ObjectOutputStream(
			new FileOutputStream("shapes.dat"));
	list.save(out);
	out.close();
}
	catch(IOException e) {
		e.printStackTrace();
	}}
public void load() {
	try {
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("shapes.dat"));
				list.load(in);
				
				in.close();
				
				repaint();
				
	}catch(IOException e) {
		e.printStackTrace();
	}
}

public void paint(Graphics g) {
	super.paint(g);
	
	if(CurrentShape != null) CurrentShape.draw(g);
	list.draw(g);
	if(CurrentShape != null) CurrentShape.fill(g);
	list.fill(g);
}
	public static void main(String[] args) {
		new ShapeWindow()
.setVisible(true);	}

}
