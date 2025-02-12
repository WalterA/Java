package com.spring.rubrica.entity;

import java.util.ArrayList;

public class Rubrica {
	private String proprietario;
	private int annoDiCreazione, id;
	private ArrayList<Contatto> rubrica = new ArrayList<Contatto>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Rubrica() {
	}

	public Rubrica(String proprietario, int annoDiCreazione, ArrayList<Contatto> rubrica) {
		this.proprietario = proprietario;
		this.annoDiCreazione = annoDiCreazione;
		this.rubrica = rubrica;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public int getAnnoDiCreazione() {
		return annoDiCreazione;
	}

	public void setAnnoDiCreazione(int annoDiCreazione) {
		this.annoDiCreazione = annoDiCreazione;
	}

	public ArrayList<Contatto> getRubrica() {
		return rubrica;
	}

	public void setRubrica(ArrayList<Contatto> rubrica) {
		this.rubrica = rubrica;
	}

}
