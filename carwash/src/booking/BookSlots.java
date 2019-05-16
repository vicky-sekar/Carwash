package booking;

/* This class inserts the booking details into the booking table
 * http://localhost:8080/carwash/Book?Bid=b&Cid=b&Cname=b&CLocation=b&CAddress=b&Time=b&comments=b&Date=b&Status=b
 * Author=Baru  
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BookSlots {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/carwash";
	static final String USER = "root";	
	static final String PASS = "";
	Boolean operationStatus=false;

	public static void main(String args[]) throws SQLException {
		BookSlots bs=new BookSlots();
		String a="Baru";
		bs.bookSlots(a,a,a,a,a,a,a,a,a);
	}
	
	
	public Boolean bookSlots(String Bid,String Cid,String Cname, String CLocation, String CAddress,String Status,
			String Time,String comments,String Date) throws SQLException {
		Connection conn = null;
		   Statement stmt = null;
		   try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		   boolean status=false;
		   try{
			   System.out.println("inside try");
			   stmt = conn.createStatement();
			      String sql = "INSERT INTO booking " +
		                   "VALUES (?,?,?,?,?,?,?,?,?)";
			      //stmt.executeUpdate(sql);  
			      PreparedStatement preapredStmt=conn.prepareStatement(sql);
			      preapredStmt.setString(1,Bid);
			      preapredStmt.setString(2,Cid);
			      preapredStmt.setString(3,Cname);
			      preapredStmt.setString(4,CLocation);
			      preapredStmt.setString(5,CAddress);
			      preapredStmt.setString(6,Status);
			      preapredStmt.setString(7,Time);
			      preapredStmt.setString(8,comments);
			      preapredStmt.setString(9,Date);
			      preapredStmt.executeUpdate();
			      operationStatus=true;
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
			   status=false;
			   e.printStackTrace();
		   }finally{
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
			return operationStatus;
	}
}
