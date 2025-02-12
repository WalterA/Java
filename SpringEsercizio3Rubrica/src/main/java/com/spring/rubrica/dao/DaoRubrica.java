package com.spring.rubrica.dao;

import java.util.List;

import com.spring.rubrica.entity.Contatto;

public interface DaoRubrica {
	public void insert(Contatto contatto);

	public boolean delete(Integer idcontatto);

	public List<Contatto> selectAll();

	public Contatto selectById(Integer idContatto);
}
