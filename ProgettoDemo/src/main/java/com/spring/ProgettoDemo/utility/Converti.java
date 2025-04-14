package com.spring.ProgettoDemo.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.spring.ProgettoDemo.dto.DtoNegozio;
import com.spring.ProgettoDemo.dto.DtoProdotto;
import com.spring.ProgettoDemo.dto.DtoRegistraNegozio;
import com.spring.ProgettoDemo.entity.Negozio;
import com.spring.ProgettoDemo.entity.Prodotto;

public class Converti {
	public static Negozio convertiDtoNegozio(DtoRegistraNegozio dtor) {
		Negozio n = new Negozio(dtor.getId(), dtor.getNome(), dtor.getEmail(), dtor.getPassword(), new ArrayList<>());

		// Conversione dei prodotti da DTO a Entity, associandoli al negozio
		if (dtor.getProdotti() != null) {
			List<Prodotto> prodotti = dtor.getProdotti().stream()
					.map(dtoProdotto -> convertiDtoProdotto(dtoProdotto))
					.collect(Collectors.toList());
			n.setProdotti(prodotti);
		}

		return n;
	}

	public static Prodotto convertiDtoProdotto(DtoProdotto dto) {
		Prodotto p = new Prodotto();
		p.setId(dto.getId());
		p.setNome(dto.getNome());

		// Se vuoi associare anche il negozio (solo ID), crei una "stub entity"
		if (dto.getNegozioId() != null) {
			Negozio n = new Negozio();
			n.setId(dto.getNegozioId());
			p.setNegozio(n);
		}

		return p;
	}

	public static DtoProdotto convertiProdotto(Prodotto p) {
		return new DtoProdotto(p.getId(), p.getNome(), p.getNegozio().getId());
	}

	public static DtoNegozio convertiNegozio(Negozio n) {
		DtoNegozio dto = new DtoNegozio();
		dto.setEmail(n.getEmail());
		dto.setId(n.getId());
		dto.setNome(n.getNome());

		// Verifica se il Negozio ha dei prodotti
		if (n.getProdotti() != null) {
			// Converte ogni Prodotto in DtoProdotto e raccoglie i risultati in una lista
			List<DtoProdotto> listaProdotto = n.getProdotti().stream()
					.map(prodotto -> {
				// Converte il Prodotto in DtoProdotto
				DtoProdotto p = convertiProdotto(prodotto);
				return p; // Restituisci il DtoProdotto
			}).collect(Collectors.toList()); // Raccoglie il risultato in una lista

			// Aggiungi la lista di DtoProdotto al DtoNegozio
			dto.setProdotti(listaProdotto);
		}

		return dto;
	}

}
