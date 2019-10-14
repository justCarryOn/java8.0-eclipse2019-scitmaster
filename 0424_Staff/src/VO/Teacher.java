package VO;

public class Teacher extends Staff {
	private String tsn;

	public Teacher() {
		super();
	}

	public Teacher(String name, String ssn, String position, String tsn) {
		super(name, ssn, position);
		this.tsn = tsn;
	}

	public String getTsn() {
		return tsn;
	}

	public void setTsn(String tsn) {
		this.tsn = tsn;
	}

	@Override
	public String toString() {
		return super.toString()+", ±³¹ø=" + tsn;
	}
}
