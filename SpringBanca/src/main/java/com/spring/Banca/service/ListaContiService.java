package com.spring.Banca.service;

import java.util.List;

import com.spring.Banca.dto.ContoCorrenteDto;
import com.spring.Banca.dto.UtenteDto;

public interface ListaContiService {
	public void Registrati(UtenteDto udto, ContoCorrenteDto cdto);
	 public List<ContoCorrenteDto> MostraConto (int idu);
}
