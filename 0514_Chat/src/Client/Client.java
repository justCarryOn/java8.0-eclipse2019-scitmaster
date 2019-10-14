package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		try {

			Socket soc = new Socket("localhost", 8989);

			System.out.println("접속성공");

			DataInputStream dis = new DataInputStream(soc.getInputStream());
			DataOutputStream dos = new DataOutputStream(soc.getOutputStream());

			Scanner sc = new Scanner(System.in);

			ClientRvc crcv = new ClientRvc(dis);
			crcv.start();

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
