package com.spring.banca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.banca.dto.DtoContoCorrente;
import com.spring.banca.dto.DtoUtente;
import com.spring.banca.service.ServiceContoCorrente;
import com.spring.banca.service.ServiceUtente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/banca")
public class Controller {
	@Autowired
	private ServiceContoCorrente servicecc;
	@Autowired
	private ServiceUtente serviceu;

	@PostMapping(path = "/conto", consumes = "application/json")
	public DtoContoCorrente registrati(@RequestBody DtoContoCorrente dto) {
		return servicecc.registrati(dto);
	}

	@PostMapping(path = "/utente", consumes = "application/json")
	public DtoUtente registrati(@RequestBody DtoUtente dto) {
		return serviceu.registrati(dto);
	}
	@GetMapping(path="/getall", produces = "application/json")
	public List<DtoUtente> getAll(){
		return serviceu.getAll();
	}

	@PatchMapping(path = "/addcc/{idUtente}", produces = "application/json", consumes = "application/json")
	public DtoUtente addcc(@PathVariable Integer idUtente, @RequestBody DtoContoCorrente dtocc) {
		return serviceu.addcc(idUtente, dtocc);
	}

	@GetMapping(path = "/login/{idUtente}", produces = "application/json")
	public Boolean login(@PathVariable Integer idUtente) {
		return serviceu.login(idUtente);
	}

	@PatchMapping(path = "/prelievo/{idUtente}/{idCc}", produces = "application/json")
	public Boolean prelievo(@RequestParam Integer prelievo, @PathVariable Integer idUtente,
			@PathVariable Integer idCc) {
		return serviceu.prelievo(prelievo, idUtente, idCc);
	}

	@PatchMapping(path = "/versamento/{idUtente}/{idCc}", produces = "application/json")
	public Boolean versamento(@RequestParam Integer versamento, 
	                          @PathVariable Integer idUtente,
	                          @PathVariable Integer idCc) {
	    return serviceu.versamento(versamento, idUtente, idCc); 
	}


	@GetMapping(path = "/saldo/{idUtente}/{idCc}", produces = "application/json")
	public Integer getSaldo(@PathVariable Integer idUtente, @PathVariable Integer idCc) {
		return serviceu.getSaldo(idUtente, idCc);
	}

	@GetMapping(path = "/movimenti/{idUtente}/{idCc}", produces = "application/json")
	public List<Integer> getMovimenti(@PathVariable Integer idUtente,@PathVariable Integer idCc) {
		return serviceu.getMovimenti(idUtente, idCc);
	}
}