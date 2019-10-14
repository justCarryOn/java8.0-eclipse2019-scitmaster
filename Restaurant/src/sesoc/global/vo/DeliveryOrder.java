package sesoc.global.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class DeliveryOrder extends Order implements Serializable{
	private String buyerPhone;		// �ֹ��� ��ȭ��ȣ
	private String buyerAddress;	// �ֹ��� �ּ�
	
	public DeliveryOrder() {
		// TODO Auto-generated constructor stub
	}
	public DeliveryOrder(String buyerPhone, String buyerAddress, Map<Food, Integer> orderedFoodNo) {
		super(orderedFoodNo);
		this.buyerPhone = buyerPhone;
		this.buyerAddress = buyerAddress;
	}
	public String getBuyerPhone() {
		return buyerPhone;
	}
	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}
	public String getbuyerAddress() {
		return buyerAddress;
	}
	public void setbuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}
	
	@Override
	public String showOrderSituation() {
		String temp = super.showOrderSituation();
		return temp+= "�ֹ��� ��ȭ��ȣ : " + buyerPhone + ", �ֹ��� �ּ� : " + buyerAddress+ "\n";
	}
}
