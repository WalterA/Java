package com.spring.studente.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.studente.dao.Daostudente;
import com.spring.studente.dto.StudenteDTO;
import com.spring.studente.entity.Studente;

@Service
@Transactional
public class StudenteServiceImpl implements StudenteService {
	@Autowired
	private Daostudente dao;

	@Override
	public Boolean immatricola(StudenteDTO dto) {
		// trasformazione
		Studente studente = new Studente(dto.getMatricola(), dto.getNome(), dto.getCognome(), dto.getAnnoImm());
		Studente x = dao.save(studente);
		return x == null ? false : true;

	}

	@Override
	public StudenteDTO cerca(Integer matricola) {
		Optional<Studente> x = dao.findById(matricola);
		if (x.isPresent()) {
			Studente stu = x.get();
			return new StudenteDTO(stu.getMatricola(), stu.getNome(), stu.getCognome(), stu.getAnnoImm());
		}
		return null;

	}

	@Override
	public List<StudenteDTO> all() {
		List<StudenteDTO> ldto = new ArrayList<StudenteDTO>();
		List<Studente> lista = dao.findAll();
		for (Studente st : lista) {
			StudenteDTO dto = new StudenteDTO(st.getMatricola(), st.getNome(), st.getCognome(), st.getAnnoImm());
			ldto.add(dto);
		}
		return ldto;

	}

	@Override
	public StudenteDTO delete(Integer matricola) {
		Optional<Studente> x = dao.findById(matricola);
		if (x.isPresent()) {
			Studente studente = x.get();
			dao.delete(studente);
			StudenteDTO dto = new StudenteDTO(studente.getMatricola(), studente.getNome(), studente.getCognome(),
					studente.getAnnoImm());
			return dto;
		}
		return null;

	}

	@Override
	public List<StudenteDTO> getStudentiGiovani(Integer annoImmatricolazione) {
		List<Studente> lista = dao.getStudentiGiovani(annoImmatricolazione);
		List<StudenteDTO> ldto = new ArrayList<StudenteDTO>();
		for (Studente st : lista) {
			StudenteDTO dto = new StudenteDTO(st.getMatricola(), st.getNome(), st.getCognome(), st.getAnnoImm());
			ldto.add(dto);
		}
		return ldto;

	}

}
