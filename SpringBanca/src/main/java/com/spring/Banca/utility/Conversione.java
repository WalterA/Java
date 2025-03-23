package com.spring.Banca.utility;
import com.spring.Banca.dto.ContoCorrenteDto;
import com.spring.Banca.dto.ListaContiDto;
import com.spring.Banca.dto.UtenteDto;
import com.spring.Banca.entity.ContoCorrente;
import com.spring.Banca.entity.ListaConti;
import com.spring.Banca.entity.Utente;

public class Conversione {

	public static Utente daUtenteDTOAUtente(UtenteDto dto) {
		return new Utente(dto.getIdUtente(), dto.getNome(), dto.getCognome(), dto.getPassword(),dto.getConti());
	}
	public static UtenteDto daUtenteAUtenteDto(Utente entity) {
		return new UtenteDto(entity.getIdUtente(), entity.getNome(), entity.getCognome(), entity.getPassword(),entity.getConti());
	}
	public static ContoCorrente daCcDTOACc(ContoCorrenteDto dto) {
		return new ContoCorrente(dto.getId(), dto.getCc(), dto.getSaldo(), dto.getContatore(), dto.getMovimenti());
	}
	public static ContoCorrenteDto daCcACcDto(ContoCorrente entity) {
		return new ContoCorrenteDto(entity.getId(), entity.getCc(), entity.getSaldo(), entity.getContatore(), entity.getMovimenti());
	}
	public static ListaConti daUcDTOAUc(ListaContiDto dto) {
		return new ListaConti(dto.getIdUtente(), dto.getIdConto());
	}
	public static ListaContiDto daUcAUcDto(ListaConti entity) {
		return new ListaContiDto(entity.getIdUtente(), entity.getIdConto());
	}
}
