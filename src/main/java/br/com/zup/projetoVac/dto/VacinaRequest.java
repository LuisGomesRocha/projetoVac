package br.com.zup.projetoVac.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.projetoVac.domain.Vacina;

public class VacinaRequest {

	
	@NotBlank
	private String nomeVacina;
	@NotBlank
	@Email
	private String email;
	@NotNull
	private LocalDate dataVacina;
	
	public Vacina entradaVac() {
		return new Vacina(this.nomeVacina, this.email, this.dataVacina);
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
