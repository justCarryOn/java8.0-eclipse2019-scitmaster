package global.sesoc.manager;

import java.util.ArrayList;
import java.util.List;

import global.sesoc.dao.DroneDaoImpl;
import global.sesoc.vo.Drone;

public class DroneManagerMgr{
	DroneDaoImpl dao;
	
	/** ������ 
	 * @throws Exception
	 */
	public DroneManagerMgr(){
		dao = new DroneDaoImpl(); 
	}

	/**
	 * ��ǰ�� �Ϸ� ��ȣ�� �̿��� �ش��ϴ� ��ǰ�� �ִ��� ã�´�.
	 * @param serialNum ��ǰ��ȣ
	 * 
	 * @return ��ǰ��ȣ�� ���� �˻��� ��ǰ ����, �˻��� ������ ���� ��� null�� ���ϵȴ�.
	 */
	public Drone searchDrone(int serialNum) {
		Drone drone = dao.searchDrone(serialNum);

		return drone;
	}

	/**
	 * ��ǰ ��ȣ�� �̿��� �ش� ��ǰ�� ã���� ��� ��ǰ�� ��Ͽ��� �����ϰ�, ���Ͽ� ������ �� true�� �����Ѵ�.
	 * ��ǰ��ȣ�� ã�� ������ ��� false�� �����Ѵ�.
	 * @param serialNum
	 * @return ���� ����
	 */
	public int deleteDrone(int serialNum) {
		int result = 0;
		result = dao.removeDrone(serialNum);

		return result;
	}

	/**
	 * �ּұݾװ�, �ִ�ݾ��� ���޹޾� �ش��ϴ� ���� ���޹޾� �� ���������� ������ �峭���� �����Ѵ�.
	 * @param �ּҰ�, �ִ밪
	 * @return ������ �ݾ� �ȿ� �����ϴ� �峭���� ���
	 */
	public List<Drone> droneListForPrice(int minPrice, int maxPrice) {
		List<Drone> pList = new ArrayList<>();
		
		pList = dao.droneListForPrice(minPrice, maxPrice);
		return pList;
	}

	/**
	 * ���޵� Ÿ���� �峭�� ����� DB���� ��ȸ�Ѵ�.
	 * @param �峭�� Ÿ��
	 * @return �˻��� �峭�� ���
	 */
	public List<Drone> printDroneInfo() {
		List<Drone> drones = new ArrayList<>();
		drones = dao.seletAllDrones();

		return drones;
	}

	/**
	 * ���޹��� Drone ��ü�� DB�� ����
	 * @param ������ Drone��ü
	 * @return �߰����� 
	 */
	public int insertDrone(Drone drone) {
		return dao.insertDrone(drone);
	}
}
