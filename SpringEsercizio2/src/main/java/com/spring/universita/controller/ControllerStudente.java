package com.spring.universita.controller;

import org.springframework.web.bind.annotation.RestController;

import com.spring.universita.dto.StudenteDTO;
import com.spring.universita.service.ServiceStudente;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ControllerStudente {
	private ServiceStudente service = new ServiceStudente();
	
	@PostMapping(path="/registrati", consumes = "application/json")
	public void registrati(@RequestBody StudenteDTO dto) {
		service.Registra(dto);
	}
	
	@GetMapping(path = "/mostraTutti", produces = "application/json")
	public List<StudenteDTO> mastraTutti() {
		return service.mostraTutti();
	}
	
	@GetMapping(path = "/cerca/{id}", produces = "application/json")
	public StudenteDTO cercaPerID(@PathVariable int id) {
		return service.cercaPerID(id);
	}
	
	@GetMapping(path = "/mostranomi", produces = "application/json")
	public List<String> mostran(){ 
		return service.mostranomi();
	}
	@GetMapping(path="/giovani", produces = "application/json")
	public StudenteDTO giovane() {
		return service.studentePiuGiovane();
	}
	@GetMapping(path="/immavecchi", produces = "application/json")
	public StudenteDTO imma() {
		return service.studentepiutempo();
	}
	@PatchMapping(path="/modindirizzo/{matricola}", produces = "application/json")
	public StudenteDTO modificaindirizzo( String indirizzo , @PathVariable int matricola) {
		return service.modificaIndirizzo(indirizzo, matricola);
	}
	
	@DeleteMapping(path="/elimina/{matricola}", produces = "application/json")
	public StudenteDTO elimina(@PathVariable int matricola) {
		return service.elimina(matricola);
	}

	
	
	
	

}
