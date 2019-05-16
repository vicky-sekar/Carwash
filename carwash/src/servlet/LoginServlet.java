package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import signup.LoginUser;

@WebServlet(value = "/Login") 
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {  
		Boolean status=false;
		String resp="";
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		String email= request.getParameter("email");
		String pwd= request.getParameter("pwd");
		LoginUser lu=new LoginUser();
		status=lu.signInUser(email, pwd);
		if(status)
			resp="Login Sucess";
		else
			resp="Login failed";
		out.print(resp); 
	}

}
