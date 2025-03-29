package com.example.ecommerce.dto;

public class DtoProdotto {

		private Integer idProdotto;
		private Integer quantita;
		private Integer prezzo;
		private Integer sconto;
		private String categoria;
		public DtoProdotto() {
			// TODO Auto-generated constructor stub
		}
		public Integer getIdProdotto() {
			return idProdotto;
		}
		public void setIdProdotto(Integer idProdotto) {
			this.idProdotto = idProdotto;
		}
		public Integer getQuantita() {
			return quantita;
		}
		public void setQuantita(Integer quantita) {
			this.quantita = quantita;
		}
		public Integer getPrezzo() {
			return prezzo;
		}
		public void setPrezzo(Integer prezzo) {
			this.prezzo = prezzo;
		}
		public Integer getSconto() {
			return sconto;
		}
		public void setSconto(Integer sconto) {
			this.sconto = sconto;
		}
		public String getCategoria() {
			return categoria;
		}
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
		public DtoProdotto(Integer idProdotto, Integer quantita, Integer prezzo, Integer sconto, String categoria) {
			super();
			this.idProdotto = idProdotto;
			this.quantita = quantita;
			this.prezzo = prezzo;
			this.sconto = sconto;
			this.categoria = categoria;
		}
		
		

	}


