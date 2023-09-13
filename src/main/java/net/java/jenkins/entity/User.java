package net.java.jenkins.entity;

public class User {
	
	private String name;
	private int age;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
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
	
	
	
	
	
}