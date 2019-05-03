package by.http.xml.parser.sax.entity;

public class Father implements BaseEntity{

	private String name;
	private String surName;
	private Integer age;
	private String gender;
	
	public Father() {
		super();
	}

	public Father(String name, String surName, Integer age, String gender) {
		super();
		this.name = name;
		this.surName = surName;
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
		return "Father [name=" + name + ", surName=" + surName + ", age=" + age
				+ ", gender=" + gender + "]";
	}
}
