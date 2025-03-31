package com.spring.rubrica.controller;

import java.security.Provider.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rubrica.dao.DaoRubrica;
import com.spring.rubrica.dto.DtoContatto;
import com.spring.rubrica.dto.DtoRubrica;
import com.spring.rubrica.service.ServiceRubrica;

import jakarta.annotation.PostConstruct;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/Rubriche")
public class Controller {
	@Autowired
	ServiceRubrica service;
	@PostMapping(path="/crea", consumes = "application/json")
	public Boolean creaRubricaVuota(@RequestBody DtoRubrica dto) {
		return service.creaRubricaVuota(dto);
	}
	@GetMapping(path="/cerca/{idRubrica}", produces="application/json" )
	public DtoRubrica cerca(@PathVariable Integer idRubrica) {
		return service.cerca(idRubrica);
	}
	
	@PostMapping(path="/add/{idRubrica}", consumes = "application/json")
	public Boolean aggiungiContatto(@PathVariable Integer idRubrica,@RequestBody DtoContatto dtoc) { 
		return service.aggiungiContatto(idRubrica, dtoc);
}
	@DeleteMapping(path="/{idRubrica}" )
	public Boolean deleteRubrica(@PathVariable Integer idRubrica) {
		return service.deleteRubrica(idRubrica);
		
	}
	@DeleteMapping(path="/{idRubrica}/contatti/{idContatto}")
	public Boolean deleteContatto(@PathVariable Integer idRubrica,@PathVariable Integer idContatto) {
		return service.deleteContatto(idRubrica, idContatto);
	}
	
	
}
