package com.spring.prodotto.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.prodotti.entity.Prodotto;

public class ReportDTO {
	private List<String> rep = new ArrayList<String>();
	private int somma, nonDIsponibili;
	private double mediap;
	private List<String> nondisponibili = new ArrayList<String>();
	private Map<String, List<Integer>> totid = new HashMap<>();
	public List<String> getRep() {
		return rep;
	}
	public void setRep(List<String> rep) {
		this.rep = rep;
	}
	public int getSomma() {
		return somma;
	}
	public void setSomma(int somma) {
		this.somma = somma;
	}
	public int getNonDIsponibili() {
		return nonDIsponibili;
	}
	public void setNonDIsponibili(int nonDIsponibili) {
		this.nonDIsponibili = nonDIsponibili;
	}
	public double getMediap() {
		return mediap;
	}
	public void setMediap(double mediap) {
		this.mediap = mediap;
	}
	public List<String> getNondisponibili() {
		return nondisponibili;
	}
	public void setNondisponibili(List<String> nondisponibili) {
		this.nondisponibili = nondisponibili;
	}
	public Map<String, List<Integer>> getTotid() {
		return totid;
	}
	public void setTotid(Map<String, List<Integer>> totid) {
		this.totid = totid;
	}
	public ReportDTO(List<String> rep, int somma, int nonDIsponibili, double mediap, List<String> nondisponibili2,
			Map<String, List<Integer>> totid) {
		this.rep = rep;
		this.somma = somma;
		this.nonDIsponibili = nonDIsponibili;
		this.mediap = mediap;
		nondisponibili = nondisponibili2;
		this.totid = totid;
	}
	public ReportDTO() {
	}

	}

