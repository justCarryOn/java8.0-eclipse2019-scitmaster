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
	ArrayList<Product> productList = new ArrayList<>(); // 판매자가 판매하는 모든 물품
	ArrayList<Product> todaySales = new ArrayList<>(); // 판매자가 오늘 판매한 모든 물품
	ArrayList<CustomerPurchase> customerSales = new ArrayList<>(); // 고객이 구매한 물품 목록
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
	 * 특정 물품에 대한 재고 확인
	 * 
	 * @param productId : 재고를 확인할 품목에 대한 id
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
	 * 전체 물품에 대한 재고 확인
	 */
	@Override
	public ArrayList<Product> stockCheck() {
		return productList;
	}

	/**
	 * 새로운 물품 등록
	 * 
	 * @param product : 판매자가 판매할 새로운 물품을 등록한다.
	 * @return 등록 여부
	 */
	@Override
	public boolean stockCreate(Product product) {
		return productList.add(product);
	}

	/**
	 * 판매자가 기존에 판매하던 물품의 수량을 업데이트
	 * 
	 * @param productId : 물품 ID
	 * @param quantity  : 추가 구매 수량
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
	 * 오늘 판매한 내용을 리턴함
	 * 
	 * @return
	 */
	@Override
	public ArrayList<Product> nowSalesList() {
		return todaySales;
	}

	/**
	 * 고객에게 물품을 판매함 고객이 물품을 구매하면 구매한 품목온 todaySales 목록에 추가하고 전체 품목 리스트에서는 판매한 만큼 수량을
	 * 뺀다.
	 * 
	 * @param purchase : 고객이 구매한 폼목
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
	 * 고객이 자신의 이메일을 통해 총 구매 내역을 확인한다.
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
										+ "      " + todaySales.get(j).getQuantity() + "개      " + totalPrice + "원");
					}
				}

			}

		}
		return customerSales;
	}

	/**
	 * 판매하는 모든 물품의 재고내역을 파일에서 불러옴
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
	 * 판매하는 모든 물품의 재고 내역을 파일로 저장함
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
