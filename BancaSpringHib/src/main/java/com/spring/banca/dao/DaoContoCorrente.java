package com.spring.banca.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.banca.entity.ContoCorrente;

public interface DaoContoCorrente extends JpaRepository<ContoCorrente, Integer> {

}
