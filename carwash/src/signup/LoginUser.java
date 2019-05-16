package signup;

/* This class login the user using parameters
 * localhost:8080/carwash/SignUp?uname=viki&email=viki&pwd=viki
 * Author=Baru  
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginUser {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/carwash";
	static final String USER = "root";	
	static final String PASS = "";
	
	public Boolean signInUser(String email,String pwd) {
		 Connection conn = null;
		   Statement stmt = null;
		   boolean status=false;
		   try{
		      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      System.out.println("Inserting records into the table...");
		      stmt = conn.createStatement();
		      PreparedStatement ps =conn.prepareStatement
                      ("select * from users where email=? and password=?");
			  ps.setString(1, email);
			  ps.setString(2,pwd);
			  ResultSet rs =ps.executeQuery();
			  status = rs.next();
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
		   return status;
	}
	
	public static void main(String args[]) {

	}

}
