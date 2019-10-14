package UI;

import java.util.Scanner;

import Service.BakeryService;
import VO.Bread;
import VO.Cake;
import VO.Roll;

public class BakeryUI {
	private Scanner sc = new Scanner(System.in);
	private int choice, length, size, price;
	private String name;
	private BakeryService bs = new BakeryService();

	public BakeryUI() {
		while (true) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				subMenu();
				choice = sc.nextInt();
				System.out.println("이름: ");
				name = sc.next();
				System.out.println("가격: ");
				price = sc.nextInt();
				switch (choice) {
				case 1:
					Bread b = new Bread(name, price);
					bs.insertBread(b);
					break;
				case 2:
					System.out.println("사이즈(호): ");
					size = sc.nextInt();
					Cake c = new Cake(name, price, size);
					bs.insertBread(c);
					break;
				case 3:
					System.out.println("길이(cm): ");
					length = sc.nextInt();
					Roll r = new Roll(name, price, length);
					bs.insertBread(r);
					break;
				default:
					System.out.println("번호를 잘못 입력하셨습니다");
				}
				break;
			case 2:
				System.out.println(bs.print());
				break;
			default:
				System.out.println("번호를 잘못 입력하셨습니다");
			}
		}
	}

	public void menu() {
		System.out.println("1.등록");
		System.out.println("2.출력");
	}

	public void subMenu() {
		System.out.println("1.일반빵");
		System.out.println("2.케이크");
		System.out.println("3.롤");
	}
}
