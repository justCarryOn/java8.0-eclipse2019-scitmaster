package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CustomerService;
import vo.Customer;
import vo.Product;
import vo.Sold;

@WebServlet("/CustomerAction")
public class CustomerServlet extends HttpServlet {

	private CustomerService cs = new CustomerService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");

		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");

		if (action.equals("goSignup")) {
			resp.sendRedirect("Customer/signup.jsp");

		} else if (action.equals("goLogin")) {
			resp.sendRedirect("Customer/login.jsp");

		} else if (action.equals("goDelete")) {
			resp.sendRedirect("Customer/delete.jsp");

		} else if (action.equals("logout")) {
			req.getSession().invalidate();
			resp.sendRedirect("./index.jsp");

		} else if (action.equals("goProduct")) {
			req.setAttribute("pList", cs.selectAllProduct());

			req.getRequestDispatcher("Customer/product.jsp").forward(req, resp);

		} else if (action.equals("goBuyPage")) {
			String productSeq = req.getParameter("productSeq");
			Product p = cs.selectProduct(productSeq);
			req.setAttribute("product", p);
			req.getRequestDispatcher("Customer/productDetail.jsp").forward(req, resp);

		} else if (action.equals("goMyPage")) {
			HttpSession session = req.getSession();
			String customerId = (String) session.getAttribute("loginId");

			ArrayList<Product> p = cs.selectMyList(customerId);
			req.setAttribute("pList", p);
			req.getRequestDispatcher("Customer/productMyList.jsp").forward(req, resp);

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");

		if (action.equals("signup")) {// 회원가입
			String customerId = req.getParameter("customerId");
			String customerPw = req.getParameter("customerPw");
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			String birthdate = req.getParameter("birthdate");
			String address = req.getParameter("address");

			boolean result = cs
					.insertCustomer(new Customer(customerId, customerPw, name, phone, birthdate, address, null));

			if (result) {

				resp.sendRedirect("./index.jsp");
			} else {

				req.setAttribute("message", "이미 존재하는 ID 입니다.");
				req.setAttribute("customerId", customerId);
				req.setAttribute("customerPw", customerPw);
				req.setAttribute("name", name);
				req.setAttribute("phone", phone);
				req.setAttribute("birthdate", birthdate);
				req.setAttribute("address", address);

				RequestDispatcher rd = req.getRequestDispatcher("/Customer/signup.jsp");
				rd.forward(req, resp);
			}

		} else if (action.equals("login")) {// 로긴
			String customerId = req.getParameter("customerId");
			String customerPw = req.getParameter("customerPw");

			Customer c = cs.selectCustomer(new Customer(customerId, customerPw, null, null, null, null, null));

			if (c == null) {
				req.setAttribute("message", "잘못된 계정정보입니다.");
				req.setAttribute("customerId", customerId);
				req.setAttribute("customerPw", customerPw);

				RequestDispatcher rd = req.getRequestDispatcher("/Customer/login.jsp");
				rd.forward(req, resp);
			} else {
				HttpSession session = req.getSession();
				session.setAttribute("loginId", c.getCustomerId());
				resp.sendRedirect("index.jsp");
			}
		} else if (action.equals("delete")) {// 회원탈퇴
			HttpSession session = req.getSession();

			String customerId = (String) session.getAttribute("loginId");

			String customerPw = req.getParameter("customerPw");

			boolean result = cs.deleteCustomer(new Customer(customerId, customerPw, null, null, null, null, null));

			if (result) {

				session.invalidate();
				resp.sendRedirect("index.jsp");
			} else {
				req.setAttribute("message", "잘못된 계정정보입니다.");
				req.setAttribute("customerId", customerId);
				req.setAttribute("customerPw", customerPw);

				RequestDispatcher rd = req.getRequestDispatcher("/Customer/delete.jsp");
				rd.forward(req, resp);
			}
		} else if (action.equals("buyProduct")) {

			HttpSession session = req.getSession();
			String customerId = (String) session.getAttribute("loginId");

			String productSeq = req.getParameter("productSeq");
			int quantity = Integer.parseInt(req.getParameter("quantity"));

			
			if(quantity<0) {
				req.setAttribute("message", "수량을 체크해주세요.");
				Product p = cs.selectProduct(productSeq);
				req.setAttribute("product", p);
				req.getRequestDispatcher("Customer/productDetail.jsp").forward(req, resp);
				return;
			}
			
			Sold s = new Sold(null, customerId, productSeq, quantity, null);

			boolean result = cs.insertSold(s);

			if (result) {

				resp.sendRedirect("CustomerAction?action=goProduct");

			} else {
				req.setAttribute("message", "수량을 체크해주세요.");
				Product p = cs.selectProduct(productSeq);
				req.setAttribute("product", p);
				req.getRequestDispatcher("Customer/productDetail.jsp").forward(req, resp);
			}
		}

	}

}
