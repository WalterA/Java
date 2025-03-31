package com.spring.rubrica.dto;

import java.util.ArrayList;
import java.util.List;

public class DtoRubrica {
	private Integer idRubrica;
	private Integer annoCreazione;
	private String proprietario;
	private List<DtoContatto> contatti;

	public DtoRubrica() {
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

	public List<DtoContatto> getContatti() {
		return contatti;
	}

	public void setContatti(List<DtoContatto> contatti) {
		this.contatti = contatti;
	}

	public DtoRubrica(Integer idRubrica, Integer annoCreazione, String proprietario, List<DtoContatto> contatti) {
		super();
		this.idRubrica = idRubrica;
		this.annoCreazione = annoCreazione;
		this.proprietario = proprietario;
		this.contatti = contatti;

	}

}
