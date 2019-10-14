package UI;

import java.util.*;

import Manager.ClientManager;

public class ClientUI {
	private Scanner sc = new Scanner(System.in);
	private String name, csn;
	private int choice;
	private ClientManager cm = new ClientManager();
	private boolean flag = true;

	public ClientUI() {
		while (flag) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("이름 : ");
				name = sc.next();
				System.out.print("등록번호 : ");
				csn = sc.next();
				break;
			case 2:
				cm.printAll();
				break;
			case 3:
				break;
			case 4:
				flag = false;
				break;

			default:
				System.out.println("번호를 잘못 입력하셨습니다");
			}
		}
	}

	public void menu() {
		System.out.println("1.등록");
		System.out.println("2.출력");
		System.out.println("3.삭제");
		System.out.println("4.종료");
	}

}
