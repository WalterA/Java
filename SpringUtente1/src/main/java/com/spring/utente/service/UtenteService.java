package com.spring.utente.service;

import java.util.ArrayList;
import java.util.List;

import com.spring.utente.dao.DAOUtente;
import com.spring.utente.dto.NomeCognomeDTO;
import com.spring.utente.entity.Utente;
import com.spring.utente.utility.Conversioni;
import com.string.utente.dto.UtenteDTO;

public class UtenteService {
	// questo costruttore crea la mappa vuota di utenti
	private DAOUtente dao = new DAOUtente();

	public void registra(UtenteDTO dto) {
		// traformo da dto a entity
		Utente entuty = Conversioni.daUtenteDTOaUtente(dto);
		// chiama il dao x inserire
		dao.insert(entuty);
	}

	public UtenteDTO cercaPerID(int id) {
		Utente utente = dao.selectById(id);
		UtenteDTO ut = Conversioni.daUtenteaUtenteDTO(utente);
		return ut;
	}

	public List<UtenteDTO> mostraTutti() {
		List<Utente> lista = dao.selectAll();
		List<UtenteDTO> listaDto = new ArrayList<>();
		for (Utente utente : lista) {
			UtenteDTO dto = Conversioni.daUtenteaUtenteDTO(utente);
			listaDto.add(dto);
		}
		return listaDto;
	}

	public boolean ok(int id) {
				return dao.delete(id);
	}
	
	public void aggiorna(int id, String pass) {
		 dao.updatePassword(id, pass);
	}
	
	
	
	// prof
	public UtenteDTO mod (int id, String pass) {
		Utente entity = dao.updatePassword(id, pass);
		if (entity!=null) {
			return Conversioni.daUtenteaUtenteDTO(entity);
		}
		return null;
}
	public UtenteDTO aggiorna(UtenteDTO dto) {
		Utente entity = Conversioni.daUtenteDTOaUtente(dto);
		entity =  dao.update(entity);
		if (entity != null) {
			return Conversioni.daUtenteaUtenteDTO(entity);
		}
		return null;
	}
	public List<String> getNomiUtenti(){
		List<Utente> lista = dao.selectAll();
		List<String> nomi = new ArrayList<String>();
		for(Utente utente :lista) {
			String NOME = utente.getNome();
			nomi.add(NOME);
		}
		return nomi;
	}
	public List<NomeCognomeDTO> getNomiCognomi(){
		List<Utente> lista = new ArrayList<Utente>();
		List<NomeCognomeDTO> listaDto = new ArrayList<>();
		for (Utente utente : lista) {
			NomeCognomeDTO dto =new NomeCognomeDTO(utente.getNome(),utente.getCognome());
			listaDto.add(dto);
		}
		return null
		
	}
}
