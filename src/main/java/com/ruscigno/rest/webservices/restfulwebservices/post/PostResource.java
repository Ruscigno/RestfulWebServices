package com.ruscigno.rest.webservices.restfulwebservices.post;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class PostResource {
	
	@Autowired
	private PostDaoService service;
	
	@GetMapping("/posts")
	public List<Post> getAllPosts() {
		return service.findAll();
	}
	
	@GetMapping("/posts/{id}")
	public Post getOnePosts(@PathVariable Integer id) {
		return service.findOne(id);
	}
	
	@PostMapping("/posts")
	public ResponseEntity<Object> createPost(@RequestBody Post post) {
		Post savedPost = service.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}

}
