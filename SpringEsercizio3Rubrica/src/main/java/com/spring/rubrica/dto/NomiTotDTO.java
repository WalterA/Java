package com.spring.rubrica.dto;

import java.util.ArrayList;
import java.util.List;

public class NomiTotDTO {
	private List<String> l = new ArrayList<String>();
	private int somma = 0;
	public List<String> getL() {
		return l;
	}
	public void setL(List<String> l) {
		this.l = l;
	}
	public int getSomma() {
		return somma;
	}
	public void setSomma(int somma) {
		this.somma = somma;
	}
	public NomiTotDTO(List<String> l, int somma) {
		super();
		this.l = l;
		this.somma = somma;
	}
	public NomiTotDTO() {
		super();
	}
}
