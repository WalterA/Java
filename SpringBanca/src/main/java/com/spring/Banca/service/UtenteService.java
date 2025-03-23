package com.spring.Banca.service;

import java.util.List;

import com.spring.Banca.dto.UtenteDto;

public interface UtenteService {
	public void Registrati (UtenteDto dto);
	public List<UtenteDto> MostraLista();
}