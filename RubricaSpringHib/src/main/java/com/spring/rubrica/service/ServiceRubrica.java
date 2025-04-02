package com.spring.rubrica.service;

import com.spring.rubrica.dto.DtoContatto;
import com.spring.rubrica.dto.DtoRubrica;
import com.spring.rubrica.entity.Contatto;

public interface ServiceRubrica {
	public Boolean creaRubricaVuota(DtoRubrica dto);
	public DtoRubrica cerca(Integer idRubrica);
	public Boolean aggiungiContatto (Integer idRubrica, DtoContatto dtoc);
	public Boolean deleteRubrica(Integer idRubrica);
	public Boolean deleteContatto(Integer idRubrica,Integer idContatto);
	public Boolean upContatto(Integer idRubrica, DtoContatto c);
}
