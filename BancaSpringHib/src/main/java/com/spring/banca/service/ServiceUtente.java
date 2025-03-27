package com.spring.banca.service;

import java.util.List;

import com.spring.banca.dto.DtoContoCorrente;
import com.spring.banca.dto.DtoUtente;


public interface ServiceUtente {
	public DtoUtente registrati(DtoUtente dto);
	public List<DtoUtente> getAll();
	public DtoUtente addcc(Integer idUtente , DtoContoCorrente dtocc );
	public Boolean login(Integer idUtente);
	public Boolean prelievo(Integer prelievo, Integer idUtente, Integer idCc);
	public Boolean versamento(Integer versamento, Integer idUtente, Integer idCc);
	public Integer getSaldo(Integer idUtente, Integer idCc);
	public List<Integer> getMovimenti(Integer idUtente, Integer idCc);

}
