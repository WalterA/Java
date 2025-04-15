package com.spring.ProgettoDemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ProgettoDemo.dto.DtoNegozio;
import com.spring.ProgettoDemo.dto.DtoRegistraNegozio;
import com.spring.ProgettoDemo.entity.Negozio;
import com.spring.ProgettoDemo.repository.RepositoryNegozio;
import com.spring.ProgettoDemo.utility.Converti;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServiceImplNegozio implements ServiceNegozio {
	@Autowired
	RepositoryNegozio repo;

	@Override
	public Boolean createNegozio(DtoRegistraNegozio dtor) {
			//Controlla se tutti gli elementi del db hanno la stessa email, se non trova nessun elemento uguale carica l'entity nel db
	        List<Negozio> listanegozi = repo.findAll();
	        Boolean emailEsistente = listanegozi.stream()
	                                           .anyMatch(nego -> nego.getEmail().equals(dtor.getEmail()));
	        if (emailEsistente) {
	            // Se l'email esiste già, interrompiamo l'operazione e si può lanciare un'eccezione o restituire false.
	        	throw new RuntimeException("Email già presente");
	        } else {
	            Negozio n = Converti.convertiDtoNegozio(dtor);
	            repo.save(n);
	            return true;
	        }
	     
	    }
	

	@Override
	public List<DtoNegozio> allNegozi() {
		//Mostra l'intera lista dei negozi presenti nel db
		List<Negozio> listanegozi = repo.listanegozi();
			if (!listanegozi.isEmpty()) {
				return listanegozi.stream()
									.map(Dto -> Converti.convertiNegozio(Dto))
									.collect(Collectors.toList());
			} else {
				throw new RuntimeException("Negozi non trovati");
			}
	}
	
	@Override
	public Boolean deleteAll() {
		//Elimina ogni elemento presente nel db
		try {
			repo.deleteAll();
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
	}

}
