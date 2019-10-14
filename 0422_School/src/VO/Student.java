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
		System.out.println("�̸� : " + super.getName() + " ���� : " + super.getAge() + " �й� : " + stNo);
		
	}
}
