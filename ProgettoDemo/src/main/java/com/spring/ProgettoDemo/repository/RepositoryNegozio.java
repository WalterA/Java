package com.spring.ProgettoDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.ProgettoDemo.entity.Negozio;

@Repository
public interface RepositoryNegozio extends JpaRepository<Negozio, Integer> {
	
		@Query(nativeQuery = true, value = "select * from Negozio") //esempio di query personalizzata
		List<Negozio> listanegozi ();

		
}
