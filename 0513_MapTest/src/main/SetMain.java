package main;

import java.util.HashSet;
import java.util.Set;

public class SetMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> sSet = new HashSet<>();
		sSet.add("��");
		sSet.add("��");
		sSet.add("��");
		sSet.add("��");

		for (String value : sSet) {
			System.out.println(value);
		}
	}

}
