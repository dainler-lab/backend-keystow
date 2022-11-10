package com.keystow.application.controller;

import com.keystow.application.dto.user.AdminCreateUserFormDataDto;
import com.keystow.application.model.user.UserRole;
import com.keystow.application.service.AdminUserService;
import com.keystow.application.validate.group.ValidationGroupSequence;
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

@Secured("ROLE_ADMIN")
@RequestMapping("/admin")
@Controller
public class AdminController {

	private final AdminUserService adminUserService;

	@Autowired
	public AdminController(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	@GetMapping("/create")
	public String viewPageFormCreateUser(Model model) {
		model.addAttribute("userFormDataDto", new AdminCreateUserFormDataDto());
		model.addAttribute("possibleRoles", Set.of(UserRole.USER, UserRole.ADMIN));
		return "user/edit";
	}

	@PostMapping("/create")
	public String createUser(
			@Validated(ValidationGroupSequence.class) @ModelAttribute("userFormDataDto") AdminCreateUserFormDataDto userFormDataDto,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("possibleRoles", Set.of(UserRole.USER, UserRole.ADMIN));
			return "user/edit";
		}

		adminUserService.createUser(userFormDataDto);

		return "redirect:/app";
	}

}
