package sesoc.global.vo;

import java.io.Serializable;

public class Novel extends Book implements Serializable {
	private String author;
	private String genre;

	public Novel() {
	}

	public Novel(String isbn, String title, String publisher, String author, String genre) {
		super(isbn, title, publisher);
		this.author = author;
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return super.toString() + " 저자:" + author + " 장르: " + genre;
	}
}
