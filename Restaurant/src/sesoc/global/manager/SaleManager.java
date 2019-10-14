package sesoc.global.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import sesoc.global.vo.DeliveryOrder;
import sesoc.global.vo.Food;
import sesoc.global.vo.Order;

public class SaleManager implements Manager {
	private List<Food> foodList;
	private List<Order> orderList;
	private final String FILE_NAME="menu.txt";
	private FileReader fr;			//������ �б� ���� Reader
	private FileWriter fw;			//������ ���� ���� Writer
	private BufferedReader br;		//���ڵ����͸� �б� ���� BufferedReader
	private BufferedWriter bw;		//���ڵ����͸� ���� ���� BufferedWriter

	public SaleManager() throws Exception {
		// ���� �޴��� �о� List�� �����Ѵ�.
		File file = new File(FILE_NAME);
		
		if(file.exists()){
			foodList = new ArrayList<>(); 
			getFile();
		} else {
			throw new Exception("�ֹ��� �޴������� �������� �ʽ��ϴ�.");
		}
		orderList = new ArrayList<>();
	}

	@Override
	public void getFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Food> getFoods() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findOrder(int orderNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order deleteOrder(int orderNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean insertOrder(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void saveFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] calcSalesTotal() {
		// TODO Auto-generated method stub
		return null;
	}

	/** �� ��ġ���� Manager �������̽��� ��� �޼��带 �������̵��Ͽ� �����Ѵ�. */
	
}
