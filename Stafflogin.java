package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Eduimpl;
import dto.Teacherdetails;
@WebServlet("/stafflogin")
public class Stafflogin extends HttpServlet
{
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
{
   String email=req.getParameter("staffemail");
   String password=req.getParameter("staffpaswd");
   Eduimpl e=new Eduimpl();
   Teacherdetails t=e.findstaff(email);
   if(t==null)
   {
	 req.getParameter("<h1>Invalid email-id</h1>");
	 req.getRequestDispatcher("stafflogin.html").include(req, resp);
   }
   else
   {
	   if(t.getStaffpassword().equals(password))
	   {
		 HttpSession session=req.getSession();
		 session.setAttribute("sessionlogin",'n');
		 resp.sendRedirect("frontpage.html");   
	   }
	   else
	   {
		   resp.getWriter().print("<h1>Invalid password</h1>");
		   req.getRequestDispatcher("stafflogin.html").include(req, resp);
	   }
	}
  }
}
