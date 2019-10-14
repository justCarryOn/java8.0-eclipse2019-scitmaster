package VO;

public class Movie {

	private String title;
	private String playTime;
	private String genre;
	private int price;

	public Movie(String title, String playTime, String genre, int price) {
		super();
		this.title = title;
		this.playTime = playTime;
		this.genre = genre;
		this.price = price;
	}

	public Movie() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "제목=" + title + ", 시간=" + playTime + ", 장르=" + genre + ", 가격=" + price;
	}

}
