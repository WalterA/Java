package com.spring.universita.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.universita.entity.Studente;

public class DAOStudenti {
	private Map<Integer, Studente> mappa = new HashMap<>();

	public boolean insert(Studente st) {
		if (!mappa.containsKey(st.getMatricola())) {
			mappa.put(st.getMatricola(), st);
			return true;
		}
		return false;
	}

	public Studente selectBymatricola(int matricola) {
		return mappa.get(matricola);
	}

	public List<Studente> selectAll() {
		return new ArrayList<>(mappa.values());
	}

	public boolean delete(int matricola) {
		if (mappa.get(matricola) != null) {
			mappa.remove(matricola);
			return true;
		}
		return false;
	}

}