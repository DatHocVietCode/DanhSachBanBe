package beans;

public class BanBe {
	private int iD;
	private String name;
	private int age;
	private String phoneNum;
	private String university;
	private String address;
	
	public BanBe() {}
	
	public BanBe(int id, String name, int age, String phoneNum, String university, String address)
	{
		setAddress(address);
		setAge(age);
		setName(name);
		setiD(id);
		setPhoneNum(phoneNum);
		setUniversity(university);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}
}
