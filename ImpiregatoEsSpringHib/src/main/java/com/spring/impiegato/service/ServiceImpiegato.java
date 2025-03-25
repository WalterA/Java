package com.spring.impiegato.service;

import java.util.List;

import com.spring.impiegato.dto.DtoImpiegato;
import com.spring.impiegato.entity.Impiegato;

public interface ServiceImpiegato {
	public DtoImpiegato Assumi(DtoImpiegato dto);
	public DtoImpiegato Cerca (Integer matricola);
	public List<DtoImpiegato> GetAll ();
	public DtoImpiegato Delete(Integer matricola);
	public DtoImpiegato AggiornaSalario(Integer matricola, Double newSalario);
	//Avanzato
	public String DeleteNomiCognomi ( Integer matricola);
	public List<DtoImpiegato> GetNomiCognomi();
	public List<DtoImpiegato> GetSalarioMassimo(Double salarioMax);
	public List<DtoImpiegato> OrdinaCognome();
	public List<DtoImpiegato> OrdinaSalario();

	

}
