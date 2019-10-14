package global.sesoc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import global.sesoc.vo.Drone;

public class DroneDaoImpl implements DroneDao{

	@Override
	public Drone searchDrone(int serialNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql  = null;
		Drone drone = null;

		try {
			con = ConnectionManager.getConnection();
			sql = "select * from drone where serialnum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, serialNum);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				drone = new Drone();
				drone.setSerialNum(rs.getInt(1));
				drone.setName(rs.getString(2));
				drone.setPrice(rs.getInt(3));
				drone.setWingCount(rs.getInt(4));
			}

		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return drone;		//결과가 없으면 null 리턴
	}
	
	@Override
	public int removeDrone(int serialNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql  = null;
		int result = 0;

		try {
			con = ConnectionManager.getConnection();
			sql = "delete from drone where serialnum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, serialNum);
			
			result = pstmt.executeUpdate();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;		
	}
	
	@Override
	public int insertDrone(Drone drone) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql  = null;
		int result = 0;

		try {
			con = ConnectionManager.getConnection();
			sql = "insert into drone values "
					+ "(drone_seq.nextval, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, drone.getName());
			pstmt.setInt(2, drone.getPrice());
			pstmt.setInt(3, drone.getWingCount());
			
			result = pstmt.executeUpdate();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;		
	}

	@Override
	public List<Drone> droneListForPrice(int minPrice, int maxPrice) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql  = null;
		Drone drone = null;
		
		List<Drone> droneList = new ArrayList<>();

		try {
			con = ConnectionManager.getConnection();
			sql = "select * from drone where price >= ? and price <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, minPrice);
			pstmt.setInt(2, maxPrice);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				drone = new Drone();
				drone.setSerialNum(rs.getInt(1));
				drone.setName(rs.getString(2));
				drone.setPrice(rs.getInt(3));
				drone.setWingCount(rs.getInt(4));
			
				droneList.add(drone);
			}

		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return droneList;		// 결과가 없으면 null 리턴
	}
	
	@Override
	public List<Drone> seletAllDrones() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql  = null;
		Drone drone = null;
		
		List<Drone> droneList = new ArrayList<>();

		try {
			con = ConnectionManager.getConnection();
			sql = "select * from drone";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				drone = new Drone();
				drone.setSerialNum(rs.getInt(1));
				drone.setName(rs.getString(2));
				drone.setPrice(rs.getInt(3));
				drone.setWingCount(rs.getInt(4));
			
				droneList.add(drone);
			}

		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return droneList;		// 결과가 없으면 null 리턴
	}
}
