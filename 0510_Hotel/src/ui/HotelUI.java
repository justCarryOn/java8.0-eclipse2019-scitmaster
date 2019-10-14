package ui;

import java.util.Scanner;

import service.HotelService;
import vo.Room;

public class HotelUI {
	private Scanner sc = new Scanner(System.in);
	private HotelService hs = new HotelService();
	private String name, ssn, roomNum, numBed, roomType;
	private int price, choice;
	private boolean flag = true;

	public HotelUI() {
		while (flag)
			menu();
		choice=sc.nextInt();
		switch(choice){
		case 1:
			hs.makeRoom(makeRoom());
			break;
		case 2:
			
			break;
		case 3:
			hs.checkOut(roomNum);
			break;
		case 4:
			System.out.println("이름:" );
			name=sc.next();
			hs.searchGuestByName(name);
			break;
		case 5:
			System.out.println("주민번호:" );
			ssn=sc.next();
			hs.searchGuestBySSn(ssn);
			break;
			
		}
	}

	public void menu() {
		System.out.println("1.방등록");
		System.out.println("2.체크인");
		System.out.println("3.체크아웃");
		System.out.println("4.이름으로검색");
		System.out.println("5.주민번호로검색");
	}
	
	public Room makeRoom() {
		System.out.println("방번호: ");
		roomNum=sc.next();
		System.out.println("침대개수: ");
		numBed=sc.next();
		System.out.println("1박가격: ");
		price=sc.nextInt();
		System.out.println("방타입: ");
		roomType=sc.next();
		return new Room(null, roomNum, numBed, price, roomType);
	}
}
