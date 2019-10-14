package vo;

public class PcGame extends Game {

	private String internetCode;// 온라인다운로드코드

	public PcGame(String name, String pCode, String genre, int amount, int price, String info, String internetCode) {
		super(name, pCode, genre, amount, price, info);
		this.internetCode = internetCode;
	}

	public PcGame() {
		super();
	}

	public String getInternetCode() {
		return internetCode;
	}

	public void setInternetCode(String internetCode) {
		this.internetCode = internetCode;
	}

	@Override
	public String toString() {
		return super.toString()+", 다운로드코드=" + internetCode;
	}

}
