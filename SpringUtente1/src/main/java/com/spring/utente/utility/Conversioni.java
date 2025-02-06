package com.spring.utente.utility;

import com.spring.utente.entity.Utente;
import com.string.utente.dto.UtenteDTO;

public class Conversioni {
	
	public static Utente daUtenteDTOaUtente(UtenteDTO dto) {
		return new Utente(dto.getId(), dto.getAnnoNascita(), dto.getNome(), dto.getCognome(), dto.getUsername(), dto.getPassword());
	}
	public static UtenteDTO daUtenteaUtenteDTO(Utente ut) {
		return new UtenteDTO(ut.getId(), ut.getAnnoNascita(), ut.getNome(), ut.getCognome(), ut.getUsername(), ut.getPassword());
	}
}
