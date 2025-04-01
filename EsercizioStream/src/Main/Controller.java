package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.processing.SupportedSourceVersion;

import Entity.Categoria;
import Entity.Prodotto;

public class Controller{

	public static void main(String[] args) {
		ArrayList<Prodotto> catalogo = new ArrayList<Prodotto>();
		 catalogo.add(new Prodotto(101, 50, 10, "Latte intero", Categoria.alimentare, true, 1.5));
		 
	     catalogo.add(new Prodotto(103, 20, 0, "Maglietta cotone", Categoria.abbigliamento, true, 0.1));
	     catalogo.add(new Prodotto(104, 10, 15, "Cuffie wireless", Categoria.elettronica, true, 50.0));
	     catalogo.add(new Prodotto(105, 0, 20, "Smartphone 5G", Categoria.elettronica, false, 700.0));
	  
	    System.out.println("Il numero di categorie");
		     long numeroCategorieDistinte = catalogo.stream()
		    		    .map(Prodotto::getCategoria)
		    		    .distinct()
		    		    .count();

	    		System.out.println(numeroCategorieDistinte);
	
	    System.out.println("Le categorie ordinate in ordine alfabetico, senza elementi doppi");
	    	catalogo.stream()
	    				.map(Prodotto::getCategoria)
	    				.distinct()
	    				.sorted(Comparator.comparing(Enum::name))
	    				.forEach(System.out::println);
	  
	    System.out.println("I nomi dei prodotti ordinati per prezzo crescente");
	    	catalogo.stream()
	                 .sorted(Comparator.comparingDouble(Prodotto::getPrezzo))
	                 .map(Prodotto::getDescrizione)
	                 .forEach(System.out::println);

	    System.out.println("I prodotti ordinati in base allo sconto");
	    	
	    	List<Prodotto> lp= catalogo.stream()
	    			.sorted(Comparator.comparingInt(Prodotto::getSconto))
	    			.collect(Collectors.toList());
	    	System.out.print(lp);
	    
	    System.out.println("");
	    System.out.println("Il prodotto con lo sconto maggiore");
	    	 Optional<Prodotto> prodottoConScontoMaggiore = catalogo.stream()
	                 .filter(p -> p.getSconto() != null) 
	                 .max(Comparator.comparingInt(Prodotto::getSconto));

	         Prodotto p= prodottoConScontoMaggiore.get();
	         System.out.println(p.getDescrizione()+" "+p.getSconto()+"%");
	    System.out.println("La somma dei prezzi dei prodotti alimentari");
	    	Optional<Double> somma= catalogo.stream()
							    			.filter(pro -> pro.getCategoria() == Categoria.alimentare)
							    			.map(Prodotto::getPrezzo)
							    			.reduce(Double::sum);
	    	System.out.println(somma.get()+"euro");
	    System.out.println("Un Optional vuoto a seguito di una ricerca di prodotto per una categoria inesistente (es. giocattoli)");
	    	Optional<Prodotto> opt = catalogo.stream()
	    	    .filter(pro -> pro.getCategoria()  == Categoria.media ) 
	    	    .findFirst(); 
	    	
	    	opt.ifPresentOrElse(
	    	    prodotto -> System.out.println("Prodotto trovato: " + prodotto.getDescrizione() + " (" + prodotto.getCategoria() + ")"),
	    	    () -> System.out.println("Nessun prodotto trovato per la categoria inesistente.")
	    	);
	    System.out.println("Il prodotto con prezzo più alto nella categoria media");
	    
	    	Optional<Prodotto> prodotto = catalogo.stream()
	    			.filter(pro->pro.getCategoria()==Categoria.alimentare)
	    			.max(Comparator.comparingDouble(Prodotto::getPrezzo));
	    	System.out.println(prodotto.get());
	    System.out.println("I nomi dei prodotti non disponibili");
	    	/*List<Prodotto> lpf =*/ catalogo.stream()
	    			.filter(prox-> prox.getDisponibilita()==false)
	    			.forEach(prodot->System.out.println(prodot));
	    			//.collect(Collectors.toList());
	    	//System.out.println(lpf);
	    			
	    			

	         
	}}
