package VO;

public class Board {
	private String seq, title, content, indate, id;

	public Board() {
		super();
	}

	public Board(String seq, String title, String content, String indate, String id) {
		super();
		this.seq = seq; // �Ϸù�ȣ
		this.title = title; // ����
		this.content = content; // ����
		this.indate = indate; // �Խ���
		this.id = id; // �Խ���
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "��ȣ=" + seq + ", ����=" + title + ", ����=" + content + ", �Խ���=" + indate + ", �Խ���=" + id;
	}
}
