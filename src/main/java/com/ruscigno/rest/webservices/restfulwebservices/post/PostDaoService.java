package com.ruscigno.rest.webservices.restfulwebservices.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PostDaoService {

	private static List<Post> posts = new ArrayList<>();
	private static int postCount = 0;
	
	public List<Post> findAll() {
		return posts;
	}
	
	public Post findOne(int id) {
		return posts.stream().filter(post -> post.getId() == id).findFirst().orElse(null);
	}
	
	public Post save(Post post) {
		if (post.getId() == null) {
			post.setId(++postCount);
		}
		posts.add(post);
		return post;
	}
	
	
}
