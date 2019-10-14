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
					System.out.println("등록완료");
				} else {
					System.out.println("이미 등록된 고객입니다");
				}
				break;
			case 2:
				System.out.println("주민등록번호: ");
				ssn = sc.next();
				bs.registerAccount(ssn, makeAccount());
				break;
			case 3:
				System.out.println("계좌번호: ");
				accountNum = sc.next();
				System.out.println("금액: ");
				money = sc.nextInt();
				bs.deposit(accountNum, money);
				break;
			case 4:
				System.out.println("계좌번호: ");
				accountNum = sc.next();
				System.out.println("금액: ");
				money = sc.nextInt();
				bs.withdrawal(accountNum, money);
				break;
			case 5:
				System.out.println("보낼계좌번호: ");
				String from = sc.next();
				System.out.println("받을계좌번호: ");
				String to = sc.next();
				System.out.println("금액: ");
				money = sc.nextInt();
				bs.transfer(from, to, money);
				break;
			case 6:
				System.out.println(bs.printAllClient());
				break;
			case 7:
				System.out.println("주민등록번호: ");
				ssn = sc.next();
				System.out.println(bs.printAllAccount(ssn));
				break;
			case 0:
				System.out.println("저장 후 종료합니다");
				bs.saveFile();
				return;
			}
		}

	}

	public void menu() {
		System.out.println("1.고객등록");
		System.out.println("2.계좌등록");
		System.out.println("3.입금");
		System.out.println("4.출금");
		System.out.println("5.송금");
		System.out.println("6.고객전체출력");
		System.out.println("7.계좌출력");
		System.out.println("0.종료");
	}

	public Client makeClient() {
		System.out.println("이름: ");
		name = sc.next();
		System.out.println("주민등록번호: ");
		ssn = sc.next();
		System.out.println("주소: ");
		address = sc.next();
		System.out.println("전화번호: ");
		phoneNum = sc.next();
		return new Client(name, ssn, address, phoneNum);
	}

	public Account makeAccount() {

		Account acc = new Account();

		System.out.println("1.저축계좌");
		System.out.println("2.마이너스계좌");
		choice = sc.nextInt();

		System.out.println("계좌번호: ");
		accountNum = sc.next();
		System.out.println("잔고: ");
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
