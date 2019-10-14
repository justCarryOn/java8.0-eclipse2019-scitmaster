package vo;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String adr;
	private String pn;

	public Member() {
		super();
	}

	public Member(String id, String pw, String name, String adr, String pn) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.adr = adr;
		this.pn = pn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getadr() {
		return adr;
	}

	public void setadr(String adr) {
		this.adr = adr;
	}

	public String getPn() {
		return pn;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", adr=" + adr + ", pn=" + pn + "]";
	}
}
