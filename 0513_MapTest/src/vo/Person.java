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
		return "이름= " + name + ", 주민번호= " + ssn;
	}

	/*
	 * Map <String,Person> pMap=new HashMap<>(); 1. 등록하기 2. 주민번호검색 3. 전체출력 4. 주민삭제
	 * 5. 주민정보수정
	 */
}
