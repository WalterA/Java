package com.example.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.dao.DaoVenditore;
import com.example.ecommerce.dto.DtoVenditore;
import com.example.ecommerce.dto.DtoVenditoreBase;
import com.example.ecommerce.entity.Prodotto;
import com.example.ecommerce.entity.Venditore;
import com.example.ecommerce.utility.Converti;

@Service
@Transactional
public class ServiceVenditoreImpl implements ServiceVenditore {
	@Autowired
	private DaoVenditore dao;

	@Override
	public DtoVenditore inserisci(Venditore v) {
		dao.save(v);
		DtoVenditore dto = Converti.entityVenditoreaDtoVenditore(v);
		return dto;
	}

	@Override
	public DtoVenditore getById(Integer idVenditore) {
		Optional<Venditore> opt = dao.findById(idVenditore);
		Venditore v = opt.get();
		DtoVenditore dto = Converti.entityVenditoreaDtoVenditore(v);
		return dto;
	}

	@Override
	public DtoVenditoreBase getByIdBase(Integer IdVenditore) {
		Optional<Venditore> opt = dao.findById(IdVenditore);
		Venditore v = opt.get();
		DtoVenditoreBase dto = new DtoVenditoreBase(v.getIdVenditore(), v.getNome(), v.getCognome(), v.getUsername(),
				v.getVia(), v.getCitta());
		return dto;
	}

	@Override
	public DtoVenditore updatePassword(Integer idVenditore, String nuovaPassword) {
		Optional<Venditore> opt = dao.findById(idVenditore);
		Venditore v = opt.get();
		v.setPassword(nuovaPassword);
		DtoVenditore dto = Converti.entityVenditoreaDtoVenditore(v);
		return dto;
	}

	@Override
	public Boolean addProdotto(Integer idVenditore, Prodotto p) {
		try {
			Optional<Venditore> opt = dao.findById(idVenditore);
			Venditore v = opt.get();
			List<Prodotto> lp = v.getProdotti();
			lp.add(p);
			v.setProdotti(lp);
			DtoVenditore dto = Converti.entityVenditoreaDtoVenditore(v);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateQuantita(Integer idVenditore, Integer idProdotto, Integer nuovaQuantita) {
		try {
			Optional<Venditore> opt = dao.findById(idVenditore);
			Venditore v = opt.get();
			List<Prodotto> lp = v.getProdotti();
			for (Prodotto p : lp) {
				if (p.getIdProdotto() == idProdotto) {
					p.setQuantita(nuovaQuantita);
				}
			}
			v.setProdotti(lp);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
