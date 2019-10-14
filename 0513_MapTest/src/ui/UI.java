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
				System.out.println("�ֹι�ȣ: ");
				ssn = sc.next();
				System.out.println(ps.searchPerson(ssn));
				break;
			case 3:
				System.out.println(ps.printAll());
				break;
			case 4:
				System.out.println("�ֹι�ȣ: ");
				ssn = sc.next();
				if (ps.removePerson(ssn)) {
					System.out.println("�����Ϸ�");
				} else {
					System.out.println("��������");
				}
				break;
			case 5:
				System.out.println("�ֹι�ȣ: ");
				ssn = sc.next();
				Person p = insertPerson();
				if (ps.renamePerson(ssn, p)) {
					System.out.println("�����Ϸ�");
				} else {
					System.out.println("��������");
				}
				break;
			}
		}

	}

	public void menu() {
		System.out.println("1.�ֹε��");
		System.out.println("2.�ֹΰ˻�");
		System.out.println("3.��ü���");
		System.out.println("4.�ֹλ���");
		System.out.println("5.��������");
	}

	public Person insertPerson() {
		System.out.println("�ֹι�ȣ: ");
		ssn = sc.next();
		System.out.println("�̸�: ");
		name = sc.next();
		return new Person(name, ssn);
	}
}
