package VO;

public class Cleaner extends Staff {
	private String offDay;

	public Cleaner() {
		super();
	}

	public Cleaner(String name, String ssn, String position, String offDay) {
		super(name, ssn, position);
		this.offDay = offDay;
	}

	public String getOffDay() {
		return offDay;
	}

	public void setOffDay(String offDay) {
		this.offDay = offDay;
	}

	@Override
	public String toString() {
		return super.toString()+", 비번일자=" + offDay;
	}
}
