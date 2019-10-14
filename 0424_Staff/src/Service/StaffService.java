package Service;

import java.util.ArrayList;

import VO.Cleaner;
import VO.Staff;
import VO.Teacher;

public class StaffService {
	private ArrayList<Staff> sList = new ArrayList<>();

	public void insertStaff(Staff s) {
		sList.add(s);
	}

	public String printAll() {
		String result = "";
		for (int i = 0; i < sList.size(); i++) {
			result += sList.get(i) + "\n";
		}
		return result;
	}

	public String printTeacher() {
		String result = "";
		for (int i = 0; i < sList.size(); i++)
			if (sList.get(i) instanceof Teacher)
				result += sList.get(i).toString() + "\n";
		return result;

	}

	public String printCleaner() {
		String result = "";
		for (int i = 0; i < sList.size(); i++)
			if (sList.get(i) instanceof Cleaner)
				result += sList.get(i).toString() + "\n";
		return result;

	}

	public String searchSsn(String ssn) {
		String result = "";
		for (int i = 0; i < sList.size(); i++)
			if (ssn.equals(sList.get(i).getSsn()))
				result = sList.get(i).toString();
		return result;
	}

	public String searchPosition(String position) {
		String result = "";
		for (int i = 0; i < sList.size(); i++)
			if (position.equals(sList.get(i).getPosition()))
				result = sList.get(i).toString();
		return result;
	}

	public String searchTsn(String tsn) {
		String result = "";
		for (int i = 0; i < sList.size(); i++)
			if (sList.get(i) instanceof Teacher)
				if (tsn.equals(((Teacher) sList.get(i)).getTsn()))
					result = sList.get(i).toString();
		return result;
	}

	public String searchOffDay(String offDay) {
		String result = "";
		for (int i = 0; i < sList.size(); i++)
			if (sList.get(i) instanceof Cleaner)
				if (offDay.equals(((Cleaner) sList.get(i)).getOffDay()))
					result = sList.get(i).toString();
		return result;
	}

	public void delSsn(String ssn) {
		for (int i = 0; i < sList.size(); i++)
			if (ssn.equals(sList.get(i).getSsn()))
				sList.remove(i);
	}
}
