package main;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriterTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileWriter fw = new FileWriter("test.txt");
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write("test\r\ntest\r\ntesttest"); // \r\n: 줄바꾸기

		bw.flush(); // 끝맺음

		bw.close(); // flush와 같은 효과지만 다시 사용할 수 없다
		
		System.out.println("complete");
	}

}
