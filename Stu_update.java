package controller;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Eduimpl;
import dto.Studentedu;
@WebServlet("/updatestudent")
public class Stu_update extends HttpServlet
{
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
{
  Studentedu e=new Studentedu();
  e.setId(Integer.parseInt(req.getParameter("studdid")));
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
  eduimpl.updatesss(e);
  List<Studentedu>l=eduimpl.fetchall();
  req.setAttribute("slist", l);
  req.getRequestDispatcher("Fetchedu.jsp").forward(req, resp);
  
   }
}
