package com.spring.banca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.banca.dao.DaoContoCorrente;
import com.spring.banca.dto.DtoContoCorrente;
import com.spring.banca.entity.ContoCorrente;
import com.spring.banca.utility.Converti;
@Service
@Transactional
public class ServiceContoCorrenteImpl implements ServiceContoCorrente {
	@Autowired
	DaoContoCorrente dao;
	@Override
	public DtoContoCorrente registrati(DtoContoCorrente dto) {
		ContoCorrente cc = Converti.dtoCcaDtoEntityCc(dto);
		dao.save(cc);
		return Converti.entityCcaDtoCc(cc);
	}

	@Override
	public List<DtoContoCorrente> getAll() {
		List<ContoCorrente> lcc= dao.findAll();
		List<DtoContoCorrente> ldto = new ArrayList<DtoContoCorrente>();
		for(ContoCorrente cc : lcc) {
			DtoContoCorrente dto = Converti.entityCcaDtoCc(cc);
			ldto.add(dto);
		}
		return ldto;
	}

}
