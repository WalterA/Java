package com.spring.Banca.dao;

import java.util.List;

import com.spring.Banca.entity.Utente;

public interface UtenteDao {
	public void insert(Utente u );
	public Utente updatePass(Utente u, String pass);
	public boolean delete(Integer id);
	public List<Utente> selectAll();
	public Utente selectByid(Integer id );
}
