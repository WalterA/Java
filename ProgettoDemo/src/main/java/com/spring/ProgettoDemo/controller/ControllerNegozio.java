package com.spring.ProgettoDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ProgettoDemo.dto.DtoNegozio;
import com.spring.ProgettoDemo.dto.DtoRegistraNegozio;
import com.spring.ProgettoDemo.service.ServiceNegozio;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/Negozio")
public class ControllerNegozio {
	@Autowired
	ServiceNegozio service;
	
	 @PostMapping(path = "/createDb", consumes = "application/json")
	    public Boolean createNegozio(@RequestBody @Valid DtoRegistraNegozio n) {
		 //Crea elementi nel bd
		 	return service.createNegozio(n);
	 }

	    @GetMapping(path = "/allnegozi")
	    public List<DtoNegozio> allNegozi() {
	    	//Mostra ogni elemento del db della tabella negozi
	       return service.allNegozi();
	    }
	    
	    @DeleteMapping(path="/deleteall")
	    public Boolean deleteall() {
	    	//Elimina ogni elemento presente
	    	return service.deleteAll();
	    }
	

}
