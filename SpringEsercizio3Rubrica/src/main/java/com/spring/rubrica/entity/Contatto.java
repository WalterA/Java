package com.spring.rubrica.entity;

public class Contatto {
	private String nome, cognome, gruppoDiAppartenenza, dataDiNascita;
	private int numero, id;
	private boolean preferito=false;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Contatto() {
	}

	public Contatto(String nome, String cognome, String gruppoDiAppartenenza, int numero, String dataDiNascita,
			boolean preferito) {
		this.nome = nome;
		this.cognome = cognome;
		this.gruppoDiAppartenenza = gruppoDiAppartenenza;
		this.numero = numero;
		this.dataDiNascita = dataDiNascita;
		this.preferito = preferito;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getGruppoDiAppartenenza() {
		return gruppoDiAppartenenza;
	}

	public void setGruppoDiAppartenenza(String gruppoDiAppartenenza) {
		this.gruppoDiAppartenenza = gruppoDiAppartenenza;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public boolean isPreferito() {
		return preferito;
	}

	public void setPreferito(boolean preferito) {
		this.preferito = preferito;
	}
}
