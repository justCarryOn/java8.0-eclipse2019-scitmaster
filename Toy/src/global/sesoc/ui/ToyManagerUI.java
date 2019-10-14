package global.sesoc.ui;

import java.util.List;
import java.util.Scanner;

import global.sesoc.manager.ToyManagerMgr;
import global.sesoc.vo.Bicycle;
import global.sesoc.vo.Drone;
import global.sesoc.vo.GameConsole;
import global.sesoc.vo.Toy;

public class ToyManagerUI {
	Scanner input = new Scanner(System.in);
	ToyManagerMgr manager = new ToyManagerMgr();
	
	/**
	 * ������
	 */
	public ToyManagerUI() {
		int mNum = 0;
		
		while(true) {
			try {
				mainMenu();
				mNum = input.nextInt();

				switch(mNum) {
				case 1:
					insertToy();
					break;
				case 2:
					searchToy();
					break;
				case 3:
					deleteToy();
					break;
				case 4:
					searchForPrice();
					break;
				case 5:
					printToyInfo();
					break;
				case 9:		// ���� �� ����
					System.out.println("������ ���� �� ���α׷� �����մϴ�.");
					manager.saveFile();
					return;
				default : 
					System.out.println("���� >>>>> �޴� ������ �ٽ��� �ּ���.");
					input.nextLine();	
				}
			} catch (Exception e) {
				System.out.println("���� >>>>> �޴� ������ �ٽ��� �ּ���.\n");
				input.nextLine();
				e.printStackTrace();
				continue;
			}
		}

	}

	/**
	 * �ָ޴��� ȭ�鿡 ����Ѵ�.
	 */
	public void mainMenu() {
		System.out.println("\n===== Toy Manager ======");
		System.out.println("1. �峭�� ���");
		System.out.println("2. �峭�� �˻�");
		System.out.println("3. �峭�� ����");
		System.out.println("4. ���ݴ� �˻�");
		System.out.println("5. �峭�� ���� ���");
		System.out.println("9. ����");
		System.out.println("=======================");
		System.out.print  ("[ �޴�  ����  ] ");
	}

	/**
	 * �峭�� ��ü�� �����ؼ� �����ϱ� ���� �޼ҵ�
	 * 
	 */
	public void insertToy() {
		while(true) {
			int iNum = 0;
			try {
				insertMenu();
				iNum = input.nextInt();

				if(iNum == 9) {
					return;
				}
			} catch(Exception e) {
				System.out.println("���� >>>>> �ٽ� ������ �ּ���.\n");
				input.nextLine();

				continue;
			}

			Toy toy = makeToy(iNum);
			manager.insertToy(toy);
		}
	}

	/**
	 * �峭�� ��ü�� ����ϱ� ���� �޴��� ȭ�鿡 ���
	 */
	public void insertMenu() {
		System.out.println("\n===== �峭�� ��� �޴� =====");
		System.out.println("1. ������");
		System.out.println("2. ���");
		System.out.println("3. ���ӱ�");
		System.out.println("9. �����޴�");
		System.out.print  ("[ �峭�� ���� ] ");
	}

	/**
	 * �峭�� ��ü�� �����ϱ� ���� Toy ��ü�� �����Ѵ�.
	 * @param toyType �峭�� ����
	 * @return ������ �峭�� ��ü
	 */
	public Toy makeToy(int toyType) {
		Toy toy = null;
		String name, serialNum;
		int price = 0;
		
		while(true) {
			try {
				System.out.print("> ������ȣ:");
				serialNum = input.next();
				
				Toy sToy = manager.searchToy(serialNum);

				if(sToy != null) {
					System.out.println("�ߺ� ���� >>>>> �Է��Ͻ� ������ȣ�� �峭���� �����մϴ�.\n");
					continue;
				}

				System.out.print("> �̸�:");
				name = input.next();
				
				System.out.print("> ����:");
				price = input.nextInt();

				switch(toyType) {
				case 1:
					String type = null;

					System.out.print("> ������ ����(1. ���ο�, 2. ��ǿ�) => ");
					int tNum = input.nextInt();
					switch(tNum) {
					case 1:
						type = "road";
						break;
					case 2:
						type = "mountain";
						break;
					default:
						new Exception("�ͼ��� �߻�..");
						break;
					}

					toy = new Bicycle(serialNum, name, price, type);
					
					break;
				case 2:
					int wingCount = 0;
					System.out.print("> ���� ���� : ");
					wingCount = input.nextInt();

					toy = new Drone(serialNum, name, price, wingCount);

					break;

				case 3:
					System.out.print("> �޴� ���� ����(y/n) ");
					String ip = input.next();
					boolean isPortable = false;

					if(ip.equalsIgnoreCase("y")) {
						isPortable = true;
					}
					else if(ip.equalsIgnoreCase("n")) {
						isPortable = false;
					}
					toy = new GameConsole(serialNum, name, price, isPortable);
					
					break;
				}
				
				return toy;
				
			} catch (Exception e) {
				input.nextLine();
				System.out.println("���� >>>>> �ٽ� �Է��� �ּ���.\n");
				continue;
			}
		}
		
	}

	/**
	 * ������ȣ�� �ش��ϴ� �峭���� �˻��Ͽ� ȭ�鿡 ����Ѵ�.
	 * 
	 */
	public void searchToy() {
		while(true) {
			System.out.print("\n> �峭�� ������ȣ: ");
			String serialNum = input.next();
			Toy sToy = manager.searchToy(serialNum);

			if(sToy != null) {
				System.out.println(sToy.toString());
			}
			else {
				System.out.println("�˻� ���� >>>>> �Է��Ͻ� ������ȣ�� �峭���� �������� �ʽ��ϴ�.\n");
			}
			return;
		}
	}

	/** 
	 * �峭���� �ø����ȣ�� �Է¹޾� �ش��ϴ� �峭�� ������ �����Ѵ�. 
	 */
	public void deleteToy() {
		System.out.println("\n===== �峭�� ���� �޴� =====");
		System.out.print("> �峭�� ���� ��ȣ: ");
		String serialNum = input.next();

		if(manager.deleteToy(serialNum)) {
			System.out.println("[ ���� ���� ]\n");
		}
		else {
			System.out.println("���� ���� >>>>> �Է��Ͻ� ������ȣ�� �峭���� �������� �ʽ��ϴ�.\n");
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
		
		List<Toy> tList = manager.toyListForPrice(minPrice, maxPrice);
		if(tList != null) {
			System.out.println("[ " + minPrice + "�� ~ " + maxPrice + "�� ������ ��ǰ �˻� ��� ] ");
			
			for(Toy t : tList) {
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
	public void printToyInfo() {
		while(true) {
			printMenu();
			int pNum = input.nextInt();
			String msg = null;

			switch(pNum) {
			case 1:
				msg = "�� �峭�� ����: [";
				break;
			case 2:
				msg = "�� ������ ���: [";
				break;
			case 3:
				msg = "�� ��� ���: [";
				break;
			case 4:
				msg = "�� �����ܼ� ���: [";
				break;
			case 9:
				return;
			}
			List<Toy> tList = manager.printToyInfo(pNum);
			if(tList != null) {
				for(int i = 0, len = tList.size(); i < len; i++) {
					System.out.println(tList.get(i).toString());
				}
				System.out.println(msg + tList.size() + "] ��");
			}
		}
	}

	/**
	 * �� �޴� ��� �޼���
	 */
	public void printMenu() {
		System.out.println("\n===== �峭�� ���� ��� =====");
		System.out.println("1. ��ü ���");
		System.out.println("2. ������ ���� ���");
		System.out.println("3. ��� ���� ���");
		System.out.println("4. �����ܼ� ���� ���");
		System.out.println("9. ���� �޴�");
		System.out.print  ("[ ���� ] ");

	}
}
