package sesoc.global.vo;

import java.io.Serializable;

public class Comics extends Book implements Serializable {
	private int year;
	private int month;

	public Comics() {
	}

	public Comics(String isbn, String title, String publisher, int year, int month) {
		super(isbn, title, publisher);
		this.year = year;
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return super.toString() + " πﬂ«‡¿œ: " + year + "/" + month;
	}
}
