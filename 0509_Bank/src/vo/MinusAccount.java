package vo;

public class MinusAccount extends Account {

	public MinusAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MinusAccount(String accountNum, int balance) {
		super(accountNum, balance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "마이너스통장 : "+super.toString();
	}

}
