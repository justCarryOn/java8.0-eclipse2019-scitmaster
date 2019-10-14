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
					System.out.println("�Խñ� ��ϿϷ�");
				} else {
					System.out.println("�̹� ���� �Ϸù�ȣ�� ��ϵ� �Խñ��� �ֽ��ϴ�");
				}
				break;
			case 2:
				ImageBoard ib = insertImage();
				String seq2 = ib.getSeq();
				if (bs.insert(ib, seq2)) {
					System.out.println("�Խñ� ��ϿϷ�");
				} else {
					System.out.println("�̹� ���� �Ϸù�ȣ�� ��ϵ� �Խñ��� �ֽ��ϴ�");
				}
				break;
			case 3:
				FileBoard fb = insertFile();
				String seq3 = fb.getSeq();
				if (bs.insert(fb, seq3)) {
					System.out.println("�Խñ� ��ϿϷ�");
				} else {
					System.out.println("�̹� ���� �Ϸù�ȣ�� ��ϵ� �Խñ��� �ֽ��ϴ�");
				}
				break;
			case 4:
				System.out.println(bs.print());
				break;
			case 5:
				System.out.println("�Ϸù�ȣ: ");
				seq = sc.next();
				System.out.println(bs.searchSeq(seq));
				break;
			case 6:
				System.out.println("����: ");
				title = sc.next();
				System.out.println(bs.searchTitle(title));
				break;
			case 7:
				System.out.println("�̹������: ");
				imgUrl = sc.next();
				System.out.println(bs.searchImgUrl(imgUrl));
				break;
			case 8:
				System.out.println("�����̸�: ");
				fileName = sc.next();
				System.out.println(bs.searchFileName(fileName));
				break;
			case 9:
				System.out.println("�Ϸù�ȣ: ");
				seq = sc.next();
				if (bs.remove(seq)) {
					System.out.println("�Խñ� �����Ϸ�");
				} else {
					System.out.println("�ش��ϴ� �Խñ��� �����ϴ�");
				}
				break;
			case 10:
				modifyMenu();
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					Board b1 = insertBoard();
					if (bs.rewriteBoard(seq,b1)) {
						System.out.println("�Խñ� �����Ϸ�");
					} else {
						System.out.println("�ش��ϴ� �Խñ��� �����ϴ�");
					}
					break;
				case 2:
					ImageBoard ib1 = insertImage();
					if (bs.rewriteImageBoard(seq,ib1)) {
						System.out.println("�Խñ� �����Ϸ�");
					} else {
						System.out.println("�ش��ϴ� �Խñ��� �����ϴ�");
					}
					break;
				case 3:
					FileBoard fb1 = insertFile();
					seq = sc.next();
					System.out.println("�Խñ� �����Ϸ�");
					if (bs.rewriteFileBoard(seq,fb1)) {
						System.out.println("�Խñ� �����Ϸ�");
					} else {
						System.out.println("�ش��ϴ� �Խñ��� �����ϴ�");
					}
					break;
				default:
					System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�");
				}
				break;
			case 11:
				System.out.println("���α׷��� �����մϴ�");
				flag = false;
				break;
			default:
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�");
			}
		}

	}

	public void menu() {
		System.out.println("1.�ϹݰԽñ۵��");
		System.out.println("2.�̹����Խñ۵��");
		System.out.println("3.���ϰԽñ۵��");
		System.out.println("4.�Խñ���ü���");
		System.out.println("5.�Ϸù�ȣ�˻�");
		System.out.println("6.����˻�");
		System.out.println("7.�̹�����ΰ˻�");
		System.out.println("8.���ϸ�˻�");
		System.out.println("9.�Խñۻ���");
		System.out.println("10.�Խñۼ���");
		System.out.println("11.���α׷�����");
	}

	public Board insertBoard() {
		System.out.println("�Ϸù�ȣ: ");
		seq = sc.next();
		System.out.println("����: ");
		title = sc.next();
		System.out.println("����: ");
		content = sc.next();
		System.out.println("�Խ���: ");
		indate = sc.next();
		System.out.println("�Խ���: ");
		id = sc.next();
		Board b = new Board(seq, title, content, indate, id);
		return b;
	}

	public ImageBoard insertImage() {
		seqList = new ArrayList<String>();
		System.out.println("�Ϸù�ȣ: ");
		seq = sc.next();
		System.out.println("����: ");
		title = sc.next();
		System.out.println("����: ");
		content = sc.next();
		System.out.println("�Խ���: ");
		indate = sc.next();
		System.out.println("�Խ���: ");
		id = sc.next();
		System.out.println("�̹�������: ");
		imgNum = sc.nextInt();
		for (int i = 0; i < imgNum; i++) {
			System.out.println("�̹������: ");
			imgUrl = sc.next();
			seqList.add(imgUrl);
		}
		ImageBoard ib = new ImageBoard(seq, title, content, indate, id, seqList);
		return ib;
	}

	public FileBoard insertFile() {
		seqList = new ArrayList<String>();
		System.out.println("�Ϸù�ȣ: ");
		seq = sc.next();
		System.out.println("����: ");
		title = sc.next();
		System.out.println("����: ");
		content = sc.next();
		System.out.println("�Խ���: ");
		indate = sc.next();
		System.out.println("�Խ���: ");
		id = sc.next();
		System.out.println("���ϼ���: ");
		fileNum = sc.nextInt();
		for (int i = 0; i < fileNum; i++) {
			System.out.println("�̹������: ");
			fileName = sc.next();
			seqList.add(fileName);
		}
		FileBoard fb = new FileBoard(seq, title, content, indate, id, seqList);
		return fb;
	}

	public void modifyMenu() {
		System.out.println("1.�ϹݰԽñۼ���");
		System.out.println("2.�̹����Խñۼ���");
		System.out.println("3.���ϰԽñۼ���");
	}
}
