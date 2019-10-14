package vo;

public class Game {

	private String name;// 타이틀명
	private String pCode;// 제품코드
	private String genre;// 장르
	private int amount;// 수량
	private int price;// 게임 가격
	private String info;// 게임정보

	public Game(String name, String pCode, String genre, int amount, int price, String info) {
		super();
		this.name = name;
		this.pCode = pCode;
		this.genre = genre;
		this.amount = amount;
		this.price = price;
		this.info = info;
	}

	public Game() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "타이틀명=" + name + ", 제품코드=" + pCode + ", 장르=" + genre + ", 수량=" + amount + ", 가격="
				+ price + ", 정보=" + info;
	}

}
