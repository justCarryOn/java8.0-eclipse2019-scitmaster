package VO;

import java.util.ArrayList;

public class USB extends Device {

	private ArrayList<Movie> mList = new ArrayList<>();

	public USB(String rackNum, ArrayList<Movie> mList) {
		super(rackNum);
		this.mList = mList;
	}

	public USB() {
		super();
	}

	public ArrayList<Movie> getmList() {
		return mList;
	}

	public void setmList(ArrayList<Movie> mList) {
		this.mList = mList;
	}

	@Override
	public String toString() {
		return super.toString() + ", 영화리스트=" + mList;
	}

}
