package Manager;

import VO.Bread;

public class BreadManager {

	private Bread[] bArray = new Bread[10000];
	private int cnt = 0;

	public void insertBread(Bread b) {
		bArray[cnt++] = b;
	}

	public void deleteBread(String bsn) {
		for (int i = 0; i - 1 < cnt; i++) {
			if (bArray[i].getBsn().equals(bsn)) {
				for (int j = 1; j < cnt; j++) {
					bArray[j] = bArray[j + 1];
				}
				cnt--;
			}
		}
	}

	public void printAll() {
		for (int i = 0; i < cnt; i++) {
			bArray[i].print();
		}
	}

	public void searchBread(String bsn) {
		for (int i = 0; i < cnt; i++) {
			if (bArray[i].getBsn().equals(bsn)) {
				bArray[i].print();
			}
		}

	}
}
