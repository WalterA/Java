package com.spring.ProgettoSpringEcommerce.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Indirizzo {

    private String via;
    private String cap;
    private String citta;
    private String paese;
    public Indirizzo() {
		// TODO Auto-generated constructor stub
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getPaese() {
		return paese;
	}
	public void setPaese(String paese) {
		this.paese = paese;
	}
	public Indirizzo(String via, String cap, String citta, String paese) {
		super();
		this.via = via;
		this.cap = cap;
		this.citta = citta;
		this.paese = paese;
	}
    
}
