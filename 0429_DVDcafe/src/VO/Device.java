package VO;

public class Device {

	private String rackNum;

	public Device(String rackNum) {
		super();
		this.rackNum = rackNum;
	}

	public Device() {
		super();
	}

	public String getRackNum() {
		return rackNum;
	}

	public void setRackNum(String rackNum) {
		this.rackNum = rackNum;
	}

	@Override
	public String toString() {
		return "보관함번호=" + rackNum;
	}

}
