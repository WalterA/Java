package com.example.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
/*
 * Il prodotto è definito da descrizione, quantità, prezzo (unitario), sconto
(numero intero, es. 5 indica 5%) e categoria*/
import jakarta.persistence.Id;
@Entity
public class Prodotto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProdotto;
	private Integer quantita;
	private Integer prezzo;
	private Integer sconto;
	private String categoria;
	public Prodotto() {
		// TODO Auto-generated constructor stub
	}
	public Integer getIdProdotto() {
		return idProdotto;
	}
	public void setIdProdotto(Integer idProdotto) {
		this.idProdotto = idProdotto;
	}
	public Integer getQuantita() {
		return quantita;
	}
	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}
	public Integer getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}
	public Integer getSconto() {
		return sconto;
	}
	public void setSconto(Integer sconto) {
		this.sconto = sconto;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Prodotto(Integer idProdotto, Integer quantita, Integer prezzo, Integer sconto, String categoria) {
		super();
		this.idProdotto = idProdotto;
		this.quantita = quantita;
		this.prezzo = prezzo;
		this.sconto = sconto;
		this.categoria = categoria;
	}
	
	

}
