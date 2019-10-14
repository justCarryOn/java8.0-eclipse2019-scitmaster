package vo;

public class DepositAccount extends Account {

	public DepositAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepositAccount(String accountNum, int balance) {
		super(accountNum, balance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "저축통장 : "+super.toString();
	}

}
