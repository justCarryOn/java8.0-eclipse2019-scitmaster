package VO;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> sList = new ArrayList<>();

		sList.add("��");
		sList.add("��");
		sList.add("��");
		sList.add("��");
		System.out.println(sList.get(1)); // �ϳ����
		System.out.println(sList.size()); // �������
		for (String str : sList) {
			System.out.println(str); // ��ü���

			sList.remove(2); // ���� ��
			sList.remove(2); // ���� ��

		}
		sList.set(2, "��"); // ����
		for (String str : sList) {
			System.out.println(str);
		}
	}

}
