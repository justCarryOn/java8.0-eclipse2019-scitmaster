package sesoc.global.ui;

import java.util.List;
import java.util.Scanner;

import sesoc.global.service.BookStoreManager;
import sesoc.global.vo.Book;
import sesoc.global.vo.Comics;
import sesoc.global.vo.Novel;

public class BookStoreUI {
	BookStoreManager manager = null;
	Scanner scan = new Scanner(System.in);
	Scanner scanLine = new Scanner(System.in);

	public BookStoreUI() throws Exception {
		manager = new BookStoreManager();
		String select = null;

		while (true) {
			printMainMenu();
			select = scanLine.nextLine();

			switch (select) {
			case "1":
				input();
				break;
			case "2":
				searchByTitle();
				break;
			case "3":
				searchByIsbn();
				break;
			case "4":
				delete();
				break;
			case "5":
				printAll();
				break;
			case "0":
				System.out.println("��� ���� ������ �����ϰ�, ���α׷��� �����մϴ�.");
				manager.saveFile();
				System.exit(0);
			default:
				System.out.println("�߸� �����߽��ϴ�.");
				break;
			}
		}
	}

	/**
	 * �������� ���α׷��� ���� �޴��� ����Ѵ�.
	 **/
	public void printMainMenu() {
		System.out.println("====================");
		System.out.println("      ���� ���� ���� ");
		System.out.println("====================");
		System.out.println("  1. ���� ���� �Է�");
		System.out.println("  2. å �������� �˻�");
		System.out.println("  3. ISBN �˻�");
		System.out.println("  4. ���� ���� ����");
		System.out.println("  5. ��ü ���");
		System.out.println("  0. ����");
		System.out.print("     ���� > ");
	}

	/**
	 * ���� ������ �Է��Ѵ�. �Է��� ���������� ������ �� ���õ� ������ ���� ������ �Է¹޾� ����Ѵ�.
	 */
	public void input() {
		System.out.println("* ���� ���� �Է�");
		System.out.print("1. �Է��� �о� (1:�Ҽ�, 2:��ȭ) : ");
		String no = scanLine.nextLine();
		Book book = null;

		switch (no) {
		case "1":
			System.out.print("���� ISBN ��ȣ : ");
			String isbn = scanLine.nextLine();

			book = manager.searchBookByIsbn(isbn);

			if (book != null) {
				System.out.println("���� ISBN�� ���� å�� �����մϴ�.");
				break;
			}

			System.out.print("���� : ");
			String title = scanLine.nextLine();
			System.out.print("���ǻ� : ");
			String publisher = scanLine.nextLine();
			System.out.print("���� : ");
			String author = scanLine.nextLine();
			System.out.print("�帣 : ");
			String genre = scanLine.nextLine();

			Novel novel = new Novel(isbn, title, publisher, author, genre);

			manager.insertBook(novel);

			break;
		case "2":
			System.out.print("���� ISBN ��ȣ : ");
			isbn = scanLine.nextLine();

			book = manager.searchBookByIsbn(isbn);

			if (book != null) {
				System.out.println("���� ISBN�� ���� å�� �����մϴ�.");
				break;
			}

			System.out.print("���� : ");
			title = scanLine.nextLine();
			System.out.print("���ǻ� : ");
			publisher = scanLine.nextLine();
			System.out.print("�⵵ : ");
			int year = scan.nextInt();
			System.out.print("�� : ");
			int month = scan.nextInt();

			Comics comics = new Comics(isbn, title, publisher, year, month);

			manager.insertBook(comics);
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}

	/**
	 * �������� ���������� �˻��Ѵ�. �˻��� å ������ �Է¹޾� �˻� ����� ����Ѵ�. �˻������ ���� �� ������ ������ ����Ѵ�.
	 */
	void searchByTitle() {
		System.out.println("* ���� ���� �˻�");
		System.out.print("�˻��� å ���� : ");
		String title = scanLine.nextLine();
		System.out.println(manager.searchBookByTitle(title));

		/* CODE HERE */
	}

	/**
	 * ISBN�� ���������� �˻��Ѵ�. �˻��� ISBN�� �Է¹޾� �˻� ����� ����Ѵ�. �˻������ ���� �� ������ ������ ����Ѵ�.
	 */
	public void searchByIsbn() {
		System.out.println("* ���� ���� �˻�");
		System.out.print("�˻��� ���� ISBN : ");
		String isbn=scanLine.nextLine();
		System.out.println(manager.searchBookByIsbn(isbn));

		/* CODE HERE */
	}

	/**
	 * ISBN�� ���������� �˻��� �� �˻��� ������ �����Ѵ�. �˻��� ISBN�� �Է¹޾� �˻� ����� ����Ѵ�. �˻������ ���� �� ������
	 * ������ ����Ѵ�.
	 */
	public void delete() {
		System.out.println("* ���� ���� ����");
		System.out.print("������ ���� ISBN : ");
	
		String isbn = scanLine.nextLine();
		boolean flag=true;
		if(manager.searchBookByIsbn(isbn)==null) {
			System.out.println("�ش��ϴ� ������ �����ϴ�.");
			flag=false;
		}
		if(flag) {
			System.out.println("���� �����Ͻðڽ��ϱ�?");
			String choice=scanLine.nextLine();
			switch(choice) {
			case "y":
				manager.deleteBook(isbn);
				System.out.println("��������");
				break;
			case "Y":
				manager.deleteBook(isbn);
				System.out.println("��������");
				break;
			}
		}
		

		/* CODE HERE */

		/*
		 * Code Here : ������ ������ isbn�� �����ϴ��� ���� Ȯ�� ==> searchBookByIsbn() �̿�, ������ ������ ���
		 * ��¥�� ������ �� Ȯ�� �� �� Y, y�� �Էµ� ���� ���� �ش� ������ �������� ���� �� �޽��� ���
		 */

	}

	/**
	 * ��ϵ� ��� ���������� ����Ѵ�.
	 */
	public void printAll() {
		String toPrint = "";
		for (Book b : manager.getAllBookList()) {
			toPrint += b + "\n";
		}
		System.out.println(toPrint);
		/* CODE HERE */
	}
}
