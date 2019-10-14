package global.sesoc.vo;

public class CustomerPurchase extends Product {
	private String email;			// 이메일
	private String productId;		// 구매한 제품고유번호
	private int buyQuantity;		// 구매한 수량

	// constructor
	public CustomerPurchase() { }

	public CustomerPurchase(String email, String productId, int buyQuantity) {
		this.productId = productId;
		this.email = email;
		this.buyQuantity = buyQuantity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getBuyQuantity() {
		return buyQuantity;
	}

	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}

	@Override
	public String toString() {
		String temp = null;
		temp = String.format("%-10s  %5d개  ", super.getProductName(), buyQuantity);
		return temp;
	}
}
