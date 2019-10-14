package Service;

import VO.Person;

public class SchoolService {
	private Person[] pArray = new Person[10000];
	private int cnt = 0;

	public void insertPerson(Person p) {
		pArray[cnt++] = p;
	}

	public void printAll() {
		for (int i = 0; i < cnt; i++) {
			pArray[i].print();
		}
	}
}
