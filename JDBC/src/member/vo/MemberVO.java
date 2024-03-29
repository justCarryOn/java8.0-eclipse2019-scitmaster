package member.vo;

public class MemberVO {
	private String id;
	private String password;
	private String name;
	private int age;

	public MemberVO() {
		super();
	}

	public MemberVO(String id, String password, String name, int age) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("ID:%s, Password:%s, Name:%s, Age:%d%n", id, password, name, age);
	}

}
