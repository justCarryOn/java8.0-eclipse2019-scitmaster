package VO;

import java.util.ArrayList;

public class FileBoard extends Board {
	private ArrayList<String> fileName = new ArrayList<>(); //파일명

	public FileBoard() {
		super();
	}

	public FileBoard(String seq, String title, String content, String indate, String id, ArrayList<String> fileName) {
		super(seq, title, content, indate, id);
		this.fileName = fileName;
	}

	public ArrayList<String> getFileName() {
		return fileName;
	}

	public void setFileName(ArrayList<String> fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return super.toString()+ ", 파일명=" + fileName;
	}
}
