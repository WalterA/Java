package com.spring.rubrica.utility;

import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.ProprietarioAnnoDTO;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.entity.Contatto;

import com.spring.rubrica.entity.Rubrica;

public class Conversioni {

	public static Contatto daUtenteDTOAUtente(ContattoDTO dto) {
		return new Contatto(dto.getNome(), dto.getCognome(), dto.getGruppoDiAppartenenza(), dto.getNumero(), dto.getDataDiNascita(), dto.isPreferito());
	}
	
	public static ContattoDTO daUtenteAUtenteDTO(Contatto entity) {
		return new ContattoDTO(entity.getNome(), entity.getCognome(), entity.getGruppoDiAppartenenza(), entity.getNumero(), entity.getDataDiNascita(), entity.isPreferito());
	}
	
	public static Rubrica daUtenteDTOAUtente(RubricaDTO dto) {
		return new Rubrica(dto.getProprietario(), dto.getAnnoDiCreazione(), dto.getRubrica());
	}
	
	public static RubricaDTO daUtenteAUtenteDTO(Rubrica entity) {
		return new RubricaDTO(entity.getProprietario(), entity.getAnnoDiCreazione(), entity.getRubrica());
	}
	
}
