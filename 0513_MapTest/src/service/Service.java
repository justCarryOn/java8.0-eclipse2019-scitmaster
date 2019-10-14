package service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import vo.Person;

public class Service {
	private Map<String, Person> pMap = new HashMap<>();

	public boolean insertPerson(Person p) {
		pMap.put(p.getSsn(), p);
		return false;
	}

	public String searchPerson(String ssn) {
		String result = "";
		return result = pMap.get(ssn) + "\n";
	}

	public String printAll() {
		String result = "";
		Set<String> keys = pMap.keySet();

		for (String ssn : keys) {
			result += pMap.get(ssn) + "\n";

		}
		return result;
	}

	public boolean removePerson(String ssn) {
		boolean result = false;
		Set<String> keys = pMap.keySet();

		for (String ssn1 : keys) {
			if (ssn1.equals(ssn)) {
				result = true;
			}
		}
		if (result) {
			pMap.remove(ssn);
		}
		return result;
	}

	public boolean renamePerson(String ssn, Person p) {
		boolean result = false;
		Set<String> keys = pMap.keySet();

		for (String ssn1 : keys) {
			if (ssn1.equals(ssn)) {
				result = true;
			}
		}
		if (result)	{
			pMap.replace(ssn, p);
		}
		return result;
	
	}
}
