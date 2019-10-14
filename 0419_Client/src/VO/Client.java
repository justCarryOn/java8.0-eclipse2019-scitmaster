package VO;

public class Client {

	private String name,csn;
	
	public Client() {
		super();
	}
	
	public Client(String name, String csn) {
		super();
		this.name = name;
		this.csn = csn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCsn() {
		return csn;
	}

	public void setCsn(String csn) {
		this.csn = csn;
	}

	public void print() {
		System.out.println("이름 : "+name+" 회원번호 : "+csn);
	}

	
}
