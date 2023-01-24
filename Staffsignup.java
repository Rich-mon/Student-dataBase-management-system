package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Eduimpl;
import dto.Teacherdetails;
@WebServlet("/staffsignup")
public class Staffsignup extends HttpServlet
{
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
{
 Teacherdetails t=new Teacherdetails();
 t.setStaffemail(req.getParameter("staffemail"));
 t.setStaffname(req.getParameter("staffname"));
 t.setStaffpassword(req.getParameter("staffpassword"));
 Eduimpl e=new Eduimpl();
 e.addstaff(t);
 resp.getWriter().print("<h1>Signup-successfull</h1>");
 req.getRequestDispatcher("stafflogin.html").include(req, resp);
}
}
