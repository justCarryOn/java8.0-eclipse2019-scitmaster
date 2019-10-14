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
	private FileReader fr;			//파일을 읽기 위한 Reader
	private FileWriter fw;			//파일을 쓰기 위한 Writer
	private BufferedReader br;		//문자데이터를 읽기 위한 BufferedReader
	private BufferedWriter bw;		//문자데이터를 쓰기 위한 BufferedWriter

	public SaleManager() throws Exception {
		// 음식 메뉴를 읽어 List에 저장한다.
		File file = new File(FILE_NAME);
		
		if(file.exists()){
			foodList = new ArrayList<>(); 
			getFile();
		} else {
			throw new Exception("주문할 메뉴파일이 존재하지 않습니다.");
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

	/** 이 위치에서 Manager 인터페이스의 모든 메서드를 오버라이딩하여 구현한다. */
	
}
