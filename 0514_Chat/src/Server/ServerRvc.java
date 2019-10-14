package Server;

import java.io.DataInputStream;
import java.io.IOException;

public class ServerRvc extends Thread {

	private DataInputStream dis;

	public ServerRvc(DataInputStream dis) {
		this.dis = dis;
	}
	@Override
	public void run() {

		while (true) {
			try {
				String message = dis.readUTF();
				System.out.println("Client : " + message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
