package sesoc.global.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Order implements Serializable {
	public static int ORDER_NO;			// �ֹ��� �Ͼ ������ ��ȣ�� �ڵ�����, ������ ���̾�� �Ѵ�.
	private int orderNo;			  	// �ֹ���ȣ(pk)
	private Map<Food, Integer> orderedFoods; // �ֹ��� ���İ� ������ ����
	
	public Order() {
	}

	public Order(Map<Food, Integer> orderedFoods) {
		ORDER_NO++;
		this.orderNo = ORDER_NO;
		this.orderedFoods = orderedFoods;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public Map<Food, Integer> getOrderedFoods() {
		return orderedFoods;
	}

	public void setOrderedFoodNo(Map<Food, Integer> orderedFoods) {
		this.orderedFoods = orderedFoods;
	}
	public String showOrderSituation() {
		String foods = "";
		
		for(Map.Entry<Food, Integer> s : orderedFoods.entrySet() ) {
			Food food = s.getKey();
			int count = s.getValue();
			foods += food.getFoodName() + " " + food.getPrice() +"��  " + count+ "�� / ";
		}
		return "�ֹ� ��ȣ(" + orderNo + "��) " + foods ;
	}
}
