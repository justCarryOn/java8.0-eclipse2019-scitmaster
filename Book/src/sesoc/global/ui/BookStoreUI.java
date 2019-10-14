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
				System.out.println("모든 도서 정보를 저장하고, 프로그램을 종료합니다.");
				manager.saveFile();
				System.exit(0);
			default:
				System.out.println("잘못 선택했습니다.");
				break;
			}
		}
	}

	/**
	 * 도서관리 프로그램의 메인 메뉴를 출력한다.
	 **/
	public void printMainMenu() {
		System.out.println("====================");
		System.out.println("      도서 정보 관리 ");
		System.out.println("====================");
		System.out.println("  1. 도서 정보 입력");
		System.out.println("  2. 책 제목으로 검색");
		System.out.println("  3. ISBN 검색");
		System.out.println("  4. 도서 정보 삭제");
		System.out.println("  5. 전체 출력");
		System.out.println("  0. 종료");
		System.out.print("     선택 > ");
	}

	/**
	 * 도서 정보를 입력한다. 입력할 도서정보를 선택한 후 선택된 도서에 따른 정보를 입력받아 등록한다.
	 */
	public void input() {
		System.out.println("* 도서 정보 입력");
		System.out.print("1. 입력할 분야 (1:소설, 2:만화) : ");
		String no = scanLine.nextLine();
		Book book = null;

		switch (no) {
		case "1":
			System.out.print("도서 ISBN 번호 : ");
			String isbn = scanLine.nextLine();

			book = manager.searchBookByIsbn(isbn);

			if (book != null) {
				System.out.println("같은 ISBN을 가진 책이 존재합니다.");
				break;
			}

			System.out.print("제목 : ");
			String title = scanLine.nextLine();
			System.out.print("출판사 : ");
			String publisher = scanLine.nextLine();
			System.out.print("저자 : ");
			String author = scanLine.nextLine();
			System.out.print("장르 : ");
			String genre = scanLine.nextLine();

			Novel novel = new Novel(isbn, title, publisher, author, genre);

			manager.insertBook(novel);

			break;
		case "2":
			System.out.print("도서 ISBN 번호 : ");
			isbn = scanLine.nextLine();

			book = manager.searchBookByIsbn(isbn);

			if (book != null) {
				System.out.println("같은 ISBN을 가진 책이 존재합니다.");
				break;
			}

			System.out.print("제목 : ");
			title = scanLine.nextLine();
			System.out.print("출판사 : ");
			publisher = scanLine.nextLine();
			System.out.print("년도 : ");
			int year = scan.nextInt();
			System.out.print("월 : ");
			int month = scan.nextInt();

			Comics comics = new Comics(isbn, title, publisher, year, month);

			manager.insertBook(comics);
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
		}
	}

	/**
	 * 제목으로 도서정보를 검색한다. 검색할 책 제목을 입력받아 검색 결과를 출력한다. 검색결과가 없을 시 적절한 문구를 출력한다.
	 */
	void searchByTitle() {
		System.out.println("* 도서 정보 검색");
		System.out.print("검색할 책 제목 : ");
		String title = scanLine.nextLine();
		System.out.println(manager.searchBookByTitle(title));

		/* CODE HERE */
	}

	/**
	 * ISBN로 도서정보를 검색한다. 검색할 ISBN를 입력받아 검색 결과를 출력한다. 검색결과가 없을 시 적절한 문구를 출력한다.
	 */
	public void searchByIsbn() {
		System.out.println("* 도서 정보 검색");
		System.out.print("검색할 도서 ISBN : ");
		String isbn=scanLine.nextLine();
		System.out.println(manager.searchBookByIsbn(isbn));

		/* CODE HERE */
	}

	/**
	 * ISBN로 도서정보를 검색한 후 검색된 도서를 삭제한다. 검색할 ISBN를 입력받아 검색 결과를 출력한다. 검색결과가 없을 시 적절한
	 * 문구를 출력한다.
	 */
	public void delete() {
		System.out.println("* 도서 정보 삭제");
		System.out.print("삭제할 도서 ISBN : ");
	
		String isbn = scanLine.nextLine();
		boolean flag=true;
		if(manager.searchBookByIsbn(isbn)==null) {
			System.out.println("해당하는 도서가 없습니다.");
			flag=false;
		}
		if(flag) {
			System.out.println("정말 삭제하시겠습니까?");
			String choice=scanLine.nextLine();
			switch(choice) {
			case "y":
				manager.deleteBook(isbn);
				System.out.println("삭제성공");
				break;
			case "Y":
				manager.deleteBook(isbn);
				System.out.println("삭제성공");
				break;
			}
		}
		

		/* CODE HERE */

		/*
		 * Code Here : 삭제할 도서의 isbn이 존재하는지 여부 확인 ==> searchBookByIsbn() 이용, 도서가 존재할 경우
		 * 진짜로 삭제할 지 확인 한 후 Y, y가 입력될 때만 삭제 해당 도서가 존재하지 않을 때 메시지 출력
		 */

	}

	/**
	 * 등록된 모든 도서정보를 출력한다.
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
