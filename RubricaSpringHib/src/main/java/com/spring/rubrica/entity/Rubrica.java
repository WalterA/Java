package com.spring.rubrica.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Rubrica {
	@Id
	private Integer idRubrica;
	private Integer annoCreazione;
	private String proprietario;
	@OneToMany
	@JoinColumn(name="FK_Rubrica")
	private List<Contatto> contatti;
public Rubrica() {
	// TODO Auto-generated constructor stub
}
public Integer getIdRubrica() {
	return idRubrica;
}
public void setIdRubrica(Integer idRubrica) {
	this.idRubrica = idRubrica;
}
public Integer getAnnoCreazione() {
	return annoCreazione;
}
public void setAnnoCreazione(Integer annoCreazione) {
	this.annoCreazione = annoCreazione;
}
public String getProprietario() {
	return proprietario;
}
public void setProprietario(String proprietario) {
	this.proprietario = proprietario;
}
public List<Contatto> getContatti() {
	return contatti;
}
public Rubrica(Integer idRubrica, Integer annoCreazione, String proprietario) {
	super();
	this.idRubrica = idRubrica;
	this.annoCreazione = annoCreazione;
	this.proprietario = proprietario;
}
public void setContatti(List<Contatto> contatti) {
	this.contatti = contatti;
}
public Rubrica(Integer idRubrica, Integer annoCreazione, String proprietario, List<Contatto> contatti) {
	super();
	this.idRubrica = idRubrica;
	this.annoCreazione = annoCreazione;
	this.proprietario = proprietario;
	this.contatti = (this.contatti == null) ? new ArrayList<Contatto>() : this.contatti;

}
//in questo entity aggiungo anche delle funzioni di business
public void aggiungi(Contatto contatto) {
	this.contatti.add(contatto);
}

}

