package com.spring.prodotto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.prodotti.entity.Prodotto;
import com.spring.prodotto.dto.ProdottoDTO;
import com.spring.prodotto.dto.ReportDTO;
import com.spring.prodotto.service.Service;
import org.springframework.web.bind.annotation.RequestParam;







@RestController
@RequestMapping(path = "/servizi")
public class Controller {
	private Service service = new Service();
	
	@PostMapping(path="/carica", consumes = "application/json")
	public  void registra(@RequestBody ProdottoDTO dto) {
		service.registra(dto);
	}

	@GetMapping(path = "/mostraTutti", produces = "application/json")
	public List<ProdottoDTO> mastraTutti() {
		return service.mostraTutti();
	}
	@GetMapping(path = "/cerca/{id}", produces = "application/json")
	public ProdottoDTO cercaPerID(@PathVariable int id) {
		return service.cercaPerID(id);
	}
	@GetMapping(path="/mostraRepo", produces = "application/json"
	public ReportDTO rep() {
		return ;
	}
	@get
	

}
