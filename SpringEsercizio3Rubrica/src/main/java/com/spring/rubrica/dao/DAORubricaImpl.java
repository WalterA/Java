package com.spring.rubrica.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.rubrica.entity.Contatto;
import com.spring.rubrica.entity.Rubrica;

@Repository
public class DAORubricaImpl implements DaoRubrica {
	private Map<Integer, Rubrica> mappa = new HashMap<>();

	public void insert(Rubrica r) {
		if (mappa.containsKey(r.getId()))
			throw new RuntimeException("utente già presente " + r.getId());
		mappa.put(r.getId(), r);
	}

	public boolean delete(Integer idcontatto) {
		Rubrica r = mappa.remove(idcontatto);
		if (r != null)
			return true;
		else
			return false;
	}

	public List<Rubrica> selectAll() {
		return new ArrayList<>(mappa.values());
	}

	public Rubrica selectById(Integer idContatto) {
		return mappa.get(idContatto);
	}


}
