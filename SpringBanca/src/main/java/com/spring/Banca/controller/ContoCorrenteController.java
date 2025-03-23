package com.spring.Banca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Banca.dto.ContoCorrenteDto;
import com.spring.Banca.dto.UtenteDto;
import com.spring.Banca.service.ContoCorrenteService;

@RestController

@RequestMapping (path="/ContoCorrente")
public class ContoCorrenteController {
	@Autowired
	private ContoCorrenteService service;
	
	@PostMapping(path="/registra" , consumes = "application/json")
	public void Registra (@RequestBody ContoCorrenteDto dto) {
		service.Registrati(dto);
	}
	
	@GetMapping(path = "/mostra", produces = "application/json")
	public List<ContoCorrenteDto> Mostra(){
		return service.MostraLista();
	}
	

}
