package com.spring.rubrica.dto;

public class ProprietarioNDTO {
	String nome ;
	int somma;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSomma() {
		return somma;
	}
	public void setSomma(int somma) {
		this.somma = somma;
	}
	public ProprietarioNDTO(String nome, int somma) {
		super();
		this.nome = nome;
		this.somma = somma;
	}
	public ProprietarioNDTO() {
		super();
	}

}
