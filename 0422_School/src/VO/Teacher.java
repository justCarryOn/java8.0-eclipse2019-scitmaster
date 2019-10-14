package VO;

public class Teacher extends Person {
	private String tNo;

	public Teacher() {
		super();
	}

	public String gettNo() {
		return tNo;
	}

	public void settNo(String tNo) {
		this.tNo = tNo;
	}

	public Teacher(String name, int age, String tNo) {
		super(name, age);
		this.tNo = tNo;
	}

	public void print() {
		System.out.println("이름 : " + super.getName() + " 나이 : " + super.getAge() + " 교번 : " + tNo);
	}
}
