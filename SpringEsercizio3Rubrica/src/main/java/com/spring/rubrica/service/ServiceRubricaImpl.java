package com.spring.rubrica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rubrica.dao.DaoRubrica;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.entity.Rubrica;
import com.spring.utente.dto.UtenteDTO;
import com.spring.utente.entity.Utente;
import com.spring.utente.utility.Conversioni;

@Service
public class ServiceRubricaImpl implements ServiceRubrica {
	@Autowired
	private DaoRubricao dao;
	
	public void registra(RubricaDTO dto) {
		// trasformo da dto a entity
		Rubrica entity = Conversioni.daUtenteDTOAUtente(dto);
		
		// chiamo il dao x inserire
		dao.insert(entity);
	}
	

}
