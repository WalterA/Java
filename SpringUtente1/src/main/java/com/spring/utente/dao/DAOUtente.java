package com.spring.utente.dao;

import java.util.List;

import com.spring.utente.entity.Utente;

public interface DAOUtente {

	public void insert(Utente utente);

	public boolean delete(Integer idUtente);

	public Utente updatePassword(Integer idUtente, String newPass);

	public Utente selectById(Integer idUtente);

	public Utente update(Utente utente);

	public List<Utente> selectAll();
}
