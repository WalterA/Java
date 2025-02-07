package com.spring.prodotto.service;

import java.util.ArrayList;
import java.util.List;

import com.spring.prodotti.dao.DAOProdotti;
import com.spring.prodotti.entity.Prodotto;
import com.spring.prodotto.dto.ProdottoDTO;
import com.spring.prodotto.utility.Conversioni;


public class Service {
	private DAOProdotti dao = new DAOProdotti();

	public void registra(ProdottoDTO dto) {

		Prodotto entity = Conversioni.daUtenteDTOaUtente(dto);

		dao.insert(entity);
	}

	public List<ProdottoDTO> mostraTutti() {
		List<Prodotto> lista = dao.selectAll();
		List<ProdottoDTO> listaDto = new ArrayList<>();
		for (Prodotto prodotto : lista) {
			ProdottoDTO dto = Conversioni.daUtenteaUtenteDTO(prodotto);
			listaDto.add(dto);
		}
		return listaDto;

	}

	public ProdottoDTO cercaPerID(int id) {
		Prodotto utente = dao.selectById(id);
		ProdottoDTO ut = Conversioni.daUtenteaUtenteDTO(utente);
		return ut;
	}

}
