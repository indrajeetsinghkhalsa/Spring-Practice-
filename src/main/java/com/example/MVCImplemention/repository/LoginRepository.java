package com.example.MVCImplemention.repository;

import org.springframework.ui.Model;

import com.example.MVCImplemention.form.LoginForm;

public interface LoginRepository {
	
	public String displayLogin();
	public String getCredential(LoginForm loginForm, Model model);

}
