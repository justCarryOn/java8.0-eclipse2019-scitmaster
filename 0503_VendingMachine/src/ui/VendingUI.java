package ui;

import java.util.ArrayList;
import java.util.Scanner;

import service.VendingService;
import vo.Product;

public class VendingUI {
	Scanner sc = new Scanner(System.in);
	private VendingService vs = new VendingService();
	private int money, price, amount, buttonNumber, change, choice;
	private String name, pCode, weight, volume, id, pw;

	public VendingUI() {
		while (true) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println(vs.showProducts());
				break;
			case 2:
				System.out.println("금액: ");
				money = sc.nextInt();
				System.out.println(vs.insertMoney(money));
				break;
			case 3:
				System.out.println("번호: ");
				buttonNumber = sc.nextInt();
				change = vs.buyProduct(buttonNumber);
				if (change <= 0) {
					System.out.println("구매불가");
				} else {
					System.out.println("구매성공, 잔액: " + change);
				}

				break;
			case 4:
				System.out.println("ID: ");
				id = sc.next();
				System.out.println("PW: ");
				pw = sc.next();
				if (true) {
					adminMenu();

				} else {
					System.out.println("관리자 정보가 일치하지 않습니다");
				}
				break;
			}
		}
	}

	public void menu() {
		System.out.println("==========사용자메뉴==========");
		System.out.println("1.상품보기");
		System.out.println("2.지폐넣기");
		System.out.println("3.상품구매");
		System.out.println("4.관리자 로그인");
		System.out.println("===========================");
	}

	public void adminMenu() {
		System.out.println("===========관리자용============");
		System.out.println("1.재고충전");
		System.out.println("2.재고가필요한상품목록");
		System.out.println("3.판매된제품통계");
		System.out.println("===========================");
	}
}
