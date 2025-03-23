package com.spring.Banca.dto;
import java.util.ArrayList;
import java.util.List;

public class ContoCorrenteDto {
	
		private Integer id,cc,saldo,contatore;
		private List<Integer> movimenti;
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
		public Integer getContatore() {
			return contatore;
		}
		public void setContatore(Integer contatore) {
			this.contatore = contatore;
		}
		public List<Integer> getMovimenti() {
			return movimenti;
		}
		public void setMovimenti(List<Integer> movimenti) {
			this.movimenti = movimenti;
		}
		public ContoCorrenteDto(Integer id,Integer cc, Integer saldo, Integer contatore, List<Integer> movimenti) {
			super();
			this.id = id;
			this.cc = cc;
			this.saldo = saldo;
			this.contatore = contatore;
			this.movimenti = new ArrayList<Integer>();
		}
		public ContoCorrenteDto() {
			super();
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		

	}

