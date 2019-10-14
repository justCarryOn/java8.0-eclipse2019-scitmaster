	package Service;

import java.util.ArrayList;

import VO.Board;
import VO.FileBoard;
import VO.ImageBoard;

public class BoardService {

	private ArrayList<Board> bList = new ArrayList<>();

	public boolean insert(Board b, String seq) {
		boolean result = true;
		for (int i = 0; i < bList.size(); i++) {
			if (bList.get(i).getSeq().equals(seq)) {
				result = false;
			}
		}
		if (result) {
			bList.add(b);
		}
		return result;
	}

	public String print() {
		String toPrint = "";
		for (Board b : bList) {
			toPrint += b + "\n";
		}
		return toPrint;
	}

	public String searchSeq(String seq) {
		String toSearchSeq = "";
		for (Board b : bList) {
			if (b.getSeq().equals(seq))
				toSearchSeq += b + "\n";
		}
		return toSearchSeq;
	}

	public String searchTitle(String title) {
		String toSearchTitle = "";
		for (Board b : bList) {
			if (b.getTitle().equals(title))
				toSearchTitle += b + "\n";
		}
		return toSearchTitle;
	}

	public String searchImgUrl(String imgUrl) {
		String toSearchImgUrl = "";
		for (Board b : bList) {
			if (b instanceof ImageBoard)
				for (int i = 0; i < ((ImageBoard) b).getImgUrl().size(); i++)
					if (((ImageBoard) b).getImgUrl().get(i).equals(imgUrl))
						toSearchImgUrl += b + "\n";
		}
		return toSearchImgUrl;
	}

	public String searchFileName(String fileName) {
		String toSearchFileName = "";
		for (Board b : bList) {
			if (b instanceof FileBoard)
				for (int i = 0; i < ((FileBoard) b).getFileName().size(); i++)
					if (((FileBoard) b).getFileName().get(i).equals(fileName))
						toSearchFileName += b + "\n";
		}
		return toSearchFileName;
	}

	public boolean remove(String seq) {
		boolean result = false;
		for (int i = 0; i < bList.size(); i++) {
			if (bList.get(i).getSeq().equals(seq)) {
				bList.remove(i);
				result = true;
			}
		}
		return result;
	}

	public boolean rewriteBoard(String seq, Board b) {
		boolean flag=false;
		for (int i = 0; i<bList.size(); i++) {
			if (bList.get(i).getSeq().equals(seq)) {
				bList.set(i, b);
				flag =true;
			}
		}
		return flag;
	}

	public boolean rewriteImageBoard(String seq, ImageBoard ib) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean rewriteFileBoard(String seq, FileBoard fb) {
		// TODO Auto-generated method stub
		return false;
	}

}
