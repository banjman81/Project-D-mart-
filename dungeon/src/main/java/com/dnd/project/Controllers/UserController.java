package com.dnd.project.Controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dnd.project.Models.User;
import com.dnd.project.Services.UserService;

@Controller
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/register")
	public String index(@ModelAttribute("user") User user, HttpSession session) {
		return "index.jsp";
	}
	
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result,  HttpSession session, RedirectAttributes redirectAttributes) {
		if(user.getPassword().equals(user.getPasswordConfirmation()) == false) {
			redirectAttributes.addFlashAttribute("password_error", "password does not match");
			return "redirect:/register";
		}
		if(result.hasErrors()) {
			return "index.jsp";
		}
		else {
			User checkUser = userService.findByEmail(user.getEmail());
			if (checkUser == null) {
				User saveUser = userService.registerUser(user);
				session.setAttribute("user_id",saveUser.getId());
				return "redirect:/home";
			}
			else {
				redirectAttributes.addFlashAttribute("email_error", "Email has been taken");
				return "redirect:/register";
			}
			
		}
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
