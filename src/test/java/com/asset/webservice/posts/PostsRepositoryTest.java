package com.asset.webservice.posts;



import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository repository;
	LocalDateTime now = LocalDateTime.now();
	@After
	public void cleanup() {
		
		repository.deleteAll();
	}
	
	@Test
	public void Save() {
		
		repository.save(Posts.builder()
				.title("테스트 게시글")
				.author("ghkt741@qoo10.com")
				.content("테스트 본문").build());
		
		List<Posts> postsList = repository.findAll();
		
		Posts posts = postsList.get(0);
		assertTrue(posts.getCreateDate().isAfter(now));
		assertTrue(posts.getModifiedDate().isAfter(now));
		
	
	}
}
