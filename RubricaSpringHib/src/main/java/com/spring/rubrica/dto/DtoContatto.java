package com.spring.rubrica.dto;

public class DtoContatto {

	private Integer idContatto;
	private String nome, cognome, numero;

	public DtoContatto() {
		// TODO Auto-generated constructor stub
	}

	public DtoContatto(Integer idContatto, String nome, String cognome, String numero) {
		super();
		this.idContatto = idContatto;
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
	}

	public Integer getIdContatto() {
		return idContatto;
	}

	public void setIdContatto(Integer idContatto) {
		this.idContatto = idContatto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
