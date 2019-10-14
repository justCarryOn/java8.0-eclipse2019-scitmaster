package global.sesoc.service;

import java.util.ArrayList;

import global.sesoc.vo.Product;
import global.sesoc.vo.CustomerPurchase;

public interface PurchaseService {
	/** 
	 * 특정 품목에 대한 재고 확인하는 메서드
	 * @param   productId : 재고를 확인할 품목에 대한 id
	 * @return  Product   : 재고가 확인된 품목 객체
	 */
	public Product stockCheck(String productId);

	/**
	 * 판매하는 전체 품목에 대한 재고 확인
	 * @return  ArrayList<Product>   : 판매하는 모든 품목에 대한 재고 목록
	 */
	public ArrayList<Product> stockCheck();
	
	/**
	 * 새로운 물품 등록
	 * @param   product : 판매자가 판매할 새로운 물품을 등록한다.
	 * @return	등록 여부 (true:등록완료, false:등록불가)
	 */
	public boolean stockCreate(Product product);

	/**
	 * 판매자가 기존에 판매하던 품목의 수량을 수정
	 * @param productId : 품목 ID
	 * @param quantity  : 추가 구매 수량
	 * @return
	 */
	public boolean stockUpdate(String productId, int quantity);

	/**
	 * 현재 판매한 매출 내역 조회
	 * @return ArrayList<Product> : 현재 판매한 매출 내역 집계를 위한 전체 목록  
	 */
	public ArrayList<Product> nowSalesList();
	
	/**
	 * 고객이 물품을 구매하면 구매한 품목온 todaySales 목록에 추가하고
	 * 전체 품목 리스트에서는 판매한 만큼 수량을 뺀다.
	 * @param purchase : 고객이 구매한 폼목
	 * @return 
	 */

	public boolean todaySales(CustomerPurchase purchase);
	
	/**
	 * 고객이 자신의 이메일을 통해 총 구매 내역을 확인
	 * @param email
	 * @return
	 */
	public ArrayList<CustomerPurchase> todayPurchase(String email);
	
	/**
	 * 판매하는 모든 물품의 재고내역을 파일에서 불러옴
	 */
	public void loadFile() ;

	/**
	 * 판매하는 모든 물품의 재고 내역을 파일로 저장함
	 */
	public void saveFile();
}
