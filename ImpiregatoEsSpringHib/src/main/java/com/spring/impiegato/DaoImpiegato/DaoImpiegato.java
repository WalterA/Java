package com.spring.impiegato.DaoImpiegato;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.impiegato.entity.Impiegato;

public interface DaoImpiegato extends JpaRepository<Impiegato, Integer> {
	@Query(nativeQuery = true, value = "SELECT * FROM impiegato WHERE salario > :salario")
	List<Impiegato> findBySalarioMaggioreDi(Double salario);

	@Query(nativeQuery = true, value = "SELECT * FROM impiegato ORDER BY cognome ASC")
	List<Impiegato> findAllOrderByCognome();

	@Query(nativeQuery = true, value = "SELECT * FROM impiegato ORDER BY salario ASC")
	List<Impiegato> findAllOrderBySalario();

}
