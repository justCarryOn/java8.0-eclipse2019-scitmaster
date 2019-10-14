package Service;

import VO.Note;
import VO.Pencil;
import VO.Product;

public class CanteenService {
	private Product[] pArray = new Product[10000];
	private int cnt = 0;

	public void insertProduct(Product pd) {
		pArray[cnt++] = pd;
	}

	public String printAll() {
		String result = "";
		for (int i = 0; i < cnt; i++) {
			result += pArray[i].toString() + "/n";
		}
		return result;
	}

	public String printNote() {
		String result = "";
		for (int i = 0; i < cnt; i++)
			if (pArray[i] instanceof Note)
				result += pArray[i].toString();
		return result;
	}

	public String printPencil() {
		String result = "";
		for (int i = 0; i < cnt; i++)
			if (pArray[i] instanceof Pencil)
				result += pArray[i].toString();
		return result;
	}

	public void print() {
		for (int i = 0; i < cnt; i++)
			System.out.println(pArray[i]);
	}

	public void search(String pCode) {
		for (int i = 0; i < cnt; i++)
			if (pCode.equals(pArray[i].getpCode())) {
				System.out.println(pArray[i]);
			}
	}

	public void delete(String pCode) {
		for (int i = 0; i < cnt; i++)
			if (pCode.equals(pArray[i].getpCode())) {
				for (int j = i; j < cnt - 1; j++)
					pArray[j] = pArray[j + 1];
			}
	}
}
