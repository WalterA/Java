package com.spring.rubrica.dao;

import java.util.List;


import com.spring.rubrica.entity.Rubrica;

public interface DaoRubrica {
	public void insert(Rubrica r);

	public boolean delete(Integer idcontatto);

	public List<Rubrica> selectAll();

	public Rubrica selectById(Integer idContatto);
	public boolean deleteContatto(Integer idc,Integer idr) ;
	public boolean deleteGruppi(String gruppo, Integer idr);
}
