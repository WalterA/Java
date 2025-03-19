package com.spring.Banca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Banca.dto.UtenteDto;
import com.spring.Banca.service.UtenteService;

@RestController
//RestController mi trasforma una semplice classe java in un controller web 
public class UtenteController {
	@Autowired
	private UtenteService service;
	
	
	public UtenteDto insertController(UtenteDto u) {
		UtenteDto utenteinserito = service.insertService(u);
		return utenteinserito;
	}
}
