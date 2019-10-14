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
			case 1: // 등록하기
				subMenu();
				choice = sc.nextInt();
				System.out.print("이름 : ");
				name = sc.next();
				System.out.print("나이 : ");
				age = sc.nextInt();
				switch (choice) {
				case 1: // 학생등록하기
					System.out.print("학번 : ");
					stNo = sc.next();
					Student st = new Student(name, age, stNo);
					ss.insertPerson(st);
					break;
				case 2: // 교사등록하기
					System.out.print("교번 : ");
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
		System.out.println("1.등록");
		System.out.println("2.출력");
	}

	public void subMenu() {
		System.out.println("1.학생등록");
		System.out.println("2.교사등록");
	}
}
