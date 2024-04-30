package tw.org.iii.apis;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JTable {
	private MyModel myModel;
	private FoodDB foodDB;
	
	public MyTable() {
		try {
			foodDB = new FoodDB();
			foodDB.query();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	
		myModel = new MyModel();
		setModel(myModel);
		myModel.setColumnIdentifiers(foodDB.getHeader());
	}
	
	
	public void delRow() {
		try {
			foodDB.delData(getSelectedRow()+1);
			repaint();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	private class MyModel extends DefaultTableModel {

		@Override
		public int getRowCount() {
			return foodDB.getRows();
		}

		@Override
		public int getColumnCount() {
			return foodDB.getCols();
		}

		@Override
		public Object getValueAt(int row, int column) {
			return foodDB.getData(row+1, column+1);
		}

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			foodDB.updateData(row+1, column+1, (String)aValue);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			boolean isEditable = true;
			
			if (column == 0) isEditable = false;
			
			return isEditable;
		}
		
		
		
		
		
	}
	
}
