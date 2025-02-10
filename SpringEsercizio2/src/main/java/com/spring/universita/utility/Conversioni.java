package com.spring.universita.utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.universita.dao.DAOStudenti;
import com.spring.universita.dto.ProfessoreDTO;
import com.spring.universita.dto.StudenteDTO;
import com.spring.universita.entity.Professore;
import com.spring.universita.entity.Studente;

public class Conversioni {
	private DAOStudenti dao = new DAOStudenti();

	public static Studente daUtenteDTOaUtente(StudenteDTO dto) {
		return new Studente(dto.getMatricola(), dto.getAnno(), dto.getImmatricolazione(), dto.getNome(),
				dto.getCognome(), dto.getIndirizzo());
	}

	public static StudenteDTO daUtenteaUtenteDTO(Studente st) {
		return new StudenteDTO(st.getMatricola(), st.getAnno(), st.getImmatricolazione(), st.getNome(), st.getCognome(),
				st.getIndirizzo());
	}

	public static Professore daUtenteDTOaUtente(ProfessoreDTO dto) {
		return new Professore(dto.getId(), dto.getNome(), dto.getCognome(), dto.getMateria());
	}

	public static ProfessoreDTO daUtenteaUtenteDTO(Professore pr) {
		return new ProfessoreDTO(pr.getId(), pr.getNome(), pr.getCognome(), pr.getMateria());
			
	}

}
