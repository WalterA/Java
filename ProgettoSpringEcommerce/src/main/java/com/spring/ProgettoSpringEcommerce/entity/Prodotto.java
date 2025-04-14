package com.spring.ProgettoSpringEcommerce.entity;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Prodotto {
	/*
	 * Il prodotto è definito da descrizione, quantità, prezzo (unitario), sconto
	 * (numero intero, es. 5 indica 5%), categoria.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProdotto;
	private String descrizione;
	private Integer quantita, sconto;
	private Double prezzo;
	
	@ManyToOne
	@JoinColumn(name = "FK_Categoria")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "FK_Venditore")
	private Venditore venditore;
	public Prodotto() {
		// TODO Auto-generated constructor stub
	}
	public Integer getIdProdotto() {
		return idProdotto;
	}
	public void setIdProdotto(Integer idProdotto) {
		this.idProdotto = idProdotto;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Integer getQuantita() {
		return quantita;
	}
	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}
	public Integer getSconto() {
		return sconto;
	}
	public void setSconto(Integer sconto) {
		this.sconto = sconto;
	}
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Venditore getVenditore() {
		return venditore;
	}
	public void setVenditore(Venditore venditore) {
		this.venditore = venditore;
	}
	public Prodotto(Integer idProdotto, String descrizione, Integer quantita, Integer sconto, Double prezzo,
			Categoria categoria, Venditore venditore) {
		super();
		this.idProdotto = idProdotto;
		this.descrizione = descrizione;
		this.quantita = quantita;
		this.sconto = sconto;
		this.prezzo = prezzo;
		this.categoria = categoria;
		this.venditore = venditore;
	}
	

}
