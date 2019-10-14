package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			ServerSocket ss = new ServerSocket(8989);

			System.out.println("접속 대기 .....");

			Socket soc = ss.accept();

			System.out.println("접속 성공");

			DataInputStream dis = new DataInputStream(soc.getInputStream());
			DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
			Scanner sc = new Scanner(System.in);

			ServerRvc rvc=new ServerRvc(dis);
			rvc.start();
			
			
			while (true) {
				System.out.println("내용 입력 : ");
				dos.writeUTF(sc.nextLine());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
