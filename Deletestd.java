package controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Eduimpl;
import dto.Studentedu;
@WebServlet("/deletestudent")
public class Deletestd extends HttpServlet
{
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
{
   int id=Integer.parseInt(req.getParameter("Stdid"));
   Eduimpl eduimpl=new Eduimpl();
   Studentedu studentedu=eduimpl.find(id);
   eduimpl.delete(studentedu);
   List<Studentedu>l=eduimpl.fetchall();
   req.setAttribute("slist", l);
   req.getRequestDispatcher("Fetchedu.jsp").forward(req, resp);
}
	
}
