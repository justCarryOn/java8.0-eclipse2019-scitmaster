package Manager;

import VO.Client;

public class ClientManager {

	private Client [] cArray=new Client[10000];
	private int cnt=0;
	
	public void insertClient(Client cli) {
		cArray[cnt++]=cli;
	}
	public void printAll() {
		for(int i=0;i<cnt;i++) {
			cArray[i].print();
		}
	}
	
}




