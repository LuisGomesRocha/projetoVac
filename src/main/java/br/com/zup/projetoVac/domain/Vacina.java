package br.com.zup.projetoVac.domain;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.projetoVac.dto.VacinaResponse;

@Entity
public class Vacina {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;;
	@NotBlank
	private String nomeVacina;
	@NotBlank
	@Email
	private String email;
	@NotNull
	private LocalDate dataVacina;
	
	

	@Deprecated
	public Vacina() {
	}

	public Vacina(@NotBlank String nomeVacina, @NotBlank @Email String email, @NotNull LocalDate dataVacina) {
		super();
		this.nomeVacina = nomeVacina;
		this.email = email;
		this.dataVacina = dataVacina;
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

	public VacinaResponse respostaVacina() {
		return new VacinaResponse (this.id, this.nomeVacina, this.email, this.dataVacina);
	}
	

}
