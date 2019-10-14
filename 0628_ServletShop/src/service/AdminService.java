package service;

import java.util.ArrayList;

import dao.AdminDAO;
import dao.CustomerDAO;
import dao.ProductDAO;
import vo.Admin;
import vo.Customer;
import vo.Product;

public class AdminService {

	private AdminDAO dao = new AdminDAO();
	private ProductDAO pDao = new ProductDAO();

	public Admin selectAdmin(Admin a) {

		return dao.selectAdmin(a);

	}

	public boolean insertProduct(Product p) {
		return pDao.insertProduct(p);
	}

	public ArrayList<Product> selectAllProduct() {
		return pDao.selectAllProduct();
	}

	public Product selectProduct(String productSeq) {
		return pDao.selectProduct(productSeq);
	}

	public boolean updateProduct(Product p) {
		return pDao.updateProduct(p);
	}
	public ArrayList<Product> selectAllSoldList(){
		return pDao.selectAllSoldList();
	}
}
