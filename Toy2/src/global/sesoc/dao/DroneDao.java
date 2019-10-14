package global.sesoc.dao;

import java.util.List;

import global.sesoc.vo.Drone;

public interface DroneDao {
	public int insertDrone(Drone Drone);
	public Drone searchDrone(int serialNum);
	public int removeDrone(int serialNum);
	public List<Drone> droneListForPrice(int minPrice, int maxPrice);
	public List<Drone> seletAllDrones();
}
