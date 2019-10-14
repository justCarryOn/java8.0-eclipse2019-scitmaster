package Service;

import java.util.ArrayList;

import VO.Bread;

public class BakeryService {

	private ArrayList<Bread> bList = new ArrayList<>();

	public void insertBread(Bread b) {
		bList.add(b);
	}

	public String print() {
		String toPrint = "";
		for (int i = 0; i < bList.size(); i++) {
			toPrint += bList.get(i);
		}
		return toPrint;
	}

	// public void print() {
	// for (Bread bread : bList)
	// System.out.println(bread);
	// }
}
