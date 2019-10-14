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
			System.out.println("�̸�:" );
			name=sc.next();
			hs.searchGuestByName(name);
			break;
		case 5:
			System.out.println("�ֹι�ȣ:" );
			ssn=sc.next();
			hs.searchGuestBySSn(ssn);
			break;
			
		}
	}

	public void menu() {
		System.out.println("1.����");
		System.out.println("2.üũ��");
		System.out.println("3.üũ�ƿ�");
		System.out.println("4.�̸����ΰ˻�");
		System.out.println("5.�ֹι�ȣ�ΰ˻�");
	}
	
	public Room makeRoom() {
		System.out.println("���ȣ: ");
		roomNum=sc.next();
		System.out.println("ħ�밳��: ");
		numBed=sc.next();
		System.out.println("1�ڰ���: ");
		price=sc.nextInt();
		System.out.println("��Ÿ��: ");
		roomType=sc.next();
		return new Room(null, roomNum, numBed, price, roomType);
	}
}
