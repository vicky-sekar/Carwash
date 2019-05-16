package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet; 


import signup.createNewUser;
@WebServlet(value = "/SignUp") 
public class SignUpServlet extends HttpServlet {


protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {  
		
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		String uname= request.getParameter("uname");
		String email= request.getParameter("email");
		String pwd= request.getParameter("pwd");
		createNewUser cnw=new createNewUser();
		String status=cnw.createUser(email, pwd, uname);  
		out.print(status);  
}  
}
