package global.sesoc.ui;

import java.util.List;
import java.util.Scanner;

import global.sesoc.manager.DroneManagerMgr;
import global.sesoc.vo.Drone;

public class DroneManagerUI {
	Scanner input = new Scanner(System.in);
	DroneManagerMgr manager = new DroneManagerMgr();

	/**
	 * 생성자
	 */
	public DroneManagerUI() {
		int mNum = 0;

		while(true) {
			try {
				mainMenu();
				mNum = input.nextInt();

				switch(mNum) {
				case 1:
					insertDrone();
					break;
				case 2:
					searchDrone();
					break;
				case 3:
					deleteDrone();
					break;
				case 4:
					searchForPrice();
					break;
				case 5:
					printDroneInfo();
					break;
				case 9 :
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);;
				default : 
					System.out.println("오류 >>>>> 메뉴 선택을 다시해 주세요.");
					input.nextLine();	
				}
			} catch (Exception e) {
				System.out.println("오류 >>>>> 메뉴 선택을 다시해 주세요.\n");
				input.nextLine();
				continue;
			}
		}

	}

	/**
	 * 주메뉴를 화면에 출력한다.
	 */
	public void mainMenu() {
		System.out.println("\n===== Drone Manager ======");
		System.out.println("1. 드론 등록");
		System.out.println("2. 드론 검색");
		System.out.println("3. 드론 삭제");
		System.out.println("4. 가격대 검색");
		System.out.println("5. 드론 정보 출력");
		System.out.println("9. 종료");
		System.out.println("=======================");
		System.out.print  ("[ 메뉴  선택  ] ");
	}


	/**
	 * 장난감 객체를 저장하기 위해 Drone 객체를 생성한다.
	 * @param DroneType 장난감 종류
	 * @return 생성된 장난감 객체
	 */
	public int insertDrone() {
		Drone drone = null;
		String name;
		int serialNum;
		int price = 0;
		int result = 0 ;

		while(true) {
			try {
				System.out.print("> 고유번호:");
				serialNum = input.nextInt();

				drone = manager.searchDrone(serialNum);

				if(drone != null) {
					System.out.println("중복 오류 >>>>> 입력하신 고유번호의 드론이 존재합니다.\n");
					continue;
				}

				System.out.print("> 이름:");
				name = input.next();

				System.out.print("> 가격:");
				price = input.nextInt();


				int wingCount = 0;
				System.out.print("> 날개 갯수 : ");
				wingCount = input.nextInt();

				drone = new Drone(serialNum, name, price, wingCount);
				result = manager.insertDrone(drone);

				System.out.println("드론 저장이 완료되었습니다.");
				input.nextLine();
				break;
			} catch (Exception e) {
				e.printStackTrace();
				input.nextLine();
				System.out.println("오류 >>>>> 다시 입력해 주세요.\n");
				continue;
			}
		}
		return result;
	}

	/**
	 * 고유번호에 해당하는 장난감을 검색하여 화면에 출력한다.
	 * 
	 */
	public void searchDrone() {
		while(true) {
			System.out.print("\n> 장난감 고유번호: ");
			int serialNum = input.nextInt();
			Drone drone = manager.searchDrone(serialNum);

			if(drone != null) {
				System.out.println(drone);
			}
			else {
				System.out.println("검색 실패 >>>>> 입력하신 고유번호의 드론이 존재하지 않습니다.\n");
			}
			return;
		}
	}

	/** 
	 * 장난감의 시리얼번호를 입력받아 해당하는 장난감 정보를 삭제한다. 
	 */
	public void deleteDrone() {
		System.out.println("\n===== 장난감 삭제 메뉴 =====");
		System.out.print("> 드론 고유 번호: ");
		int serialNum = input.nextInt();

		if(manager.deleteDrone(serialNum) == 1) {
			System.out.println("[ 삭제 성공 ]\n");
		}
		else {
			System.out.println("삭제 실패 >>>>> 입력하신 고유번호의 드론이 존재하지 않습니다.\n");
		}
	}

	/**
	 * 가격 검색
	 */
	public void searchForPrice() {
		System.out.println("\n===== 가격 검색 메뉴 =====");
		System.out.print("> 최소가격: ");
		int minPrice = input.nextInt();

		System.out.print("> 최대가격: ");
		int maxPrice = input.nextInt();

		int count = 0;

		List<Drone> tList = manager.droneListForPrice(minPrice, maxPrice);
		if(tList != null) {
			System.out.println("[ " + minPrice + "원 ~ " + maxPrice + "원 사이의 제품 검색 결과 ] ");

			for(Drone t : tList) {
				System.out.println(t);
				count++;
			}
			System.out.println("[ 총  "+ count +" 개의 제품이 검색되었습니다.]\n");

		}
		else {
			System.out.println(">>>>> 원하시는 가격 대의 제품이 존재하지 않습니다.\n");
		}
	}

	/**
	 * 장난감 정보를 화면에 출력한다.
	 */
	public void printDroneInfo() {
		String msg = "총 드론 대수: [";
		List<Drone> tList = manager.printDroneInfo();
		if(tList != null) {
			for(int i = 0, len = tList.size(); i < len; i++) {
				System.out.println(tList.get(i).toString());
			}
			System.out.println(msg + tList.size() + "] 대");
		}
	}
}
