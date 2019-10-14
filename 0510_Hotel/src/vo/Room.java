package vo;

import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {

	private ArrayList<Guest> gList;// 투숙중인 고객명단
	private String roomNum;// 방 번호
	private String numBed;// 침대 갯수
	private int price;// 1박 가격
	private String roomType;// 방타입

	public Room() {
		super();
	}

	public Room(ArrayList<Guest> gList, String roomNum, String numBed, int price, String roomType) {
		super();
		this.gList = gList;
		this.roomNum = roomNum;
		this.numBed = numBed;
		this.price = price;
		this.roomType = roomType;
	}

	public ArrayList<Guest> getgList() {
		return gList;
	}

	public void setgList(ArrayList<Guest> gList) {
		this.gList = gList;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getNumBed() {
		return numBed;
	}

	public void setNumBed(String numBed) {
		this.numBed = numBed;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return "고객명단=" + gList + ", 방번호=" + roomNum + ", 침대개수=" + numBed + ", 1박가격=" + price
				+ ", 방타입=" + roomType;
	}

}
