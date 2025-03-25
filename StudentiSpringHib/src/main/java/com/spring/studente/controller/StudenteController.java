package com.spring.studente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.studente.dto.StudenteDTO;
import com.spring.studente.service.StudenteService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path = "/studente")
public class StudenteController {
	@Autowired
	private StudenteService service;

	@PostMapping(consumes = "application/json")
	public Boolean immatricola(@RequestBody StudenteDTO dto) {
		return service.immatricola(dto);
	}

	@GetMapping(path = "/{matricola}", produces = "application/json")
	public StudenteDTO cerca(@PathVariable Integer matricola) {
		return service.cerca(matricola);
	}

	@GetMapping(produces = "application/json")
	public List<StudenteDTO> all() {
		return service.all();
	}

	@DeleteMapping(path = "/{matricola}", produces = "application/json")
	public StudenteDTO delete(@PathVariable Integer matricola) {
		return service.delete(matricola);
	}
	
	@GetMapping(path="/getanno",produces = "application/json")
	public List<StudenteDTO> getGiovani(Integer annoImm) {
		return service.getStudentiGiovani(annoImm);
	}
	

}
