package com.spring.Banca.service;

import java.util.List;

import com.spring.Banca.dto.ContoCorrenteDto;

public interface ContoCorrenteService {
	public void Registrati(ContoCorrenteDto dto) ;
	public List<ContoCorrenteDto> MostraLista();
}
