	package com.example.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entity.Prodotto;

public interface DaoProdotto extends JpaRepository<Prodotto, Integer>{

}