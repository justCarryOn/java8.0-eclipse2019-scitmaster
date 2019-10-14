package VO;

public class DVD extends Device {

	private Movie movie;
	private String madeDate;

	public DVD(String rackNum, Movie movie, String madeDate) {
		super(rackNum);
		this.movie = movie;
		this.madeDate = madeDate;
	}

	public DVD() {
		super();
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getMadeDate() {
		return madeDate;
	}

	public void setMadeDate(String madeDate) {
		this.madeDate = madeDate;
	}

	@Override
	public String toString() {
		return super.toString() + ", 영화=" + movie + ", 제작일자=" + madeDate;
	}

}
