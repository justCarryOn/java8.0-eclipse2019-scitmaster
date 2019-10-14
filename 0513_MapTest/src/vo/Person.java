package vo;

public class Person {
	private String name;
	private String ssn;

	public Person(String name, String ssn) {
		super();
		this.name = name;
		this.ssn = ssn;
	}

	public Person() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "�̸�= " + name + ", �ֹι�ȣ= " + ssn;
	}

	/*
	 * Map <String,Person> pMap=new HashMap<>(); 1. ����ϱ� 2. �ֹι�ȣ�˻� 3. ��ü��� 4. �ֹλ���
	 * 5. �ֹ���������
	 */
}
