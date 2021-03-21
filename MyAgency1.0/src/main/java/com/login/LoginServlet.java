package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.LoginDao;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
		
	
	private static final long serialVersionUID = 1L;
	
	

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String uname= req.getParameter("uname");
		String pass=req.getParameter("pass");
		
		LoginDao dao = new LoginDao();
		
		if (dao.check(uname, pass)){
			
			HttpSession session= req.getSession();
			session.setAttribute("username", uname);
			res.sendRedirect("Accueillogged.jsp");
		}
		else {
			
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Username ou Mot de passe Incorrect!');");  
			out.println("location='login.jsp';");
			out.println("</script>");
			/*res.sendRedirect("login.jsp");*/
		}
		
		
		
	}
	

}
