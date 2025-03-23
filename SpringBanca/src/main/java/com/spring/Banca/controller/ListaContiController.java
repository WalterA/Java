package com.spring.Banca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Banca.dto.ContoCorrenteDto;
import com.spring.Banca.dto.UtenteDto;
import com.spring.Banca.service.ListaContiService;
@RestController

@RequestMapping (path="/ListaConti")
public class ListaContiController {
	@Autowired
	private ListaContiService service;
	
	@PostMapping(path="/registra" , consumes = "application/json")
	public void Registra (@RequestBody UtenteDto udto,@RequestBody ContoCorrenteDto cdto ) {
		service.Registrati(udto,cdto);
	}
	
	@GetMapping(path = "/mostra/{id}", produces = "application/json")
	public List<ContoCorrenteDto> Mostra(@PathVariable int id){
		return service.MostraConto(id);
	}
	
	
	
	
	
}
