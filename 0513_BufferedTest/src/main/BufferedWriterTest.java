package main;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriterTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileWriter fw = new FileWriter("test.txt");
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write("test\r\ntest\r\ntesttest"); // \r\n: �ٹٲٱ�

		bw.flush(); // ������

		bw.close(); // flush�� ���� ȿ������ �ٽ� ����� �� ����
		
		System.out.println("complete");
	}

}
