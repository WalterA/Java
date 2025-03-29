package com.example.ecommerce.service;

import com.example.ecommerce.dto.DtoVenditore;
import com.example.ecommerce.dto.DtoVenditoreBase;
import com.example.ecommerce.entity.Prodotto;
import com.example.ecommerce.entity.Venditore;

public interface ServiceVenditore {
	public DtoVenditore inserisci (Venditore v);
	public DtoVenditore getById (Integer idVenditore);
	public DtoVenditoreBase getByIdBase(Integer IdVenditore);
	public DtoVenditore updatePassword ( Integer idVenditore , String nuovaPassword);
	public Boolean addProdotto(Integer idVenditore, Prodotto p);
	public Boolean updateQuantita(Integer idVenditore, Integer idProdotto, Integer nuovaQuantita);

}
