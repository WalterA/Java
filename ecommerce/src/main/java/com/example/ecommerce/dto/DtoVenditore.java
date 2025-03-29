package com.example.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

public class DtoVenditore {
		private Integer idVenditore;
		private List<DtoProdotto> prodotti=new ArrayList<DtoProdotto>();
		private String nome,cognome,username,password,via,citta;
		public DtoVenditore() {
			// TODO Auto-generated constructor stub
		}
		public Integer getIdVenditore() {
			return idVenditore;
		}
		public void setIdVenditore(Integer idVenditore) {
			this.idVenditore = idVenditore;
		}
		public List<DtoProdotto> getProdotti() {
			return prodotti;
		}
		public void setProdotti(List<DtoProdotto> prodotti) {
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
		public DtoVenditore(Integer idVenditore, List<DtoProdotto> prodotti, String nome, String cognome, String username,
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
		public DtoVenditore(Integer idVenditore , String nome, String cognome, String username,
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


