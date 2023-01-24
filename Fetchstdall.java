package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Eduimpl;
import dto.Studentedu;
@WebServlet("/hellow")
public class Fetchstdall extends HttpServlet
{
  @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	  HttpSession session=req.getSession(false);
	  if(session!=null)
	  {
       Eduimpl eduimpl=new Eduimpl();
       List<Studentedu>l=eduimpl.fetchall();
       req.setAttribute("slist",l);
       req.getRequestDispatcher("Fetchedu.jsp").forward(req, resp);
	  }
	  else
	  {
		  resp.sendRedirect("Alert.html");
	  }
}    
}
