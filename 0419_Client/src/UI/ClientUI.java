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
				System.out.print("�̸� : ");
				name = sc.next();
				System.out.print("��Ϲ�ȣ : ");
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
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�");
			}
		}
	}

	public void menu() {
		System.out.println("1.���");
		System.out.println("2.���");
		System.out.println("3.����");
		System.out.println("4.����");
	}

}
