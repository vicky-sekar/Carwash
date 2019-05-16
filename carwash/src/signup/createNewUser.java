package signup;


/* This class sign up the user using parameters
 * http://localhost:8080/carwash/Login?email=viki&pwd=viki
 * Author=Baru  
 */




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createNewUser {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/carwash";
	static final String USER = "root";	
	static final String PASS = "";
	
	public String createUser(String email,String pwd,String name) {
		 Connection conn = null;
		   Statement stmt = null;
		   String status="User created";
		   try{
		      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      System.out.println("Inserting records into the table...");
		      stmt = conn.createStatement();
		      String sql = "INSERT INTO users " +
	                   "VALUES ('"+name+"','"+email+"','"+pwd+"')";
		      stmt.executeUpdate(sql);
		      System.out.println("Inserted records into the table...");
		   }catch(SQLException se){
			   if(se.toString().contains("Duplicate entry"))
				   status="Email id already registered";
		      se.printStackTrace();
		   }catch(Exception e){
			   System.out.println("e"+e);
			  status="Error in database";
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
		createNewUser cnw=new createNewUser();
		System.out.println(cnw.createUser("a", "a", "s"));
	}
}
