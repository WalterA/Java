package com.spring.impiegato.dto;

public class DtoImpiegato {

	public DtoImpiegato(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}

	private String nome, cognome;
	private Integer matricola;
	private Double salario;

	public DtoImpiegato() {
		// TODO Auto-generated constructor stub
	}

	public DtoImpiegato(String nome, String cognome, Integer matricola, Double salario) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.salario = salario;
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

	public Integer getMatricola() {
		return matricola;
	}

	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

}
