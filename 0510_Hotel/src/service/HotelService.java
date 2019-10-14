package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import vo.Guest;
import vo.Room;

public class HotelService implements HotelInterface {
	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private ArrayList<Room> rList = new ArrayList<>();

	@Override
	public boolean makeRoom(Room r) {
		rList.add(r);
		saveFile();
		return false;
	}

	@Override
	public boolean insertGuest(ArrayList<Guest> g, String roomNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int checkOut(String roomNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Guest> searchGuestByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Guest> searchGuestBySSn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveFile() {
		File f = new File("C:/test/hotel.dat");
		try {
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(rList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void loadFile() {
		File f = new File("C:/test/bank.dat");
		if (f.exists()) {
			try {
				fis = new FileInputStream(f);
				ois = new ObjectInputStream(fis);
				rList = (ArrayList<Room>) ois.readObject();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
