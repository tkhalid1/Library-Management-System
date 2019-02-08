package com.library.management.entity;

public class Books {

	private Integer id;
	private String name;
	private String authorName;
	private Integer categoryId;

	public Integer getId() {
		return id;
	}

	public Books setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Books setName(String name) {
		this.name = name;
		return this;
	}

	public String getAuthorName() {
		return authorName;
	}

	public Books setAuthorName(String authorName) {
		this.authorName = authorName;
		return this;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public Books setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
		return this;
	}


}
