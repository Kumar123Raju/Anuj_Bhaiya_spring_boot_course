package com.example.RestClient.RestClient;

import com.example.RestClient.RestClient.Model.User;
import com.example.RestClient.RestClient.Services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestClientApplicationTests {

	@Autowired
	private JwtService jwtService;
	@Test
	void contextLoads() {
//		User user=new User(4L,"rjrajujames@gmail.com","1234");
		User user=new User(4L,"raju@gmail.com","1234");
		String token=jwtService.generateToken(user);
		System.out.println(token);
		Long id= jwtService.getUserIdFromToken(token);
		System.out.println(id);
	}

}
