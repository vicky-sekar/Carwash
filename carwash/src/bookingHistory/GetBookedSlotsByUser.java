package bookingHistory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GetBookedSlotsByUser {
	

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/carwash";
	static final String USER = "root";	
	static final String PASS = "";
	
	public String getBookedSlotsByUser(String email,String pwd) {
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
		   return "";
	}
	
		void getDetails() {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
 
            DocumentBuilder documentBuilder = null;
			try {
				documentBuilder = documentFactory.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 
            Document document = documentBuilder.newDocument();
 
            // root element
            Element root = document.createElement("company");
            document.appendChild(root);
            
            System.out.println(documentFactor);

		}

}
