package vo;

import java.io.Serializable;
import java.util.Date;

public class Guest implements Serializable {

	private String name;// �̸�
	private String ssn;// �ֹι�ȣ
	private Date from;// �������۱Ⱓ
	private Date to;// �������Ⱓ

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
		return "�̸�=" + name + ", �ֹι�ȣ=" + ssn + ", üũ�γ�¥=" + from + ", üũ�ƿ���¥=" + to;
	}

}
