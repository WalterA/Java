package com.spring.banca.dto;

import java.util.ArrayList;
import java.util.List;


public class DtoUtente {
	
		private Integer idutente;
		private String nome,cognome;
		private List<DtoContoCorrente> listaConti = new ArrayList<>();
		public DtoUtente() {
			// TODO Auto-generated constructor stub
		}
		public Integer getIdutente() {
			return idutente;
		}
		public void setIdutente(Integer idutente) {
			this.idutente = idutente;
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
		public List<DtoContoCorrente> getListaConti() {
			return listaConti;
		}
		public void setListaConti(List<DtoContoCorrente> listaConti) {
			this.listaConti = listaConti;
		}
		public DtoUtente(Integer idutente, String nome, String cognome, List<DtoContoCorrente> listaConti) {
			super();
			this.idutente = idutente;
			this.nome = nome;
			this.cognome = cognome;
			this.listaConti = listaConti;
		}
		public DtoUtente(Integer idutente, String nome, String cognome) {
			super();
			this.idutente = idutente;
			this.nome = nome;
			this.cognome = cognome;
		}
		
	}

