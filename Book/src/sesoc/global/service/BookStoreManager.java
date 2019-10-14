package sesoc.global.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import sesoc.global.vo.Book;

/**
 * 도서 정보를 관리하는 클래스
 */
public class BookStoreManager {
	
	private ArrayList<Book> bookList; // 책 정보들을 저장하기 위한 ArrayList
	private final String FILE_NAME = "book_store.dat";
	private File file;
	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	/**
	 * 기본 생성자
	 **/
	public BookStoreManager() throws Exception {
		// 파일에 저장된 책에 대한 정보를 읽어 List에 저장한다.
		if (new File(FILE_NAME).exists()) {
			getFile();
		} else {
			bookList = new ArrayList<>();
		}
	}

	/**
	 * 기존에 저장된 파일이 존재하면 파일로부터 데이터를 읽어 ArrayList에 저장한다.
	 */
	public void getFile() throws Exception {
		file = new File(FILE_NAME);
		fis = new FileInputStream(file);
		ois = new ObjectInputStream(fis);
		bookList = (ArrayList<Book>) ois.readObject();
	}

	/**
	 * ArrayList에 저장된 모든 책관련 정보를 파일에 저장한다.
	 */
	public void saveFile() {
		file = new File(FILE_NAME);
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(bookList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Book객체를 전달받아 ArrayList에 추가
	 * 
	 * @param book
	 *            등록할 Book 클래스의 객체
	 * @return 추가가 된 경우 true, 동일한 isbn이 있어 추가를 못한 경우 false
	 */
	public boolean insertBook(Book book) {
		boolean flag=false;
		if(searchBookByIsbn(book.getIsbn())==null) {
			bookList.add(book);
			flag=true;
		}
		/*
		 * Code here : 도서가 존재하는지 searchBookByIsbn() 이용 이미 존재할 경우 false를 없으면 ArrayList에
		 * 저장 후 true 리턴
		 */
		return flag;
	}

	/**
	 * 책의 isbn 값을 전달받아 ArrayList에 등록되어 있는 데이터를 찾아 삭제한다.
	 * 
	 * @param 책의
	 *            isbn 번호
	 * @return 도서정보의 삭제여부 리턴, true이면 삭제완료, false이면 삭제불가
	 */
	public boolean deleteBook(String isbn) {
		boolean flag=false;
		for(int i=0;i<bookList.size();i++) {
			if(bookList.get(i).getIsbn().equals(isbn))
				bookList.remove(i);
				flag=true;
		}
		/*
		 * Code here : 전달받은 ISBN 값으로 도서 정보를 찾아 데이터를 삭제. 삭제 완료 후 true 리턴 삭제를 못할 경우 false
		 * 리턴 (항상 false만 리턴되면 감점)
		 */
		return flag;
	}

	/**
	 * 책 제목을 이용하여 등록된 같은 제목의 모든 책 정보를 검색한다.
	 * 
	 * @param title
	 *            검색할 책 제목
	 * @return 책 제목으로 검색된 책 정보들. 동일한 책 제목의 모든 책을 검색하여 ArrayList에 저장하여 반환한다.
	 */
	public List<Book> searchBookByTitle(String title) {
		List<Book> lb= new ArrayList<>();
		for (Book book : bookList) {
			if(book.getTitle().equals(title)) {
				lb.add(book);
			}
		}
		/*
		 * Code Here : 모든 책 정보를 전부 검색하는가? (전부 검색하지 못할 경우 감점 )
		 */
		return lb;
	}

	/**
	 * 책 구분 번호(ISBN)로 책을 검색한다.
	 * 
	 * @param id
	 *            검색할 책 구분 번호(ISBN값)
	 * @return 검색된 책 정보
	 */

	public Book searchBookByIsbn(String isbn) {
		Book b = null;
		for (Book book : bookList) {
			if(book.getIsbn().equals(isbn)) {
				b=book;
			}
		}
		return b;

		/*
		 * Code Here 전달된 isbn 번호로 검색되는가? 항상 null 이 리턴되면 감점
		 */
	}

	/**
	 * ArrayList에 등록된 모든 책 정보를 반환한다.
	 * 
	 * @return ArrayList에 등록된 모든 책 정보
	 */
	public List<Book> getAllBookList() {
		return bookList;

		/*
		 * Code here 모든 도서 정보 반환
		 */
	}
	
}
