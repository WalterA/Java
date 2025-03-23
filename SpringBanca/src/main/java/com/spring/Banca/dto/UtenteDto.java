package com.spring.Banca.dto;

import java.util.ArrayList;
import java.util.List;

public class UtenteDto {
	
		private Integer idUtente;
		private String nome;
		private String cognome;
		private List<Integer> conti;
		public Integer getIdUtente() {
			return idUtente;
		}
		public void setIdUtente(Integer idUtente) {
			this.idUtente = idUtente;
		}
		public String getNome() {
			return nome;
		}
		public UtenteDto() {
			super();
		}
		public UtenteDto(Integer idUtente, String nome, String cognome, String password, List<Integer> conti) {
			super();
			this.idUtente = idUtente;
			this.nome = nome;
			this.cognome = cognome;
			this.password = password;
			this.conti = new ArrayList<Integer>();
		}
		public List<Integer> getConti() {
			return conti;
		}
		public void setConti(List<Integer> conti) {
			this.conti = conti;
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
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		private String password;
		public UtenteDto(Integer idUtente, String nome, String cognome, List<Integer> conti) {
			super();
			this.idUtente = idUtente;
			this.nome = nome;
			this.cognome = cognome;
			this.conti = conti;
		}
	}
