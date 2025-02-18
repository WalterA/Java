package com.spring.rubrica.service;

import java.util.List;

import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.GruppiDTO;
import com.spring.rubrica.dto.NomiTotDTO;
import com.spring.rubrica.dto.ProprietarioAnnoDTO;
import com.spring.rubrica.dto.ProprietarioNDTO;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.entity.Contatto;

public interface ServiceRubrica {
	public void registra(RubricaDTO dto);
	public RubricaDTO cercaPerId(int id) ;
	public List<RubricaDTO> mostraTutti();
	public boolean cancella(int id);
	public List<String> getNomiUtenti();
	public void aggiungi(ContattoDTO dto, int idRubrica);
	public ProprietarioAnnoDTO mostraProprietario(int id);
	public RubricaDTO modificaProprietario(int id, String proprietario);
	public RubricaDTO modificaAnno(int id, int anno) ;
	public NomiTotDTO nomietot();
	public RubricaDTO vecchio() ;
	public List<Integer> anno();
	public ProprietarioNDTO mo(int id);
	public ContattoDTO cID (int idcontatto, int idrubrica);
	public 	ContattoDTO modificaContatto(int idrubrica, ContattoDTO dto);
	public Boolean cancella (int idrubrica, int idcontatto);
	public List<Contatto> visualizzaContatti( int  idr);
	public Integer visualizzaNumeri( int  idr) ;
	public ContattoDTO visualcontNum (int idr, int numero);

	public GruppiDTO visualgruppi(int idr, String gruppo);
	public boolean deletegruppi(int idr, String gruppo);
	public boolean preferito(int idrubrica, int idc);
	public List<ContattoDTO> mostraPreferiti(int idr) ;
}
