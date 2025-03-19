package com.spring.Banca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Banca.dao.UtenteDao;
import com.spring.Banca.dto.UtenteDto;
import com.spring.Banca.entity.Utente;
import com.spring.Banca.utility.Conversione;

@Service
public class UtenteServiceImpl {
	@Autowired
	UtenteDao utenteDao;

	public void Registrati(UtenteDto dto) {
		Utente entity = Conversione.daUtenteDTOAUtente(dto);
		utenteDao.insert(entity);
};

}
