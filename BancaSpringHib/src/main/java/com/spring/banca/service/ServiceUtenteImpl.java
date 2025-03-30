package com.spring.banca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.banca.dao.DaoUtente;
import com.spring.banca.dto.DtoContoCorrente;
import com.spring.banca.dto.DtoUtente;
import com.spring.banca.entity.ContoCorrente;
import com.spring.banca.entity.Utente;
import com.spring.banca.utility.Converti;

@Service
@Transactional
public class ServiceUtenteImpl implements ServiceUtente {
	@Autowired
	DaoUtente dao;

	@Override
	public DtoUtente registrati(DtoUtente dto) {
		Utente entity = Converti.dtoUtenteaEntityUtente(dto);
		dao.save(entity);
		return Converti.EntityUtenteaDtoUtente(entity);
	}

	@Override
	public List<DtoUtente> getAll() {
		List<Utente> le = dao.findAll();
		return le.stream().map(Converti::EntityUtenteaDtoUtente).collect(Collectors.toList());

		/*
		 * List<DtoUtente> ldto =new ArrayList<DtoUtente>(); for (Utente u : le) {
		 * DtoUtente dto = Converti.EntityUtenteaDtoUtente(u); ldto.add(dto); } return
		 * ldto;
		 */
	}

	@Override
	public DtoUtente addcc(Integer idUtente, DtoContoCorrente dtocc) {
	    try {
	    	if (dtocc == null) {
	            throw new RuntimeException("Dati del conto corrente mancanti");
	           
	        }
	        ContoCorrente cc = Converti.dtoCcaDtoEntityCc(dtocc);
	        Utente u = dao.findById(idUtente)
	                      .orElseThrow(() -> new RuntimeException("Utente non trovato"));
	        boolean esiste = u.getListaConti().add(cc);
	        return esiste ? Converti.EntityUtenteaDtoUtente(u) : new DtoUtente();
	    } catch (RuntimeException e) {
	        // Gestione dell'eccezione: log e restituzione di un DTO con informazioni sull'errore
	        System.err.println("Errore durante l'aggiunta del conto: " + e.getMessage());
	        // In alternativa, potresti impostare un campo "messaggioErrore" o simile in DtoUtente
	        DtoUtente erroreDto = new DtoUtente();
	        // Supponendo che DtoUtente abbia un metodo per impostare un messaggio di errore:
	        return erroreDto;
	    }
	
		/*
		 * List<ContoCorrente> lcc = u.getListaConti(); Utente u = opt.get();
		 * ContoCorrente cc = Converti.dtoCcaDtoEntityCc(dtocc); lcc.add(cc); return
		 * Converti.EntityUtenteaDtoUtente(u);
		 */
	}

	@Override
	public Boolean login(Integer idUtente) {
		Optional<Utente> opt = dao.findById(idUtente);
		return opt.isPresent();
	}

	@Override
	public Boolean prelievo(Integer prelievo, Integer idUtente, Integer idCc) {
		try {
		Utente u = dao.findById(idUtente)
				.orElseThrow(() -> new RuntimeException("Utente non trovato"));
		ContoCorrente cce = u.getListaConti().stream()
				.filter(conto->conto.getIdConto().equals(idCc))
				.findFirst().get();
		if(cce==null) {
			 throw new RuntimeException("Id conto non trovato");
		}else {
			if (cce.getSaldo() >= prelievo) {
				Integer saldoattuale = cce.getSaldo();
				Integer nuovosaldo = saldoattuale - prelievo;
				cce.setSaldo(nuovosaldo);
				List<Integer> movimenti = cce.getMovimenti();
				movimenti.add(-prelievo);
				cce.setMovimenti(movimenti);
				return true;
				}else {
					throw new RuntimeException("Saldo insufficiente");
				}
		}}catch (Exception e) {
			System.err.println("Errore durante l'aggiunta del conto: " + e.getMessage());
			return false;
		}
	
		/*
		Optional<Utente> opt = dao.findById(idUtente);
		Utente u = opt.get();
		List<ContoCorrente> lcc = u.getListaConti();
		Optional<ContoCorrente> cc = lcc.stream().filter(conto -> conto.getIdConto().equals(idCc)).findFirst();
		ContoCorrente cce = cc.get();
		if (cce.getSaldo() > prelievo) {
			Integer saldoattuale = cce.getSaldo();
			Integer nuovosaldo = saldoattuale - prelievo;
			cce.setSaldo(nuovosaldo);
			List<Integer> movimenti = cce.getMovimenti();
			movimenti.add(-prelievo);
			cce.setMovimenti(movimenti);
			return true;
		}
		return false;*/
	}

	@Override
	public Boolean versamento(Integer versamento, Integer idUtente, Integer idCc) {
		Optional<Utente> opt = dao.findById(idUtente);
		Utente u = opt.get();
		List<ContoCorrente> lcc = u.getListaConti();
		Optional<ContoCorrente> cc = lcc.stream().filter(conto -> conto.getIdConto().equals(idCc)).findFirst();
		ContoCorrente cce = cc.get();
		if (versamento != null) {
			Integer saldoattuale = cce.getSaldo();
			Integer nuovosaldo = saldoattuale + versamento;
			cce.setSaldo(nuovosaldo);
			List<Integer> movimenti = cce.getMovimenti();
			movimenti.add(versamento);
			cce.setMovimenti(movimenti);
			return true;
		}
		return false;
	}

	@Override
	public Integer getSaldo(Integer idUtente, Integer idCc) {
		Optional<Utente> opt = dao.findById(idUtente);
		Utente u = opt.get();
		List<ContoCorrente> lcc = u.getListaConti();
		Optional<ContoCorrente> cc = lcc.stream().filter(conto -> conto.getIdConto().equals(idCc)).findFirst();
		DtoContoCorrente cce = Converti.entityCcaDtoCc(cc.get());
		return cce.getSaldo();
	}

	@Override
	public List<Integer> getMovimenti(Integer idUtente, Integer idCc) {
		Optional<Utente> opt = dao.findById(idUtente);
		Utente u = opt.get();
		List<ContoCorrente> lcc = u.getListaConti();
		Optional<ContoCorrente> cc = lcc.stream().filter(conto -> conto.getIdConto().equals(idCc)).findFirst();
		DtoContoCorrente cce = Converti.entityCcaDtoCc(cc.get());
		List<Integer> mov = cce.getMovimenti();
		return mov;
	}

}
