package main;

import java.util.HashSet;
import java.util.Set;

public class SetMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> sSet = new HashSet<>();
		sSet.add("가");
		sSet.add("나");
		sSet.add("다");
		sSet.add("라");

		for (String value : sSet) {
			System.out.println(value);
		}
	}

}
