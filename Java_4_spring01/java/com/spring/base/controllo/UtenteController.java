package com.spring.base.controllo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.base.entity.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path="/gestioneUtenti")
public class UtenteController {
	
	@GetMapping(path="/carica", consumes = "application/json")
	public boolean registra(@RequestBody Utente utente) {
		System.out.println("ho registrato " + utente);
		return true;
	}
	@GetMapping(path="/cerca/{id}", produces = "application/json")
	public Utente cerca(@PathVariable int id) {
		return new Utente(id, 1998, "bianchi", "anni", "111", "anna");
	}
	@GetMapping(path="/modifica/{id}",produces = "application/json")
	public Utente modifica(@PathVariable int id , String nome) {
		return new Utente(id,1998, nome, "anni","111", "anna");
	}
	
}
