package com.spring.rubrica.utility;

import com.spring.rubrica.dto.ContattoDTO;
import com.spring.utente.dto.UtenteDTO;
import com.spring.utente.entity.Utente;

public class Conversioni {

	public static Contatto daUtenteDTOAUtente(ContattoDTO dto) {
		return new Contatto(dto.getId(), dto.getNome(), dto.getCognome(), dto.getUsername(), dto.getPassword(), dto.getAnnoNascita());
	}
	
	public static UtenteDTO daUtenteAUtenteDTO(Utente entity) {
		return new UtenteDTO(entity.getId(), entity.getNome(), entity.getCognome(), entity.getUsername(), entity.getPassword(), entity.getAnnoNascita());
	}
}
