package com.spring.Banca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Banca.dao.UtenteDao;
import com.spring.Banca.dto.ContoCorrenteDto;
import com.spring.Banca.dto.UtenteDto;
import com.spring.Banca.entity.ContoCorrente;
import com.spring.Banca.entity.Utente;
import com.spring.Banca.utility.Conversione;

@Service
public class UtenteServiceImpl implements UtenteService {
	@Autowired
	UtenteDao utenteDao;

	public void Registrati(UtenteDto dto) {
		Utente entity = Conversione.daUtenteDTOAUtente(dto);
		utenteDao.insert(entity);
	};

	public List<UtenteDto> MostraLista() {
		List<Utente> lista = utenteDao.selectAll();
		List<UtenteDto> listaDto = new ArrayList<>();
		for (Utente u : lista) {
			UtenteDto dto = Conversione.daUtenteAUtenteDto(u);
			listaDto.add(dto);
		}
		return listaDto;
	};

	public void RegistraConto(UtenteDto dto, ContoCorrenteDto dtocc) {
		Utente entity = Conversione.daUtenteDTOAUtente(dto);
		ContoCorrente entitycc = Conversione.daCcDTOACc(dtocc);
		List<Integer> ucc = entity.getConti();
		ucc.add(entitycc.getId());
		entity.setConti(ucc);
	}
}
