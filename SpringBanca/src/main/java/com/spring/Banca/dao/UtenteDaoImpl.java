package com.spring.Banca.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.Banca.entity.Utente;

@Repository
public class UtenteDaoImpl implements UtenteDao {
	// un domani andrà cancellato ora lo usiamo per simulare un db
	Map<Integer, Utente> listaUtenti = new HashMap<>();

	@Override
	public void insert(Utente u) {
		if (listaUtenti.containsKey((u.getIdUtente()))) {
			throw new RuntimeException("Utente già presente" + u.getIdUtente());
		}
		listaUtenti.put(u.getIdUtente(), u);
	}

	@Override
	public Utente updatePass(Utente u, String pass) {
		if (!listaUtenti.containsKey(u.getIdUtente())) {
			return null;
		}
		listaUtenti.get(u.getIdUtente()).setPassword(pass);
		;
		return listaUtenti.get(u.getIdUtente());
	}

	@Override
	public boolean delete(Integer id) {
		Utente r = listaUtenti.remove(id);
		if (r != null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<Utente> selectAll() {
		return new ArrayList<>(listaUtenti.values());
	}

	@Override
	public Utente selectByid(Integer id) {
		return listaUtenti.get(id);
	}

}
