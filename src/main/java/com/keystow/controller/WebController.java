package com.keystow.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WebController {

	@GetMapping
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String login(@AuthenticationPrincipal UserDetails userDetails) {

		if (userDetails == null) {
			return "/login";
		}
		else {
			return "redirect:/app";
		}
	}

	@GetMapping("/dica")
	public String dicaDeSenha() {
		return "/dica";
	}

	@GetMapping("/app")
	public String home() {
		return "/app/home";
	}

}
