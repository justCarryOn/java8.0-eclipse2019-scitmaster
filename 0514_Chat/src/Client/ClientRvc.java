package Client;

import java.io.DataInputStream;
import java.io.IOException;

public class ClientRvc extends Thread {

	private DataInputStream dis;

	public ClientRvc(DataInputStream dis) {
		this.dis = dis;
	}

	@Override
	public void run() {

		while (true) {
			try {
				String message = dis.readUTF();
				System.out.println("Server : " + message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
