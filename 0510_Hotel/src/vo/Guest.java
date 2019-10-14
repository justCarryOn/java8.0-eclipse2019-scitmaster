package vo;

import java.io.Serializable;
import java.util.Date;

public class Guest implements Serializable {

	private String name;// 이름
	private String ssn;// 주민번호
	private Date from;// 투숙시작기간
	private Date to;// 투숙끝기간

	public Guest() {
		super();
	}

	public Guest(String name, String ssn, Date from, Date to) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.from = from;
		this.to = to;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "이름=" + name + ", 주민번호=" + ssn + ", 체크인날짜=" + from + ", 체크아웃날짜=" + to;
	}

}
