package ui;

import java.util.Scanner;

import service.BankService;
import vo.Account;
import vo.Client;
import vo.DepositAccount;
import vo.MinusAccount;

public class BankUI {
	private Scanner sc = new Scanner(System.in);
	private String name, ssn, address, phoneNum, accountNum;
	private int balance, money, choice;
	private boolean flag = true;
	private BankService bs = new BankService();

	public BankUI() {
		while (flag) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				boolean flag;
				flag = bs.insertClient(makeClient());
				if (flag) {
					System.out.println("��ϿϷ�");
				} else {
					System.out.println("�̹� ��ϵ� ���Դϴ�");
				}
				break;
			case 2:
				System.out.println("�ֹε�Ϲ�ȣ: ");
				ssn = sc.next();
				bs.registerAccount(ssn, makeAccount());
				break;
			case 3:
				System.out.println("���¹�ȣ: ");
				accountNum = sc.next();
				System.out.println("�ݾ�: ");
				money = sc.nextInt();
				bs.deposit(accountNum, money);
				break;
			case 4:
				System.out.println("���¹�ȣ: ");
				accountNum = sc.next();
				System.out.println("�ݾ�: ");
				money = sc.nextInt();
				bs.withdrawal(accountNum, money);
				break;
			case 5:
				System.out.println("�������¹�ȣ: ");
				String from = sc.next();
				System.out.println("�������¹�ȣ: ");
				String to = sc.next();
				System.out.println("�ݾ�: ");
				money = sc.nextInt();
				bs.transfer(from, to, money);
				break;
			case 6:
				System.out.println(bs.printAllClient());
				break;
			case 7:
				System.out.println("�ֹε�Ϲ�ȣ: ");
				ssn = sc.next();
				System.out.println(bs.printAllAccount(ssn));
				break;
			case 0:
				System.out.println("���� �� �����մϴ�");
				bs.saveFile();
				return;
			}
		}

	}

	public void menu() {
		System.out.println("1.�����");
		System.out.println("2.���µ��");
		System.out.println("3.�Ա�");
		System.out.println("4.���");
		System.out.println("5.�۱�");
		System.out.println("6.����ü���");
		System.out.println("7.�������");
		System.out.println("0.����");
	}

	public Client makeClient() {
		System.out.println("�̸�: ");
		name = sc.next();
		System.out.println("�ֹε�Ϲ�ȣ: ");
		ssn = sc.next();
		System.out.println("�ּ�: ");
		address = sc.next();
		System.out.println("��ȭ��ȣ: ");
		phoneNum = sc.next();
		return new Client(name, ssn, address, phoneNum);
	}

	public Account makeAccount() {

		Account acc = new Account();

		System.out.println("1.�������");
		System.out.println("2.���̳ʽ�����");
		choice = sc.nextInt();

		System.out.println("���¹�ȣ: ");
		accountNum = sc.next();
		System.out.println("�ܰ�: ");
		balance = sc.nextInt();

		switch (choice) {
		case 1:
			DepositAccount dacc = new DepositAccount(accountNum, balance);
			acc = dacc;
			break;
		case 2:
			MinusAccount macc = new MinusAccount(accountNum, balance);
			acc = macc;
			break;
		}
		return acc;
	}
}
