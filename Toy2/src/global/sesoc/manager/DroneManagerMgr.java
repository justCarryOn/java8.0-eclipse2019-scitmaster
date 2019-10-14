package global.sesoc.manager;

import java.util.ArrayList;
import java.util.List;

import global.sesoc.dao.DroneDaoImpl;
import global.sesoc.vo.Drone;

public class DroneManagerMgr{
	DroneDaoImpl dao;
	
	/** 생성자 
	 * @throws Exception
	 */
	public DroneManagerMgr(){
		dao = new DroneDaoImpl(); 
	}

	/**
	 * 제품의 일련 번호를 이용해 해당하는 제품이 있는지 찾는다.
	 * @param serialNum 제품번호
	 * 
	 * @return 제품번호에 의해 검색된 제품 정보, 검색된 내용이 없을 경우 null이 리턴된다.
	 */
	public Drone searchDrone(int serialNum) {
		Drone drone = dao.searchDrone(serialNum);

		return drone;
	}

	/**
	 * 제품 번호를 이용해 해당 제품을 찾았을 경우 제품을 목록에서 삭제하고, 파일에 저장한 후 true릉 리턴한다.
	 * 제품번호를 찾지 못했을 경우 false를 리턴한다.
	 * @param serialNum
	 * @return 삭제 여부
	 */
	public int deleteDrone(int serialNum) {
		int result = 0;
		result = dao.removeDrone(serialNum);

		return result;
	}

	/**
	 * 최소금액과, 최대금액을 전달받아 해당하는 값을 전달받아 그 영역사이의 가격인 장난감을 리턴한다.
	 * @param 최소값, 최대값
	 * @return 지정한 금액 안에 존재하는 장난감의 목록
	 */
	public List<Drone> droneListForPrice(int minPrice, int maxPrice) {
		List<Drone> pList = new ArrayList<>();
		
		pList = dao.droneListForPrice(minPrice, maxPrice);
		return pList;
	}

	/**
	 * 전달된 타입의 장난감 목록을 DB에서 조회한다.
	 * @param 장난감 타입
	 * @return 검색된 장난감 목록
	 */
	public List<Drone> printDroneInfo() {
		List<Drone> drones = new ArrayList<>();
		drones = dao.seletAllDrones();

		return drones;
	}

	/**
	 * 전달받은 Drone 객체를 DB에 저장
	 * @param 저장할 Drone객체
	 * @return 추가여부 
	 */
	public int insertDrone(Drone drone) {
		return dao.insertDrone(drone);
	}
}
