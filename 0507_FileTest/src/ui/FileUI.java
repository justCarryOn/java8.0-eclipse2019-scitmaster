package ui;

import java.util.Scanner;

import service.FileService;

public class FileUI {
	private Scanner sc = new Scanner(System.in);
	private Scanner scLine=new Scanner(System.in);
	private int choice;
	private String content; 
	private boolean flag = true;
	private FileService fs=new FileService();

	public FileUI() {
		while(flag) {
			menu();
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("����: ");
				content=scLine.nextLine();
				fs.writeString(content);
				break;
			case 2:
				System.out.println("����: ");
				System.out.println(fs.readString());
				break;
			case 3:
				System.out.println("����: ");
				content=scLine.nextLine();
				fs.writeString(content);
			case 4:
				fs.closeStream();
				flag = false;
				break;
			}
		}
	}

	public void menu() {
		System.out.println("1.�۾���");
		System.out.println("2.���б�");
		System.out.println("3.�̾��");
		System.out.println("4.����");
	}
}
