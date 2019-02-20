package com.ruscigno.rest.webservices.restfulwebservices.user;

import java.util.Date;

public class User {

	private Integer id;

	public User(Integer id, String name, Date bithDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = bithDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", bithDate=" + birthDate + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBithDate() {
		return birthDate;
	}

	public void setBithDate(Date bithDate) {
		this.birthDate = bithDate;
	}

	private String name;
	private Date birthDate;

}
