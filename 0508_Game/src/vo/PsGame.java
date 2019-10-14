package vo;

public class PsGame extends Game {

	private String psRegNum;// 타이틀등록번호

	public PsGame(String name, String pCode, String genre, int amount, int price, String info, String psRegNum) {
		super(name, pCode, genre, amount, price, info);
		this.psRegNum = psRegNum;
	}

	public PsGame() {
		super();
	}

	public String getPsRegNum() {
		return psRegNum;
	}

	public void setPsRegNum(String psRegNum) {
		this.psRegNum = psRegNum;
	}

	@Override
	public String toString() {
		return super.toString()+", 플스타이틀등록번호=" + psRegNum;
	}

}
