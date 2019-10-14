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
 * ���� ������ �����ϴ� Ŭ����
 */
public class BookStoreManager {
	
	private ArrayList<Book> bookList; // å �������� �����ϱ� ���� ArrayList
	private final String FILE_NAME = "book_store.dat";
	private File file;
	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	/**
	 * �⺻ ������
	 **/
	public BookStoreManager() throws Exception {
		// ���Ͽ� ����� å�� ���� ������ �о� List�� �����Ѵ�.
		if (new File(FILE_NAME).exists()) {
			getFile();
		} else {
			bookList = new ArrayList<>();
		}
	}

	/**
	 * ������ ����� ������ �����ϸ� ���Ϸκ��� �����͸� �о� ArrayList�� �����Ѵ�.
	 */
	public void getFile() throws Exception {
		file = new File(FILE_NAME);
		fis = new FileInputStream(file);
		ois = new ObjectInputStream(fis);
		bookList = (ArrayList<Book>) ois.readObject();
	}

	/**
	 * ArrayList�� ����� ��� å���� ������ ���Ͽ� �����Ѵ�.
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
	 * Book��ü�� ���޹޾� ArrayList�� �߰�
	 * 
	 * @param book
	 *            ����� Book Ŭ������ ��ü
	 * @return �߰��� �� ��� true, ������ isbn�� �־� �߰��� ���� ��� false
	 */
	public boolean insertBook(Book book) {
		boolean flag=false;
		if(searchBookByIsbn(book.getIsbn())==null) {
			bookList.add(book);
			flag=true;
		}
		/*
		 * Code here : ������ �����ϴ��� searchBookByIsbn() �̿� �̹� ������ ��� false�� ������ ArrayList��
		 * ���� �� true ����
		 */
		return flag;
	}

	/**
	 * å�� isbn ���� ���޹޾� ArrayList�� ��ϵǾ� �ִ� �����͸� ã�� �����Ѵ�.
	 * 
	 * @param å��
	 *            isbn ��ȣ
	 * @return ���������� �������� ����, true�̸� �����Ϸ�, false�̸� �����Ұ�
	 */
	public boolean deleteBook(String isbn) {
		boolean flag=false;
		for(int i=0;i<bookList.size();i++) {
			if(bookList.get(i).getIsbn().equals(isbn))
				bookList.remove(i);
				flag=true;
		}
		/*
		 * Code here : ���޹��� ISBN ������ ���� ������ ã�� �����͸� ����. ���� �Ϸ� �� true ���� ������ ���� ��� false
		 * ���� (�׻� false�� ���ϵǸ� ����)
		 */
		return flag;
	}

	/**
	 * å ������ �̿��Ͽ� ��ϵ� ���� ������ ��� å ������ �˻��Ѵ�.
	 * 
	 * @param title
	 *            �˻��� å ����
	 * @return å �������� �˻��� å ������. ������ å ������ ��� å�� �˻��Ͽ� ArrayList�� �����Ͽ� ��ȯ�Ѵ�.
	 */
	public List<Book> searchBookByTitle(String title) {
		List<Book> lb= new ArrayList<>();
		for (Book book : bookList) {
			if(book.getTitle().equals(title)) {
				lb.add(book);
			}
		}
		/*
		 * Code Here : ��� å ������ ���� �˻��ϴ°�? (���� �˻����� ���� ��� ���� )
		 */
		return lb;
	}

	/**
	 * å ���� ��ȣ(ISBN)�� å�� �˻��Ѵ�.
	 * 
	 * @param id
	 *            �˻��� å ���� ��ȣ(ISBN��)
	 * @return �˻��� å ����
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
		 * Code Here ���޵� isbn ��ȣ�� �˻��Ǵ°�? �׻� null �� ���ϵǸ� ����
		 */
	}

	/**
	 * ArrayList�� ��ϵ� ��� å ������ ��ȯ�Ѵ�.
	 * 
	 * @return ArrayList�� ��ϵ� ��� å ����
	 */
	public List<Book> getAllBookList() {
		return bookList;

		/*
		 * Code here ��� ���� ���� ��ȯ
		 */
	}
	
}
