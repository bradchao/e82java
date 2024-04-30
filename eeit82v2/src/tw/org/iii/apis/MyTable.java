package tw.org.iii.apis;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JTable {
	private MyModel myModel;
	
	public MyTable() {
	
		myModel = new MyModel();
		setModel(myModel);
	}
	
	
	private class MyModel extends DefaultTableModel {

		@Override
		public int getRowCount() {
			return 10;
		}

		@Override
		public int getColumnCount() {
			return 4;
		}

		@Override
		public Object getValueAt(int row, int column) {
			return "Brad";
		}

//		@Override
//		public void setValueAt(Object aValue, int row, int column) {
//			// TODO Auto-generated method stub
//			super.setValueAt(aValue, row, column);
//		}
		
	}
	
}
