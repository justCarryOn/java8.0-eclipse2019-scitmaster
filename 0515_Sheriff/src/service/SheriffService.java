package service;

import vo.Criminal;
import vo.Person;
import vo.Sheriff;

public class SheriffService implements ServiceInterface {

	@Override
	public boolean insertPerson(Person p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Person searchPersonBySsn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sheriff searchSheriffByOfficerNum(String officerNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Criminal searchCriminalByCriminalNum(String criminalNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean caughtCriminal(String officerNum, String criminalNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String orderSheriffByHighCaught() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String orderCriminalByHighBounty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String unCaughtCriminalList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String printAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadFile() {
		// TODO Auto-generated method stub
		
	}

}
