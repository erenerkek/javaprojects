import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

public class RectangleWindow extends JFrame {

	public Rectangle currentRectangle;
	private RectangleList list = new RectangleList();

	public RectangleWindow() {
		setTitle("Draw rectangle application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,800);
		
		 initToolbar();
		 initMouselisteners();
		
	}
	
	private void initMouselisteners() {
			addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					if(currentRectangle != null) {	
					list.add(currentRectangle);
						currentRectangle = null;
					}
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					if(currentRectangle != null) {
					currentRectangle.setX(e.getX());
					currentRectangle.setY(e.getY());
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
					currentRectangle.setWidth(e.getX() - currentRectangle.getX());
					currentRectangle.setHeight(e.getY() - currentRectangle.getY());
					
					update(getGraphics());

				
				}});
	}

	private void initToolbar() {
		JToolBar toolbar = new JToolBar();
		
		JButton btn = new JButton("Add Rectangle");
		btn.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				currentRectangle = new Rectangle();
				
			}
		});
		toolbar.add(btn);
		add(toolbar, BorderLayout.PAGE_START);
		
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		if(currentRectangle != null) currentRectangle.draw(g);
		
		list.draw(g);
	}
	
	public static void main(String[] args) {
			new RectangleWindow().setVisible(true);
	}

}
