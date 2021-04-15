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

import org.hibernate.validator.constraints.br.CPF;

import br.com.zup.projetoVac.dto.UsuariosResponse;

@Entity
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@NotBlank(message = "Nome em branco")
	private String nome;
	@NotBlank(message = "E-mail em branco")
	@Email(message = "E-mail inválido!")
	private String email;
	@NotBlank(message = "CPF em branco")
	@CPF(message = "CPF inválido!")
	private String cpf;
	@NotNull(message = "Data inválida!")
	private LocalDate dataNascimento;

	@Deprecated
	public Usuarios() {

	}

	public Usuarios(@NotBlank(message = "Nome em branco") String nome,
			@NotBlank(message = "E-mail em branco") @Email(message = "E-mail inválido!") String email,
			@NotBlank(message = "CPF em branco") @CPF(message = "CPF inválido!") String cpf,
			@NotNull(message = "Data inválida!") LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public UsuariosResponse resposta() {
		return new UsuariosResponse(this.id, this.nome, this.email);
	}

}
