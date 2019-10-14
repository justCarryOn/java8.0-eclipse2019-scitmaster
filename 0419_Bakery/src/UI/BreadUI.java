package UI;

import java.util.Scanner;

import Manager.BreadManager;
import VO.Bread;

public class BreadUI {
	private Scanner sc = new Scanner(System.in);
	private String name, bsn, maker;
	private int price, choice;
	private boolean flag = true;
	private BreadManager bm = new BreadManager();

	public BreadUI() {
		while (flag) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("��ǰ�� : ");
				name = sc.next();
				System.out.print("������ȣ : ");
				bsn = sc.next();
				System.out.print("���� : ");
				price = sc.nextInt();
				System.out.print("������ : ");
				maker = sc.next();
				bm.insertBread(new Bread(name,bsn,maker,price));
				break;
			case 2:
				System.out.print("������ȣ : ");
				bsn = sc.next();
				bm.deleteBread(bsn);
				break;
			case 3:
				bm.printAll();
				break;
			case 4:
				System.out.print("������ȣ : ");
				bsn = sc.next();
				bm.searchBread(bsn);
				break;
			case 5:
				flag = false;
				break;
			default:
				System.out.println("�߸��� ��ȣ�� �Է��ϼ̽��ϴ�");
			}
		}
		System.out.println();
	}

	public void menu() {
		System.out.println("1.���");
		System.out.println("2.����");
		System.out.println("3.���");
		System.out.println("4.�˻�");
		System.out.println("5.����");
	}
}
