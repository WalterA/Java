package com.spring.Banca.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.Banca.entity.ContoCorrente;
import com.spring.Banca.entity.Utente;


@Repository
public class ContoCorrenteDaoImpl implements ContoCorrenteDao {
	Map<Integer, ContoCorrente> lcc = new HashMap<>();
	
	
	@Override
	public void insert(ContoCorrente cc) {
		if(lcc.containsKey((cc.getId()))) {
			throw new RuntimeException("Cc già presente"+ cc.getId());
		}
		lcc.put(cc.getId(), cc);
	}
	@Override
	public boolean delete(Integer id) {
		ContoCorrente cc = lcc.remove(id);
		return cc != null;
	}
	@Override
	public List<ContoCorrente> selectAll() {
		return new ArrayList<>(lcc.values());
	}

	@Override
	public ContoCorrente selectByid(Integer id) {
		return lcc.get(id);
	}
	@Override
	public ContoCorrente updateSaldo(ContoCorrente cc,Integer nuovoSaldo ) {
		if(!lcc.containsKey(cc.getId())) {
			return null;
		}
		lcc.get(cc.getId()).setSaldo(nuovoSaldo);
		return lcc.get(cc.getId());
	}
	
	@Override
	public Boolean aggingimovimento ( ContoCorrente cc, Integer prelievo) {
		List<Integer> movimenti = cc.getMovimenti();
		Integer conta = cc.getContatore();
		if(movimenti==null) {
			return false;
		}
		movimenti.add(prelievo);
		cc.setMovimenti(movimenti);
		conta++;
		cc.setContatore(conta);
		return true;
		
		
	}
	

}
