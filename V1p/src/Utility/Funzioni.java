package Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.management.RuntimeErrorException;

import Entity.Cliente;
import Entity.Negozio;
import Entity.Prodotto;

public class Funzioni {
	public String InsertN(Prodotto p, Negozio n) {
		try {
			Boolean ok = p.getNegozzi().add(n);
			return ok ? "Aggiunto al " 
					+ n.getNegozio() 
					+ " il prodotto " 
					+ p.getNome() : "Non è stato aggiunto";
		} catch (Exception e) {
			throw new RuntimeException("Errore, il prodotto non è stato aggiunto: " + e);
		}
	}

	private static HashMap<Integer, List<Prodotto>> carrello = new HashMap<>();

	public String InsertP(Cliente c, Negozio n, Prodotto p) {
		try {
			if (p.getNegozzi().contains(n)) {
				Boolean ok = carrello.containsKey(c.getId()) ? carrello.get(c.getId()).add(p)
						:carrello.computeIfAbsent(c.getId(),k-> new ArrayList<Prodotto>()).add(p);
				if (ok) {
					return "Prodotto aggiunto" + carrello.get(c.getId());
				} else {
					return "Prodotto non aggiunto";
				}
			} else {
				return "Nel Negozio non vende quel prodotto";
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public void Getprodotti(Cliente c) {
		try {
			Boolean ok = carrello.containsKey(c.getId());
			if (ok) {
			 List<Prodotto> lp =carrello.get(c.getId());
			 for (Prodotto p : lp) {
				 System.out.println("Nome del cliente: "+ c.getNome()+
						 "\n"+"Ha acquistato "+carrello.get(c.getId()).size()+" "+"prodotti"+
						 "\n"+"Nome del prodotto "+p.getNome()+
						 "\n"+"Prezzo: "+p.getPrezzo()+
						 "\n"+"Descrizione: "+p.getDescrizione());
			 }
			} else {
				throw new RuntimeException("Cliente non trovato");
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		

	}
}
