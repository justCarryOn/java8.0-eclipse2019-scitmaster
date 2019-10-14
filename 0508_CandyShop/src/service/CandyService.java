package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import vo.Candy;

public class CandyService {

	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private ArrayList<Candy> cList = new ArrayList<>();

	public CandyService() {
		loadData();
	}

	public void insertCandy(Candy c) {//����ϱ�
		cList.add(c);
		saveData();
	}

	public String printAll() {//��ü���
		String con = "";

		for (Candy c : cList) {
			con += c + "\n";
		}
		return con;
	}

	public void saveData() {// ���� �����ϱ�
		File f = new File("C:/test/candy.dat");

		try {
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(cList);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void loadData() {// ���� �о����
		File f = new File("C:/test/candy.dat");

		if (f.exists()) {
			try {
				fis = new FileInputStream(f);
				ois = new ObjectInputStream(fis);
				cList = (ArrayList<Candy>) ois.readObject();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void closeStream() {//���α׷� ����

		if (oos != null) {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (ois != null) {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
