package global.sesoc.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import global.sesoc.vo.Bicycle;
import global.sesoc.vo.Drone;
import global.sesoc.vo.GameConsole;
import global.sesoc.vo.Toy;

public class ToyManagerMgr implements ToyManager {

	private final String FILE_NAME = "toy.dat";
	private List<Toy> toyList = new ArrayList<>();
	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public ToyManagerMgr() {
		if (new File(FILE_NAME).exists()) {
			loadFile();
		} else {
			toyList = new ArrayList<>();
		}
	}

	public void saveFile() {
		File f = new File(FILE_NAME);
		try {
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(toyList);
			;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				oos.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void loadFile() {
		File f = new File(FILE_NAME);
		try {
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			toyList = (List<Toy>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean insertToy(Toy toy) {
		if (searchToy(toy.getSerialNum()) == null) {
			toyList.add(toy);
			System.out.println("등록 성공");
			saveFile();
			return true;
		}
		System.out.println("등록 실패");
		return false;
	}

	@Override
	public Toy searchToy(String serialNum) {
		Toy sToy = null;
		for (Toy toy : toyList) {
			if (toy.getSerialNum().equals(serialNum)) {
				sToy = toy;
			}
		}
		return sToy;
	}

	@Override
	public boolean deleteToy(String serialNum) {
		Toy sToy = searchToy(serialNum);
		if (sToy != null) {
			toyList.remove(sToy);
			return true;
		}
		return false;
	}

	@Override
	public List<Toy> toyListForPrice(int minPrice, int maxPrice) {
		List<Toy> tList = new ArrayList<>();
		for (Toy toy : toyList) {
			if (toy.getPrice() >= minPrice && toy.getPrice() <= maxPrice) {
				tList.add(toy);
			}
		}
		return tList;
	}

	@Override
	public List<Toy> printToyInfo(int type) {
		List<Toy> tList = new ArrayList<>();
		switch (type) {
		case 1:
			return toyList;
		case 2:
			for (Toy toy : toyList) {
				if (toy instanceof Bicycle) {
					tList.add(toy);
				}
			}
			break;
		case 3:
			for (Toy toy : toyList) {
				if (toy instanceof Drone) {
					tList.add(toy);
				}
			}
			break;
		case 4:
			for (Toy toy : toyList) {
				if (toy instanceof GameConsole) {
					tList.add(toy);
				}
			}
			break;
		}
		return tList;
	}

}