package com.example.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entity.Venditore;

public interface DaoVenditore extends JpaRepository<Venditore,Integer> {
	
}