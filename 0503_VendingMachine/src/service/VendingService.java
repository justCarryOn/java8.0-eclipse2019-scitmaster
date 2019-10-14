package service;

import java.util.ArrayList;

import service.interfaceImp.ServiceInterface;
import vo.Account;
import vo.Drink;
import vo.Product;
import vo.Snack;

public class VendingService implements ServiceInterface {

	private ArrayList<Product> sellingList;// 판매중인 리스트
	private ArrayList<Product> soldList;// 판매된 상품리스트
	private ArrayList<Account> adminAccount;// 관리자 계정정보
	private int money;// 고객이 넣은 지폐

	public VendingService() {
		sellingList = new ArrayList<>();
		soldList = new ArrayList<>();
		adminAccount = new ArrayList<>();
		// 상품 초기화
		sellingList.add(new Snack("초코감자칩", "001", 1500, 100, "100g")); // 버튼 1번
		sellingList.add(new Snack("츄러츄러스", "002", 1800, 100, "120g")); // 버튼 2번
		sellingList.add(new Snack("촉촉오징어", "003", 2100, 100, "200g")); // 버튼 3번
		sellingList.add(new Snack("하늘보리칩", "004", 1600, 100, "140g")); // 버튼 4번
		sellingList.add(new Snack("정브라우니", "005", 1800, 100, "110g")); // 버튼 5번
		sellingList.add(new Snack("히말라야츄", "006", 1500, 100, "90g")); // 버튼 6번
		sellingList.add(new Drink("밀크소다", "007", 1000, 100, "150ml")); // 버튼 7번
		sellingList.add(new Drink("비암강장제", "008", 1800, 100, "150ml")); // 버튼 8번
		sellingList.add(new Drink("핵사이다", "009", 1500, 100, "250ml")); // 버튼 9번
		sellingList.add(new Drink("강탄산수", "010", 1000, 100, "150ml")); // 버튼 10번
		sellingList.add(new Drink("한강점프콜라", "011", 1200, 100, "180ml")); // 버튼 11번
		sellingList.add(new Drink("골든티", "012", 1000, 100, "150ml")); // 버튼 12번

		adminAccount.add(new Account("admin", "1234"));// 관리자 계정 초기화
	}

	@Override
	public String insertMoney(int price) {// 사용자가 지폐(price)를 넣는다. 얼마를 넣냐에 따라 무엇을 살수있는지, 제품명과 가격만 String 으로 보여준다.
		// TODO Auto-generated method stub
		String toPrint = "";
		money = price;
		for (Product p : sellingList) {
			if (p.getPrice() <= money)
				toPrint += p + "\n";
		}

		return toPrint;
	}

	@Override
	public int buyProduct(int buttonNumber) {// 사용자에게 버튼을 입력 받아 구매 성공여부를 리턴한다. 한번에 1개씩만 구매하고 거스름돈을 준다.
		// TODO Auto-generated method stub
		int change = 0;
		if (sellingList.get(buttonNumber - 1).getAmount() <= 0) {
			if (money < sellingList.get(buttonNumber - 1).getPrice()) {
				change = 0;
			}
		} else {
			sellingList.get(buttonNumber - 1).setAmount(sellingList.get(buttonNumber - 1).getAmount() - 1);
			soldList.add(sellingList.get(buttonNumber - 1));
			change = money - sellingList.get(buttonNumber - 1).getPrice();
		}
		return change;
	}

	@Override
	public String showProducts() {// 지폐를 넣기전 사용자가 상품 전체리스트를 본다.
		// TODO Auto-generated method stub
		String toPrint = "";
		for (Product p : sellingList) {
			toPrint += p + "\n";
		}
		return toPrint;

	}

	@Override
	public String amountZeroList() {// 관리자가 사용하는 재고가 10개 미만인 상품리스트 출력 관리자용 메서드
		// TODO Auto-generated method stub
		String toPrint = "";
		for (Product p : sellingList) {
			if (p.getAmount() < 10)
				toPrint += p + "\n";
		}
		return toPrint;
	}

	@Override
	public boolean setProduct(String pCode, int amount) {// 부족한 재고를 채워넣는 관리자용 메서드
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Product> soldListStatistics() {// 판매 리스트를 확인하는 관리자용 메서드
		// TODO Auto-generated method stub
		String toPrint = "";
		for (Product p : soldList) {
			toPrint += p + "\n";
		}
		return soldList;
	}

	@Override
	public boolean loginAdmin(String id, String pw) {// 관리자로그인, 관리자계정으로 로그인해야 사용할 수 있는 기능등이 있다.
		// TODO Auto-generated method stub
		return false;
	}

}
