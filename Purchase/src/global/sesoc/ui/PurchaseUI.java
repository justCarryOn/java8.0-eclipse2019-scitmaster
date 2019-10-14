package global.sesoc.ui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import global.sesoc.service.PurchaseServiceImpl;
import global.sesoc.vo.Product;
import global.sesoc.vo.CustomerPurchase;

public class PurchaseUI {
	Scanner keyin = new Scanner(System.in);
	PurchaseServiceImpl service = new PurchaseServiceImpl();

	public PurchaseUI() {
		String choice = null;

		while (true) {
			try {
				mainMenu();
				choice = keyin.next();

				switch (choice) {
				case "1":
					ownerProcess();
					break;
				case "2":
					customerProcess();
					break;

				case "0":
					System.out.println("** ���α׷��� �����մϴ�.");
					service.saveFile();
					// ��� ������ �����ϰ� ����
				default:
					keyin.nextLine();
					System.exit(0);
					;
				}
			} catch (Exception e) {
				continue;
			}
		}
	}

	/**
	 * �ָ޴�
	 */
	private void mainMenu() {
		System.out.println();
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int date = calendar.get(Calendar.DATE);

		System.out.println("         << ���̾� ���汸 >>");
		System.out.println(year + "�� " + month + "�� " + date + "��");
		System.out.println("==============================");
		System.out.println("    1. �Ǹ���");
		System.out.println("    2. ��  ��");
		System.out.println("    0. ��  ��");
		System.out.println("==============================");
		System.out.print("    >> ���� : ");
	}

	///////////////////////// �Ǹ��� ���� ���� ///////////////////////////
	/**
	 * �Ǹ��� ���� �޴��� ȭ�鿡 �����
	 */
	private void ownerProcess() {
		String choice = null;
		while (true) {
			ownerMenu();
			choice = keyin.next();

			switch (choice) {
			case "1": // �Ǹ��ڰ� �Ǹ��� ��ǰ�� �����Ͽ� ��� Ȯ��
				ownerBuy();
				break;
			case "2": // �Ǹ��ڰ� ���� ��� Ȯ��
				stockCheck();
				break;

			case "3": // �Ǹ��ڰ� ������ �Ǹ� ������ Ȯ��
				profitCheck();
				break;

			case "0": // ���� ȭ������ ���ư�
				return;

			default:
				System.out.println("** ���� : �޴��� �ٽ� ������ �ּ���");
				keyin.nextLine();
			}
		}
	}

	/**
	 * �Ǹ��� �޴�
	 */
	private void ownerMenu() {
		System.out.println();
		System.out.println("           << �Ǹ��� >>");
		System.out.println("==============================");
		System.out.println("    1. ��ǰ ����");
		System.out.println("    2. ��� Ȯ��");
		System.out.println("    3. �Ǹ� ���� Ȯ��");
		System.out.println("    0. ���� �޴���");
		System.out.println("==============================");
		System.out.print("    >> ���� : ");
	}

	/**
	 * �Ǹ��ڰ� �Ǹ� ��ǰ ��ü�� ���� ��� Ȯ��
	 */
	private void stockCheck() {
		ArrayList<Product> productList = service.stockCheck();

		if (productList.size() == 0) {
			System.out.println("** ��� ��ǰ�� �ϳ��� �����ϴ�. �Ǹ��� ��ǰ�� ��� Ȯ���ϼ���");
			return;
		}
		System.out.println("\n          [ ���� �Ǹ� ������ ��� ���� ]");
		System.out.println(" ǰ���ȣ      ǰ���                �ܰ�          ���              �ǸŰ� ");
		System.out.println("===============================================");

		for (Product product : productList)
			System.out.println(product);

	}

	/**
	 * �Ǹ��ڰ� ��ǰ ����
	 */
	private void ownerBuy() {
		// �������� ����
		String productId = null;
		String productName = null;
		int quantity = 0;
		int unitPrice = 0;

		try {
			System.out.print("1) ��ǰ �Ϸù�ȣ : ");
			productId = keyin.next();

			// ���� ��ǰ�� �����ϴ��� Ȯ��
			Product product = service.stockCheck(productId);

			// ������ �Ǹ��� �� �ִ� ��ǰ ���
			if (product != null) {
				System.out.println(product);
				System.out.print("2) ���� ���� : ");
				quantity = keyin.nextInt();

				service.stockUpdate(productId, quantity);
			}

			// ������ �Ǹ��� �� ���� ���ο� ��ǰ
			else {
				System.out.print("2) ��ǰ�� : ");
				productName = keyin.next();
				System.out.print("3) �ܰ� : ");
				unitPrice = keyin.nextInt();
				System.out.print("4) ���� ���� : ");
				quantity = keyin.nextInt();

				service.stockCreate(new Product(productId, productName, unitPrice, quantity));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("** �Է� ������ ����. ó������ ���ư��ϴ�.");
			keyin.nextLine();

			return;
		}

		System.out.println("** ��ǰ ���� �Ϸ�");
	}

	/**
	 * ���� �Ǹ� ����üũ
	 */
	private void profitCheck() {
		ArrayList<Product> todaySales = service.nowSalesList();

		if (todaySales.size() == 0) {
			System.out.println("** ������ �� ���� �Ǹ����� ���߽��ϴ�.");
			return;
		}

		int totalPrice = 0;

		System.out.println("\n                [ ���� �Ǹ� �Ѿ� �� ���� ]");
		System.out.println(" ��ǰ��ȣ      ��ǰ��                �ܰ�         �Ǹ� ����         �ǸŰ�              �Ǹ����� ");
		System.out.println("============================================================");

		for (Product product : todaySales) {
			int redMoney = (product.getPrice() - product.getUnitPrice()) * product.getQuantity();
			System.out.println(product + "          " + redMoney);
			totalPrice += redMoney;
		}

		System.out.println("=======================================================");
		System.out.printf("������� �� ���� : %,d\n", totalPrice);
	}

	///////////////////////// ������ ���� ���� ///////////////////////////
	private void customerProcess() {
		String choice = null;

		while (true) {
			customerMenu();

			choice = keyin.next();

			switch (choice) {
			case "1": // �����ϱ�
				customerBuy();
				break;
			case "2": // ���� ���� Ȯ��
				purchaseCheck();
				break;

			case "0": // ���� ȭ������
				return;
			default:
				System.out.println("** �޴��� �ٽ� ������ �ּ���");
				keyin.nextLine();
			}
		}
	}

	/**
	 * ������ �޴�
	 */
	private void customerMenu() {
		System.out.println();
		System.out.println("           << ������ >>");
		System.out.println("==============================");
		System.out.println("    1. ���� �����ϱ�");
		System.out.println("    2. ���� ���� Ȯ��");
		System.out.println("    0. ���� �޴���");
		System.out.println("==============================");
		System.out.print("    >> ���� : ");
	}

	/**
	 * ���� ���� ���� �ϱ�
	 */
	private void customerBuy() {
		String email = null; // �� �̸���
		String productId = null; // ����ǰ �Ϸú�ȣ
		int quantity = 0; // ���ż���

		ArrayList<Product> product = service.stockCheck();
		boolean flag = false;

		System.out.println("\n>> ���� ������ ǰ��");
		for (Product p : product) {
			if (p.getQuantity() > 0) {
				System.out.printf("%s)\t%s(%d��)\t%,6d��%n", p.getProductId(), p.getProductName(), p.getQuantity(),
						p.getPrice());
				flag = true;
			}
		}

		System.out.println("> �� �̸��� : ");
		email = keyin.next();
		System.out.println("> ������ ǰ�� ���� ��ȣ : ");
		productId = keyin.next();
		if (service.stockCheck(productId) == null) {
			System.out.println("** �˼��մϴ�. �ش��ϴ� ������ȣ�� ������ �����ϴ�.");
			return;
		}
		System.out.println("> ���� ���� : ");
		quantity = keyin.nextInt();
		CustomerPurchase purchase = new CustomerPurchase(email, productId, quantity);
		if (service.stockCheck(productId).getQuantity() < quantity) {
			flag = false;
		}

		if (!flag) {
			System.out.println("** �˼��մϴ�. ������ �Ǹ��� ������ �����ϴ�. ������ �̿��� �ּ���");
			return;
		} else {
			service.todaySales(purchase);
			System.out.println("** �����մϴ�. ���� �Ϸ��߽��ϴ�.");
			return;
		}

		// ���� ������ �����ϴ� ���μ��� ó��
		// �̸���, ������ ǰ�� ������ȣ�� �Է¹ް� �ش� ������ȣ�� ������ ǰ���� �ִ��� �˻��� ��
		// �ش� ǰ���� �������� ���� ��� ������ �˸�
		// ���ż����� �Է¹޾Ҵµ�, ���������� ���� ��� �Ǹ��� �� ���ٴ� �޽��� ���
		// Code Here

	}

	/**
	 * ���� �ڽ��� ���� ������ ǰ���� Ȯ����
	 */
	public void purchaseCheck() {
		String email = null; // �� �̸���
		int total = 0; // �� ���Ű�

		System.out.println("> �� �̸��� : ");
		email = keyin.next();
		System.out.println("��ǰ��ȣ         ��ǰ��           ���� ����         �� ���Ű�");
		System.out.println("=============================================");
		service.todayPurchase(email);
		// ���� �̸����� �Է¹޾� �� ���� ������ ������ ����ϰ�, �� ������ ���ݵ� ����Ͽ� ����Ѵ�.
		// ���� ������ ������ ������ ���� ������ ���ٴ� �޽��� ���
		// Code Here

	}
}
