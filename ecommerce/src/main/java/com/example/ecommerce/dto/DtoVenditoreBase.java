package com.example.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

public class DtoVenditoreBase {
	private Integer idVenditore;
	private String nome,cognome,username,via,citta;
	public DtoVenditoreBase() {
		// TODO Auto-generated constructor stub
	}
	public Integer getIdVenditore() {
		return idVenditore;
	}
	public void setIdVenditore(Integer idVenditore) {
		this.idVenditore = idVenditore;
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
	public DtoVenditoreBase(Integer idVenditore, String nome, String cognome, String username,
			String via, String citta) {
		super();
		this.idVenditore = idVenditore;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
	
		this.via = via;
		this.citta = citta;
	}
	
}
