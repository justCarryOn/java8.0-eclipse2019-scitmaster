package ui;

import java.util.Scanner;

public class GameUI {
	private Scanner sc=new Scanner(System.in);
	private boolean flag=true;
	private int choice;
	
	public GameUI() {
		while(flag) {
			menu();
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 9:
				boolean flag=false;
				break;
			}
			
		}
	}

	public void menu() {
		System.out.println("===== Toy Manager ======");
		System.out.println("1. �峭�� ���");
		System.out.println("2. �峭�� �˻�");
		System.out.println("3. �峭�� ����");
		System.out.println("4. ���ݴ� �˻�");
		System.out.println("5. �峭�� ���� ���");
		System.out.println("5. ����");
		System.out.println("=======================");
		System.out.println("[ �޴� ���� ]");
	}
}
