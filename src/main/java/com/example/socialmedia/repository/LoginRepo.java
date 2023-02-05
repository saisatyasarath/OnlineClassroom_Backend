package com.example.socialmedia.repository;

import java.util.List;
import java.util.Optional;

//import com.globallogic.spring.mongodb.model.Login;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.socialmedia.model.Login;

public interface LoginRepo extends MongoRepository<Login, String>{

	List<Login> findByEmail(String string);

}
