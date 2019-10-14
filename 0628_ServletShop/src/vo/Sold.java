package vo;

public class Sold {

	private String soldSeq;
	private String customerId;
	private String productSeq;
	private int quantity;
	private String indate;

	public Sold(String soldSeq, String customerId, String productSeq, int quantity, String indate) {
		this.soldSeq = soldSeq;
		this.customerId = customerId;
		this.productSeq = productSeq;
		this.quantity = quantity;
		this.indate = indate;
	}

	public Sold() {
	}

	public String getSoldSeq() {
		return soldSeq;
	}

	public void setSoldSeq(String soldSeq) {
		this.soldSeq = soldSeq;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getProductSeq() {
		return productSeq;
	}

	public void setProductSeq(String productSeq) {
		this.productSeq = productSeq;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "Sold [soldSeq=" + soldSeq + ", customerId=" + customerId + ", productSeq=" + productSeq + ", quantity="
				+ quantity + ", indate=" + indate + "]";
	}

}
