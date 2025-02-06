package com.spring.base.controllo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/saluto")
public class SalutoController {
	public SalutoController() {
		System.out.println("Spring crea saluto controller");
	}
	@GetMapping(path="/generico")
	public String helloword() {
		return " HEllo word!";
	}
	@GetMapping(path="/persona")
	public String hello(String nome) {
		return "Hello"+ " " + nome;
	}
}
