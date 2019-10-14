package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/write")
public class PostServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String tt = req.getParameter("title");
		String ct = req.getParameter("content");
		
		ArrayList<String> pList=new ArrayList<>();
		pList.add("apple");
		pList.add("tomato");
		pList.add("banana");
		
		req.setAttribute("pList", pList);
		
		System.out.println(tt+" "+ct);
		RequestDispatcher rd = req.getRequestDispatcher("submit.jsp");
		rd.forward(req, resp);
	}

}
