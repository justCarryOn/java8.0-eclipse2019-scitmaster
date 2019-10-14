package UI;

import java.util.ArrayList;
import java.util.Scanner;

import Service.BoardService;
import VO.Board;
import VO.ImageBoard;
import VO.FileBoard;

public class BoardUI {
	private Scanner sc = new Scanner(System.in);
	private BoardService bs = new BoardService();
	private ArrayList<String> seqList = new ArrayList<String>();
	private String seq, title, content, indate, id, imgUrl, fileName;
	private int choice, imgNum, fileNum;
	boolean flag = true;

	public BoardUI() {
		while (flag) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				Board b = insertBoard();
				String seq1 = b.getSeq();
				if (bs.insert(b, seq1)) {
					System.out.println("게시글 등록완료");
				} else {
					System.out.println("이미 같은 일련번호로 등록된 게시글이 있습니다");
				}
				break;
			case 2:
				ImageBoard ib = insertImage();
				String seq2 = ib.getSeq();
				if (bs.insert(ib, seq2)) {
					System.out.println("게시글 등록완료");
				} else {
					System.out.println("이미 같은 일련번호로 등록된 게시글이 있습니다");
				}
				break;
			case 3:
				FileBoard fb = insertFile();
				String seq3 = fb.getSeq();
				if (bs.insert(fb, seq3)) {
					System.out.println("게시글 등록완료");
				} else {
					System.out.println("이미 같은 일련번호로 등록된 게시글이 있습니다");
				}
				break;
			case 4:
				System.out.println(bs.print());
				break;
			case 5:
				System.out.println("일련번호: ");
				seq = sc.next();
				System.out.println(bs.searchSeq(seq));
				break;
			case 6:
				System.out.println("제목: ");
				title = sc.next();
				System.out.println(bs.searchTitle(title));
				break;
			case 7:
				System.out.println("이미지경로: ");
				imgUrl = sc.next();
				System.out.println(bs.searchImgUrl(imgUrl));
				break;
			case 8:
				System.out.println("파일이름: ");
				fileName = sc.next();
				System.out.println(bs.searchFileName(fileName));
				break;
			case 9:
				System.out.println("일련번호: ");
				seq = sc.next();
				if (bs.remove(seq)) {
					System.out.println("게시글 삭제완료");
				} else {
					System.out.println("해당하는 게시글이 없습니다");
				}
				break;
			case 10:
				modifyMenu();
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					Board b1 = insertBoard();
					if (bs.rewriteBoard(seq,b1)) {
						System.out.println("게시글 수정완료");
					} else {
						System.out.println("해당하는 게시글이 없습니다");
					}
					break;
				case 2:
					ImageBoard ib1 = insertImage();
					if (bs.rewriteImageBoard(seq,ib1)) {
						System.out.println("게시글 수정완료");
					} else {
						System.out.println("해당하는 게시글이 없습니다");
					}
					break;
				case 3:
					FileBoard fb1 = insertFile();
					seq = sc.next();
					System.out.println("게시글 수정완료");
					if (bs.rewriteFileBoard(seq,fb1)) {
						System.out.println("게시글 수정완료");
					} else {
						System.out.println("해당하는 게시글이 없습니다");
					}
					break;
				default:
					System.out.println("번호를 잘못 입력하셨습니다");
				}
				break;
			case 11:
				System.out.println("프로그램을 종료합니다");
				flag = false;
				break;
			default:
				System.out.println("번호를 잘못 입력하셨습니다");
			}
		}

	}

	public void menu() {
		System.out.println("1.일반게시글등록");
		System.out.println("2.이미지게시글등록");
		System.out.println("3.파일게시글등록");
		System.out.println("4.게시글전체출력");
		System.out.println("5.일련번호검색");
		System.out.println("6.제목검색");
		System.out.println("7.이미지경로검색");
		System.out.println("8.파일명검색");
		System.out.println("9.게시글삭제");
		System.out.println("10.게시글수정");
		System.out.println("11.프로그램종료");
	}

	public Board insertBoard() {
		System.out.println("일련번호: ");
		seq = sc.next();
		System.out.println("제목: ");
		title = sc.next();
		System.out.println("내용: ");
		content = sc.next();
		System.out.println("게시일: ");
		indate = sc.next();
		System.out.println("게시자: ");
		id = sc.next();
		Board b = new Board(seq, title, content, indate, id);
		return b;
	}

	public ImageBoard insertImage() {
		seqList = new ArrayList<String>();
		System.out.println("일련번호: ");
		seq = sc.next();
		System.out.println("제목: ");
		title = sc.next();
		System.out.println("내용: ");
		content = sc.next();
		System.out.println("게시일: ");
		indate = sc.next();
		System.out.println("게시자: ");
		id = sc.next();
		System.out.println("이미지수량: ");
		imgNum = sc.nextInt();
		for (int i = 0; i < imgNum; i++) {
			System.out.println("이미지경로: ");
			imgUrl = sc.next();
			seqList.add(imgUrl);
		}
		ImageBoard ib = new ImageBoard(seq, title, content, indate, id, seqList);
		return ib;
	}

	public FileBoard insertFile() {
		seqList = new ArrayList<String>();
		System.out.println("일련번호: ");
		seq = sc.next();
		System.out.println("제목: ");
		title = sc.next();
		System.out.println("내용: ");
		content = sc.next();
		System.out.println("게시일: ");
		indate = sc.next();
		System.out.println("게시자: ");
		id = sc.next();
		System.out.println("파일수량: ");
		fileNum = sc.nextInt();
		for (int i = 0; i < fileNum; i++) {
			System.out.println("이미지경로: ");
			fileName = sc.next();
			seqList.add(fileName);
		}
		FileBoard fb = new FileBoard(seq, title, content, indate, id, seqList);
		return fb;
	}

	public void modifyMenu() {
		System.out.println("1.일반게시글수정");
		System.out.println("2.이미지게시글수정");
		System.out.println("3.파일게시글수정");
	}
}
