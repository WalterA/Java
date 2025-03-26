package com.spring.rubrica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rubrica.dao.DaoRubrica;
import com.spring.rubrica.dto.DtoContatto;
import com.spring.rubrica.dto.DtoRubrica;
import com.spring.rubrica.entity.Rubrica;
import com.spring.rubrica.utility.Conversioni;
@Service
@Transactional
public class ServiceRubricaImpl implements ServiceRubrica {
	@Autowired
	private DaoRubrica dao;
	
	@Override
	public Boolean creaRubricaVuota(DtoRubrica dto) {
		Rubrica entity = Conversioni.daRubricaDtoaRubrica(dto);
		dao.save(entity);
		return true;
	}

	@Override
	public DtoRubrica cerca(Integer idRubrica) {
		Optional<Rubrica> opt = dao.findById(idRubrica);
		if(opt.isPresent()) {
			Rubrica entity = opt.get();
			return Conversioni.daRubricaaRubricaDto(entity);
		}
		return null;
	}

	@Override
	public Boolean aggiungiContatto(Integer idRubrica, DtoContatto dtoc) {
		
		return null;
	}

}
