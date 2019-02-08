package com.library.management.entity;

public class Users {

	private Integer id;
	private String name;
	private String cnic;
	private String address;
	private String mobile;


	public Integer getId() {
		return id;
	}

	public Users setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Users setName(String name) {
		this.name = name;
		return this;
	}

	public String getCnic() {
		return cnic;
	}

	public Users setCnic(String cnic) {
		this.cnic = cnic;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Users setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getMobile() {
		return mobile;
	}

	public Users setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	@Override
	public String toString() {
		return "{" +
			"\"id\":\"" + id +
			"\", \"name\":\"" + name  +
			"\", \"cnic\":\"" + cnic +
			"\", \"address\":\"" + address +
			"\", \"mobile\":\"" + mobile + '\"' +
			'}';
	}
}
