package com.spring.banca.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.banca.entity.Utente;


public interface DaoUtente extends  JpaRepository<Utente, Integer> {

}
