package by.http.xml.parser.sax.entity;

public class Mother implements BaseEntity{

	private String name;
	private String surName;
	private String maidenName;
	private Integer age;
	private String gender;

	public Mother() {
		super();
	}
	
	public Mother(String name, String surName, String maidenName, int age,
			String gender) {
		super();
		this.name = name;
		this.surName = surName;
		this.maidenName = maidenName;
		this.age = age;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurName() {
		return surName;
	}
	
	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	public String getMaidenName() {
		return maidenName;
	}
	
	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = Integer.parseInt(age);
	}	
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Mother [name=" + name + ", surName=" + surName
				+ ", maidenName=" + maidenName + ", age=" + age + ", gender="
				+ gender + "]";
	}
}
