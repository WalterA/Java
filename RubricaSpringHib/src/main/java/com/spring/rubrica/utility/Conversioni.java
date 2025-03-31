package com.spring.rubrica.utility;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.rubrica.dto.DtoContatto;
import com.spring.rubrica.dto.DtoRubrica;
import com.spring.rubrica.entity.Contatto;
import com.spring.rubrica.entity.Rubrica;

public class Conversioni {
	public static Contatto daContattoDtoaContatto(DtoContatto dto) {
		return new Contatto(dto.getIdContatto(), dto.getNome(), dto.getCognome(), dto.getNumero());
	}

	public static DtoContatto daContattoaDtoContatto(Contatto contatto) {
		return new DtoContatto(contatto.getIdContatto(), contatto.getNome(), contatto.getCognome(),
				contatto.getNumero());
	}

	public static Rubrica daRubricaDtoaRubrica(DtoRubrica dto) {
		Rubrica rubrica = new Rubrica(dto.getIdRubrica(), dto.getAnnoCreazione(), dto.getProprietario());
		List<DtoContatto> listaD = dto.getContatti();
		List<Contatto> lista = listaD.stream().map(contattoD -> Conversioni.daContattoDtoaContatto(contattoD))
				.collect(Collectors.toList());
		rubrica.setContatti(lista);
		return rubrica;
	}

	public static DtoRubrica daRubricaaRubricaDto(Rubrica entity) {

		List<Contatto> lista = entity.getContatti();
		List<DtoContatto> listaD = lista.stream().map(contatto -> Conversioni.daContattoaDtoContatto(contatto))
				.collect(Collectors.toList());
		System.out.println("size nel dto : " + listaD.size());
		DtoRubrica dto = new DtoRubrica(entity.getIdRubrica(), entity.getAnnoCreazione(), entity.getProprietario(),
				listaD);

		return dto;
	}
}
