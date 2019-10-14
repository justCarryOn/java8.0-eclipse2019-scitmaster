package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		File file = new File("C:/test/object.txt");
		ArrayList<Person> pList=new ArrayList<>();
		pList.add(new Person("È«±æµ¿",21));
		pList.add(new Person("ÀÌÃ¶¼ö",26));

		if (file.exists()) {
			/*FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);	
			String str="i am your father";
			oos.writeObject(str);
			oos.close();
			System.out.println("¿Ï·á.");*/
			
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			pList=(ArrayList<Person>)ois.readObject();
			for(Person p:pList) {
				System.out.println(pList);
			}
			/*String str=(String)ois.readObject();
			System.out.println(str);*/
			
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(pList);
			oos.close();
			
			System.out.println("¿Ï·á");
		}
	}

}
