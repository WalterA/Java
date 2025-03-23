package com.spring.Banca.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.Banca.entity.ContoCorrente;
import com.spring.Banca.entity.Utente;

@Repository
public class ListaContiDaoImpl implements ListaContiDao {
	Map<Integer, List<Integer>> ucc = new HashMap<>();

	@Override
	public void Insert(Utente u, ContoCorrente cc) {
		List<Integer> conti = ucc.get(u.getIdUtente());

		if (conti == null) {
			// Se l'utente non ha ancora conti, creiamo una nuova lista
			conti = new ArrayList<>();
			ucc.put(u.getIdUtente(), conti);
		}

		// Aggiungiamo il nuovo conto alla lista
		conti.add(cc.getId());
	}

	@Override
	public boolean deleteU(Integer id) {
	    // Rimuove l'utente dalla mappa e restituisce la lista dei conti (se esiste)
	    List<Integer> removed = ucc.remove(id);

	    // Se la rimozione ha avuto successo (esisteva l'utente), restituisce true
	    return removed != null;
	}

	@Override
	public boolean deleteConto(Integer idUtente, Integer idConto) {
		List<Integer> conti = ucc.get(idUtente);

		if (conti == null || !conti.contains(idConto)) {
			// L'utente non esiste o non ha quel conto
			return false;
		}

		// Rimuove il conto dalla lista
		conti.remove(idConto);

		return true; // Il conto è stato rimosso con successo
	}
	
	@Override
	public Map<Integer, List<Integer>> getAll() {
        return new HashMap<>(ucc); // Restituisce una copia per evitare modifiche esterne
    }

}
