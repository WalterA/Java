package com.spring.prodotto.utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.prodotti.dao.DAOProdotti;
import com.spring.prodotti.entity.Prodotto;
import com.spring.prodotto.dto.ProdottoDTO;
import com.spring.prodotto.dto.ReportDTO;

public class Conversioni {
	private DAOProdotti dao = new DAOProdotti();
	public static Prodotto daUtenteDTOaUtente(ProdottoDTO dto) {
		return new Prodotto(dto.getId(), dto.getQuantita(), dto.getPrezzoConsigliato(), dto.getPrezzoMassimo(), dto.getMarca(), dto.getModello(), dto.getDescrizione(), dto.getCategoria());
	}
	public static ProdottoDTO daUtenteaUtenteDTO(Prodotto ut) {
		return new ProdottoDTO(ut.getId(), ut.getQuantita(), ut.getPrezzoConsigliato(), ut.getPrezzoMassimo(), ut.getMarca(), ut.getModello(), ut.getDescrizione(), ut.getCategoria());
	}
	public static ReportDTO generaReportDaProdotti(Collection<Prodotto> prodotti) {
		
		List<String> rep = new ArrayList<String>();
		int somma=0;
		int nonDIsponibili=0;
		Double mediap=0.0;
		Double tot=0.0;
		List<String> nondisponibili = new ArrayList<String>();
		Map<String, List<Integer>> totid = new HashMap<>();
		
		for (Prodotto prodotto : prodotti ) {
			rep.add(prodotto.getDescrizione());
			if (prodotto.getQuantita() != 0) {
			somma += prodotto.getQuantita();
			
			}
			else {
				
			nonDIsponibili++;
			nondisponibili.add(prodotto.getDescrizione());
		}
			if (totid.containsKey(prodotto.getCategoria())){
				totid.get(prodotto.getCategoria()).add(prodotto.getId());			
			} else {
			totid.put(prodotto.getCategoria(),new ArrayList<Integer>());
			totid.get(prodotto.getCategoria()).add(prodotto.getId());			
		}
			tot += prodotto.getPrezzoConsigliato();
	}
		
		return new  ReportDTO(rep, somma, nonDIsponibili, mediap, nondisponibili, totid);
}}
