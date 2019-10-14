package vo;

public class XboxGame extends Game {

	private String xboxId;// ����� ID

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
		return super.toString() + ", ���ڰ������̵�=" + xboxId;
	}

}
