package com.spring.universita.service;

import java.util.ArrayList;
import java.util.List;
import com.spring.universita.dao.DAOStudenti;
import com.spring.universita.dto.StudenteDTO;
import com.spring.universita.entity.Studente;
import com.spring.universita.utility.Conversioni;

public class ServiceStudente {
	private DAOStudenti dao = new DAOStudenti();

	public void Registra(StudenteDTO dto) {
		Studente entity = Conversioni.daUtenteDTOaUtente(dto);
		dao.insert(entity);
	}

	public List<StudenteDTO> mostraTutti() {
		List<Studente> lista = dao.selectAll();
		List<StudenteDTO> listaDto = new ArrayList<>();
		for (Studente st : lista) {
			StudenteDTO dto = Conversioni.daUtenteaUtenteDTO(st);
			listaDto.add(dto);
		}
		return listaDto;
	}

	public StudenteDTO cercaPerID(int matricola) {
		Studente utente = dao.selectBymatricola(matricola);
		StudenteDTO ut = Conversioni.daUtenteaUtenteDTO(utente);
		return ut;
	}

	public List<String> mostranomi() {
		List<Studente> lista = dao.selectAll();
		List<String> nomi = new ArrayList<>();
		for (Studente studente : lista) {
			nomi.add(studente.getNome());
		}
		return nomi;
	}

	public StudenteDTO studentePiuGiovane() {
		List<Studente> lista = dao.selectAll();
		Studente piuGiovane = null;
		for (Studente studente : lista) {
			if (studente.getAnno() > piuGiovane.getAnno()) {
				piuGiovane = studente;
			}
		}
		StudenteDTO ut = Conversioni.daUtenteaUtenteDTO(piuGiovane);
		return ut;
	}

	public StudenteDTO studentepiutempo() {
		List<Studente> lista = dao.selectAll();
		Studente piuTempo = null;

		for (Studente studente : lista) {
			if (studente.getImmatricolazione() > piuTempo.getImmatricolazione()) {
				piuTempo = studente;
			}
		}
		StudenteDTO ut = Conversioni.daUtenteaUtenteDTO(piuTempo);
		return ut;
	}

	public StudenteDTO modificaIndirizzo(String indirizzo, int matricola) {
		List<Studente> lista = dao.selectAll();
		Studente st = dao.selectBymatricola(matricola);
		st.setIndirizzo(indirizzo);
		StudenteDTO ut = Conversioni.daUtenteaUtenteDTO(st);
		return ut;
		/*
		StudenteDTO ut = null;
		for (Studente studente : lista) {
			if (studente.getMatricola() == matricola) {
				studente.setIndirizzo(indirizzo);
				ut = Conversioni.daUtenteaUtenteDTO(studente);
				return ut;
			}
		}
		return ut;*/
	}

	public StudenteDTO elimina(int matricola) {
		List<Studente> lista = dao.selectAll();
		for (Studente studente : lista) {
			if (studente.getMatricola() == matricola) {
				dao.delete(matricola);
				StudenteDTO ut = Conversioni.daUtenteaUtenteDTO(studente);
				return ut;
			}
		}
		return null;

	}
}