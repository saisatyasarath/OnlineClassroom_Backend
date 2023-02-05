package com.example.socialmedia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "testFirst")
public class Login {
	
	@Id 
	private int id;
    private String name;
    private String userid;
    private String email;
    private String password;
}
