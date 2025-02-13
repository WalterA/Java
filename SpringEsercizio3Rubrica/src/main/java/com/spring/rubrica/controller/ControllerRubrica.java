package com.spring.rubrica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.NomiTotDTO;
import com.spring.rubrica.dto.ProprietarioAnnoDTO;
import com.spring.rubrica.dto.ProprietarioNDTO;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.entity.Contatto;
import com.spring.rubrica.service.ServiceRubrica;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = "/servizi")
public class ControllerRubrica {
	@Autowired
	private ServiceRubrica service;

	@PostMapping(path = "/registra", consumes = "application/json")
	public void registra(@RequestBody RubricaDTO dto) {
		service.registra(dto);
	}

	@GetMapping(path = "/cerca/{id}", produces = "application/json")
	public RubricaDTO cercaPerID(@PathVariable int id) {
		return service.cercaPerId(id);
	}

	@GetMapping(path = "/mostraTutti", produces = "application/json")
	public List<RubricaDTO> mastraTutti() {
		return service.mostraTutti();
	}

	@GetMapping(path = "/elimana/{id}", produces = "application/json")
	public boolean eli(@PathVariable int id) {
		return service.cancella(id);
	}

	@GetMapping(path = "/mostraNomi", produces = "application/json")
	public List<String> mostranomi() {
		return service.getNomiUtenti();
	}

	@PostMapping(path = "/aggiungicontatto/{idrubrica}", consumes = "application/json", produces = "application/json")
	public void aggiungi(@RequestBody ContattoDTO con, @PathVariable int idrubrica) {
		service.aggiungi(con, idrubrica);
	}
	@GetMapping(path = "/mostraProprietario/{id}", produces = "application/json")
	public ProprietarioAnnoDTO mostraProprietario(@PathVariable int id) {
	    return service.mostraProprietario(id);
	}

	@PatchMapping(path = "/modificaProprietario/{id}", consumes = "application/json", produces = "application/json")
	public RubricaDTO modificaProprietario(@PathVariable int id, @RequestBody String proprietario) {
	    return service.modificaProprietario(id, proprietario);
	}

	@PatchMapping(path = "/modificaAnno/{id}", consumes = "application/json", produces = "application/json")
	public RubricaDTO modificaAnno(@PathVariable int id, @RequestBody int anno) {
	    return service.modificaAnno(id, anno);
	}

	@GetMapping(path = "/nomiTotali", produces = "application/json")
	public NomiTotDTO nomiTotali() {
	    return service.nomietot();
	}

	@GetMapping(path = "/rubricaPiuVecchia", produces = "application/json")
	public RubricaDTO rubricaPiuVecchia() {
	    return service.vecchio();
	}

	@GetMapping(path = "/anniCreazione", produces = "application/json")
	public List<Integer> anniCreazione() {
	    return service.anno();
	}

	@GetMapping(path = "/proprietarioContatti/{id}", produces = "application/json")
	public ProprietarioNDTO proprietarioContatti(@PathVariable int id) {
	    return service.mo(id);
	}
	@GetMapping(path="/contattoinRubrica/{idcontatto}/{idrubrica}", produces = "application/json")
			public ContattoDTO contattoinRubrica(@PathVariable int idcontatto,@PathVariable int idrubrica) {
		return service.cID(idcontatto, idrubrica);
	}


	@PutMapping(path="/modificaContatto/{idrubrica}", consumes = "application/json", produces = "application/json")
	public ContattoDTO modificaContatto(@PathVariable int idrubrica, @RequestBody ContattoDTO dto) {
	    return service.modificaContatto(idrubrica, dto);
	}

	@DeleteMapping(path="/cancellaContatto/{idrubrica}/{idcontatto}")
	public Boolean cancellaContatto(@PathVariable int idrubrica, @PathVariable int idcontatto) {
	    return service.cancella(idrubrica, idcontatto);
	}


}
