package com.spring.banca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.banca.dao.DaoUtente;
import com.spring.banca.dto.DtoContoCorrente;
import com.spring.banca.dto.DtoUtente;
import com.spring.banca.entity.ContoCorrente;
import com.spring.banca.entity.Utente;
import com.spring.banca.utility.Converti;

@Service
@Transactional
public class ServiceUtenteImpl implements ServiceUtente {
	@Autowired
	DaoUtente dao;

	@Override
	public DtoUtente registrati(DtoUtente dto) {
		Utente entity = Converti.dtoUtenteaEntityUtente(dto);
		dao.save(entity);
		return Converti.EntityUtenteaDtoUtente(entity);
	}

	@Override
	public List<DtoUtente> getAll() {
		List<Utente> le = dao.findAll();
		List<DtoUtente> ldto =new ArrayList<DtoUtente>();
		for (Utente u : le) {
			DtoUtente dto = Converti.EntityUtenteaDtoUtente(u);
			ldto.add(dto);
		}
		return ldto;
	}
	
	@Override
	public DtoUtente addcc(Integer idUtente , DtoContoCorrente dtocc ) {
		Optional<Utente> opt = dao.findById(idUtente);
		Utente u = opt.get();
		List<ContoCorrente> lcc = u.getListaConti();
		ContoCorrente cc =  Converti.dtoCcaDtoEntityCc(dtocc);
		lcc.add(cc);
		return Converti.EntityUtenteaDtoUtente(u);
	}

}
