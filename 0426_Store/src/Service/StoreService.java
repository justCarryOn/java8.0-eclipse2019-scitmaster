package Service;

import java.util.ArrayList;

import VO.Food;
import VO.Medicine;
import VO.Product;

public class StoreService {
	private ArrayList<Product> pList = new ArrayList<>();

	public void insert(Product p) {
		pList.add(p);
	}

	public String printAll() {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			result += pList.get(i) + "\n";
		}
		return result;
	}

	public String searchpCode(String pCode) {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			if (pCode.equals(pList.get(i).getpCode()))
				result = pList.get(i).toString();
		}
		return result;
	}

	public String searchdueDate(String dueDate) {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i) instanceof Food)
				if (dueDate.equals(((Food) pList.get(i)).getdueDate()))
					result = pList.get(i).toString();

		}
		return result;
	}

	public String searchShelfLife(String shlefLife) {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i) instanceof Medicine)
				if (shlefLife.equals(((Medicine) pList.get(i)).getShelfLife()))
					result = pList.get(i).toString();

		}
		return result;
	}

	public String printFood() {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i) instanceof Food)
				result += pList.get(i).toString() + "\n";
		}
		return result;
	}

	public String printMedicine() {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i) instanceof Medicine)
				result += pList.get(i).toString() + "\n";
		}
		return result;
	}

	public String printProduct() {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			if (!(pList.get(i) instanceof Food) && !(pList.get(i) instanceof Medicine))
				result += pList.get(i).toString() + "\n";
		}
		return result;
	}

	public String printZero() {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i) instanceof Food)
				if (pList.get(i).getNumber()==0) 
					result += pList.get(i) + "\n";
		}
		return result;
	}
}
