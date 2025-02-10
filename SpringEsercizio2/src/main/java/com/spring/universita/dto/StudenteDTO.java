package com.spring.universita.dto;

public class StudenteDTO {

	private int matricola, anno, immatricolazione;
	private String nome, cognome, indirizzo;

	public StudenteDTO() {
	}

	public StudenteDTO(int matricola, int anno, int immatricolazione, String nome, String cognome, String indirizzo) {
		this.matricola = matricola;
		this.anno = anno;
		this.immatricolazione = immatricolazione;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getImmatricolazione() {
		return immatricolazione;
	}

	public void setImmatricolazione(int immatricolazione) {
		this.immatricolazione = immatricolazione;
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

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
}
