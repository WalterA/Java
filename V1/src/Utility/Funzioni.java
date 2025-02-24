package Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Entity.Cliente;
import Entity.Negozio;
import Entity.Prodotto;

public class Funzioni {
	public String InsertN(Prodotto p, Negozio n) {
		p.getNegozzi().add(n);
		return "Aggiunto al " + n.getNegozio() + " il prodotto " + p.getNome();
	}

	private static HashMap<Integer, List<String>> carrello = new HashMap<>();

	public String InsertP(Cliente c, Prodotto p) {
		if (carrello.containsKey(c.getId())) {
			List<String> prodotti = carrello.get(c.getId());
			prodotti.add(p.getNome());
		} else {
			List<String> nuovaListaProdotti = new ArrayList<>();
			nuovaListaProdotti.add(p.getNome());
			carrello.put(c.getId(), nuovaListaProdotti);
		}
		return "Prodotto aggiunto: " + p.getNome() + " per il cliente con ID: " + c.getId();
	}

	public List<String> Getprodotti(Cliente c) {
		if (carrello.containsKey(c.getId())) {
			List<String> prodotti = carrello.get(c.getId());
			return  prodotti.stream().collect(Collectors.toList());
		}
		return null;
	}
}
