package com.example.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
/*
 * Il venditore è definito da nome, cognome, username, password, via e città*/
@Entity
public class Venditore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVenditore;
	@OneToMany
	@JoinColumn(name="FK_Prodotto")
	private List<Prodotto> prodotti= new ArrayList<>();
	private String nome,cognome,username,password,via,citta;
	public Venditore() {
		// TODO Auto-generated constructor stub
	}
	public Integer getIdVenditore() {
		return idVenditore;
	}
	public void setIdVenditore(Integer idVenditore) {
		this.idVenditore = idVenditore;
	}
	public List<Prodotto> getProdotti() {
		return prodotti;
	}
	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public Venditore(Integer idVenditore, List<Prodotto> prodotti, String nome, String cognome, String username,
			String password, String via, String citta) {
		super();
		this.idVenditore = idVenditore;
		this.prodotti = prodotti;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.via = via;
		this.citta = citta;
	}
	public Venditore(Integer idVenditore , String nome, String cognome, String username,
			String password, String via, String citta) {
		super();
		this.idVenditore = idVenditore;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.via = via;
		this.citta = citta;
	}
	
}
