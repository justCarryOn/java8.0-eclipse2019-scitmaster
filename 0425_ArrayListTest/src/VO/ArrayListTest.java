package VO;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> sList = new ArrayList<>();

		sList.add("가");
		sList.add("나");
		sList.add("다");
		sList.add("라");
		System.out.println(sList.get(1)); // 하나출력
		System.out.println(sList.size()); // 개수출력
		for (String str : sList) {
			System.out.println(str); // 전체출력

			sList.remove(2); // 삭제 다
			sList.remove(2); // 삭제 라

		}
		sList.set(2, "마"); // 수정
		for (String str : sList) {
			System.out.println(str);
		}
	}

}
