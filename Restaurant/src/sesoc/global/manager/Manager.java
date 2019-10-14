package sesoc.global.manager;
import java.util.List;
import sesoc.global.vo.Food;
import sesoc.global.vo.Order;

public interface Manager {
	/**
	 * menu.txt 파일로부터 모든 데이터를 읽어 , 구분자로 구분하여 분리한 후 
	 * ArrayList에 저장한다.
	 */
	public void getFile(); 
	
	/**
	 * @return 주문가능한 음식 목록을 반환한다.
	 */
	public List<Food> getFoods() ;
	
	/**
	 * 주문 번호를 이용해 주문 목록이 있는지 찾는다.
	 * @param orderNo 주문번호
	 * @return 주문번호를 이용해 검색한 주문목록
	 */
	public Order findOrder(int orderNo) ;
	/**
	 * 주문번호를 이용해 해당 주문을 취소한다.
	 * 주문번호를 찾아 해당 주문이 취소되면 해당 객체를 리턴한다.
	 * 만약 주문번호를 찾지 못하면 null을 리턴한다.
	 * @param orderNo
	 * @return 삭제된 Order 객체
	 */
	public Order deleteOrder(int orderNo); 
	
	/**
	 * 현재까지 판매된 모든 총액을 화면에 출력한다.
	 */
	public void showAll();
	
	/**
	 * 주문받은 내용을 매상에 등록함
	 * @param 주문받은 내용
	 * @return 추가 되었는지의 여부 리턴, 추가 되었으면 true, 아니면 false 
	 */
	public boolean insertOrder(Order order) ;
	
	/**
	 * 오늘 현재 모든 매상을 파일에 기록한다.
	 * 매장에서 판매한 총액과 배달 판매 총액도 파일에 기록한다.
	 * 각 판매 총액은 calcSalesTotal() 메서드를 실행시켜 리턴받는다.
	 */
	public void saveFile() ;
	
	/**
	 * 주문처리된 모든 목록 중 매장에서 판매된 총액과 배달 판매된 총액을 누적하여 int[] 에 저장한다.
	 * sale[0] : 매장판매 총액이 누적됨
	 * sale[1] : 배달판매 총액이 누적됨
	 * @return 
	 */
	public int[] calcSalesTotal();
}
