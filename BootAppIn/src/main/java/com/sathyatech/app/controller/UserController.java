package com.sathyatech.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathyatech.app.config.EmailConfig;
import com.sathyatech.app.model.Role;
import com.sathyatech.app.model.User;
import com.sathyatech.app.repo.RoleRepository;
import com.sathyatech.app.service.IUserService;
import com.sathyatech.app.validator.UserValidator;

@Controller
public class UserController {
	
	
	@Autowired
	private EmailConfig email;
	
	@Autowired
	private IUserService userService;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserValidator validator;

	@GetMapping(value={"/","/login"})
	public String showLogin(){
		
		return "Login";
	}

	@GetMapping("/register")
	public String showRegister(ModelMap map){
		map.addAttribute("user", new User());
		return "Register";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user,@RequestParam(value="rolesData",required=false)List<String> data,Errors errors,ModelMap map){
		System.out.println(data+"***********************");
		validator.validate(user, errors);
		if(!errors.hasErrors()){
		
		User u=userService.findUserByEmail(user.getUserEmail());
		if(u!=null && u.getUserId()!=0){
			map.addAttribute("message", "User email already exist...");
		}
		else if(data!=null && data.size()>0){
			for(String roleName:data){
				Role role=roleRepository.findByRoleName(roleName);
				user.getRoles().add(role);
			}
			user.getRoles().add(roleRepository.findByRoleName("ACTUATOR"));
			String message="Welcome to User :"+user.getUserName() 
			+" Your Login Id is: "+user.getUserEmail()
			+" Your Password is: "+user.getPassword()
			+" Your Roles are: "+user.getRoles();
			userService.saveUser(user);
			email.sendEmail(user.getUserEmail(), "Application User Registration", message, null);
			map.addAttribute("user", new User());
			map.addAttribute("message", "User Registered...");
		}
		}
		//map.addAttribute("roles", UserUtil.getUserRoles());
		return "Register";
	}
	
	@GetMapping("/AccessDenied")
	public String showDenied(){
		return "AccessDenied";
	}
}
