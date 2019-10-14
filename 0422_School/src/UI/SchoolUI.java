package UI;

import java.util.Scanner;

import Service.SchoolService;
import VO.Student;
import VO.Teacher;

public class SchoolUI {

	private SchoolService ss = new SchoolService();
	private int choice, age;
	private String name, stNo, tNo;
	private Scanner sc = new Scanner(System.in);

	public SchoolUI() {
		while (true) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1: // ����ϱ�
				subMenu();
				choice = sc.nextInt();
				System.out.print("�̸� : ");
				name = sc.next();
				System.out.print("���� : ");
				age = sc.nextInt();
				switch (choice) {
				case 1: // �л�����ϱ�
					System.out.print("�й� : ");
					stNo = sc.next();
					Student st = new Student(name, age, stNo);
					ss.insertPerson(st);
					break;
				case 2: // �������ϱ�
					System.out.print("���� : ");
					tNo = sc.next();
					Teacher t = new Teacher(name, age, tNo);
					ss.insertPerson(t);
					;
					break;
				}
				break;
			case 2:
				break;
			}
		}

	}

	public void menu() {
		System.out.println("1.���");
		System.out.println("2.���");
	}

	public void subMenu() {
		System.out.println("1.�л����");
		System.out.println("2.������");
	}
}
