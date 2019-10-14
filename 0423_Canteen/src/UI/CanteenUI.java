package UI;

import java.util.Scanner;

import Service.CanteenService;
import VO.Note;
import VO.Pencil;
import VO.Product;

public class CanteenUI {
	private Scanner sc = new Scanner(System.in);
	private int price, noPage, choice;
	private String name, pCode, kind;
	private CanteenService cs = new CanteenService();

	public CanteenUI() {
		while (true) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("��ǰ��: ");
				name = sc.next();
				System.out.println("��ǰ�ڵ�: ");
				pCode = sc.next();
				System.out.println("����: ");
				price = sc.nextInt();
				subMenu();
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					Product pd = new Product(name, pCode, price);
					cs.insertProduct(pd);
					break;
				case 2:
					System.out.println("��������: ");
					noPage = sc.nextInt();
					Note n = new Note(name, pCode, price, noPage);
					cs.insertProduct(n);
					break;
				case 3:
					System.out.println("�� ����: ");
					kind = sc.next();
					Pencil p = new Pencil(name, pCode, price, kind);
					cs.insertProduct(p);
					break;
				default:
					System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�");
				}
				break;
			case 2:
				printMenu();
				choice=sc.nextInt();
						switch (choice) {
						case 1:
							System.out.println(cs.printAll());
							break;
						case 2:
							System.out.println(cs.printNote());
							break;
						case 3:
							System.out.println(cs.printPencil());
							break;
							default :
								System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�");
						}
				break;
			case 3:
				System.out.println("��ǰ�ڵ�: ");
				pCode = sc.next();
				cs.search(pCode);
				break;
			case 4:
				pCode = sc.next();
				cs.delete(pCode);
				break;
			default:
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�");
			}
		}
	}

	public void menu() {
		System.out.println("1.���");
		System.out.println("2.���");
		System.out.println("3.�˻�");
		System.out.println("4.����");
	}

	public void subMenu() {
		System.out.println("1.�Ϲݹ���");
		System.out.println("2.��Ʈ");
		System.out.println("3.����");
	}

	public void printMenu() {
		System.out.println("1.��ü���");
		System.out.println("2.��Ʈ���");
		System.out.println("3.�������");
	}
}
