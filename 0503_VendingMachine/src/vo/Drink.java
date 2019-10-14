package vo;

public class Drink extends Product {

	private String volume;// ml 용량

	public Drink(String name, String pCode, int price, int amount, String volume) {
		super(name, pCode, price, amount);
		this.volume = volume;
	}

	public Drink() {
		super();
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return super.toString() + "용량=" + volume;
	}

}
