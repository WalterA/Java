package com.spring.utente.service;

import java.util.List;

import com.spring.utente.dto.UtenteDTO;

public interface UtenteService {
	public void registra(UtenteDTO dto);

	public UtenteDTO cercaPerId(int id);

	public List<UtenteDTO> mostraTutti();

	public boolean cancella(int id);

	public UtenteDTO modificaPassword(int id, String password);

	public UtenteDTO aggiorna(UtenteDTO dto);

	public List<String> getNomiUtenti();

}
