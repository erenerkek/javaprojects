import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SimpleDrawApp extends JFrame {
	public SimpleDrawApp() {
		setTitle("Draw application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,500);
		
		init();
	}
	 private void init() {
		 JLabel lbl = new JLabel("Some Text");
		 add(lbl, BorderLayout.NORTH);
		 addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				lbl.setText("Mouse was clicked at: "+ e.getX()+ " "+ e.getY());			}
		});
		 
	 }
	 
	 public void paint (Graphics g) {
		 addMouseMotionListener(new MouseMotionListener() {
				
				@Override
				public void mouseMoved(MouseEvent e) {
					
					// TODO Auto-generated method stub
					
					
					
				}
				
				@Override
				public void mouseDragged(MouseEvent e) {
					// TODO Auto-generated method stub
					//super.paint(g);
					getGraphics().drawLine(e.getX(), e.getY(), e.getX(),e.getY());
					
				}
			});
		 
	 }
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SimpleDrawApp().setVisible(true);
	}

}
