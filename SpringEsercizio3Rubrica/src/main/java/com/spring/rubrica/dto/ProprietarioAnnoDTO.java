package com.spring.rubrica.dto;

public class ProprietarioAnnoDTO {
	private String proprietario;
	private int annoDiCreazione;
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public int getAnnoDiCreazione() {
		return annoDiCreazione;
	}
	public void setAnnoDiCreazione(int annoDiCreazione) {
		this.annoDiCreazione = annoDiCreazione;
	}
	public ProprietarioAnnoDTO() {
		super();
	}
	public ProprietarioAnnoDTO(String proprietario, int annoDiCreazione) {
		super();
		this.proprietario = proprietario;
		this.annoDiCreazione = annoDiCreazione;
	}
}
