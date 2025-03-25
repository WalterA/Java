package com.spring.impiegato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.impiegato.dto.DtoImpiegato;
import com.spring.impiegato.service.ServiceImpiegato;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = "/impiegato")
public class ImpiegatoController {
	@Autowired
	private ServiceImpiegato service;
	
	@PostMapping(consumes = "application/json")
	public DtoImpiegato Assumi(@RequestBody DtoImpiegato dto) {
		return service.Assumi(dto);
	}
	@GetMapping(path="/{matricola}", produces = "application/json")
	public DtoImpiegato Cerca (@PathVariable Integer matricola) {
		return service.Cerca(matricola);
	}
	@GetMapping(produces = "application/json")
	public List<DtoImpiegato> GetAll(){
		return service.GetAll();
	}
	@DeleteMapping(path = "/delete/{matricola}", produces = "application/json")
	public DtoImpiegato deleteImpiegato(@PathVariable Integer matricola) {
	   return service.Delete(matricola);
	}

	@PatchMapping(path = "/{matricola}",produces = "application/json")
	public DtoImpiegato AggiornaSalario(@PathVariable Integer matricola, Double newSalario) {
		return service.AggiornaSalario(matricola, newSalario);
	}
	@DeleteMapping (path="/nomicognomi/{matricola}", produces = "application/json")
	public String DeleteNomiCognomi (@PathVariable Integer matricola) {
		return service.DeleteNomiCognomi(matricola);
	}
	@GetMapping(path="/nomicognomi",produces = "application/json")
	public List<DtoImpiegato> GetNomiCognomi(){
		return service.GetNomiCognomi();
	}
	
	@GetMapping(path="/salariomax",produces = "application/json")
	public List<DtoImpiegato> GetSalarioMax(Double salarioMax){
		return service.GetSalarioMassimo(salarioMax);
	}
	@GetMapping(path="/ordinecognomi", produces = "application/json")
	public List<DtoImpiegato> OrdineCognomi(){
		return service.OrdinaCognome();
	}
	@GetMapping(path="/ordineSalario", produces = "application/json")
	public List<DtoImpiegato> OrdineSalario(){
		return service.OrdinaSalario();
	}
	
	
	
}
