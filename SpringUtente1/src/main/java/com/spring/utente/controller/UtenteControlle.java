package com.spring.utente.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.spring.utente.dto.UtenteDTO;
import com.spring.utente.service.UtenteService;
import com.spring.utente.utility.Conversioni;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController

@RequestMapping(path = "/servizi")
public class UtenteControlle {
	@Autowired
	private UtenteService service;

	@GetMapping(path = "/registra", consumes = "application/json")
	public void registra(@RequestBody UtenteDTO dto) {
		service.registra(dto);
	}

	@GetMapping(path = "/cerca/{id}", produces = "application/json")
	public UtenteDTO cercaPerID(@PathVariable int id) {
		return service.cercaPerId(id);
	}

	@GetMapping(path = "/mostraTutti", produces = "application/json")
	public List<UtenteDTO> mastraTutti() {
		return service.mostraTutti();
	}
	@GetMapping(path="/elimana/{id}",produces = "application/json")
	public boolean eli(@PathVariable int id) {
		return service.cancella(id);
	}
	@GetMapping(path="/modpass/{id}/",produces = "application/json")
	public void mod(@PathVariable int id,@RequestBody String pass) {
		service.modificaPassword(id, pass);
	}
	//prof 
	@GetMapping(path = "/md/{id}", produces = "application/json")
	public UtenteDTO modfi(@PathVariable int id,String pass) {
		return service.modificaPassword(id, pass);
	}
	@GetMapping(path="/agg", consumes = "application/json",produces = "application/json")
	public UtenteDTO aggiorna(@RequestBody UtenteDTO dto) {
		return service.aggiorna(dto);
	}
	@GetMapping (path = "/nomiUtenti", produces = "application/json")
	public List<String> getNomiUtenti(){
		return service.getNomiUtenti();
	}
	
}
