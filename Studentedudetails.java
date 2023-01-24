package controller;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Eduimpl;
import dto.Studentedu;
@WebServlet("/regform")
public class Studentedudetails extends HttpServlet
{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
   {
	 HttpSession session=req.getSession(false);
	 if(session!=null)
	 {
	 Studentedu e=new Studentedu();
     e.setName(req.getParameter("studentname"));
     e.setSclass(req.getParameter("studentclass"));
     LocalDate d=LocalDate.parse(req.getParameter("studentdob"));
     LocalDate d1=LocalDate.now();
     int age=Period.between(d,d1).getYears();
     e.setDob(d);
     e.setAge(age);
     e.setMark1(Integer.parseInt(req.getParameter("mark1")));
     e.setMark2(Integer.parseInt(req.getParameter("mark2")));
     e.setMark3(Integer.parseInt(req.getParameter("mark3")));
     e.setTotal_mark(e.getMark1()+e.getMark2()+e.getMark3());
     Eduimpl eduimpl=new Eduimpl();
     eduimpl.add(e);
     resp.getWriter().print("<h1>Details updated successfuly</h1>");
     req.getRequestDispatcher("frontpage.html").include(req, resp);
	 }
	 else
	 {
		 resp.sendRedirect("Alert.html");
	 }
   }
}
