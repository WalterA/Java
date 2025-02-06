package com.spring.base.controllo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/date")

public class DateController {
	@GetMapping(path = "/attuale")
	public LocalDateTime getDataAttuale() {
		return LocalDateTime.now();
	}

	@GetMapping(path = "precisa")
	public LocalDate getdata() {
		return LocalDate.of(2026, 10, 05);
	}
}
