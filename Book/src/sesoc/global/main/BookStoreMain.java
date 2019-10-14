package sesoc.global.main;

import sesoc.global.ui.BookStoreUI;

public class BookStoreMain {
	public static void main(String[] args) {
		try {
			new BookStoreUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
