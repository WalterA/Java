package com.spring.studente.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.studente.dao.Daostudente;
import com.spring.studente.dto.StudenteDTO;

public interface StudenteService  {
	public Boolean immatricola (StudenteDTO dto);
	public StudenteDTO cerca (Integer matricola);

}
