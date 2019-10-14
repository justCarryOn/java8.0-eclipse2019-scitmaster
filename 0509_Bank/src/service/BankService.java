package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import vo.Account;
import vo.Client;
import vo.DepositAccount;
import vo.MinusAccount;

public class BankService implements BankInterface {
	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private ArrayList<Client> cList = new ArrayList<>();
	private String FILE_NAME = "bank.dat";

	public BankService() {
		if (new File(FILE_NAME).exists()) {
			loadFile();
		} else {
			cList = new ArrayList<>();
		}
	}

	@Override
	public boolean insertClient(Client c) {
		for (Client client : cList) {
			if (client.getSsn().equals(c.getSsn())) {
				return false;
			}
		}
		cList.add(c);
		saveFile();
		return true;
	}

	@Override
	public boolean registerAccount(String ssn, Account acc) {
		boolean flag = false;
		boolean check = true;
		for (Client client : cList) {
			for (int i = 0; i < client.getAccList().size(); i++) {
				if (client.getAccList().get(i).equals(acc)) {
					check = false;
				}
			}
		}
		if (acc instanceof DepositAccount) {
			if (acc.getBalance() < 0) {
				check = false;
			}
		}
		if (check) {
			for (Client client : cList) {
				if (client.getSsn().equals(ssn)) {
					client.getAccList().add(acc);
					saveFile();
					flag = true;
				}
			}
		}
		return flag;
	}

	@Override
	public boolean deposit(String accNum, int money) {
		for (Client client : cList) {
			for (int i = 0; i < client.getAccList().size(); i++) {
				if (client.getAccList().get(i).getAccountNum().equals(accNum)) {
					client.getAccList().get(i).setBalance(client.getAccList().get(i).getBalance() + money);
					saveFile();
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean withdrawal(String accNum, int money) {
		for (Client client : cList) {
			for (int i = 0; i < client.getAccList().size(); i++) {
				if (client.getAccList().get(i).getAccountNum().equals(accNum)) {
					if (client.getAccList().get(i) instanceof DepositAccount) {
						client.getAccList().get(i).setBalance(client.getAccList().get(i).getBalance() - money);
						if (client.getAccList().get(i).getBalance() < 0) {
							return false;
						} else {
							saveFile();
							return true;
						}
					} else {
						client.getAccList().get(i).setBalance(client.getAccList().get(i).getBalance() - money);
						saveFile();
						return true;
					}
				}
			}
		}

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transfer(String from, String to, int money) {
		if (withdrawal(from, money)) {
			deposit(to, money);
			saveFile();
			return true;
		}
		return false;
	}

	@Override
	public String printAllClient() {
		String toPrint = "";
		for (Client client : cList) {
			toPrint += client + "\n";
		}
		return toPrint;
	}

	@Override
	public String printAllAccount(String ssn) {
		String toPrint = "";
		for (Client client : cList) {
			if (client.getSsn().equals(ssn)) {
				toPrint += client.getAccList() + "\n";
			}
		}
		return toPrint;
	}

	@Override
	public void saveFile() {
		File f = new File(FILE_NAME);
		try {
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(cList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void loadFile() {
		File f = new File(FILE_NAME);
		try {
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			cList = (ArrayList<Client>) ois.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
