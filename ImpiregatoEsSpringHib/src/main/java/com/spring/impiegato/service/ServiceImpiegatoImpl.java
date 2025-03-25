package com.spring.impiegato.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.impiegato.DaoImpiegato.DaoImpiegato;
import com.spring.impiegato.dto.DtoImpiegato;
import com.spring.impiegato.entity.Impiegato;

@Service
@Transactional
public class ServiceImpiegatoImpl implements ServiceImpiegato {
	@Autowired
	DaoImpiegato dao;

	@Override
	public DtoImpiegato Assumi(DtoImpiegato dto) {
		Impiegato im = new Impiegato(dto.getNome(), dto.getCognome(), dto.getMatricola(), dto.getSalario());
		Impiegato i =dao.save(im);
		DtoImpiegato newdto = new DtoImpiegato(i.getNome(), i.getCognome(), i.getMatricola(), i.getSalario());
		return newdto;
	}

	@Override
	public DtoImpiegato Cerca(Integer matricola) {
		Optional<Impiegato> i = dao.findById(matricola);
		Impiegato im = i.get();
		DtoImpiegato dto = new DtoImpiegato(im.getNome(), im.getCognome(), im.getMatricola(), im.getSalario());
		return dto;
	}

	@Override
	public List<DtoImpiegato> GetAll() {
		List<Impiegato> le= dao.findAll();
		List<DtoImpiegato> ldto = new ArrayList<DtoImpiegato>(); 
		for (Impiegato i : le) {
			DtoImpiegato dto = new DtoImpiegato(i.getNome(), i.getCognome(), i.getMatricola(), i.getSalario());
			ldto.add(dto);
		}
		return ldto;
	}

	@Override
	public DtoImpiegato Delete(Integer matricola) {
		Optional<Impiegato> i = dao.findById(matricola);
		Impiegato im = i.get();
		dao.delete(im);
		DtoImpiegato dto = new DtoImpiegato(im.getNome(), im.getCognome(), im.getMatricola(),im.getSalario());
		return dto;
	}

	@Override
	public DtoImpiegato AggiornaSalario(Integer matricola, Double newSalario) {
		Optional<Impiegato> i = dao.findById(matricola);
		Impiegato im = i.get();
		im.setSalario(newSalario);
		dao.save(im);
		DtoImpiegato dto = new DtoImpiegato(im.getNome(), im.getCognome(), im.getMatricola(), im.getSalario());
		return dto;
	}

	@Override
	public String DeleteNomiCognomi(Integer matricola) {
		Optional<Impiegato> i = dao.findById(matricola);
		Impiegato im = i.get();
		dao.delete(im);
		DtoImpiegato dto = new DtoImpiegato(im.getNome(), im.getCognome(), im.getMatricola(),im.getSalario());
		return dto.getNome()+dto.getCognome();
	}

	@Override
	public List<DtoImpiegato> GetNomiCognomi() {
		List<Impiegato> le= dao.findAll();
		List<DtoImpiegato> ldto = new ArrayList<DtoImpiegato>(); 
		for (Impiegato i : le) {
			DtoImpiegato dto = new DtoImpiegato(i.getNome(), i.getCognome());
			ldto.add(dto);
		}
		return ldto;
	}
/*
	@Override
	public List<DtoImpiegato> GetSalarioMassimo(Double salarioMax) {
		
		return null;
	}

	@Override
	public List<DtoImpiegato> OrdinaCognome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DtoImpiegato> OrdinaSalario() {
		// TODO Auto-generated method stub
		return null;
	}
	*/

}
