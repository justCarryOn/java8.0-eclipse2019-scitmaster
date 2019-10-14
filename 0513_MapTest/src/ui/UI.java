package ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import service.Service;
import vo.Person;

public class UI {
	private Scanner sc = new Scanner(System.in);
	private Service ps = new Service();
	private boolean flag = true;
	private String name, ssn;
	private int choice;

	public UI() {
		while (flag) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				ps.insertPerson(insertPerson());
				break;
			case 2:
				System.out.println("주민번호: ");
				ssn = sc.next();
				System.out.println(ps.searchPerson(ssn));
				break;
			case 3:
				System.out.println(ps.printAll());
				break;
			case 4:
				System.out.println("주민번호: ");
				ssn = sc.next();
				if (ps.removePerson(ssn)) {
					System.out.println("삭제완료");
				} else {
					System.out.println("삭제실패");
				}
				break;
			case 5:
				System.out.println("주민번호: ");
				ssn = sc.next();
				Person p = insertPerson();
				if (ps.renamePerson(ssn, p)) {
					System.out.println("수정완료");
				} else {
					System.out.println("수정실패");
				}
				break;
			}
		}

	}

	public void menu() {
		System.out.println("1.주민등록");
		System.out.println("2.주민검색");
		System.out.println("3.전체출력");
		System.out.println("4.주민삭제");
		System.out.println("5.정보수정");
	}

	public Person insertPerson() {
		System.out.println("주민번호: ");
		ssn = sc.next();
		System.out.println("이름: ");
		name = sc.next();
		return new Person(name, ssn);
	}
}
