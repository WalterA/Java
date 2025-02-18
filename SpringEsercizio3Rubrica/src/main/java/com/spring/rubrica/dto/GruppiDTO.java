package com.spring.rubrica.dto;

import java.util.ArrayList;
import java.util.List;

import com.spring.rubrica.entity.Contatto;

public class GruppiDTO {
	private List<Contatto> contatto = new ArrayList<Contatto>();
	private Integer somma = 0;
	public GruppiDTO(List<Contatto> contatto, Integer somma) {
		super();
		this.contatto = contatto;
		this.somma = somma;
	}
	public List<Contatto> getContatto() {
		return contatto;
	}
	public void setContatto(List<Contatto> contatto) {
		this.contatto = contatto;
	}
	public Integer getSomma() {
		return somma;
	}
	public void setSomma(Integer somma) {
		this.somma = somma;
	}
}
