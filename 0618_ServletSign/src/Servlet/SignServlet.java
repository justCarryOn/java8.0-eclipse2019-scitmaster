package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sign")
public class SignServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		
		req.setAttribute("id", id);
		req.setAttribute("pw", pw);
		req.setAttribute("name", name);
		req.setAttribute("address", address);
		
		System.out.println(id+" "+name+" "+address+" 회원가입 완료");
		RequestDispatcher rd = req.getRequestDispatcher("submit.jsp");
		rd.forward(req, resp);
	}

}
