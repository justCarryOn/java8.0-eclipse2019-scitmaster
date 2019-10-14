package global.sesoc.service;

import java.util.ArrayList;

import global.sesoc.vo.Product;
import global.sesoc.vo.CustomerPurchase;

public interface PurchaseService {
	/** 
	 * Ư�� ǰ�� ���� ��� Ȯ���ϴ� �޼���
	 * @param   productId : ��� Ȯ���� ǰ�� ���� id
	 * @return  Product   : ��� Ȯ�ε� ǰ�� ��ü
	 */
	public Product stockCheck(String productId);

	/**
	 * �Ǹ��ϴ� ��ü ǰ�� ���� ��� Ȯ��
	 * @return  ArrayList<Product>   : �Ǹ��ϴ� ��� ǰ�� ���� ��� ���
	 */
	public ArrayList<Product> stockCheck();
	
	/**
	 * ���ο� ��ǰ ���
	 * @param   product : �Ǹ��ڰ� �Ǹ��� ���ο� ��ǰ�� ����Ѵ�.
	 * @return	��� ���� (true:��ϿϷ�, false:��ϺҰ�)
	 */
	public boolean stockCreate(Product product);

	/**
	 * �Ǹ��ڰ� ������ �Ǹ��ϴ� ǰ���� ������ ����
	 * @param productId : ǰ�� ID
	 * @param quantity  : �߰� ���� ����
	 * @return
	 */
	public boolean stockUpdate(String productId, int quantity);

	/**
	 * ���� �Ǹ��� ���� ���� ��ȸ
	 * @return ArrayList<Product> : ���� �Ǹ��� ���� ���� ���踦 ���� ��ü ���  
	 */
	public ArrayList<Product> nowSalesList();
	
	/**
	 * ���� ��ǰ�� �����ϸ� ������ ǰ��� todaySales ��Ͽ� �߰��ϰ�
	 * ��ü ǰ�� ����Ʈ������ �Ǹ��� ��ŭ ������ ����.
	 * @param purchase : ���� ������ ����
	 * @return 
	 */

	public boolean todaySales(CustomerPurchase purchase);
	
	/**
	 * ���� �ڽ��� �̸����� ���� �� ���� ������ Ȯ��
	 * @param email
	 * @return
	 */
	public ArrayList<CustomerPurchase> todayPurchase(String email);
	
	/**
	 * �Ǹ��ϴ� ��� ��ǰ�� ������� ���Ͽ��� �ҷ���
	 */
	public void loadFile() ;

	/**
	 * �Ǹ��ϴ� ��� ��ǰ�� ��� ������ ���Ϸ� ������
	 */
	public void saveFile();
}
