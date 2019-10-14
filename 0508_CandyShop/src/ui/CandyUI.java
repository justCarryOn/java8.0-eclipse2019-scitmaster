package ui;

import java.util.Scanner;

import service.CandyService;
import vo.Candy;

public class CandyUI {

	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private String pCode, name, flavor, color;
	private int amount, choice;
	private boolean flag = true;
	private CandyService cs;

	public CandyUI() {
		cs=new CandyService();
		while (flag) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				cs.insertCandy(makeCandy());
				break;
			case 2:
				System.out.println(cs.printAll());
				break;
			case 9:
				flag=false;
				break;
			}
		}
	}

	public void menu() {
		System.out.println("============");
		System.out.println("1.���");
		System.out.println("2.��ü���");
		System.out.println("9.����");
		System.out.println("============");
	}

	public Candy makeCandy() {
		
		System.out.println("�̸� �Է� : ");
		name = scLine.nextLine();
		System.out.println("���� �Է� : ");
		color = scLine.nextLine();
		System.out.println("���� �Է� : ");
		amount = sc.nextInt();
		System.out.println("�� �Է� : ");
		flavor = scLine.nextLine();
		System.out.println("��ǰ�ڵ� �Է� : ");
		pCode = scLine.nextLine();

		return new Candy(name, color, amount, flavor, pCode);
	}

}
