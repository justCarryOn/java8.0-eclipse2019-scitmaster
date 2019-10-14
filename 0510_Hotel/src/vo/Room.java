package vo;

import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {

	private ArrayList<Guest> gList;// �������� �����
	private String roomNum;// �� ��ȣ
	private String numBed;// ħ�� ����
	private int price;// 1�� ����
	private String roomType;// ��Ÿ��

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
		return "�����=" + gList + ", ���ȣ=" + roomNum + ", ħ�밳��=" + numBed + ", 1�ڰ���=" + price
				+ ", ��Ÿ��=" + roomType;
	}

}
