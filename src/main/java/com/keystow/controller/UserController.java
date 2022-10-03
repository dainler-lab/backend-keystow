package com.keystow.controller;

import com.keystow.dto.UserDto;
import com.keystow.service.UserService;
import com.keystow.validate.group.ValidationGroupSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/signup")
	public String viewUserFormPageSignup(Model model) {

		model.addAttribute("userDto", new UserDto());

		return "user/signup";
	}

	@PostMapping("/create")
	public String createUser(@Validated(ValidationGroupSequence.class) @ModelAttribute("userDto") UserDto userDto,
			BindingResult result) {

		if (result.hasErrors()) {
			return "user/signup";
		}

		userService.saveUser(userDto);

		return "redirect:/login";
	}

}
