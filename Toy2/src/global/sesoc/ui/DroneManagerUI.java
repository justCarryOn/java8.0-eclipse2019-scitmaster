package global.sesoc.ui;

import java.util.List;
import java.util.Scanner;

import global.sesoc.manager.DroneManagerMgr;
import global.sesoc.vo.Drone;

public class DroneManagerUI {
	Scanner input = new Scanner(System.in);
	DroneManagerMgr manager = new DroneManagerMgr();

	/**
	 * ������
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
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);;
				default : 
					System.out.println("���� >>>>> �޴� ������ �ٽ��� �ּ���.");
					input.nextLine();	
				}
			} catch (Exception e) {
				System.out.println("���� >>>>> �޴� ������ �ٽ��� �ּ���.\n");
				input.nextLine();
				continue;
			}
		}

	}

	/**
	 * �ָ޴��� ȭ�鿡 ����Ѵ�.
	 */
	public void mainMenu() {
		System.out.println("\n===== Drone Manager ======");
		System.out.println("1. ��� ���");
		System.out.println("2. ��� �˻�");
		System.out.println("3. ��� ����");
		System.out.println("4. ���ݴ� �˻�");
		System.out.println("5. ��� ���� ���");
		System.out.println("9. ����");
		System.out.println("=======================");
		System.out.print  ("[ �޴�  ����  ] ");
	}


	/**
	 * �峭�� ��ü�� �����ϱ� ���� Drone ��ü�� �����Ѵ�.
	 * @param DroneType �峭�� ����
	 * @return ������ �峭�� ��ü
	 */
	public int insertDrone() {
		Drone drone = null;
		String name;
		int serialNum;
		int price = 0;
		int result = 0 ;

		while(true) {
			try {
				System.out.print("> ������ȣ:");
				serialNum = input.nextInt();

				drone = manager.searchDrone(serialNum);

				if(drone != null) {
					System.out.println("�ߺ� ���� >>>>> �Է��Ͻ� ������ȣ�� ����� �����մϴ�.\n");
					continue;
				}

				System.out.print("> �̸�:");
				name = input.next();

				System.out.print("> ����:");
				price = input.nextInt();


				int wingCount = 0;
				System.out.print("> ���� ���� : ");
				wingCount = input.nextInt();

				drone = new Drone(serialNum, name, price, wingCount);
				result = manager.insertDrone(drone);

				System.out.println("��� ������ �Ϸ�Ǿ����ϴ�.");
				input.nextLine();
				break;
			} catch (Exception e) {
				e.printStackTrace();
				input.nextLine();
				System.out.println("���� >>>>> �ٽ� �Է��� �ּ���.\n");
				continue;
			}
		}
		return result;
	}

	/**
	 * ������ȣ�� �ش��ϴ� �峭���� �˻��Ͽ� ȭ�鿡 ����Ѵ�.
	 * 
	 */
	public void searchDrone() {
		while(true) {
			System.out.print("\n> �峭�� ������ȣ: ");
			int serialNum = input.nextInt();
			Drone drone = manager.searchDrone(serialNum);

			if(drone != null) {
				System.out.println(drone);
			}
			else {
				System.out.println("�˻� ���� >>>>> �Է��Ͻ� ������ȣ�� ����� �������� �ʽ��ϴ�.\n");
			}
			return;
		}
	}

	/** 
	 * �峭���� �ø����ȣ�� �Է¹޾� �ش��ϴ� �峭�� ������ �����Ѵ�. 
	 */
	public void deleteDrone() {
		System.out.println("\n===== �峭�� ���� �޴� =====");
		System.out.print("> ��� ���� ��ȣ: ");
		int serialNum = input.nextInt();

		if(manager.deleteDrone(serialNum) == 1) {
			System.out.println("[ ���� ���� ]\n");
		}
		else {
			System.out.println("���� ���� >>>>> �Է��Ͻ� ������ȣ�� ����� �������� �ʽ��ϴ�.\n");
		}
	}

	/**
	 * ���� �˻�
	 */
	public void searchForPrice() {
		System.out.println("\n===== ���� �˻� �޴� =====");
		System.out.print("> �ּҰ���: ");
		int minPrice = input.nextInt();

		System.out.print("> �ִ밡��: ");
		int maxPrice = input.nextInt();

		int count = 0;

		List<Drone> tList = manager.droneListForPrice(minPrice, maxPrice);
		if(tList != null) {
			System.out.println("[ " + minPrice + "�� ~ " + maxPrice + "�� ������ ��ǰ �˻� ��� ] ");

			for(Drone t : tList) {
				System.out.println(t);
				count++;
			}
			System.out.println("[ ��  "+ count +" ���� ��ǰ�� �˻��Ǿ����ϴ�.]\n");

		}
		else {
			System.out.println(">>>>> ���Ͻô� ���� ���� ��ǰ�� �������� �ʽ��ϴ�.\n");
		}
	}

	/**
	 * �峭�� ������ ȭ�鿡 ����Ѵ�.
	 */
	public void printDroneInfo() {
		String msg = "�� ��� ���: [";
		List<Drone> tList = manager.printDroneInfo();
		if(tList != null) {
			for(int i = 0, len = tList.size(); i < len; i++) {
				System.out.println(tList.get(i).toString());
			}
			System.out.println(msg + tList.size() + "] ��");
		}
	}
}
