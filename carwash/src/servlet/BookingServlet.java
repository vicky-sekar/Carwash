package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booking.BookSlots;

@WebServlet(value = "/Book") 
public class BookingServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {  
		Boolean status=false;
		String resp="";
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
			
		String Bid= request.getParameter("Bid");
		String Cid= request.getParameter("Cid");
		String Cname= request.getParameter("Cname");
		String CLocation= request.getParameter("CLocation");
		String CAddress= request.getParameter("CAddress");
		String Time= request.getParameter("Time");
		String comments= request.getParameter("comments");
		String Date= request.getParameter("Date");
		String State= request.getParameter("Status");
		BookSlots book=new BookSlots();
		try {
			status=book.bookSlots(Bid, Cid, Cname, CLocation, CAddress, State, Time, comments, Date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status)
			resp="Booking Sucess";
		else
			resp="Booking failed";
		out.print(resp); 
	}

}
