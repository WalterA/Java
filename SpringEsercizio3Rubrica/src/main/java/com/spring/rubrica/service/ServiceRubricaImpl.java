package com.spring.rubrica.service;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rubrica.dao.DaoRubrica;
import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.NomiTotDTO;
import com.spring.rubrica.dto.ProprietarioAnnoDTO;
import com.spring.rubrica.dto.ProprietarioNDTO;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.entity.Contatto;

import com.spring.rubrica.entity.Rubrica;
import com.spring.rubrica.utility.Conversioni;

@Service
public class ServiceRubricaImpl implements ServiceRubrica {

	@Autowired
	private DaoRubrica dao;

	public void registra(RubricaDTO dto) {
		// trasformo da dto a entity
		Rubrica entity = Conversioni.daUtenteDTOAUtente(dto);

		// chiamo il dao x inserire
		dao.insert(entity);
	}

	public RubricaDTO cercaPerId(int id) {
		// chiamo il dao
		Rubrica rubrica = dao.selectById(id);

		// trasformo da entity a dto
		return Conversioni.daUtenteAUtenteDTO(rubrica);
	}

	public List<RubricaDTO> mostraTutti() {
		// chiamo il dao
		List<Rubrica> lista = dao.selectAll();

		// trasformo
		List<RubricaDTO> listaDto = new ArrayList<>();
		for (Rubrica utente : lista) {
			RubricaDTO dto = Conversioni.daUtenteAUtenteDTO(utente);
			listaDto.add(dto);
		}

		return listaDto;
	}

	public boolean cancella(int id) {
		return dao.delete(id);
	}

	public List<String> getNomiUtenti() {
		List<Rubrica> lista = dao.selectAll();

		List<String> nomi = new ArrayList<>();
		for (Rubrica utente : lista) {
			String nome = utente.getProprietario();
			nomi.add(nome);
		}
		return nomi;
	}

	public void aggiungi(ContattoDTO dto, int idRubrica) {
		Rubrica rubrica = dao.selectById(idRubrica);
		if (rubrica != null) {
			Contatto con = Conversioni.daUtenteDTOAUtente(dto);
			rubrica.getRubrica().add(con);
		}
	}

	public ProprietarioAnnoDTO mostraProprietario(int id) {
		Rubrica rubrica = dao.selectById(id);
		if (rubrica != null) {
			RubricaDTO con = Conversioni.daUtenteAUtenteDTO(rubrica);
			ProprietarioAnnoDTO padto = new ProprietarioAnnoDTO(con.getProprietario(), con.getAnnoDiCreazione());
			return padto;
		}
		return null;
	}

	public RubricaDTO modificaProprietario(int id, String proprietario) {
		Rubrica rubrica = dao.selectById(id);
		if (rubrica != null) {
			rubrica.setProprietario(proprietario);
			RubricaDTO dto = Conversioni.daUtenteAUtenteDTO(rubrica);
			return dto;
		}
		return null;
	}

	public RubricaDTO modificaAnno(int id, int anno) {
		Rubrica rubrica = dao.selectById(id);
		if (rubrica != null) {
			rubrica.setAnnoDiCreazione(anno);
			RubricaDTO dto = Conversioni.daUtenteAUtenteDTO(rubrica);
			return dto;
		}
		return null;
	}

	public NomiTotDTO nomietot() {
		List<Rubrica> lista = dao.selectAll();
		int somma = 0;
		List<String> nomi = new ArrayList<>();
		for (Rubrica utente : lista) {
			String nome = utente.getProprietario();
			nomi.add(nome);
			somma++;
		}
		NomiTotDTO dto = new NomiTotDTO(nomi, somma);
		return dto;
	}

	public RubricaDTO vecchio() {
		List<Rubrica> lista = dao.selectAll();
		int rubricaPiuVecchia = lista.get(0).getAnnoDiCreazione();
		Rubrica r = null;
		for (Rubrica rubrica : lista) {
			if (rubrica.getAnnoDiCreazione() <= rubricaPiuVecchia) {
				rubricaPiuVecchia = rubrica.getAnnoDiCreazione();
				r = rubrica;
			}
		}
		if (r != null) {
			RubricaDTO dto = Conversioni.daUtenteAUtenteDTO(r);
			return dto;
		}
		return null;
	}

	public List<Integer> anno() {
		List<Rubrica> lista = dao.selectAll();
		List<Integer> annocre = new ArrayList<Integer>();
		for (Rubrica rubrica : lista) {
			annocre.add(rubrica.getAnnoDiCreazione());
		}
		annocre.sort(Comparator.reverseOrder());
		return annocre;
	}

	public ProprietarioNDTO mo(int id) {
		Rubrica r = dao.selectById(id);
		List<Contatto> n = r.getRubrica();
		return new ProprietarioNDTO(r.getProprietario(), n.size());
	}

	public ContattoDTO cID (int idcontatto, int idrubrica) {
		Rubrica r =dao.selectById(idrubrica);
		List<Contatto> c = r.getRubrica();
		for (Contatto ci : c) {
			if(ci.getId()== idcontatto) {
				ContattoDTO dto = Conversioni.daUtenteAUtenteDTO(ci);
				return dto;
			}
		}
		return null;
	}

	public 	ContattoDTO modificaContatto(int idrubrica, ContattoDTO dto) {
		Rubrica r =dao.selectById(idrubrica);
		List<Contatto> c = r.getRubrica();
		for (Contatto ci : c) {
			if(ci.getId()== dto.getId()) {
				ci.setCognome(dto.getCognome());
				ci.setNome(dto.getNome());
				ci.setDataDiNascita(dto.getDataDiNascita());
				ci.setGruppoDiAppartenenza(dto.getGruppoDiAppartenenza());
				ContattoDTO dto1 = Conversioni.daUtenteAUtenteDTO(ci);
				return dto1;
			}
	}
	return null;
}
	public Boolean cancella (int idrubrica, int idcontatto) {
		Rubrica r =dao.selectById(idrubrica);
		List<Contatto> c = r.getRubrica();
		for (Contatto ci : c) {
			if(ci.getId()== idcontatto) {
				dao.delete(idcontatto);
				return true;
			}
	}
		return false;
	
	
}
}

