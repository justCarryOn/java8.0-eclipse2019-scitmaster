package service;

import java.util.ArrayList;

import vo.Guest;
import vo.Room;

public interface HotelInterface {
	public boolean makeRoom(Room r); // ����
	public boolean insertGuest(ArrayList<Guest> g, String roomNum);
	public int checkOut(String roomNum); // üũ�ƿ�, ���� ����
	public ArrayList<Guest> searchGuestByName(String name);
	public ArrayList<Guest> searchGuestBySSn(String ssn);
	
	public void saveFile();
	public void loadFile();
}
