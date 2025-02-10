package com.spring.universita.service;

import java.util.ArrayList;
import java.util.List;

import com.spring.universita.dao.DAOProfessore;
import com.spring.universita.dto.ProfessoreDTO;
import com.spring.universita.entity.Professore;
import com.spring.universita.utility.Conversioni;

public class ServiceProfessore {
	
		private DAOProfessore dao = new DAOProfessore();

		public void Registra(ProfessoreDTO dto) {
			Professore entity = Conversioni.daUtenteDTOaUtente(dto);
			dao.insert(entity);
		}

		public List<ProfessoreDTO> mostraTutti() {
			List<Professore> lista = dao.selectAll();
			List<ProfessoreDTO> listaDto = new ArrayList<>();
			for (Professore pr: lista) {
				ProfessoreDTO dto = Conversioni.daUtenteaUtenteDTO(pr);
				listaDto.add(dto);
			}
			return listaDto;
		}

		public ProfessoreDTO cercaPerID(int id) {
			Professore utente = dao.selectByID(id);
			ProfessoreDTO ut = Conversioni.daUtenteaUtenteDTO(utente);
			return ut;
		}

		public List<String> mostracognomi() {
			List<Professore> lista = dao.selectAll();
			List<String> cognomi = new ArrayList<>();
			for (Professore pr : lista) {
				cognomi.add(pr.getCognome());
			}
			return cognomi;
		}

		
		public ProfessoreDTO modificaMateria(String materia, int id) {
			Professore pr = dao.selectByID(id);
			pr.setMateria(materia);
			ProfessoreDTO prdto= Conversioni.daUtenteaUtenteDTO(pr);
			return prdto;
		}

		public ProfessoreDTO elimina(int id) {
			Professore utente = dao.selectByID(id);
			if(utente!= null) {
				dao.delete(id);
			return Conversioni.daUtenteaUtenteDTO(utente);
			}
			return null;
		}
		public List<ProfessoreDTO> cercapermateria(String materia) {
		List<Professore> lista = dao.selectAll();
		List<ProfessoreDTO> listaDto = new ArrayList<>();
		for (Professore pr: lista) {
			if(pr.getMateria() == materia) {
				ProfessoreDTO ut = Conversioni.daUtenteaUtenteDTO(pr);
				listaDto.add(ut);
			}
		}
		return listaDto;
		}
}
			