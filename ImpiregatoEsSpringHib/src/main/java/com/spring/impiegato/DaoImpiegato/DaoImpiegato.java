package com.spring.impiegato.DaoImpiegato;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.impiegato.entity.Impiegato;

public interface DaoImpiegato extends JpaRepository<Impiegato, Integer> {

}
