package service;

import java.util.ArrayList;

import dao.CustomerDAO;
import dao.ProductDAO;
import vo.Customer;
import vo.Product;
import vo.Sold;

public class CustomerService {

	private CustomerDAO dao = new CustomerDAO();
	private ProductDAO pDao = new ProductDAO();

	public boolean insertCustomer(Customer c) {

		return dao.insertCustomer(c);

	}

	public Customer selectCustomer(Customer c) {

		return dao.selectCustomer(c);

	}

	public boolean deleteCustomer(Customer c) {

		return dao.deleteCustomer(c);
	}

	public ArrayList<Product> selectAllProduct() {
		return pDao.selectAllProduct();
	}

	public Product selectProduct(String productSeq) {
		return pDao.selectProduct(productSeq);
	}

	public boolean insertSold(Sold s) {
		return pDao.insertSold(s);
	}
	
	public ArrayList<Product> selectMyList(String customerId){
		return pDao.selectMyList(customerId);
	}
}
