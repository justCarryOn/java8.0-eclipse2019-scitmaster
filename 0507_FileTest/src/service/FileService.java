package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileService {
	private FileInputStream fis;
	private FileOutputStream fos;
	private InputStreamReader isr;
	private OutputStreamWriter osw;
	private String total;

	public void writeString(String str) {// 글쓰기
		try {
			total = "";
			fos = new FileOutputStream("C:/test/text.txt");
			osw = new OutputStreamWriter(fos, "MS949");
			osw.write(str);
			osw.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		total=str;
	}

	public String readString() {// 글읽기
		try {
			fis = new FileInputStream("C:/test/text.txt");
			isr = new InputStreamReader(fis, "MS949");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str = "";
		int a = 0;

		while (a != -1) {
			try {
				a = isr.read();
				if (a != -1)
					str += (char) a;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return str;
			}
		}
		return str;
	}

	public void rewriteString(String str) {
		try {
			fos = new FileOutputStream("C:/test/text.txt");
			osw = new OutputStreamWriter(fos, "MS949");
			String plus;
			plus = total+str;
			osw.write(plus);
			osw.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void closeStream() {// Stream 닫기

		if (isr != null && osw != null) {
			try {
				isr.close();
				osw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
