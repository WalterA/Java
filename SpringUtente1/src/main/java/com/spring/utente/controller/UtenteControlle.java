package com.spring.utente.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.utente.service.UtenteService;
import com.string.utente.dto.UtenteDTO;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController

@RequestMapping(path = "/servizi")
public class UtenteControlle {
	private UtenteService service = new UtenteService();

	@GetMapping(path = "/registra", consumes = "application/json")
	public void registra(@RequestBody UtenteDTO dto) {
		service.registra(dto);
	}

	@GetMapping(path = "/cerca/{id}", produces = "application/json")
	public UtenteDTO cercaPerID(@PathVariable int id) {
		return service.cercaPerID(id);
	}

	@GetMapping(path = "/mostraTutti", produces = "application/json")
	public List<UtenteDTO> mastraTutti() {
		return service.mostraTutti();
	}
}
