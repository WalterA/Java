package com.spring.Banca.dao;

import java.util.List;
import java.util.Map;

import com.spring.Banca.entity.ContoCorrente;
import com.spring.Banca.entity.Utente;

public interface ListaContiDao {
	public void Insert(Utente u, ContoCorrente cc) ;
	public boolean deleteU(Integer id);
	public boolean deleteConto(Integer idUtente, Integer idConto);
	public Map<Integer, List<Integer>> getAll();
}
