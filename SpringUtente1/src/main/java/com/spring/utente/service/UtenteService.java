package com.spring.utente.service;

import java.util.ArrayList;
import java.util.List;

import com.spring.utente.dao.DAOUtente;
import com.spring.utente.entity.Utente;
import com.spring.utente.utility.Conversioni;
import com.string.utente.dto.UtenteDTO;

public class UtenteService {
	// questo costruttore crea la mappa vuota di utenti
	private DAOUtente dao = new DAOUtente();
	
	public void registra(UtenteDTO dto) {
		// traformo da dto a entity
		Utente entuty = Conversioni.daUtenteDTOaUtente(dto);
		//chiama il dao x inserire
		dao.insert(entuty);
	}
	public UtenteDTO cercaPerID (int id) {
		Utente utente = dao.selectById(id);
		UtenteDTO ut = Conversioni.daUtenteaUtenteDTO(utente);
		return ut;
	}
	public List<UtenteDTO> mostraTutti(){
		List<Utente> lista = dao.selectAll();
		List<UtenteDTO> listaDto = new ArrayList<>();
		for (Utente utente : lista) {
			UtenteDTO dto = Conversioni.daUtenteaUtenteDTO(utente);
			listaDto.add(dto);
		}
		return listaDto;
	}
}
