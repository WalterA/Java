package com.spring.studente.service;

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
		//trasformazione
		Studente studente = new Studente(dto.getMatricola(), dto.getNome(), dto.getCognome(), dto.getAnnoImm());
		Studente x=dao.save(studente);
		return x==null?true:false;
		
	}

	@Override
	public StudenteDTO cerca(Integer matricola) {
		Optional<Studente> x = dao.findById(matricola);
		if(x.isPresent()) {
			Studente stu = x.get();
			return new StudenteDTO(stu.getMatricola(), stu.getNome(), stu.getCognome(), stu.getAnnoImm()); 
		}
		return null;
		
	}

}
