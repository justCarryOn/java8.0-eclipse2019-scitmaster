package UI;

import java.util.Scanner;

import Service.StoreService;
import VO.Food;
import VO.Medicine;
import VO.Product;

public class StoreUI {
	private Scanner sc = new Scanner(System.in);
	private String name, pCode, dueDate, kind, shelfLife;
	private int number = 0, price = 0, calorie = 0, choice;
	private StoreService ss = new StoreService();

	public StoreUI() {
		while (true) {
			sc = new Scanner(System.in);
			menu();
			try {
				choice = sc.nextInt();
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다");
				continue;
			}
			switch (choice) {
			case 1:
				System.out.println("이름: ");
				try {
					name = sc.next();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("제품코드: ");
				try {
					pCode = sc.next();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("수량: ");
				try {
					number = sc.nextInt();
				} catch (Exception e) {
					sc=new Scanner(System.in);
					System.out.println("입력실패, 기본값=0");
				}
				System.out.println("가격: ");
				try {
					price = sc.nextInt();
				} catch (Exception e) {
					sc=new Scanner(System.in);
					System.out.println("입력실패, 기본값=0");
					
				}
				subMenu();
				try {
					choice = sc.nextInt();
				} catch (Exception e) {
					
				}
				switch (choice) {
				case 1:
					Product p = new Product(name, pCode, number, price);
					ss.insert(p);
					break;
				case 2:
					System.out.println("칼로리: ");
					try {
						calorie = sc.nextInt();
					} catch (Exception e) {
						calorie = 0;
						e.printStackTrace();
					}
					System.out.println("유통기한: ");
					try {
						dueDate = sc.next();
					} catch (Exception e) {
						e.printStackTrace();
					}
					Food f = new Food(name, pCode, number, price, calorie, dueDate);
					ss.insert(f);
					break;
				case 3:
					System.out.println("약종류: ");
					try {
						kind = sc.next();
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("유효기간: ");
					try {
						shelfLife = sc.next();
					} catch (Exception e) {
						e.printStackTrace();
					}
					Medicine m = new Medicine(name, pCode, number, price, kind, shelfLife);
					ss.insert(m);
					break;
				}
				break;
			case 2:
				ss.printAll();
				break;
			case 3:
				System.out.println("제품코드 : ");
				try {
					pCode = sc.next();
				} catch (Exception e) {
					e.printStackTrace();
				}
				ss.searchpCode(pCode);
				break;
			case 4:

				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				System.out.println("식품 유통기한: ");
				try {
					dueDate = sc.next();
				} catch (Exception e) {
					e.printStackTrace();
				}
				ss.searchdueDate(dueDate);
				break;
			case 8:
				System.out.println("약품 유효기간: ");
				try {
					shelfLife = sc.next();
				} catch (Exception e) {
					e.printStackTrace();
				}
				ss.searchShelfLife(shelfLife);
				break;
			case 9:
				ss.printFood();
				break;
			case 10:
				ss.printMedicine();
				break;
			case 11:
				ss.printProduct();
				break;
			case 12:
				ss.printZero();
				break;
			default:
				System.out.println("정확한 번호를 눌러주세요");
			}
		}
	}

	public void menu() {
		System.out.println("1.등록");
		System.out.println("2.전체출력");
		System.out.println("3.제품코드검색");
		System.out.println("4.제품삭제");
		System.out.println("5.판매");
		System.out.println("6.총판매액계산");
		System.out.println("7.식품유통기한검색");
		System.out.println("8.약품유효기간검색");
		System.out.println("9.식품총출력");
		System.out.println("10.약품총출력");
		System.out.println("11.일반제품총출력");
		System.out.println("12.수량0인제품출력");
	}

	public void subMenu() {
		System.out.println("1.일반제품");
		System.out.println("2.식품");
		System.out.println("3.약품");

	}
}
