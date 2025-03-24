package com.spring.studente.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.studente.entity.Studente;

public interface Daostudente extends JpaRepository<Studente, Integer> {
	// qui eredito già tutte le funzioni CRUD

}
