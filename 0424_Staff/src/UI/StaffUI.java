package UI;

import java.util.Scanner;

import Service.StaffService;
import VO.Cleaner;
import VO.Staff;
import VO.Teacher;

public class StaffUI {

	private Scanner sc = new Scanner(System.in);
	private String name, ssn, position, tsn, offDay;
	private int choice;
	private StaffService ss = new StaffService();

	public StaffUI() {
		while (true) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("�̸�: ");
				name = sc.next();
				System.out.println("�ֹι�ȣ: ");
				ssn = sc.next();
				System.out.println("����: ");
				position = sc.next();
				subMenu();
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					Staff s = new Staff(name, ssn, position);
					ss.insertStaff(s);
					break;
				case 2:
					System.out.println("����: ");
					tsn = sc.next();
					Teacher t = new Teacher(name, ssn, position, tsn);
					ss.insertStaff(t);
					break;
				case 3:
					System.out.println("�����: ");
					offDay = sc.next();
					Cleaner c = new Cleaner(name, ssn, position, offDay);
					ss.insertStaff(c);
					break;
				default:
					System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
				}
				break;
			case 2:
				printMenu();
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println(ss.printAll());
					break;
				case 2:
					System.out.println(ss.printTeacher());
					break;
				case 3:
					System.out.println(ss.printCleaner());
					break;
				default:
					System.out.println("������ �߸� �Է��ϼ̽��ϴ�");
				}
				break;
			case 3:
				searchMenu();
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("�ֹι�ȣ: ");
					ssn = sc.next();
					System.out.println(ss.searchSsn(ssn));
					break;
				case 2:
					System.out.println("����: ");
					position = sc.next();
					System.out.println(ss.searchPosition(position));
					break;
				case 3:
					System.out.println("����: ");
					tsn = sc.next();
					System.out.println(ss.searchTsn(tsn));
					break;
				case 4:
					System.out.println("�������: ");
					offDay = sc.next();
					System.out.println(ss.searchOffDay(offDay));
					break;
				default:
				}
				break;
			case 4:
				System.out.println("�ֹι�ȣ: ");
				ssn = sc.next();
				ss.delSsn(ssn);
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
		System.out.println("1.�Ϲ�����");
		System.out.println("2.����");
		System.out.println("3.û�Һ�");
	}

	public void printMenu() {
		System.out.println("1.��ü���");
		System.out.println("2.�������");
		System.out.println("3.û�Һ����");
	}

	public void searchMenu() {
		System.out.println("1.�ֹι�ȣ�˻�");
		System.out.println("2.���ް˻�");
		System.out.println("3.�����˻�");
		System.out.println("4.������ڰ˻�");
	}
}
