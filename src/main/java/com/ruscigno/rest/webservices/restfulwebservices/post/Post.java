package com.ruscigno.rest.webservices.restfulwebservices.post;

import java.util.Date;

public class Post {

	private Integer id;
	private String body;
	private Date postDate;

	public Post(Integer id, String body, Date postDate) {
		super();
		this.id = id;
		this.body = body;
		this.postDate = postDate;
	}

	@Override
	public String toString() {
		return "Posts [id=" + id + ", body=" + body + ", postDate=" + postDate + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
}
