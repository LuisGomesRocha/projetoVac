package br.com.zup.projetoVac.dto;

import java.time.LocalDate;



public class VacinaResponse {

	private Long id;	
	private String nomeVacina;
	private String email;
	private LocalDate dataVacina;
	public VacinaResponse(Long id, String nomeVacina, String email, LocalDate dataVacina) {
		super();
		this.id = id;
		this.nomeVacina = nomeVacina;
		this.email = email;
		this.dataVacina = dataVacina;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeVacina() {
		return nomeVacina;
	}
	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDataVacina() {
		return dataVacina;
	}
	public void setDataVacina(LocalDate dataVacina) {
		this.dataVacina = dataVacina;
	}
	
	
	
}
