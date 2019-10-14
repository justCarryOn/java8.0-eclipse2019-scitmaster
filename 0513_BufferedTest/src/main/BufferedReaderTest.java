package main;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("test.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String result="";
		while((result=br.readLine())!=null) {
			System.out.println(result);
		}
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		String str3 = br.readLine();
		String str4 = br.readLine();

		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4); // null
		fr.close();
	}

}
