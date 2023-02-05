package com.example.socialmedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VirtualClassroomBackendApplication {

	@Autowired
	private MongoTemplate mongoTemplate; 
	public static void main(String[] args) {
		SpringApplication.run(VirtualClassroomBackendApplication.class, args);
	}

}
