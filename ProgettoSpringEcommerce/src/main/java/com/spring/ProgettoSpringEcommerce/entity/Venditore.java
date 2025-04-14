package com.spring.ProgettoSpringEcommerce.entity;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Venditore {
	/*
	 * Il venditore è definito da nome, cognome, username, password, residenza.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVenditore;

	@NotNull
	private String nome, cognome;
	
	@NotBlank(message = "Lo username è obbligatorio")
	@Size(min = 4, max = 20)
	@Column(nullable = false, unique = true)
	private String username;
	
	@NotBlank(message = "La password è obbligatoria")
	@Size(min = 8, message = "La password deve contenere almeno 8 caratteri")
	@Column(nullable = false)
	private String password;
	
	@Embedded
	@NotNull(message = "L'indirizzo di residenza è obbligatorio")
	private Indirizzo residenza;

	@OneToMany(mappedBy = "venditore")
	private ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
public Venditore() {
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Indirizzo getResidenza() {
	return residenza;
}
public void setResidenza(Indirizzo residenza) {
	this.residenza = residenza;
}
public ArrayList<Prodotto> getProdotti() {
	return prodotti;
}
public void setProdotti(ArrayList<Prodotto> prodotti) {
	this.prodotti = prodotti;
}
public Venditore(Integer idVenditore, @NotNull String nome, @NotNull String cognome,
		@NotBlank(message = "Lo username è obbligatorio") @Size(min = 4, max = 20) String username,
		@NotBlank(message = "La password è obbligatoria") @Size(min = 8, message = "La password deve contenere almeno 8 caratteri") String password,
		@NotNull(message = "L'indirizzo di residenza è obbligatorio") Indirizzo residenza,
		ArrayList<Prodotto> prodotti) {
	super();
	this.idVenditore = idVenditore;
	this.nome = nome;
	this.cognome = cognome;
	this.username = username;
	this.password = password;
	this.residenza = residenza;
	this.prodotti = prodotti;
}

}
