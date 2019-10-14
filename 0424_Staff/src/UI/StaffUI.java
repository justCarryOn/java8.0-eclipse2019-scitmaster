package UI;

import java.util.Scanner;

import Service.StaffService;
import VO.Cleaner;
import VO.Staff;
import VO.Teacher;

public class StaffUI {

	private Scanner sc = new Scanner(System.in);
	private String name, ssn, position, tsn, offDay;
	private int choice;
	private StaffService ss = new StaffService();

	public StaffUI() {
		while (true) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("이름: ");
				name = sc.next();
				System.out.println("주민번호: ");
				ssn = sc.next();
				System.out.println("직급: ");
				position = sc.next();
				subMenu();
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					Staff s = new Staff(name, ssn, position);
					ss.insertStaff(s);
					break;
				case 2:
					System.out.println("교번: ");
					tsn = sc.next();
					Teacher t = new Teacher(name, ssn, position, tsn);
					ss.insertStaff(t);
					break;
				case 3:
					System.out.println("비번일: ");
					offDay = sc.next();
					Cleaner c = new Cleaner(name, ssn, position, offDay);
					ss.insertStaff(c);
					break;
				default:
					System.out.println("번호를 잘못 입력하셨습니다.");
				}
				break;
			case 2:
				printMenu();
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println(ss.printAll());
					break;
				case 2:
					System.out.println(ss.printTeacher());
					break;
				case 3:
					System.out.println(ss.printCleaner());
					break;
				default:
					System.out.println("정보를 잘못 입력하셨습니다");
				}
				break;
			case 3:
				searchMenu();
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("주민번호: ");
					ssn = sc.next();
					System.out.println(ss.searchSsn(ssn));
					break;
				case 2:
					System.out.println("직급: ");
					position = sc.next();
					System.out.println(ss.searchPosition(position));
					break;
				case 3:
					System.out.println("교번: ");
					tsn = sc.next();
					System.out.println(ss.searchTsn(tsn));
					break;
				case 4:
					System.out.println("비번일자: ");
					offDay = sc.next();
					System.out.println(ss.searchOffDay(offDay));
					break;
				default:
				}
				break;
			case 4:
				System.out.println("주민번호: ");
				ssn = sc.next();
				ss.delSsn(ssn);
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
		System.out.println("1.일반직원");
		System.out.println("2.교사");
		System.out.println("3.청소부");
	}

	public void printMenu() {
		System.out.println("1.전체출력");
		System.out.println("2.교사출력");
		System.out.println("3.청소부출력");
	}

	public void searchMenu() {
		System.out.println("1.주민번호검색");
		System.out.println("2.직급검색");
		System.out.println("3.교번검색");
		System.out.println("4.비번일자검색");
	}
}
