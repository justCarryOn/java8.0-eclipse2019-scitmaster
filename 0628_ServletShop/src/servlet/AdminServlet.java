package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AdminService;
import vo.Admin;
import vo.Customer;
import vo.Product;

@WebServlet("/AdminAction")
public class AdminServlet extends HttpServlet {

	private AdminService as = new AdminService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");

		if (action == null) {// 어드민 홈주소
			resp.sendRedirect("/Shop/Admin/index.jsp");

		} else if (action.equals("goLogin")) {
			resp.sendRedirect("/Shop/Admin/login.jsp");

		} else if (action.equals("logout")) {
			req.getSession().invalidate();
			resp.sendRedirect("/Shop/Admin/index.jsp");

		} else if (action.equals("goProduct")) {

			req.setAttribute("pList", as.selectAllProduct());

			req.getRequestDispatcher("/Admin/product.jsp").forward(req, resp);

		}else if (action.equals("goSoldProduct")) {

			req.setAttribute("pList", as.selectAllSoldList());

			req.getRequestDispatcher("/Admin/productSold.jsp").forward(req, resp);

		} else if (action.equals("goInsertProduct")) {
			resp.sendRedirect("/Shop/Admin/productDetail.jsp");

		} else if (action.equals("update")) {

			String productSeq = req.getParameter("productSeq");
			Product p = as.selectProduct(productSeq);
			req.setAttribute("product", p);
			req.getRequestDispatcher("/Admin/productUpdate.jsp").forward(req, resp);

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = req.getParameter("action");

		req.setCharacterEncoding("utf-8");

		if (action.equals("login")) {// 로긴
			String adminId = req.getParameter("adminId");
			String adminPw = req.getParameter("adminPw");

			Admin a = as.selectAdmin(new Admin(adminId, adminPw));

			if (a == null) {
				req.setAttribute("message", "잘못된 계정정보입니다.");
				req.setAttribute("adminId", adminId);
				req.setAttribute("adminPw", adminPw);

				RequestDispatcher rd = req.getRequestDispatcher("/Shop/Admin/login.jsp");
				rd.forward(req, resp);

			} else {
				HttpSession session = req.getSession();
				session.setAttribute("adminId", a.getAdminId());
				resp.sendRedirect("/Shop/Admin/index.jsp");
			}

		} else if (action.equals("insertProduct")) {

			String name = req.getParameter("name");
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			int price = Integer.parseInt(req.getParameter("price"));
			String comments = req.getParameter("comments");

			boolean result = as.insertProduct(new Product(null, name, quantity, price, comments, null));
			if (result) {
				resp.sendRedirect("/Shop/AdminAction?action=goProduct");
			}
		} else if (action.equals("updateProduct")) {

			String productSeq = req.getParameter("productSeq");
			String quantity = req.getParameter("quantity");
			Product p = new Product();
			p.setProductSeq(productSeq);
			p.setQuantity(Integer.parseInt(quantity));
			as.updateProduct(p);

			resp.sendRedirect("/Shop/AdminAction?action=goProduct");

		}
	}

}
