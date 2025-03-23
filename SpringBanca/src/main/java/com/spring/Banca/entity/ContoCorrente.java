package com.spring.Banca.entity;
/*- numero di CC (intero)
- saldo attuale (intero)
- lista dei movimenti effettuati sul conto (vettore di interi)
- contatore dei movimenti effettuati (intero)
Nel vettore dei movimenti vengono registrati gli importi di
prelievo e versamento (1000, -500, 800, ...).
Il contatore dei movimenti conta il numero dei movimenti
registrati nel vettore.*/

import java.util.ArrayList;
import java.util.List;

public class ContoCorrente {
	private Integer id,cc,saldo,contatore;
	private List<Integer> movimenti;
	
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
	public Integer getContatore() {
		return contatore;
	}
	public void setContatore(Integer contatore) {
		this.contatore = contatore;
	}
	public List<Integer> getMovimenti() {
		return movimenti;
	}
	public void setMovimenti(List<Integer> movimenti) {
		this.movimenti = movimenti;
	}
	public ContoCorrente(Integer id,Integer cc, Integer saldo, Integer contatore, List<Integer> movimenti) {
		super();
		this.id = id;
		this.cc = cc;
		this.saldo = saldo;
		this.contatore = contatore;
		this.movimenti = new ArrayList<Integer>();
	}
	public ContoCorrente() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

}
