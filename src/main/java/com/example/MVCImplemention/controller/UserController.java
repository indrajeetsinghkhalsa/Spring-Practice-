package com.example.MVCImplemention.controller;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.MVCImplemention.model.User;
import com.example.MVCImplemention.repository.UserRepository;


@Repository
public class UserController implements UserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public User validate(String username,String Password) {
		String sql = "select username,password from user where username= ? and password=?";
		// TODO Auto-generated method stub
		try {
			
		User userData = (User) jdbcTemplate.queryForObject(
				sql,
				new Object[] {username,Password},
				new int[] {Types.VARCHAR , Types.VARCHAR},
				new BeanPropertyRowMapper(User.class));
		return userData;
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
