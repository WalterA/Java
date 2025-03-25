package com.spring.studente.dto;

public class StudenteDTO {

	private Integer matricola;

	private String nome, cognome;
	private Integer annoImm;

	public StudenteDTO() {
		// TODO Auto-generated constructor stub
	}

	public StudenteDTO(Integer matricola, String nome, String cognome, Integer annoImm) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.annoImm = annoImm;
	}

	public Integer getMatricola() {
		return matricola;
	}

	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
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

	public Integer getAnnoImm() {
		return annoImm;
	}

	public void setAnnoImm(Integer annoImm) {
		this.annoImm = annoImm;
	}

}
