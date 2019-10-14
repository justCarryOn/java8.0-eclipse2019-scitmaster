package ui;

import java.util.ArrayList;
import java.util.Scanner;

import service.BarService;
import vo.Customer;
import vo.Drink;
import vo.Ingredient;

public class BarUI {

	private boolean flag = true;
	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private BarService bs = new BarService();

	public BarUI() {
		while (flag) {
			mainMenu();
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				insertIngredient();
				break;
			case 2:
				insertDrink();
				break;
			case 3:
				selectAllDrink();
				break;
			case 4:
				selectDrink();
				break;
			case 5:
				sellDrink();
				break;
			case 6:
				selectAllSold();
				break;
			case 7:
				break;
			case 8:
				flag=false;
				break;
			}
		}
	}

	public void mainMenu() {
		System.out.println("===========드루와Bar===========");
		System.out.println("1.원료등록");
		System.out.println("2.술제조 레시피 등록");
		System.out.println("3.술목록보기");
		System.out.println("4.레시피 조회");
		System.out.println("5.판매하기");
		System.out.println("6.모든 판매정보보기(최신순정렬)");
		System.out.println("7.손님별 판매정보 검색");
		System.out.println("8.종료");
		System.out.println("=============================");
	}

	public void insertIngredient() {
		System.out.println("======원료 등록=======");
		System.out.println("원료명 입력 : ");
		String ingredientName = scLine.nextLine();
		System.out.println("원료 설명 입력 : ");
		String ingredientComment = scLine.nextLine();

		boolean result = bs.insertIngredient(new Ingredient(ingredientName, ingredientComment));
		if (result) {
			System.out.println("등록 성공!");
		} else {
			System.out.println("ERROR**** 등록실패");
		}
	}

	public void insertDrink() {

		ArrayList<Ingredient> ingList = new ArrayList<>();
		ArrayList<Ingredient> dbList = bs.selectAllIngredient();

		System.out.println("======술제조 레시피 등록=======");

		System.out.println("술이름 입력 : ");
		String drinkName = scLine.nextLine();
		System.out.println("술설명 입력 : ");
		String drinkComment = scLine.nextLine();
		System.out.println("술가격 입력 : ");
		int price = sc.nextInt();
		Drink d = new Drink(drinkName, drinkComment, price, null);

		while (true) {
			printAllIngredients();
			System.out.println("들어가는 원료 일련번호 입력 : ");
			String ingredientSeq = scLine.nextLine();
			System.out.println("수량 입력 : ");
			int quantity = sc.nextInt();

			for (Ingredient ing : dbList) {
				if (ingredientSeq.equals(ing.getIngredientSeq())) {
					ing.setQuantity(quantity);
					ingList.add(ing);
				}
			}

			System.out.println("더입력하시겠습니까?(Y/N)");
			String conAnswer = sc.next();
			if (!(conAnswer.equals("Y") || conAnswer.equals("y"))) {

				break;
			}
		}
		d.setIngredientList(ingList);

		boolean result = bs.insertDrink(d);
		if (result) {
			System.out.println("등록 성공!");
		} else {
			System.out.println("ERROR**** 등록실패");
		}

	}

	public void selectDrink() {
		System.out.println("술이름 검색 : ");

		String drinkName = scLine.nextLine();

		Drink dList = bs.selectDrink(drinkName);

		System.out.println(dList);

		for (Ingredient ing : dList.getIngredientList()) {
			System.out.println("=================================");
			System.out.println("원료명 : " + ing.getIngredientName());
			System.out.println("원료일련번호 : " + ing.getIngredientSeq());
			System.out.println("들어가는 수량 : " + ing.getQuantity() + "잔");
			System.out.println("원료설명 : " + ing.getIngredientComment());
		}

	}

	public void sellDrink() {
		System.out.println("손님 별명 입력 : ");
		String customerId = scLine.nextLine();
		System.out.println("무슨 술입니까?");
		String drinkName = scLine.nextLine();
		Drink dList = bs.selectDrink(drinkName);

		if (dList == null) {
			System.out.println("없는 술입니다.");
			return;
		} else {
			System.out.println("몇잔을 판매합니까?");
			int quantity = sc.nextInt();
			Customer c = new Customer();
			Drink sold = new Drink();
			sold.setDrinkName(drinkName);
			sold.setQuantity(quantity);
			c.setCustomerId(customerId);
			c.getDrinkList().add(sold);
			bs.sellDrink(c);
		}
	}

	public void printAllIngredients() {
		System.out.println("- 원료목록 -");
		for (Ingredient ing : bs.selectAllIngredient()) {
			System.out.println(ing);
		}
	}

	public void selectAllDrink() {
		System.out.println("- 술목록 -");
		for (Drink drink : bs.selectAllDrink()) {
			System.out.println(drink);
		}
	}
	public void selectAllSold(){
		System.out.println("- 판매목록 - ");
		for (Customer c : bs.selectAllSold()) {
			System.out.println("구매자 : "+c.getCustomerId()+ " 술이름 : "+c.getDrinkList().get(0).getDrinkName()+" 판매량 : "+c.getDrinkList().get(0).getQuantity()+" 총 판매가 : "+c.getTotal()+"원");
		}
		
	}
}
