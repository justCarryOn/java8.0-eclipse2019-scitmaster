package sesoc.global.vo;

import java.io.Serializable;

public class Book implements Serializable {
	private String isbn;
	private String title;
	private String publisher;

	public Book() {
	}

	public Book(String isbn, String title, String publisher) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "번호: " + isbn + " 제목: " + title + " 출판사: " + publisher;
	}
}
