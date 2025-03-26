package com.spring.rubrica.service;

import com.spring.rubrica.dto.DtoContatto;
import com.spring.rubrica.dto.DtoRubrica;

public interface ServiceRubrica {
	public Boolean creaRubricaVuota(DtoRubrica dto);
	public DtoRubrica cerca(Integer idRubrica);
	public Boolean aggiungiContatto (Integer idRubrica, DtoContatto dtoc);
}
