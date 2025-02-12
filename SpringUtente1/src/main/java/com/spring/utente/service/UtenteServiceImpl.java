package com.spring.utente.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.utente.dao.DAOUtente;

import com.spring.utente.dto.UtenteDTO;
import com.spring.utente.entity.Utente;
import com.spring.utente.utility.Conversioni;
@Service
public class UtenteServiceImpl implements UtenteService {
	@Autowired
	// questo costruttore crea la mappa vuota di utenti
	private DAOUtente dao;
	
	public void registra(UtenteDTO dto) {
		// trasformo da dto a entity
		Utente entity = Conversioni.daUtenteDTOAUtente(dto);
		
		// chiamo il dao x inserire
		dao.insert(entity);
	}
	
	public UtenteDTO cercaPerId(int id) {
		// chiamo il dao
		Utente utente = dao.selectById(id);
		
		// trasformo da entity a dto
		return Conversioni.daUtenteAUtenteDTO(utente);
	}
	
	public List<UtenteDTO> mostraTutti(){
		// chiamo il dao
		List<Utente> lista= dao.selectAll();
		
		// trasformo
		List<UtenteDTO> listaDto = new ArrayList<>();
		for (Utente utente : lista) {
			UtenteDTO dto = Conversioni.daUtenteAUtenteDTO(utente);
			listaDto.add(dto);
		}
		
		return listaDto;
	}
	
	public boolean cancella(int id) {
		return dao.delete(id);
	}
	
	public UtenteDTO modificaPassword(int id, String password) {
		Utente entity = dao.updatePassword(id, password);
		if(entity != null) {
			// trasformazione
			return Conversioni.daUtenteAUtenteDTO(entity);
		}
		return null;
	}
	
	public UtenteDTO aggiorna(UtenteDTO dto) {
		// trasformo....
		Utente utente = Conversioni.daUtenteDTOAUtente(dto);
		// aggiorno
		utente = dao.update(utente);
		if(utente != null) {
			// trasformo di nuovo...
			return Conversioni.daUtenteAUtenteDTO(utente);
		}
		return null;
	}
	
	public List<String> getNomiUtenti(){
		List<Utente> lista = dao.selectAll();
		
		List<String> nomi = new ArrayList<>();
		for (Utente utente : lista) {
			String nome = utente.getNome();
			nomi.add(nome);
		}
		return nomi;
	}

	
	
}






