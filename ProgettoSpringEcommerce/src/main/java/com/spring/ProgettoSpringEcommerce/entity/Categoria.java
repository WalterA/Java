package com.spring.ProgettoSpringEcommerce.entity;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategoria;
	@NotNull
	private String nome;
	@OneToMany(mappedBy = "categoria")
	private ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
public Categoria() {
	// TODO Auto-generated constructor stub
}
public Integer getIdCategoria() {
	return idCategoria;
}
public void setIdCategoria(Integer idCategoria) {
	this.idCategoria = idCategoria;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public ArrayList<Prodotto> getProdotti() {
	return prodotti;
}
public void setProdotti(ArrayList<Prodotto> prodotti) {
	this.prodotti = prodotti;
}
public Categoria(Integer idCategoria, @NotNull String nome, ArrayList<Prodotto> prodotti) {
	super();
	this.idCategoria = idCategoria;
	this.nome = nome;
	this.prodotti = prodotti;
}

}
