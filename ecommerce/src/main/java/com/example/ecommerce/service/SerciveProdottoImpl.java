package com.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.dao.DaoProdotto;
import com.example.ecommerce.dto.DtoProdotto;
import com.example.ecommerce.entity.Prodotto;
import com.example.ecommerce.utility.Converti;
@Service
@Transactional
public class SerciveProdottoImpl implements ServiceProdotto {
	@Autowired
	private DaoProdotto dao;

	@Override
	public DtoProdotto registraProdotto(Prodotto pr) {
		dao.save(pr);
		DtoProdotto dto = Converti.entityProdottoaDtoProdotto(pr);
		return dto;
}

	
}
