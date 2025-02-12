package com.spring.rubrica.dao;

import java.util.List;

import com.spring.rubrica.entity.Contatto;

public interface DaoContatto {
	public void insert(Contatto c);
	public boolean delete(Integer idContatto);
	public List<Contatto> selectAll();
	public Contatto selectById(Integer idContatto) ;
	
}
