package com.spring.banca;

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

@RestController
@RequestMapping("/banca")
public class Controller {
	@Autowired
	private ServiceContoCorrente servicecc;
	@Autowired
	private ServiceUtente serviceu;
	
	@PostMapping(path="/conto",consumes = "application/json")
	public DtoContoCorrente registrati (@RequestBody DtoContoCorrente dto) {
		return servicecc.registrati(dto);
	}
	@PostMapping(path="/utente",consumes = "application/json")
	public DtoUtente registrati(@RequestBody DtoUtente dto) {
		return serviceu.registrati(dto);
	}
	@PatchMapping(path="/addcc/{idUtente}", produces = "application/json", consumes = "application/json")
	public DtoUtente addcc(@PathVariable Integer idUtente ,@RequestBody DtoContoCorrente dtocc ) {
		return serviceu.addcc(idUtente, dtocc);
	}
}
