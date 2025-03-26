package com.spring.banca.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idutente;
	private String nome,cognome;
	@ManyToMany
	@JoinTable(name = "Conti",
			joinColumns = @JoinColumn (name= "FK_Utente") , 
			inverseJoinColumns = @JoinColumn(name= "FK_ContoCorrente"))
	private List<ContoCorrente> listaConti = new ArrayList<>();
	public Utente() {
		// TODO Auto-generated constructor stub
	}
	public Utente(Integer idutente, String nome, String cognome) {
		super();
		this.idutente = idutente;
		this.nome = nome;
		this.cognome = cognome;
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
	public List<ContoCorrente> getListaConti() {
		return listaConti;
	}
	public void setListaConti(List<ContoCorrente> listaConti) {
		this.listaConti = listaConti;
	}
	public Utente(Integer idutente, String nome, String cognome, List<ContoCorrente> listaConti) {
		super();
		this.idutente = idutente;
		this.nome = nome;
		this.cognome = cognome;
		this.listaConti = listaConti;
	}
	public void aggiungi(ContoCorrente cc) {
		this.listaConti.add(cc);
	}

}
