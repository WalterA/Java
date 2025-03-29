package com.example.ecommerce.utility;

import java.util.List;
import java.util.stream.Collectors;

import com.example.ecommerce.dto.DtoProdotto;
import com.example.ecommerce.dto.DtoVenditore;
import com.example.ecommerce.entity.Prodotto;
import com.example.ecommerce.entity.Venditore;



public class Converti {

	public static DtoVenditore entityVenditoreaDtoVenditore(Venditore en) {
		DtoVenditore dto = new DtoVenditore(en.getIdVenditore(), en.getNome(), en.getCognome(), en.getUsername(), en.getPassword(), en.getVia(), en.getCitta());
		List<Prodotto> lp = en.getProdotti();
		List<DtoProdotto> ldto = lp.stream().map(prodotto -> Converti.entityProdottoaDtoProdotto(prodotto)).collect(Collectors.toList());
		dto.setProdotti(ldto);
		return dto;
	}
	public static Venditore DtoVenditoreaVenditore(DtoVenditore dto) {
		Venditore v = new Venditore(dto.getIdVenditore(), dto.getNome(), dto.getCognome(), dto.getUsername(), dto.getPassword(), dto.getVia(), dto.getCitta());
		List<DtoProdotto> ldto = dto.getProdotti();
		List<Prodotto> lp = ldto.stream().map(dtoprodotto -> Converti.dtoProdottoaProdotto(dtoprodotto)).collect(Collectors.toList());
		v.setProdotti(lp);
		return v;
	}

	public static DtoProdotto entityProdottoaDtoProdotto(Prodotto pr) {
		return new DtoProdotto(pr.getIdProdotto(), pr.getQuantita(), pr.getPrezzo(), pr.getSconto(), pr.getCategoria());
	}
	public static Prodotto dtoProdottoaProdotto(DtoProdotto dto) {
		return new Prodotto(dto.getIdProdotto(), dto.getQuantita(), dto.getPrezzo(), dto.getSconto(), dto.getCategoria());
	}
	
}
