package com.spring.Banca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Banca.dto.UtenteDto;
import com.spring.Banca.service.UtenteService;

@RestController

//RestController mi trasforma una semplice classe java in un controller web 

@RequestMapping(path = "/utente")
public class UtenteController {
	@Autowired
	private UtenteService service;
	
	@PostMapping(path = "/registra", consumes = "application/json")
	public void Registra(@RequestBody UtenteDto dto) {
		service.Registrati(dto);
	}
	@GetMapping(path = "/mostra", produces = "application/json")
	public List<UtenteDto> Mostra(){
		return service.MostraLista();
	}
}
