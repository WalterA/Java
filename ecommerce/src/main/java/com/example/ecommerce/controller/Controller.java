package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.DtoProdotto;
import com.example.ecommerce.dto.DtoVenditore;
import com.example.ecommerce.dto.DtoVenditoreBase;
import com.example.ecommerce.entity.Prodotto;
import com.example.ecommerce.entity.Venditore;
import com.example.ecommerce.service.ServiceProdotto;
import com.example.ecommerce.service.ServiceVenditore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/venditore")
public class Controller {
	@Autowired
	ServiceProdotto sp;
	@Autowired
	ServiceVenditore sv;
	
	@PostMapping(path="/rv", consumes = "application/json")
	public DtoVenditore inserisci (@RequestBody Venditore v) {
		return sv.inserisci(v);
	}
	@PostMapping(path="/rp", consumes = "application/json")
	public DtoProdotto inserisci (@RequestBody Prodotto p) {
		return sp.registraProdotto(p);
	}
	
	@GetMapping(path="/getv/{idVenditore}" , produces= "application/json")
	public DtoVenditore getById (@PathVariable Integer idVenditore) {
		return sv.getById(idVenditore);
	}
	@GetMapping(path="/getvbase/{IdVenditore}", produces = "application/json")
	public DtoVenditoreBase getByIdBase(@PathVariable Integer IdVenditore) {
		return sv.getByIdBase(IdVenditore);
	}
	
	@PatchMapping(path="/updatepass/{idVenditore}", produces = "application/json")
	public DtoVenditore updatePassword (@PathVariable Integer idVenditore , String nuovaPassword) {
		return sv.updatePassword(idVenditore, nuovaPassword);
	}
	@PatchMapping(path="/addProdotto/{idVenditore}",produces = "application/json", consumes = "application/json")
	public Boolean addProdotto(@PathVariable Integer idVenditore,@RequestBody Prodotto p) {
		return sv.addProdotto(idVenditore, p);
	}
	@PatchMapping(path="updatequantita/{idVenditore}/{idProdotto}",produces = "application/json", consumes = "application/json")
	public Boolean updateQuantita(@PathVariable Integer idVenditore,@PathVariable Integer idProdotto, Integer nuovaQuantita) {
		return sv.updateQuantita(idVenditore, idProdotto, nuovaQuantita);
	}
}
