package com.spring.banca.service;

import java.util.List;

import com.spring.banca.dto.DtoContoCorrente;
import com.spring.banca.dto.DtoUtente;


public interface ServiceUtente {
	public DtoUtente registrati(DtoUtente dto);
	public List<DtoUtente> getAll();
	public DtoUtente addcc(Integer idUtente , DtoContoCorrente dtocc );

}
