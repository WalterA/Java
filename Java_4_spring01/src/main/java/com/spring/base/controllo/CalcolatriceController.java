package com.spring.base.controllo;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping(path = "/calcoli")

public class CalcolatriceController {
	// niente attributi

	public CalcolatriceController() {
		System.out.println("Spring crea CalcolatriceController");
	}

	@GetMapping(path = "/sum")
	public int somma(int num1, int num2) {
		return num1 + num2;
	}

	@GetMapping(path = "/meno")
	public int sottrai(int num1, int num2) {
		return num1 - num2;
	}

	@GetMapping(path = "/molt")
	public int molt(int num1, int num2) {
		return  num1 * num2;
	}

	@GetMapping(path = "/div")
	public double div(int num1, int num2) {
		 BigDecimal result = BigDecimal.valueOf((double) num1 / num2);
		    return result.setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
	
}
