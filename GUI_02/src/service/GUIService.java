package service;

import java.util.ArrayList;

import vo.Person;

public class GUIService {

	private ArrayList<Person> pList = new ArrayList<>();

	public void insertPerson(Person p) {
		pList.add(p);
	}

	public ArrayList<Person> getpList() {
		return pList;
	}

	public void setpList(ArrayList<Person> pList) {
		this.pList = pList;
	}

}
