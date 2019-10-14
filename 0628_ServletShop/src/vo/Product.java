package vo;

public class Product {

	private String productSeq;
	private String name;
	private int quantity;
	private int price;
	private String comments;
	private String indate;
	private String customerId;

	public Product(String productSeq, String name, int quantity, int price, String comments, String indate) {
		this.productSeq = productSeq;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.comments = comments;
		this.indate = indate;
	}

	public Product() {
	}

	public String getProductSeq() {
		return productSeq;
	}

	public void setProductSeq(String productSeq) {
		this.productSeq = productSeq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Product [productSeq=" + productSeq + ", name=" + name + ", quantity=" + quantity + ", price=" + price
				+ ", comments=" + comments + ", indate=" + indate + "]";
	}

}
