package com.spring.studente.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.studente.entity.Studente;

public interface Daostudente extends JpaRepository<Studente, Integer> {
	// qui eredito già tutte le funzioni CRUD
	
	@Query(nativeQuery = true, value="select * from studente where anno_imm > :annoImmatricolazione")
	public List<Studente> getStudentiGiovani(Integer annoImmatricolazione);
	
}
