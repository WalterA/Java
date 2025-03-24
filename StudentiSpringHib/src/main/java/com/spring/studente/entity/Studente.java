package com.spring.studente.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Studente {
		@Id
		private Integer matricola;
		
		private String nome, cognome;
		private Integer annoImm;
		
		public Studente() {
			// TODO Auto-generated constructor stub
		}
		public Studente(Integer matricola, String nome, String cognome, Integer annoImm) {
			super();
			this.matricola = matricola;
			this.nome = nome;
			this.cognome = cognome;
			this.annoImm = annoImm;
		}
		public Integer getMatricola() {
			return matricola;
		}
		public void setMatricola(Integer matricola) {
			this.matricola = matricola;
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
		public Integer getAnnoImm() {
			return annoImm;
		}
		public void setAnnoImm(Integer annoImm) {
			this.annoImm = annoImm;
		}
		
}
