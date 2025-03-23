package com.spring.Banca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Banca.dao.ContoCorrenteDao;
import com.spring.Banca.dto.ContoCorrenteDto;
import com.spring.Banca.entity.ContoCorrente;
import com.spring.Banca.utility.Conversione;

@Service
public class ContoCorrenteServiceImpl implements ContoCorrenteService {
	@Autowired
	ContoCorrenteDao ccDao;
	
	public void Registrati(ContoCorrenteDto dto) {
		ContoCorrente entity = Conversione.daCcDTOACc(dto);
		ccDao.insert(entity);
	};
	
	public List<ContoCorrenteDto> MostraLista() {
		List<ContoCorrente> lista = ccDao.selectAll();
		List<ContoCorrenteDto> listaDto = new ArrayList<>();
		for (ContoCorrente c : lista) {
			ContoCorrenteDto dto = Conversione.daCcACcDto(c);
			listaDto.add(dto);
		}
		return listaDto;
	};
	

}
