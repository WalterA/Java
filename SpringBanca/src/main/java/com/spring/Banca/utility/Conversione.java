package com.spring.Banca.utility;
import com.spring.Banca.dto.UtenteDto;
import com.spring.Banca.entity.Utente;

public class Conversione {

	public static Utente daUtenteDTOAUtente(UtenteDto dto) {
		return new Utente(dto.getIdUtente(), dto.getNome(), dto.getCognome(), dto.getPassword());
	}
	public static UtenteDto daUtenteDTOAUtente(Utente entity) {
		return new UtenteDto(entity.getIdUtente(), entity.getNome(), entity.getCognome(), entity.getPassword());
	}
}
