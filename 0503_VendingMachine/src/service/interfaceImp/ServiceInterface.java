package service.interfaceImp;

import java.util.ArrayList;

import vo.Product;

public interface ServiceInterface {

	public String insertMoney(int price);//고객에 지폐를 넣는다.(고객용)
	public int buyProduct(int buttonNumber);//상품사기(고객용)
	public String showProducts();//비치된 상품 보여주기(고객용)
	public String amountZeroList();//재고충전이 필요한 상품리스트 출력(관리자용) //재고가 10개 미만인 재품
	public boolean setProduct(String pCode,int amount);//재고충전(관리자용) //어떤 상품을 몇개 채울것인가
	public ArrayList<Product> soldListStatistics();//판매된 상품 리스트출력(관리자용)
	public boolean loginAdmin(String id, String pw);//관리자 로그인(관리자용)

}
