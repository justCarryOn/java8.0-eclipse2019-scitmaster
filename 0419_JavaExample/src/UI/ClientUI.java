package UI;

import java.util.Scanner;

import Manager.ClientManager;
import VO.Client;

public class ClientUI {

	private Scanner sc = new Scanner(System.in);
	private int choice;
	private String name,csn;
	private ClientManager cm=new ClientManager();
	
	public ClientUI() {
		while (true) {
			menu();
			choice = sc.nextInt();

			switch (choice) {
			case 1://���
				System.out.println("�̸� �Է� : ");
				name=sc.next();
				System.out.println("ȸ����ȣ �Է� : ");
				csn=sc.next();
				
				Client c=new Client(name,csn);
				
				cm.insertClient(c);
				
				break;
			case 2://��ü���
				cm.printAll();
				break;
			case 3://����
				break;
			}

		}
	}

	public void menu() {
		System.out.println("==============");
		System.out.println("1.���");
		System.out.println("2.��ü���");
		System.out.println("3.����");
		System.out.println("==============");
	}

}
