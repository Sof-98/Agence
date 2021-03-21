package com.signup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.client.dao.ClientDao;
import com.client.model.ClientModel;




@WebServlet("/Signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ClientDao Cd= new ClientDao();
	

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String firstname= req.getParameter("firstname");
		String lastname= req.getParameter("lastname");
		String username= req.getParameter("username");
		String mdp=req.getParameter("mdp");
		String adresse= req.getParameter("adresse");
		
		ClientModel Cm = new ClientModel();
		Cm.setFirstname(firstname);
		Cm.setLastname(lastname);
		Cm.setUsername(username);
		Cm.setMdp(mdp);
		Cm.setAdresse(adresse);
		
		try {
			if(Cd.CheckAlreadyExist(Cm)) {
				res.setContentType("text/html");
				PrintWriter out = res.getWriter();
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Username déja utilisé');");  
				out.println("location='login.jsp#carousel_669b';");
				out.println("</script>");
				/*res.sendRedirect("login.jsp");*/
				
				
				
			}
			else {
				Cd.RegisterClient(Cm);
				res.sendRedirect("registrationdone.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	

}

