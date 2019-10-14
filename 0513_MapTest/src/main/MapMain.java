package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> sMap = new HashMap<>();

		sMap.put("1", "고양이"); // put: 입력
		sMap.put("1", "강아지"); // 고양이를 덮어씌움
		sMap.put("2", "토끼");
		sMap.put("3", "강아지");
		sMap.remove("1"); // 강아지를 지움

		System.out.println(sMap.get("1")); // get: 출력
		System.out.println(sMap.get("2"));

		Set<String> keys = sMap.keySet();

		for (String a : keys) {
			System.out.println("키값: " + a + ", 밸류값: " + sMap.get(a));
		}
	}

}
