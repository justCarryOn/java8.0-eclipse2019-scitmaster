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
import vo.Member;

@WebServlet("/frontAction")
public class BoardServlet extends HttpServlet {

	private BoardService bs = new BoardService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");

		if (action.equals("login")) {

			String id = req.getParameter("userId");
			String pw = req.getParameter("userPw");
			
			Member mem=new Member(id,pw);
			
			Member result=bs.selectMember(mem);
			
			if(result==null) {//로그인 실패
				
				System.out.println((String)req.getAttribute("message"));
				
				req.setAttribute("userId", id);
				req.setAttribute("userPw", pw);
				req.setAttribute("message", "로그인실패");

				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);	
				
				
			}else {//로그인성공
				
				HttpSession session=req.getSession();
				session.setAttribute("loginId", id);
				
				resp.sendRedirect("index.jsp");
				
			}

			
		}else if(action.equals("logout")) {
			
			HttpSession session=req.getSession();
			
			session.setAttribute("loginId", null);
			
			resp.sendRedirect("index.jsp");
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = req.getParameter("action");

		if (action.equals("signup")) {

			String id = req.getParameter("userId");
			String pw = req.getParameter("userPw");

			if (id != null && pw != null) {
				if (!id.equals("") && !pw.equals("")) {
					Member mem = new Member(id, pw);
					boolean result = bs.insertMember(mem);

					if (result) {// 가입성공시

						resp.sendRedirect("index.jsp");

					} else {// 가입실패

						req.setAttribute("userId", id);
						req.setAttribute("userPw", pw);
						req.setAttribute("message", "아이디가 중복되었습니다.");

						RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
						rd.forward(req, resp);

					}

				}
			}

		}else if(action.equals("delete")) {
			
			HttpSession session=req.getSession();
			String id=(String)session.getAttribute("loginId");
			String pw = req.getParameter("userPw");
			
			Member mem=new Member(id,pw);
			
			boolean result=bs.deleteMember(mem);
			
			if (result) {// 탈퇴성공시
				req.getSession().invalidate();
				resp.sendRedirect("index.jsp");

			} else {// 탈퇴실패

				req.setAttribute("userPw", pw);
				req.setAttribute("message", "비밀번호가 일치하지 않습니다.");

				RequestDispatcher rd = req.getRequestDispatcher("deletemember.jsp");
				rd.forward(req, resp);

			}
			
		}

	}

}
