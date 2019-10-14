package sesoc.global.manager;
import java.util.List;
import sesoc.global.vo.Food;
import sesoc.global.vo.Order;

public interface Manager {
	/**
	 * menu.txt ���Ϸκ��� ��� �����͸� �о� , �����ڷ� �����Ͽ� �и��� �� 
	 * ArrayList�� �����Ѵ�.
	 */
	public void getFile(); 
	
	/**
	 * @return �ֹ������� ���� ����� ��ȯ�Ѵ�.
	 */
	public List<Food> getFoods() ;
	
	/**
	 * �ֹ� ��ȣ�� �̿��� �ֹ� ����� �ִ��� ã�´�.
	 * @param orderNo �ֹ���ȣ
	 * @return �ֹ���ȣ�� �̿��� �˻��� �ֹ����
	 */
	public Order findOrder(int orderNo) ;
	/**
	 * �ֹ���ȣ�� �̿��� �ش� �ֹ��� ����Ѵ�.
	 * �ֹ���ȣ�� ã�� �ش� �ֹ��� ��ҵǸ� �ش� ��ü�� �����Ѵ�.
	 * ���� �ֹ���ȣ�� ã�� ���ϸ� null�� �����Ѵ�.
	 * @param orderNo
	 * @return ������ Order ��ü
	 */
	public Order deleteOrder(int orderNo); 
	
	/**
	 * ������� �Ǹŵ� ��� �Ѿ��� ȭ�鿡 ����Ѵ�.
	 */
	public void showAll();
	
	/**
	 * �ֹ����� ������ �Ż� �����
	 * @param �ֹ����� ����
	 * @return �߰� �Ǿ������� ���� ����, �߰� �Ǿ����� true, �ƴϸ� false 
	 */
	public boolean insertOrder(Order order) ;
	
	/**
	 * ���� ���� ��� �Ż��� ���Ͽ� ����Ѵ�.
	 * ���忡�� �Ǹ��� �Ѿװ� ��� �Ǹ� �Ѿ׵� ���Ͽ� ����Ѵ�.
	 * �� �Ǹ� �Ѿ��� calcSalesTotal() �޼��带 ������� ���Ϲ޴´�.
	 */
	public void saveFile() ;
	
	/**
	 * �ֹ�ó���� ��� ��� �� ���忡�� �Ǹŵ� �Ѿװ� ��� �Ǹŵ� �Ѿ��� �����Ͽ� int[] �� �����Ѵ�.
	 * sale[0] : �����Ǹ� �Ѿ��� ������
	 * sale[1] : ����Ǹ� �Ѿ��� ������
	 * @return 
	 */
	public int[] calcSalesTotal();
}
