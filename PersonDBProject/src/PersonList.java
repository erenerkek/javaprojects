import java.util.ArrayList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class PersonList extends ArrayList<Person> implements TableModel{

	@Override
	public int getRowCount() {
		return size();
	}

	@Override
	public int getColumnCount() {
		return colNames.length;
	}
	
	private String[] colNames = {"name","age","email"};

	@Override
	public String getColumnName(int columnIndex) {
		return colNames[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {

		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Person p = get(rowIndex);
		String value = "";
		switch (columnIndex) {
		case 0: value = p.getName();break;
		case 1: value = p.getAge() + "years"; break;
		case 2: value = p.getEmail();break;
		}
		return value;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Person p = get(rowIndex);
		String value = (String)aValue;
		switch (columnIndex) {
		case 0: p.setName(value);break;
		case 1: p.setAge(Integer.parseInt(value)) ; break;
		case 2: p.setEmail(value);break;
		}
	}
	
	private ArrayList<TableModelListener> listeners =
			new ArrayList<TableModelListener>();

	@Override
	public void addTableModelListener(TableModelListener l) {
		listeners.add(l);
		
	}
	private void notifyListeners() {
		listeners.forEach(x -> x.tableChanged(new TableModelEvent(this)));
	}
	
	@Override
	public boolean add(Person e) {
		boolean b = super.add(e);
		notifyListeners();
		return b;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
	
}
