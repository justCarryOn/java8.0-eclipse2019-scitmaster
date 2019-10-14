package global.sesoc.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import global.sesoc.vo.Product;
import global.sesoc.vo.CustomerPurchase;

public class PurchaseServiceImpl implements PurchaseService {
	ArrayList<Product> productList = new ArrayList<>(); // �Ǹ��ڰ� �Ǹ��ϴ� ��� ��ǰ
	ArrayList<Product> todaySales = new ArrayList<>(); // �Ǹ��ڰ� ���� �Ǹ��� ��� ��ǰ
	ArrayList<CustomerPurchase> customerSales = new ArrayList<>(); // ���� ������ ��ǰ ���
	final String FILE_NAME = "purchaseList.dat";
	FileInputStream fis;
	ObjectInputStream ois;
	FileOutputStream fos;
	ObjectOutputStream oos;

	public PurchaseServiceImpl() {
		if (new File(FILE_NAME).exists()) {
			loadFile();
		} else {
			productList = new ArrayList<>();
		}
	}

	/**
	 * Ư�� ��ǰ�� ���� ��� Ȯ��
	 * 
	 * @param productId : ��� Ȯ���� ǰ�� ���� id
	 * @return
	 */
	@Override
	public Product stockCheck(String productId) {
		Product product = null;
		for (Product p : productList) {
			if (p.getProductId().equals(productId)) {
				product = p;
			}
		}
		return product;

	}

	/**
	 * ��ü ��ǰ�� ���� ��� Ȯ��
	 */
	@Override
	public ArrayList<Product> stockCheck() {
		return productList;
	}

	/**
	 * ���ο� ��ǰ ���
	 * 
	 * @param product : �Ǹ��ڰ� �Ǹ��� ���ο� ��ǰ�� ����Ѵ�.
	 * @return ��� ����
	 */
	@Override
	public boolean stockCreate(Product product) {
		return productList.add(product);
	}

	/**
	 * �Ǹ��ڰ� ������ �Ǹ��ϴ� ��ǰ�� ������ ������Ʈ
	 * 
	 * @param productId : ��ǰ ID
	 * @param quantity  : �߰� ���� ����
	 * @return
	 */
	@Override
	public boolean stockUpdate(String productId, int quantity) {
		boolean result = false;
		if (stockCheck(productId) != null) {
			stockCheck(productId).setQuantity(stockCheck(productId).getQuantity() + quantity);
			result = true;
		}
		// Code Here
		return result;
	}

	/**
	 * ���� �Ǹ��� ������ ������
	 * 
	 * @return
	 */
	@Override
	public ArrayList<Product> nowSalesList() {
		return todaySales;
	}

	/**
	 * ������ ��ǰ�� �Ǹ��� ���� ��ǰ�� �����ϸ� ������ ǰ��� todaySales ��Ͽ� �߰��ϰ� ��ü ǰ�� ����Ʈ������ �Ǹ��� ��ŭ ������
	 * ����.
	 * 
	 * @param purchase : ���� ������ ����
	 */
	@Override
	public boolean todaySales(CustomerPurchase purchase) {
		boolean flag = true;
		for (Product p : productList) {
			if (p.getProductId().equals(purchase.getProductId())) {
				Product np = new Product(p.getProductId(), p.getProductName(), p.getUnitPrice(),
						purchase.getBuyQuantity());
				todaySales.add(np);
				CustomerPurchase cp = new CustomerPurchase(purchase.getEmail(), purchase.getProductId(),
						purchase.getBuyQuantity());
				customerSales.add(cp);
				p.setQuantity(p.getQuantity() - purchase.getBuyQuantity());
			}
		}
		return flag;
	}

	/**
	 * ���� �ڽ��� �̸����� ���� �� ���� ������ Ȯ���Ѵ�.
	 * 
	 * @param email
	 * @return
	 */
	@Override
	public ArrayList<CustomerPurchase> todayPurchase(String email) {
		for (int i = 0; i < customerSales.size(); i++) {
			for (int j = 0; j < todaySales.size(); j++) {
				if (i == j) {
					if (customerSales.get(i).getEmail().equals(email)) {
						int totalPrice = todaySales.get(j).getPrice() * todaySales.get(j).getQuantity();
						System.out.println(
								todaySales.get(j).getProductId() + "      " + todaySales.get(j).getProductName()
										+ "      " + todaySales.get(j).getQuantity() + "��      " + totalPrice + "��");
					}
				}

			}

		}
		return customerSales;
	}

	/**
	 * �Ǹ��ϴ� ��� ��ǰ�� ������� ���Ͽ��� �ҷ���
	 */
	@Override
	public void loadFile() {
		File f = new File(FILE_NAME);
		try {
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			productList = (ArrayList<Product>) ois.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				ois.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * �Ǹ��ϴ� ��� ��ǰ�� ��� ������ ���Ϸ� ������
	 */
	@Override
	public void saveFile() {
		File f = new File(FILE_NAME);
		try {
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(productList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				oos.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
