package com.example.MVCImplemention.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MVCImplemention.form.LoginForm;
import com.example.MVCImplemention.repository.LoginRepository;

@Controller
public class LoginController {
	
	@Autowired
	LoginRepository loginRepository;
	
	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public String show()
	{
		return loginRepository.displayLogin();
	}
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String login(@ModelAttribute(name = "loginForm") LoginForm login , Model model) {
		return loginRepository.getCredential( login, model);
	}

}
