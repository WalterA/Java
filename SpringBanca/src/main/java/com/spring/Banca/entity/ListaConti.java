package com.spring.Banca.entity;

public class ListaConti {
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

	public ListaConti() {
		super();
	}

	public ListaConti(Integer idUtente, Integer idConto) {
		super();
		this.idUtente = idUtente;
		this.idConto = idConto;
	}
}
