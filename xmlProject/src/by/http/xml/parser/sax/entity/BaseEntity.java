package by.http.xml.parser.sax.entity;

public interface BaseEntity {

	String getName();
	String getSurName();
	Integer getAge();
	String getGender();
	
	void setName(String surName);
	void setSurName(String name);
	void setAge(String age);
	void setGender(String gender);
}
