package VO;

public class Student extends Person {
	private String stNo;

	public Student(String name, int age, String stNo) {
		super(name, age);
		this.stNo = stNo;
	}

	public Student() {

	}

	public String getStNo() {
		return stNo;
	}

	public void setStNo(String stNo) {
		this.stNo = stNo;
	}
	
	public void print() {
		System.out.println("이름 : " + super.getName() + " 나이 : " + super.getAge() + " 학번 : " + stNo);
		
	}
}
