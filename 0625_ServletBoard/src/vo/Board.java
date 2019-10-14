package vo;

public class Board {

	private String boardSeq;
	private String id;
	private String title;
	private String content;
	private String indate;

	public Board(String boardSeq, String id, String title, String content, String indate) {
		this.boardSeq = boardSeq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.indate = indate;
	}

	public String getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(String boardSeq) {
		this.boardSeq = boardSeq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Board [boardSeq=" + boardSeq + ", id=" + id + ", title=" + title + ", content=" + content + ", indate="
				+ indate + "]";
	}

}
