package com.example.MVCImplemention.repository;

import com.example.MVCImplemention.model.User;

public interface UserRepository {
	
	public User validate(String username, String password);

}
