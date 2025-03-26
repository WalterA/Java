package com.spring.banca.utility;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.banca.dto.DtoContoCorrente;
import com.spring.banca.dto.DtoUtente;
import com.spring.banca.entity.ContoCorrente;
import com.spring.banca.entity.Utente;

public class Converti {

	public static DtoContoCorrente entityCcaDtoCc(ContoCorrente entity) {
		return new DtoContoCorrente(entity.getIdConto(), entity.getCc(), entity.getSaldo(), entity.getMovimenti());
	}

	public static ContoCorrente dtoCcaDtoEntityCc(DtoContoCorrente dto) {
		return new ContoCorrente(dto.getIdConto(), dto.getCc(), dto.getSaldo(), dto.getMovimenti());
	}

	public static Utente dtoUtenteaEntityUtente(DtoUtente dto) {
		Utente e = new Utente(dto.getIdutente(), dto.getNome(), dto.getCognome());
		List<DtoContoCorrente> lcc = dto.getListaConti();
		List<ContoCorrente> ldto = lcc.stream().map(conto -> Converti.dtoCcaDtoEntityCc(conto))
				.collect(Collectors.toList());
		e.setListaConti(ldto);
		return e;
	}

	public static DtoUtente EntityUtenteaDtoUtente(Utente entity) {
		DtoUtente dto = new DtoUtente(entity.getIdutente(), entity.getNome(), entity.getCognome());
		List<ContoCorrente> lcc = entity.getListaConti();
		List<DtoContoCorrente> le = lcc.stream().map(conto -> Converti.entityCcaDtoCc(conto))
				.collect(Collectors.toList());
		dto.setListaConti(le);
		return dto;
	}
}
