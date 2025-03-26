package com.spring.banca.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
/*
 * - numero di CC (intero)
- saldo attuale (intero)
- lista dei movimenti effettuati sul conto (vettore di interi)
- contatore dei movimenti effettuati (intero) 
*/
import jakarta.persistence.Id;
@Entity
public class ContoCorrente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConto;
	private Integer cc,saldo;
	private List<Integer> movimenti = new ArrayList<Integer>();

	public ContoCorrente() {
		// TODO Auto-generated constructor stub
	}
	public Integer getIdConto() {
		return idConto;
	}
	public void setIdConto(Integer idConto) {
		this.idConto = idConto;
	}
	public Integer getCc() {
		return cc;
	}
	public void setCc(Integer cc) {
		this.cc = cc;
	}
	public Integer getSaldo() {
		return saldo;
	}
	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}
	public List<Integer> getMovimenti() {
		return movimenti;
	}
	public void setMovimenti(List<Integer> movimenti) {
		this.movimenti = movimenti;
	}
	public Integer getContatore() {
		return movimenti.size();
	}
	
	public ContoCorrente(Integer idConto, Integer cc, Integer saldo, List<Integer> movimenti) {
		super();
		this.idConto = idConto;
		this.cc = cc;
		this.saldo = saldo;
		this.movimenti = movimenti;
		
	}
	
	

}
