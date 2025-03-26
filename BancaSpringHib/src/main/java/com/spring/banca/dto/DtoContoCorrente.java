package com.spring.banca.dto;

import java.util.ArrayList;
import java.util.List;

public class DtoContoCorrente {
	
		private Integer idConto;
		private Integer cc,saldo;
		private List<Integer> movimenti = new ArrayList<Integer>();

		public DtoContoCorrente() {
			// TODO Auto-generated constructor stub
		}
		public Integer getIdConto() {
			return idConto;
		}
		public void setIdConto(Integer idConto) {
			this.idConto = idConto;
		}
		public Integer getCc() {
			return cc;
		}
		public void setCc(Integer cc) {
			this.cc = cc;
		}
		public Integer getSaldo() {
			return saldo;
		}
		public void setSaldo(Integer saldo) {
			this.saldo = saldo;
		}
		public List<Integer> getMovimenti() {
			return movimenti;
		}
		public void setMovimenti(List<Integer> movimenti) {
			this.movimenti = movimenti;
		}
		public Integer getContatore() {
			return movimenti.size();
		}
		
		public DtoContoCorrente(Integer idConto, Integer cc, Integer saldo, List<Integer> movimenti) {
			super();
			this.idConto = idConto;
			this.cc = cc;
			this.saldo = saldo;
			this.movimenti = movimenti;
			
		}
		
		

	}

