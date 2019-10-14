package global.sesoc.vo;

import java.io.Serializable;

public class Product implements Serializable {
	private String productId;	// 제품고유번호
	private String productName;	// 물품명
	private int unitPrice;		// 단가
	private int quantity;		// 재고수량
	private int price;			// 판매가
	
	public Product() { }
	public Product(String productId, String productName, int unitPrice, int quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.price = unitPrice + (int)( unitPrice*0.3);
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
		this.price = unitPrice + (int)( unitPrice*0.15);
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		String temp = null;
		temp = String.format("%4s  %-10s  %,6d원   %5d개  %,11d원", productId, productName, unitPrice, quantity, price);
		
		return temp;
	}
}


