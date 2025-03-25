package com.spring.studente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.studente.dao.Daostudente;
import com.spring.studente.dto.StudenteDTO;

public interface StudenteService  {
	public Boolean immatricola (StudenteDTO dto);
	public StudenteDTO cerca (Integer matricola);
	public List<StudenteDTO> all ();
	public StudenteDTO delete(Integer matricola);
	public List<StudenteDTO> getStudentiGiovani(Integer annoImmatricolazione);

}
