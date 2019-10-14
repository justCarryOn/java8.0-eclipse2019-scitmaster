package UI;

import java.util.Scanner;

import Manager.BreadManager;
import VO.Bread;

public class BreadUI {
	private Scanner sc = new Scanner(System.in);
	private String name, bsn, maker;
	private int price, choice;
	private boolean flag = true;
	private BreadManager bm = new BreadManager();

	public BreadUI() {
		while (flag) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("제품명 : ");
				name = sc.next();
				System.out.print("제조번호 : ");
				bsn = sc.next();
				System.out.print("가격 : ");
				price = sc.nextInt();
				System.out.print("제조자 : ");
				maker = sc.next();
				bm.insertBread(new Bread(name,bsn,maker,price));
				break;
			case 2:
				System.out.print("제조번호 : ");
				bsn = sc.next();
				bm.deleteBread(bsn);
				break;
			case 3:
				bm.printAll();
				break;
			case 4:
				System.out.print("제조번호 : ");
				bsn = sc.next();
				bm.searchBread(bsn);
				break;
			case 5:
				flag = false;
				break;
			default:
				System.out.println("잘못된 번호를 입력하셨습니다");
			}
		}
		System.out.println();
	}

	public void menu() {
		System.out.println("1.등록");
		System.out.println("2.삭제");
		System.out.println("3.출력");
		System.out.println("4.검색");
		System.out.println("5.종료");
	}
}
