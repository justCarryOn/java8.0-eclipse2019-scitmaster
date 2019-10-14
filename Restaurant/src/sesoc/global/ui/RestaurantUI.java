package sesoc.global.ui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import sesoc.global.manager.SaleManager;
import sesoc.global.vo.DeliveryOrder;
import sesoc.global.vo.Food;
import sesoc.global.vo.Order;
import sesoc.global.vo.StoreOrder;

public class RestaurantUI implements UI {
	private SaleManager manager; 	// ��û�� ���õ� ó���� �ϱ� ���� ������ SESManager Ŭ������ ��ü
	private Scanner scanner ; 		// Ű����κ��� ������ �Է¹ޱ� ���� ������ Scanner Ŭ������ ��ü
	List<Food> foodList= null;		// �ֹ� ������ ���� ���

	public RestaurantUI() throws Exception{
		manager = new SaleManager();
		scanner = new Scanner(System.in);

		foodList = manager.getFoods();

		while(true){
			// ��ü ȭ���� ����Ѵ�.
			printMainMenu();

			// ������ �����Ͽ� �Է� �޴´�.
			String sel = null;
			try {
				sel = scanner.nextLine();
			}
			catch (Exception e) {
				// ���ڷ� �Է¹��� �� ���� ������ �� ��� Exception ó��
				e.printStackTrace();
			}

			switch(sel){
			// �ֹ��� �Է��Ͽ� Order ��ü�� �����Ѵ�.
			case "1": 
				insertOrder();
				break;

				// �ֹ���ȣ�� �Է¹޾� �ش��ϴ� �ش� �ֹ��� �����Ѵ�.
			case "2": 
				deleteOrder();
				break;

				// ���� ���� ��Ȳ�� ȭ�鿡 ����Ѵ�.
			case "3": 
				manager.showAll();
				break;

				// ������ ��� �Ż��� ���Ͽ� ������ �� ���� �Ѵ�.
			case "9":
				System.out.println("���α׷��� �����մϴ�. \n���� ���� ������ �����Ǿ����ϴ�.");
				manager.saveFile();

				System.exit(0);
				break;

				// ���� ��ȣ�� �ش����� �ʴ´ٸ� �����Ѵ�
			default:
			}
		}
	}
	/**
	 * �ֹ��� ����� ��ȣ�� �Է¹޾� �� ��ȣ�� �ش��ϴ� �ֹ��� 
	 * ��ü �ֹ������ ����Ǿ� �ִ� ArrayList���� ã�� Manager Ŭ������ ���� ��û�� �Ѵ�.
	 */
	@Override
	public void deleteOrder() {
		int orderNo = 0;
		System.out.print(" > ����� �ֹ���ȣ �Է� : ");
		orderNo = scanner.nextInt();
		scanner.nextLine();
		Order order = manager.findOrder(orderNo);
		if(!(order==null)) {
			manager.deleteOrder(orderNo);
			System.out.println(" ** �ֹ� ��Ұ� �Ϸ�Ǿ����ϴ�. ");
		} else {
			System.out.println(" ** �ֹ���ȣ�� �߸� �ԷµǾ����ϴ�.");
		}
	}

	/** 
	 * ������ �ֹ��ϱ� ���� �޴������ ����� ��
	 * �� Ÿ�Կ� ���� �ֹ���ü�� ���� �� �� �ֹ���ü�� ������ �Ǹ� �ش� �ֹ� ��ü�� 
	 * Manager Ŭ������ ArrayList�� ��Ͻ�Ų��.
	 */
	@Override
	public void insertOrder(){
		while(true){
			// ������ �ֹ��ϱ� ���� ȭ���� ����Ѵ�.
			printOrderMenu();

			String type = null;
			type = scanner.nextLine();

			switch(type){
			case "1": // �����ֹ�
			case "2": // ����ֹ�
				Order order = makeOrder(type);
				boolean result = manager.insertOrder(order);

				if(result) 
					System.out.println(" ** ���� �ֹ��� �Ϸ��Ͽ����ϴ�.");
				else 
					System.out.println(" ** ���� �ֹ��� ��ҵǾ����ϴ�.");

				break;

				// ���� �޴��� �̵��Ѵ�
			case "9": return;	
			default:
			}//switch
		}//while
	}
	/**
	 * ���α׷��� �ָ޴� ȭ��
	 */
	@Override
	public void printMainMenu(){
		System.out.println("===================================");
		System.out.println("  [ SCIT Restaurant �Ż� ���� �ý��� ]");
		System.out.println("===================================");
		System.out.println(" 1.�ֹ�");	
		System.out.println(" 2.�ֹ� ���");	
		System.out.println(" 3.���� ���� ���� ���");	
		System.out.println(" 9.����");
		System.out.println("===================================");
		System.out.print  ("** �޴� ��ȣ���� : ");	
	}
	/**
	 * �ֹ��� ���� ȭ��
	 */
	@Override
	public void printOrderMenu() {
		System.out.println();
		System.out.println("===================================");
		System.out.println("          [ SCIT ���� �ֹ� ]");
		System.out.println("===================================");
		System.out.println(" 1.���� �ֹ�");	
		System.out.println(" 2.��� �ֹ�");	
		System.out.println(" 9.������ ");
		System.out.print  ("** �ֹ� ��� : ");			
	}

	/**
	 * �ֹ��� ���� ��� �ֹ���ü�� �����Ͽ� �����Ѵ�.
	 * ���� �ֹ��� ���� �� �� �� ������, �ֹ��� ������ Map�� ����ȴ�.
	 * @param type 1: �����ֹ�, 2: ����ֹ�
	 * @return ������ �ֹ���ü Order
	 */
	@Override
	public Order makeOrder(String type){
		Order o = null;
		int totalPrice = 0;
		Map<Food, Integer> orderFoods = new HashMap<>();

		switch(type){
		case "1": // ���� �ֹ�
			printFoodList(foodList);				

			System.out.print(" > ���̺� ��ȣ : ");
			int tableNo = scanner.nextInt();
			scanner.nextLine();

			// ���� ������ �ֹ��ϱ� ���� �޼ҵ� foodOrdered�� ȣ���Ѵ�.
			totalPrice = foodOrdered(orderFoods);

			o = new StoreOrder(tableNo, orderFoods);

			// �ֹ� ���� Ȯ�� 
			System.out.println();

			System.out.print(o.showOrderSituation());
			System.out.println("�� �հ� : " + totalPrice + "��");

			break;

		case "2": 
			printFoodList(foodList);				// ȭ�鿡 ���� ������ �����

			System.out.print(" > �ֹ��� ��ȭ��ȣ : ");
			String buyerPhone = scanner.nextLine();

			System.out.print(" > �ֹ��� �ּ� : ");
			String buyerAddress = scanner.nextLine();

			// ���� ������ �ֹ��ϱ� ���� �޼ҵ� foodOrdered�� ȣ���Ѵ�.
			totalPrice = foodOrdered(orderFoods);

			o = new DeliveryOrder(buyerPhone, buyerAddress, orderFoods);

			// �ֹ� ���� Ȯ�� 
			System.out.println();
			System.out.print(o.showOrderSituation());
			System.out.println("�� �հ� : " + totalPrice + "��");

			break;
		}

		return o;
	}

	/**
	 * �ֹ� ������ ���� ����� ���
	 * @param foodList
	 */
	@Override
	public void printFoodList(List<Food> foodList) {
		System.out.println("=========== �ֹ� ������ �޴� ===========");

		Iterator<Food> menuIter = foodList.iterator();
		while(menuIter.hasNext()) {
			Food food = menuIter.next();
			System.out.println(food);
		}
		System.out.println("===================================\n");
	}

	/**
	 * ����ڷκ��� �޴��� �ֹ��޴´�. 
	 * ���� ������ �޴��� �ֹ��� �� ������ �ֹ��� �������� �ϸ� EnterŰ�� ģ��. 
	 * �ֹ����� �޴��� �Ű������� ���޵�  Map�� ����.
	 * ������ �ֹ��� ������ ���İ��� �����Ͽ� �Ѿ��� ���� �� �����Ѵ�.
	 * 
	 * @param orderFoods �ֹ��� ������ ���� Map��ü
	 * @return �ֹ��� ���İ� �Ѿ�
	 */
	@Override
	public int foodOrdered(Map<Food, Integer> orderFoods) {
		String menu    = null;
		int foodNo     = 0;
		int totalPrice = 0;
		while(true) {
			try {
				System.out.print(" > �ֹ��� �޴� (�Է��� ������ Enter) : ");

				menu = scanner.nextLine();
				if(menu.trim().length() == 0) {
					break;
				}

				System.out.print(" > ���� : ");
				int count = scanner.nextInt();
				scanner.nextLine();
				
				foodNo = Integer.parseInt(menu);
				if(foodNo > foodList.size() || foodNo <= 0 ) {
					System.out.println(" >>> �޴������� �߸��Ǿ����ϴ�.");
					continue;
				}

				// totalPrice �����ϱ�
				/*
				 * Code Here
				 */
				
			} catch(Exception e) {
				System.out.println(" >>> �޴������� �߸��Ǿ����ϴ�.");
				scanner.nextLine();		// �Է� ���۸� �����Ѵ�.
				continue;
			}
		} 

		return totalPrice;
	}
}
