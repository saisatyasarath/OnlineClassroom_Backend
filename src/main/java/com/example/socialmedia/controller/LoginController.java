package com.example.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.socialmedia.model.Login;
import com.example.socialmedia.repository.LoginRepo;

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
	
	@GetMapping("/testing")
	public Map<String, String> testing() {
		System.out.println("testing api called");
		return Collections.singletonMap("response", "your string value");
	}

}
