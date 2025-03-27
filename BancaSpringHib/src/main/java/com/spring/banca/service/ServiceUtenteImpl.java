package com.spring.banca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		List<DtoUtente> ldto =new ArrayList<DtoUtente>();
		for (Utente u : le) {
			DtoUtente dto = Converti.EntityUtenteaDtoUtente(u);
			ldto.add(dto);
		}
		return ldto;
	}
	
	@Override
	public DtoUtente addcc(Integer idUtente , DtoContoCorrente dtocc ) {
		Optional<Utente> opt = dao.findById(idUtente);
		Utente u = opt.get();
		List<ContoCorrente> lcc = u.getListaConti();
		ContoCorrente cc =  Converti.dtoCcaDtoEntityCc(dtocc);
		lcc.add(cc);
		return Converti.EntityUtenteaDtoUtente(u);
	}

	@Override
	public Boolean login(Integer idUtente) {
		Optional<Utente> opt = dao.findById(idUtente);
		return opt.isPresent();
	}

	@Override
	public Boolean prelievo(Integer prelievo, Integer idUtente, Integer idCc) {
		Optional<Utente> opt = dao.findById(idUtente);
		Utente u = opt.get();
		List<ContoCorrente> lcc = u.getListaConti();
		 Optional<ContoCorrente> cc = lcc.stream()
         .filter(conto -> conto.getIdConto().equals(idCc))
         .findFirst();
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
		return false;
	}

	@Override
	public Boolean versamento(Integer versamento, Integer idUtente, Integer idCc) {
		Optional<Utente> opt = dao.findById(idUtente);
		Utente u = opt.get();
		List<ContoCorrente> lcc = u.getListaConti();
		 Optional<ContoCorrente> cc = lcc.stream()
         .filter(conto -> conto.getIdConto().equals(idCc))
         .findFirst();
		 ContoCorrente cce = cc.get();
		 if (versamento!= null) {
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
		 Optional<ContoCorrente> cc = lcc.stream()
         .filter(conto -> conto.getIdConto().equals(idCc))
         .findFirst();
		 DtoContoCorrente cce = Converti.entityCcaDtoCc(cc.get());
		 return cce.getSaldo();
	}

	@Override
	public List<Integer> getMovimenti(Integer idUtente, Integer idCc) {
		Optional<Utente> opt = dao.findById(idUtente);
		Utente u = opt.get();
		List<ContoCorrente> lcc = u.getListaConti();
		 Optional<ContoCorrente> cc = lcc.stream()
         .filter(conto -> conto.getIdConto().equals(idCc))
         .findFirst();
		 DtoContoCorrente cce = Converti.entityCcaDtoCc(cc.get());
		 List<Integer> mov = cce.getMovimenti();
		 return mov;
	}

}
