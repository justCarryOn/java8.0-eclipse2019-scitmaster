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
		System.out.println("1. 장난감 등록");
		System.out.println("2. 장난감 검색");
		System.out.println("3. 장난감 변경");
		System.out.println("4. 가격대 검색");
		System.out.println("5. 장난감 정보 출력");
		System.out.println("5. 종료");
		System.out.println("=======================");
		System.out.println("[ 메뉴 선택 ]");
	}
}
