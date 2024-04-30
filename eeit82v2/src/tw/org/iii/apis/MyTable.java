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

//		@Override
//		public void setValueAt(Object aValue, int row, int column) {
//			// TODO Auto-generated method stub
//			super.setValueAt(aValue, row, column);
//		}
		
	}
	
}
