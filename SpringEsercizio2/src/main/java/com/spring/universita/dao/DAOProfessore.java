package com.spring.universita.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.universita.entity.Professore;
import com.spring.universita.entity.Studente;

public class DAOProfessore {
	private Map<Integer, Professore> mappa = new HashMap<>();

	public boolean insert(Professore pr) {
		if (!mappa.containsKey(pr.getId())) {
			mappa.put(pr.getId(), pr);
			return true;
		}
		return false;
	}

	public Professore selectByID(int id) {
		return mappa.get(id);
	}

	public List<Professore> selectAll() {
		return new ArrayList<>(mappa.values());
	}

	public boolean delete(int id) {
		if (mappa.get(id) != null) {
			mappa.remove(id);
			return true;
		}
		return false;
	}
}
