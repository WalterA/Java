package com.spring.Banca.service;

import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Banca.dao.ListaContiDao;
import com.spring.Banca.dto.ContoCorrenteDto;
import com.spring.Banca.dto.UtenteDto;
import com.spring.Banca.entity.ContoCorrente;
import com.spring.Banca.entity.Utente;
import com.spring.Banca.utility.Conversione;

@Service
public class ListaContiServiceImpl implements ListaContiService {
	@Autowired
	ListaContiDao dao;
	ContoCorrenteService service;

	@Override
	public void Registrati(UtenteDto udto, ContoCorrenteDto cdto) {
		Utente uentity = Conversione.daUtenteDTOAUtente(udto);
		ContoCorrente centity = Conversione.daCcDTOACc(cdto);
		dao.Insert(uentity, centity);
	};

	@Override
	public List<ContoCorrenteDto> MostraConto(int idu) {
		List<ContoCorrenteDto> conti = new ArrayList<ContoCorrenteDto>();
		Map<Integer, List<Integer>> lisuc = dao.getAll();
		List<Integer> cc = lisuc.get(idu);
		List<ContoCorrenteDto> ccesistente = service.MostraLista();
		for (ContoCorrenteDto i : ccesistente) {
			if (cc.contains(i.getId())) {
				conti.add(i);
			}
		}
		return conti;
	}

}
