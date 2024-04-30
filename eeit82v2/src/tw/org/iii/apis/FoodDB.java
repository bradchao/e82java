package tw.org.iii.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class FoodDB {
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://localhost/iii";
	private static final String QUERY_SQL = "SELECT * FROM food";
	
	private Connection conn;
	private ResultSet rs = null;
	private String[] fieldNames;
	
	public FoodDB() throws Exception {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);	
		
		conn = DriverManager.getConnection(URL, prop);
		
	}
	
	public void query()  throws SQLException {
		query(QUERY_SQL);
	}
	
	public void query(String sql) throws SQLException {
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql);
		
		ResultSetMetaData rsmd = rs.getMetaData();
		fieldNames = new String[rsmd.getColumnCount()];
		for (int i=0; i<fieldNames.length; i++) {
			fieldNames[i] = rsmd.getColumnName(i+1);
		}
	}
	
	public int getRows() {
		try {
			rs.last();
			return rs.getRow();
		}catch(Exception e) {
			return 0;
		}
	}
	
	// 1-base
	public void move(int row) throws Exception{
		rs.absolute(row);
	}
	
	public int getCols() {
		return fieldNames.length;
	}
	
	// row, col => 1-base
	public String getData(int row, int col) {
		try {
			rs.absolute(row);
			return rs.getString(fieldNames[col-1]);	// rs.getString("name")
		}catch(Exception e) {
			return "ERROR";
		}
	}
	
	
	public String[] getHeader() {
		return fieldNames;
	}
	
	public void delData(int row) throws Exception {
		rs.absolute(row);
		rs.deleteRow();
	}
	
	// row, col => 1-base
	public void updateData(int row, int col, String value) {
		try {
			rs.absolute(row);
			rs.updateString(col, value);
			rs.updateRow();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	
}
