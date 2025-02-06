package com.spring.base.entity;

public class Utente {
	private Integer id, annoNascita;
	private String nome, cognome, username, password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnnoNascita() {
		return annoNascita;
	}

	public void setAnnoNascita(Integer annoNascita) {
		this.annoNascita = annoNascita;
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

	public Utente(Integer id, Integer annoNascita, String nome, String cognome, String username, String password) {
		this.id = id;
		this.annoNascita = annoNascita;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
	}

	public Utente() {
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", annoNascita=" + annoNascita + ", nome=" + nome + ", cognome=" + cognome
				+ ", username=" + username + ", password=" + password + "]";
	}

}
