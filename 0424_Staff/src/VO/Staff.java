package VO;

public class Staff {
	private String name, ssn, position;

	public Staff() {
		super();
	}

	public Staff(String name, String ssn, String position) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "이름=" + name + ", 주민번호=" + ssn + ", 직급=" + position;
	}
}
