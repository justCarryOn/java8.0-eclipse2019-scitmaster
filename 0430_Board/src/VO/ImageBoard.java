package VO;

import java.util.ArrayList;

public class ImageBoard extends Board {
	private ArrayList<String> imgUrl = new ArrayList<>(); // 이미지경로

	public ImageBoard() {
		super();
	}

	public ImageBoard(String seq, String title, String content, String indate, String id, ArrayList<String> imgUrl) {
		super(seq, title, content, indate, id);
		this.imgUrl = imgUrl;
	}

	public ArrayList<String> getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(ArrayList<String> imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return super.toString()+ ", 이미지경로=" + imgUrl;
	}
}
