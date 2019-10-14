package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import vo.Board;

@WebServlet("/boardAction")
public class MainServlet extends HttpServlet {
	
	private BoardService bs=new BoardService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");

		if (action.equals("board")) {

			checkLogin(req,resp);
			
			req.setAttribute("bList", bs.selectAllBoard());
			
			RequestDispatcher rd = req.getRequestDispatcher("board.jsp");
			rd.forward(req, resp);

		} else if (action.equals("boardWrite")) {

			checkLogin(req,resp);
			
			resp.sendRedirect("boardWrite.jsp");

		} else if(action.equals("detail")) {
			
			String boardSeq=req.getParameter("boardSeq");
			
			Board board=bs.selectBoard(boardSeq);
			
			req.setAttribute("board", board);
			
			RequestDispatcher rd=req.getRequestDispatcher("boardDetail.jsp");
			rd.forward(req, resp);
		
		} else if(action.equals("goUpdate")) {
			
			
			String boardSeq=req.getParameter("boardSeq");
			
			Board board=bs.selectBoard(boardSeq);
			
			req.setAttribute("board", board);	

			RequestDispatcher rd=req.getRequestDispatcher("boardWrite.jsp");
			rd.forward(req, resp);
			
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=req.getParameter("action");
		
		if(action.equals("write")) {
			String title=req.getParameter("title");
			String content=req.getParameter("content");
			String id=(String)req.getSession().getAttribute("loginId");
			
			
			Board board=new Board(null,id,title,content,null);
			
			bs.insertBoard(board);
			
			resp.sendRedirect("boardAction?action=board");
		
		}else if(action.equals("delete")) {
			String boardSeq=req.getParameter("boardSeq");
			
			bs.deleteBoard(boardSeq);
			
			resp.sendRedirect("boardAction?action=board");
			
		}else if(action.equals("update")) {

			String boardSeq=req.getParameter("boardSeq");
			String title=req.getParameter("title");
			String content=req.getParameter("content");
			
			bs.updateBoard(new Board(boardSeq,null,title,content,null));
			
			resp.sendRedirect("boardAction?action=detail&boardSeq="+boardSeq);
			
		}
		

	}

	public void checkLogin(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();

		String loginId = (String) session.getAttribute("loginId");

		if (loginId == null) {// 로그인X

			try {
				resp.sendRedirect("login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
