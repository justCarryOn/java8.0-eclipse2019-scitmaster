package vo;

public class XboxGame extends Game {

	private String xboxId;// 사용자 ID

	public XboxGame(String name, String pCode, String genre, int amount, int price, String info, String xboxId) {
		super(name, pCode, genre, amount, price, info);
		this.xboxId = xboxId;
	}

	public XboxGame() {
		super();
	}

	public String getXboxId() {
		return xboxId;
	}

	public void setXboxId(String xboxId) {
		this.xboxId = xboxId;
	}

	@Override
	public String toString() {
		return super.toString() + ", 엑박계정아이디=" + xboxId;
	}

}
