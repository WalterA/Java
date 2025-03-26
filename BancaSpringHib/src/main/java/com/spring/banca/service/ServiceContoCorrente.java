package com.spring.banca.service;

import java.util.List;

import com.spring.banca.dto.DtoContoCorrente;

public interface ServiceContoCorrente {
	public DtoContoCorrente registrati ( DtoContoCorrente dto);
	public List<DtoContoCorrente> getAll();
}
