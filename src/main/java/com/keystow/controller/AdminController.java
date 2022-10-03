package com.keystow.controller;

import com.keystow.dto.UserDto;
import com.keystow.model.user.UserRole;
import com.keystow.service.UserService;
import com.keystow.validate.group.ValidationGroupSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private UserService userService;

	@Autowired
	public AdminController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/create")
	@Secured("ROLE_ADMIN")
	public String viewUserFormPageCreate(Model model) {
		model.addAttribute("userDto", new UserDto()); // userFormDataDto
		model.addAttribute("genders", Set.of(UserRole.USER, UserRole.ADMIN));
		// model.addAttribute("editMode", EditMode.CREATE);
		return "user/edit";
	}

	@PostMapping("/create")
	public String createUser(@Validated(ValidationGroupSequence.class) @ModelAttribute("userDto") UserDto userDto,
			BindingResult result) {

		if (result.hasErrors()) {
			return "user/edit";
		}

		userService.saveUser(userDto);

		return "redirect:/login";
	}

}
