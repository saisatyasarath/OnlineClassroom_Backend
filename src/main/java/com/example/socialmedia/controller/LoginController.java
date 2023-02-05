package com.example.socialmedia.controller;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.socialmedia.model.Login;
import com.example.socialmedia.repository.LoginRepo;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	
	@Autowired
    private LoginRepo repo;
	
	@RequestMapping(value = "/aunthenticate", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:3000")
    public Map<String, Boolean> getBooks(@RequestParam String email,@RequestParam String password) {
		
        
        List<Login> res =  repo.findByEmail(email);
        
        //List<Login> l = (List<Login>) res.stream();
        
        Login l1 = res.get(0);
        
        
        
        //System.out.println(l1.getPassword());
        
        String orgPass = l1.getPassword();
        
        System.out.println(password);
        System.out.println(orgPass);
        
        System.out.println(password.equals(orgPass));
        
        if(password!=null && password.equals(orgPass)) {
        	return Collections.singletonMap("response", true);
        }
                            
        return Collections.singletonMap("response", false);
    }
	
	@RequestMapping(value = "/insertUsers", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:3000")
    public Map<String, String> insertUsers(@RequestBody Map<String, Object> payload) {
		
		if(!payload.containsKey("email")||!payload.containsKey("password")||!payload.containsKey("userid")) {
			 Collections.singletonMap("response", "required details not present");
		}
		
		String email = (String) payload.get("email");
		String password = (String) payload.get("password");
		String userid = (String) payload.get("userid");
		String role = (String) payload.get("role");
		
		System.out.println("Inser Users "+email);
        
        List<Login> res =  repo.findByEmail(email);
        
        if(res.size()>0) {
        	return Collections.singletonMap("response", "email already exists, please enter details again");
        }
        
        res = repo.findByUserid(userid);
        
        if(res.size()>0) {
        	System.out.println("Hii");
        	return Collections.singletonMap("response", "userid already exists, please enter details again");
        }
        
        MongoClient mongo = MongoClients.create();
        //Connecting to the database
        MongoDatabase database = mongo.getDatabase("test");
        
        Document document = new Document();
        document.append("email", email);
        document.append("password", password);
        document.append("userid", userid);
        document.append("role", role);
        
        database.getCollection("testFirst").insertOne(document);
        
        
        
        
        return Collections.singletonMap("response", "Signup success");
        
        
    }
	
	@GetMapping("/testing")
	public Map<String, String> testing() {
		System.out.println("testing api called");
		return Collections.singletonMap("response", "your string value");
	}

}
