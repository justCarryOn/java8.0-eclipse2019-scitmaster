package UI;

import java.util.ArrayList;
import java.util.Scanner;

import Service.DVDcafeService;
import VO.Movie;
import VO.DVD;
import VO.Device;
import VO.USB;

public class DVDcafeUI {

	private int price, movieNum, choice;
	private String title, playTime, genre, rackNum, madeDate;
	private ArrayList<String> titleList;
	private Scanner sc = new Scanner(System.in);
	private DVDcafeService ds = new DVDcafeService();
	private boolean flag = true;

	public DVDcafeUI() {
		while (flag) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				Movie m = insertMenu();
				ds.insert(m);
				break;
			case 2:
				ds.print();
				break;
			case 3:
				if (ds.makeDVD(dvdMenu(), title)) {
					System.out.println("��ϼ���");
				} else {
					System.out.println("��Ͻ���");
				}
				break;
			case 4:
				USB u = usbMenu();
				ds.makeUSB(usbMenu(), titleList);
				break;
			case 5:
				System.out.println("����: ");
				title=sc.next();
				ds.search(title);
				break;
			case 6:
				System.out.println("���α׷��� �����մϴ�");
				flag = false;
			default:
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�");
			}
		}
	}

	public void menu() {
		System.out.println("1.��ȭ���");
		System.out.println("2.��Ϻ���");
		System.out.println("3.DVD����");
		System.out.println("4.USB����");
		System.out.println("5.��ȭ�˻�");
		System.out.println("6.����");
	}

	public Movie insertMenu() {
		System.out.println("����: ");
		title = sc.next();
		System.out.println("�ð�: ");
		playTime = sc.next();
		System.out.println("�帣: ");
		genre = sc.next();
		System.out.println("����: ");
		price = sc.nextInt();
		return new Movie(title, playTime, genre, price);
	}

	public DVD dvdMenu() {
		System.out.println("��ȣ: ");
		rackNum = sc.next();
		System.out.println("����: ");
		title = sc.next();
		System.out.println("��������: ");
		madeDate = sc.next();
		DVD d = new DVD();
		d.setRackNum(rackNum);
		d.setMadeDate(madeDate);
		return d;
	}

	public USB usbMenu() {
		System.out.println("��ȣ: ");
		rackNum = sc.next();
		System.out.println("��ȭ��: ");
		movieNum = sc.nextInt();
		for (int i = 0; i < movieNum; i++) {
			System.out.println("����: ");
			String title = sc.next();
			titleList.add(title);
		}
		USB u = new USB();
		u.setRackNum(rackNum);
		return u;
	}
}
