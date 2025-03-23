package com.spring.Banca.dao;

import java.util.List;

import com.spring.Banca.entity.ContoCorrente;

public interface ContoCorrenteDao {
	public void insert(ContoCorrente cc);
	public boolean delete(Integer id);
	public List<ContoCorrente> selectAll();
	public ContoCorrente selectByid(Integer id);
	public ContoCorrente updateSaldo(ContoCorrente cc,Integer nuovoSaldo );
	public Boolean aggingimovimento ( ContoCorrente cc, Integer prelievo);
}
