package com.example.MVCImplemention.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.example.MVCImplemention.form.LoginForm;
import com.example.MVCImplemention.model.User;
import com.example.MVCImplemention.repository.LoginRepository;
import com.example.MVCImplemention.repository.UserRepository;

@Component
public class LoginDao implements LoginRepository {
//	@Autowired
//	private User user;
	@Autowired
	private UserRepository userRepository;
	@Override
	public String displayLogin() {
		// TODO Auto-generated method stub
		return "Login";
	}

	@Override
	public String getCredential(LoginForm loginForm,Model model) {
		// TODO Auto-generated method stub
		
		String name = loginForm.getUsername();
		String password = loginForm.getPassword();
		if(!name.isEmpty())
		{
			if(!password.isEmpty())
			{
				User user = userRepository.validate(name, password);
				if(user==null)
				{
					model.addAttribute("InvalidUser",true);
					return "login";
				}
				else
				{
					if(name.equals(user.getUsername()) && password.equals(user.getPassword()))
					{
						//returning to the page where we want
						model.addAttribute("dashboard",true);
						return "redirect:/dashboard";
					}
					else
					{
						//returning to the page where we want
						model.addAttribute("credential",true);
						return "login";		
					}
				}
				
			}
			else
			{
				model.addAttribute("password",true);
				return "login";
			}
		}
		else {
			
			model.addAttribute("username",true);
			return "login";
		}		
	}

}
