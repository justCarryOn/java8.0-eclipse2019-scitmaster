package VO;

public class Board {
	private String seq, title, content, indate, id;

	public Board() {
		super();
	}

	public Board(String seq, String title, String content, String indate, String id) {
		super();
		this.seq = seq; // 일련번호
		this.title = title; // 제목
		this.content = content; // 내용
		this.indate = indate; // 게시일
		this.id = id; // 게시자
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
		return "번호=" + seq + ", 제목=" + title + ", 내용=" + content + ", 게시일=" + indate + ", 게시자=" + id;
	}
}
