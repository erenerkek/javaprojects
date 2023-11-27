import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SimpleWindowApp extends JFrame implements ActionListener {
	private JLabel lbl;
	private static int a=0;
	public SimpleWindowApp() {
		setTitle("Test Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,500);
		
		initCompenents();
	}
	private void initCompenents() {
		// TODO Auto-generated method stub
		JButton btn = new JButton("Click");
		
		btn.addActionListener(this);
		add(btn, BorderLayout.CENTER);
		lbl = new JLabel("Some Text");
		add(lbl, BorderLayout.NORTH);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SimpleWindowApp().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		a++;
		lbl.setText("Counter: "+ a );
	}

}
