package UI;

import java.util.Scanner;

import Manager.ClientManager;
import VO.Client;

public class ClientUI {

	private Scanner sc = new Scanner(System.in);
	private int choice;
	private String name,csn;
	private ClientManager cm=new ClientManager();
	
	public ClientUI() {
		while (true) {
			menu();
			choice = sc.nextInt();

			switch (choice) {
			case 1://등록
				System.out.println("이름 입력 : ");
				name=sc.next();
				System.out.println("회원번호 입력 : ");
				csn=sc.next();
				
				Client c=new Client(name,csn);
				
				cm.insertClient(c);
				
				break;
			case 2://전체출력
				cm.printAll();
				break;
			case 3://삭제
				break;
			}

		}
	}

	public void menu() {
		System.out.println("==============");
		System.out.println("1.등록");
		System.out.println("2.전체출력");
		System.out.println("3.삭제");
		System.out.println("==============");
	}

}
