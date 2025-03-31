package com.spring.rubrica.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rubrica.dao.DaoRubrica;
import com.spring.rubrica.dto.DtoContatto;
import com.spring.rubrica.dto.DtoRubrica;
import com.spring.rubrica.entity.Contatto;
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
		if (opt.isPresent()) {
			Rubrica entity = opt.get();
			System.out.println("size " +entity.getContatti().size());
			return Conversioni.daRubricaaRubricaDto(entity);
		}
		return null;
	}

	@Override
	public Boolean aggiungiContatto(Integer idRubrica, DtoContatto dtoc) {
		dao.findById(idRubrica).get().aggiungi(Conversioni.daContattoDtoaContatto(dtoc));
		return true;
	}

	@Override
	public Boolean deleteRubrica(Integer idRubrica) {
		try {
			Boolean esatto = dao.findById(idRubrica).isPresent();
			if (esatto) {
				dao.deleteById(idRubrica);
				return esatto;
			} else {
				return esatto;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean deleteContatto(Integer idRubrica, Integer idContatto) {
		try {
			Boolean esatto = dao.findById(idRubrica).isPresent();
			if (esatto) {
				List<Contatto> lc = dao.findById(idRubrica).get().getContatti();
				Optional<Contatto> opt = lc.stream().filter(c -> c.getIdContatto() == idContatto).findFirst();
				Contatto c = opt.get();
				lc.remove(c);
				return esatto;
			} else
				throw new RuntimeException("id rubrica non presente");

		} catch (Exception e) {
			throw new RuntimeException("id contatto non presente");
		}

	}
	
	@Override
	public Boolean upContatto(Integer idRubrica, DtoContatto c) {
		try {
			Boolean esatto= dao.findById(idRubrica).isPresent();
			if(esatto) {
				List<Contatto> lc =dao.findById(idRubrica).get().getContatti();
				Optional<Contatto> opt =lc.stream().filter(k->k.getIdContatto()==c.getIdContatto()).findFirst();
				Contatto entity = opt.get();
				Conversioni
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
