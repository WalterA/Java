package com.spring.universita.dto;

public class ProfessoreDTO {
		private int id;
		private String nome,cognome,materia;
		public ProfessoreDTO() {
		}
		public ProfessoreDTO(int id, String nome, String cognome, String materia) {
			this.id = id;
			this.nome = nome;
			this.cognome = cognome;
			this.materia = materia;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
		public String getMateria() {
			return materia;
		}
		public void setMateria(String materia) {
			this.materia = materia;
		}
	}


