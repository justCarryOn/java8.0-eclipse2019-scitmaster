package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> sMap = new HashMap<>();

		sMap.put("1", "�����"); // put: �Է�
		sMap.put("1", "������"); // ����̸� �����
		sMap.put("2", "�䳢");
		sMap.put("3", "������");
		sMap.remove("1"); // �������� ����

		System.out.println(sMap.get("1")); // get: ���
		System.out.println(sMap.get("2"));

		Set<String> keys = sMap.keySet();

		for (String a : keys) {
			System.out.println("Ű��: " + a + ", �����: " + sMap.get(a));
		}
	}

}
