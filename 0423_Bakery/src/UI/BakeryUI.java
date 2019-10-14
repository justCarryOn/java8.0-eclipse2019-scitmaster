package UI;

import java.util.Scanner;

import Service.BakeryService;
import VO.Bread;
import VO.Cake;
import VO.Roll;

public class BakeryUI {
	private Scanner sc = new Scanner(System.in);
	private int choice, length, size, price;
	private String name;
	private BakeryService bs = new BakeryService();

	public BakeryUI() {
		while (true) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				subMenu();
				choice = sc.nextInt();
				System.out.println("�̸�: ");
				name = sc.next();
				System.out.println("����: ");
				price = sc.nextInt();
				switch (choice) {
				case 1:
					Bread b = new Bread(name, price);
					bs.insertBread(b);
					break;
				case 2:
					System.out.println("������(ȣ): ");
					size = sc.nextInt();
					Cake c = new Cake(name, price, size);
					bs.insertBread(c);
					break;
				case 3:
					System.out.println("����(cm): ");
					length = sc.nextInt();
					Roll r = new Roll(name, price, length);
					bs.insertBread(r);
					break;
				default:
					System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�");
				}
				break;
			case 2:
				System.out.println(bs.print());
				break;
			default:
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�");
			}
		}
	}

	public void menu() {
		System.out.println("1.���");
		System.out.println("2.���");
	}

	public void subMenu() {
		System.out.println("1.�Ϲݻ�");
		System.out.println("2.����ũ");
		System.out.println("3.��");
	}
}
