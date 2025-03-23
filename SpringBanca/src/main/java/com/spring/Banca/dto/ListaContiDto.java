package com.spring.Banca.dto;

public class ListaContiDto {

	public Integer idUtente, idConto;

	public Integer getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}

	public Integer getIdConto() {
		return idConto;
	}

	public void setIdConto(Integer idConto) {
		this.idConto = idConto;
	}

	public ListaContiDto() {
		super();
	}

	public ListaContiDto(Integer idUtente, Integer idConto) {
		super();
		this.idUtente = idUtente;
		this.idConto = idConto;
	}
}
