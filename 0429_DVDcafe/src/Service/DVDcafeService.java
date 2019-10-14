package Service;

import java.util.ArrayList;

import VO.DVD;
import VO.Device;
import VO.Movie;
import VO.USB;

public class DVDcafeService {
	private ArrayList<Movie> mList = new ArrayList<>();
	private ArrayList<Device> dList = new ArrayList<>();

	public void insert(Movie m) { // 영화등록
		mList.add(m);
	}

	public String print() { // 목록보기
		String toPrint = "";
		for (Movie m : mList) {
			toPrint += m + "\n";
		}
		return toPrint;
	}

	public boolean makeDVD(DVD d, String title) { // DVD제조
		boolean result = false;
		for (int i = 0; i < dList.size(); i++) {
			for (Movie m : mList) {
				if (m.getTitle().equals(title)) {
					d.setMovie(m);
					dList.add(d);
					result = true;
					break;
				}
			}
		}
		return result;
	}

	public boolean makeUSB(USB u, ArrayList<String> sList) { // USB제조
		boolean flag = false;
		for (Movie m : mList) {
			for (String title : sList) {
				if (m.getTitle().equals(title)) {
					u.getmList().add(m);
					flag = true;
				}
			}
		}
		if (flag) {
			dList.add(u);
		}
		return flag;
	}

	public String search(String title) { // 검색
		String toPrint = "";
		for (Device device : dList) {
			if (device instanceof DVD) {
				if (((DVD) device).getMovie().getTitle().equals(title))
					toPrint += device + "\n";
			} else if (device instanceof USB) {
				for (int i = 0; i < ((USB) device).getmList().size(); i++) {
					if (((USB) device).getmList().get(i).getTitle().equals(title)) {
						toPrint += device + "\n";
					}
				}
			}
		}
		return toPrint;
	}
}
