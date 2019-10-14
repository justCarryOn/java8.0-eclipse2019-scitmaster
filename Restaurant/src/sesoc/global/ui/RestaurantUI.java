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
	private SaleManager manager; 	// 요청과 관련된 처리를 하기 위해 생성한 SESManager 클래스의 객체
	private Scanner scanner ; 		// 키보드로부터 정보를 입력받기 위해 생성한 Scanner 클래스의 객체
	List<Food> foodList= null;		// 주문 가능한 음식 목록

	public RestaurantUI() throws Exception{
		manager = new SaleManager();
		scanner = new Scanner(System.in);

		foodList = manager.getFoods();

		while(true){
			// 전체 화면을 출력한다.
			printMainMenu();

			// 업무를 선택하여 입력 받는다.
			String sel = null;
			try {
				sel = scanner.nextLine();
			}
			catch (Exception e) {
				// 숫자로 입력받을 수 없는 에러가 날 경우 Exception 처리
				e.printStackTrace();
			}

			switch(sel){
			// 주문을 입력하여 Order 객체를 생성한다.
			case "1": 
				insertOrder();
				break;

				// 주문번호를 입력받아 해당하는 해당 주문을 삭제한다.
			case "2": 
				deleteOrder();
				break;

				// 오늘 매출 현황을 화면에 출력한다.
			case "3": 
				manager.showAll();
				break;

				// 오늘의 모든 매상은 파일에 저장한 후 종료 한다.
			case "9":
				System.out.println("프로그램을 종료합니다. \n당일 매출 파일이 생성되었습니다.");
				manager.saveFile();

				System.exit(0);
				break;

				// 위의 번호에 해당하지 않는다면 무시한다
			default:
			}
		}
	}
	/**
	 * 주문을 취소할 번호를 입력받아 그 번호에 해당하는 주문를 
	 * 전체 주문목록이 저장되어 있는 ArrayList에서 찾아 Manager 클래스에 삭제 요청을 한다.
	 */
	@Override
	public void deleteOrder() {
		int orderNo = 0;
		System.out.print(" > 취소할 주문번호 입력 : ");
		orderNo = scanner.nextInt();
		scanner.nextLine();
		Order order = manager.findOrder(orderNo);
		if(!(order==null)) {
			manager.deleteOrder(orderNo);
			System.out.println(" ** 주문 취소가 완료되었습니다. ");
		} else {
			System.out.println(" ** 주문번호가 잘못 입력되었습니다.");
		}
	}

	/** 
	 * 음식을 주문하기 위한 메뉴목록을 출력한 후
	 * 그 타입에 따라 주문객체를 생성 한 후 주문객체가 생성이 되면 해당 주문 객체를 
	 * Manager 클래스의 ArrayList에 등록시킨다.
	 */
	@Override
	public void insertOrder(){
		while(true){
			// 음식을 주문하기 위한 화면을 출력한다.
			printOrderMenu();

			String type = null;
			type = scanner.nextLine();

			switch(type){
			case "1": // 매장주문
			case "2": // 배달주문
				Order order = makeOrder(type);
				boolean result = manager.insertOrder(order);

				if(result) 
					System.out.println(" ** 음식 주문을 완료하였습니다.");
				else 
					System.out.println(" ** 음식 주문이 취소되었습니다.");

				break;

				// 상위 메뉴로 이동한다
			case "9": return;	
			default:
			}//switch
		}//while
	}
	/**
	 * 프로그램의 주메뉴 화면
	 */
	@Override
	public void printMainMenu(){
		System.out.println("===================================");
		System.out.println("  [ SCIT Restaurant 매상 관리 시스템 ]");
		System.out.println("===================================");
		System.out.println(" 1.주문");	
		System.out.println(" 2.주문 취소");	
		System.out.println(" 3.당일 매출 정산 출력");	
		System.out.println(" 9.종료");
		System.out.println("===================================");
		System.out.print  ("** 메뉴 번호선택 : ");	
	}
	/**
	 * 주문을 위한 화면
	 */
	@Override
	public void printOrderMenu() {
		System.out.println();
		System.out.println("===================================");
		System.out.println("          [ SCIT 음식 주문 ]");
		System.out.println("===================================");
		System.out.println(" 1.매장 주문");	
		System.out.println(" 2.배달 주문");	
		System.out.println(" 9.상위로 ");
		System.out.print  ("** 주문 방식 : ");			
	}

	/**
	 * 주문을 했을 경우 주문객체를 생성하여 리턴한다.
	 * 음식 주문은 여러 개 할 수 있으며, 주문된 음식은 Map에 저장된다.
	 * @param type 1: 매장주문, 2: 배달주문
	 * @return 생성된 주문객체 Order
	 */
	@Override
	public Order makeOrder(String type){
		Order o = null;
		int totalPrice = 0;
		Map<Food, Integer> orderFoods = new HashMap<>();

		switch(type){
		case "1": // 매장 주문
			printFoodList(foodList);				

			System.out.print(" > 테이블 번호 : ");
			int tableNo = scanner.nextInt();
			scanner.nextLine();

			// 여러 음식을 주문하기 위해 메소드 foodOrdered를 호출한다.
			totalPrice = foodOrdered(orderFoods);

			o = new StoreOrder(tableNo, orderFoods);

			// 주문 내용 확인 
			System.out.println();

			System.out.print(o.showOrderSituation());
			System.out.println("총 합계 : " + totalPrice + "원");

			break;

		case "2": 
			printFoodList(foodList);				// 화면에 음식 종류를 출력함

			System.out.print(" > 주문자 전화번호 : ");
			String buyerPhone = scanner.nextLine();

			System.out.print(" > 주문자 주소 : ");
			String buyerAddress = scanner.nextLine();

			// 여러 음식을 주문하기 위해 메소드 foodOrdered를 호출한다.
			totalPrice = foodOrdered(orderFoods);

			o = new DeliveryOrder(buyerPhone, buyerAddress, orderFoods);

			// 주문 내용 확인 
			System.out.println();
			System.out.print(o.showOrderSituation());
			System.out.println("총 합계 : " + totalPrice + "원");

			break;
		}

		return o;
	}

	/**
	 * 주문 가능한 음식 목록을 출력
	 * @param foodList
	 */
	@Override
	public void printFoodList(List<Food> foodList) {
		System.out.println("=========== 주문 가능한 메뉴 ===========");

		Iterator<Food> menuIter = foodList.iterator();
		while(menuIter.hasNext()) {
			Food food = menuIter.next();
			System.out.println(food);
		}
		System.out.println("===================================\n");
	}

	/**
	 * 사용자로부터 메뉴를 주문받는다. 
	 * 여러 종류의 메뉴를 주문할 수 있으며 주문을 끝내고자 하면 Enter키를 친다. 
	 * 주문받은 메뉴는 매개변수로 전달된  Map에 담긴다.
	 * 음식이 주문될 때마다 음식값을 누적하여 총액을 구한 후 리턴한다.
	 * 
	 * @param orderFoods 주문한 음식을 담을 Map객체
	 * @return 주문한 음식값 총액
	 */
	@Override
	public int foodOrdered(Map<Food, Integer> orderFoods) {
		String menu    = null;
		int foodNo     = 0;
		int totalPrice = 0;
		while(true) {
			try {
				System.out.print(" > 주문할 메뉴 (입력이 끝나면 Enter) : ");

				menu = scanner.nextLine();
				if(menu.trim().length() == 0) {
					break;
				}

				System.out.print(" > 개수 : ");
				int count = scanner.nextInt();
				scanner.nextLine();
				
				foodNo = Integer.parseInt(menu);
				if(foodNo > foodList.size() || foodNo <= 0 ) {
					System.out.println(" >>> 메뉴선택이 잘못되었습니다.");
					continue;
				}

				// totalPrice 누적하기
				/*
				 * Code Here
				 */
				
			} catch(Exception e) {
				System.out.println(" >>> 메뉴선택이 잘못되었습니다.");
				scanner.nextLine();		// 입력 버퍼를 삭제한다.
				continue;
			}
		} 

		return totalPrice;
	}
}
