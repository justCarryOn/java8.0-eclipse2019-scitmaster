package vo;

public class Game {

	private String name;// Ÿ��Ʋ��
	private String pCode;// ��ǰ�ڵ�
	private String genre;// �帣
	private int amount;// ����
	private int price;// ���� ����
	private String info;// ��������

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
		return "Ÿ��Ʋ��=" + name + ", ��ǰ�ڵ�=" + pCode + ", �帣=" + genre + ", ����=" + amount + ", ����="
				+ price + ", ����=" + info;
	}

}
