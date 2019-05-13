package com.trix.simpleCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trix.simpleCrud.entity.User;
import com.trix.simpleCrud.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String listUsers(Model theModel) {
		List<User> users = userService.getUsers();
		theModel.addAttribute("users", users);
		return "list-users";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		User user = new User();
		theModel.addAttribute("user", user);
		return "user-form";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/user/list";
	}

	@GetMapping("/showFormForUpdate")
	public String updateUser(@RequestParam("userId") int theId, Model theModel) {
		User user = userService.findById(theId);
		theModel.addAttribute("user", user);
		return "user-form";
	}

	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") int theId, Model theModel) {
		User user = userService.findById(theId);
		userService.deleteUser(user);
		return "redirect:/user/list";
	}
}
