package UI;

import java.util.Scanner;

import Service.CanteenService;
import VO.Note;
import VO.Pencil;
import VO.Product;

public class CanteenUI {
	private Scanner sc = new Scanner(System.in);
	private int price, noPage, choice;
	private String name, pCode, kind;
	private CanteenService cs = new CanteenService();

	public CanteenUI() {
		while (true) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("상품명: ");
				name = sc.next();
				System.out.println("제품코드: ");
				pCode = sc.next();
				System.out.println("가격: ");
				price = sc.nextInt();
				subMenu();
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					Product pd = new Product(name, pCode, price);
					cs.insertProduct(pd);
					break;
				case 2:
					System.out.println("페이지수: ");
					noPage = sc.nextInt();
					Note n = new Note(name, pCode, price, noPage);
					cs.insertProduct(n);
					break;
				case 3:
					System.out.println("심 종류: ");
					kind = sc.next();
					Pencil p = new Pencil(name, pCode, price, kind);
					cs.insertProduct(p);
					break;
				default:
					System.out.println("번호를 잘못 입력하셨습니다");
				}
				break;
			case 2:
				printMenu();
				choice=sc.nextInt();
						switch (choice) {
						case 1:
							System.out.println(cs.printAll());
							break;
						case 2:
							System.out.println(cs.printNote());
							break;
						case 3:
							System.out.println(cs.printPencil());
							break;
							default :
								System.out.println("번호를 잘못 입력하셨습니다");
						}
				break;
			case 3:
				System.out.println("제품코드: ");
				pCode = sc.next();
				cs.search(pCode);
				break;
			case 4:
				pCode = sc.next();
				cs.delete(pCode);
				break;
			default:
				System.out.println("번호를 잘못 입력하셨습니다");
			}
		}
	}

	public void menu() {
		System.out.println("1.등록");
		System.out.println("2.출력");
		System.out.println("3.검색");
		System.out.println("4.삭제");
	}

	public void subMenu() {
		System.out.println("1.일반문구");
		System.out.println("2.노트");
		System.out.println("3.연필");
	}

	public void printMenu() {
		System.out.println("1.전체출력");
		System.out.println("2.노트출력");
		System.out.println("3.연필출력");
	}
}
