package vo;

public class Snack extends Product{

	private String weight;//무게 gram

	public Snack(String name, String pCode, int price, int amount, String weight) {
		super(name, pCode, price, amount);
		this.weight = weight;
	}

	public Snack() {
		super();
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return super.toString()+", 무게=" + weight;
	}
	
	
}
