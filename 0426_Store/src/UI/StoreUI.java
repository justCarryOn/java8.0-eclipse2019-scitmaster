package UI;

import java.util.Scanner;

import Service.StoreService;
import VO.Food;
import VO.Medicine;
import VO.Product;

public class StoreUI {
	private Scanner sc = new Scanner(System.in);
	private String name, pCode, dueDate, kind, shelfLife;
	private int number = 0, price = 0, calorie = 0, choice;
	private StoreService ss = new StoreService();

	public StoreUI() {
		while (true) {
			sc = new Scanner(System.in);
			menu();
			try {
				choice = sc.nextInt();
			} catch (Exception e) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
				continue;
			}
			switch (choice) {
			case 1:
				System.out.println("�̸�: ");
				try {
					name = sc.next();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("��ǰ�ڵ�: ");
				try {
					pCode = sc.next();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("����: ");
				try {
					number = sc.nextInt();
				} catch (Exception e) {
					sc=new Scanner(System.in);
					System.out.println("�Է½���, �⺻��=0");
				}
				System.out.println("����: ");
				try {
					price = sc.nextInt();
				} catch (Exception e) {
					sc=new Scanner(System.in);
					System.out.println("�Է½���, �⺻��=0");
					
				}
				subMenu();
				try {
					choice = sc.nextInt();
				} catch (Exception e) {
					
				}
				switch (choice) {
				case 1:
					Product p = new Product(name, pCode, number, price);
					ss.insert(p);
					break;
				case 2:
					System.out.println("Į�θ�: ");
					try {
						calorie = sc.nextInt();
					} catch (Exception e) {
						calorie = 0;
						e.printStackTrace();
					}
					System.out.println("�������: ");
					try {
						dueDate = sc.next();
					} catch (Exception e) {
						e.printStackTrace();
					}
					Food f = new Food(name, pCode, number, price, calorie, dueDate);
					ss.insert(f);
					break;
				case 3:
					System.out.println("������: ");
					try {
						kind = sc.next();
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("��ȿ�Ⱓ: ");
					try {
						shelfLife = sc.next();
					} catch (Exception e) {
						e.printStackTrace();
					}
					Medicine m = new Medicine(name, pCode, number, price, kind, shelfLife);
					ss.insert(m);
					break;
				}
				break;
			case 2:
				ss.printAll();
				break;
			case 3:
				System.out.println("��ǰ�ڵ� : ");
				try {
					pCode = sc.next();
				} catch (Exception e) {
					e.printStackTrace();
				}
				ss.searchpCode(pCode);
				break;
			case 4:

				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				System.out.println("��ǰ �������: ");
				try {
					dueDate = sc.next();
				} catch (Exception e) {
					e.printStackTrace();
				}
				ss.searchdueDate(dueDate);
				break;
			case 8:
				System.out.println("��ǰ ��ȿ�Ⱓ: ");
				try {
					shelfLife = sc.next();
				} catch (Exception e) {
					e.printStackTrace();
				}
				ss.searchShelfLife(shelfLife);
				break;
			case 9:
				ss.printFood();
				break;
			case 10:
				ss.printMedicine();
				break;
			case 11:
				ss.printProduct();
				break;
			case 12:
				ss.printZero();
				break;
			default:
				System.out.println("��Ȯ�� ��ȣ�� �����ּ���");
			}
		}
	}

	public void menu() {
		System.out.println("1.���");
		System.out.println("2.��ü���");
		System.out.println("3.��ǰ�ڵ�˻�");
		System.out.println("4.��ǰ����");
		System.out.println("5.�Ǹ�");
		System.out.println("6.���Ǹžװ��");
		System.out.println("7.��ǰ������Ѱ˻�");
		System.out.println("8.��ǰ��ȿ�Ⱓ�˻�");
		System.out.println("9.��ǰ�����");
		System.out.println("10.��ǰ�����");
		System.out.println("11.�Ϲ���ǰ�����");
		System.out.println("12.����0����ǰ���");
	}

	public void subMenu() {
		System.out.println("1.�Ϲ���ǰ");
		System.out.println("2.��ǰ");
		System.out.println("3.��ǰ");

	}
}
