package com.keystow.controller;

import com.keystow.dto.user.CreateUserFormDataDto;
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

@RequestMapping("/user")
@Controller
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/signup")
	public String viewUserFormPageSignup(Model model) {

		model.addAttribute("user", new CreateUserFormDataDto());

		return "user/signup";
	}

	@PostMapping("/create")
	public String createUser(
			@Validated(ValidationGroupSequence.class) @ModelAttribute("user") CreateUserFormDataDto user,
			BindingResult result) {

		if (result.hasErrors()) {
			return "user/signup";
		}

		userService.saveUser(user);

		return "redirect:/login";
	}

}
