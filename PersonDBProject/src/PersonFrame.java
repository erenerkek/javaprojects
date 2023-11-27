import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

public class PersonFrame extends JFrame {
	
	private PersonList list;

	public PersonFrame() {
		setTitle("Person DB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		init();
		initToolbar();
	}
	private void initToolbar() {
		JToolBar toolbar = new JToolBar();
		
		JButton btn = new JButton("Add Person");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				list.add(new Person("<name>",0,"<name>"));
			}
		});
		toolbar.add(btn);
		btn = new JButton("Delete Person");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
			}
		});
		toolbar.add(btn);

		add(toolbar, BorderLayout.PAGE_START);
	}
	private void init() {
		list = new PersonList();
		list.add(new Person("John", 20, "john@gmail.com"));
		list.add(new Person("eren", 20, "eren@gmail.com"));

		JTable table = new JTable(list);
		JScrollPane pane = new JScrollPane(table);
		
		

		
		add(pane, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new PersonFrame().setVisible(true);
		
	}

}
