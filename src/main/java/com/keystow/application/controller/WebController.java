package com.keystow.application.controller;

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

	@GetMapping("/dica")
	public String dicaDeSenha() {
		return "/dica";
	}

	@GetMapping("/app")
	public String home() {
		return "/app/home";
	}

}
