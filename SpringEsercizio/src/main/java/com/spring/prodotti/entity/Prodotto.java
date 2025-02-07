package com.spring.prodotti.entity;

public class Prodotto {
	private int id,quantita;
	private Double prezzoConsigliato, prezzoMassimo;
	private String marca,modello,descrizione, categoria;
	public Prodotto() {
	}
	public Prodotto(int id, int quantita, Double prezzoConsigliato, Double prezzoMassimo, String marca, String modello,
			String descrizione, String categoria) {
		this.id = id;
		this.quantita = quantita;
		this.prezzoConsigliato = prezzoConsigliato;
		this.prezzoMassimo = prezzoMassimo;
		this.marca = marca;
		this.modello = modello;
		this.descrizione = descrizione;
		this.categoria = categoria;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public Double getPrezzoConsigliato() {
		return prezzoConsigliato;
	}
	public void setPrezzoConsigliato(Double prezzoConsigliato) {
		this.prezzoConsigliato = prezzoConsigliato;
	}
	public Double getPrezzoMassimo() {
		return prezzoMassimo;
	}
	public void setPrezzoMassimo(Double prezzoMassimo) {
		this.prezzoMassimo = prezzoMassimo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
