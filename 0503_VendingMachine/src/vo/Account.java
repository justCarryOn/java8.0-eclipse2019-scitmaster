package vo;

public class Account {

	private String id;//관리자 계정 id
	private String pw;//관리자 계정 pw

	public Account(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public Account() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "관리자계정ID=" + id + ", 관리자계정PW=" + pw;
	}

}
