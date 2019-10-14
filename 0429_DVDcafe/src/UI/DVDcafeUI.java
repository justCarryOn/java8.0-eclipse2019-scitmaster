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
					System.out.println("등록성공");
				} else {
					System.out.println("등록실패");
				}
				break;
			case 4:
				USB u = usbMenu();
				ds.makeUSB(usbMenu(), titleList);
				break;
			case 5:
				System.out.println("제목: ");
				title=sc.next();
				ds.search(title);
				break;
			case 6:
				System.out.println("프로그램을 종료합니다");
				flag = false;
			default:
				System.out.println("번호를 잘못 입력하셨습니다");
			}
		}
	}

	public void menu() {
		System.out.println("1.영화등록");
		System.out.println("2.목록보기");
		System.out.println("3.DVD제조");
		System.out.println("4.USB제조");
		System.out.println("5.영화검색");
		System.out.println("6.종료");
	}

	public Movie insertMenu() {
		System.out.println("제목: ");
		title = sc.next();
		System.out.println("시간: ");
		playTime = sc.next();
		System.out.println("장르: ");
		genre = sc.next();
		System.out.println("가격: ");
		price = sc.nextInt();
		return new Movie(title, playTime, genre, price);
	}

	public DVD dvdMenu() {
		System.out.println("번호: ");
		rackNum = sc.next();
		System.out.println("제목: ");
		title = sc.next();
		System.out.println("제조일자: ");
		madeDate = sc.next();
		DVD d = new DVD();
		d.setRackNum(rackNum);
		d.setMadeDate(madeDate);
		return d;
	}

	public USB usbMenu() {
		System.out.println("번호: ");
		rackNum = sc.next();
		System.out.println("영화수: ");
		movieNum = sc.nextInt();
		for (int i = 0; i < movieNum; i++) {
			System.out.println("제목: ");
			String title = sc.next();
			titleList.add(title);
		}
		USB u = new USB();
		u.setRackNum(rackNum);
		return u;
	}
}
