package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Eduimpl;
import dto.Studentedu;
@WebServlet("/fetchidd")
public class FethbyId extends HttpServlet
{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Eduimpl eduimpl=new Eduimpl();
	Studentedu studentedu=eduimpl.find(Integer.parseInt(req.getParameter("fetchid")));
	HttpSession session=req.getSession(false);
	if(session!=null)
	{
	if(studentedu==null)
	{
		resp.getWriter().print("<h1>Details not found for above entered id.Please enter valid id</h1>");
	}
	else
	{
	  req.setAttribute("Student", studentedu);
	  req.getRequestDispatcher("Stuid.jsp").forward(req, resp);
	}
	}
	else
	{
		 resp.sendRedirect("Alert.html");
	}
}
}
