package br.com.zup.projetoVac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.projetoVac.domain.Usuarios;
import br.com.zup.projetoVac.repository.UsuariosRepository;

@Service
public class UsuariosService {

	@Autowired
	public UsuariosRepository usuariosRepository;

	// Regras cadastrar
	public Usuarios regras(Usuarios condicao) throws Exception {
		if (existeEmail(condicao.getEmail())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail já existe.");
		} else if (existeCPF(condicao.getCpf())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF já existe.");
		}
		return usuariosRepository.save(condicao);
	}

	// Condições
	public boolean existeEmail(String email) {
		List<Usuarios> buscaEmail = usuariosRepository.findByEmail(email);
		if ((buscaEmail != null) && (!buscaEmail.isEmpty())) {
			return true;
		}
		return false;
	}

	public boolean existeCPF(String cpf) {
		List<Usuarios> buscaCpf = usuariosRepository.findByCpf(cpf);
		if ((buscaCpf != null) && (!buscaCpf.isEmpty())) {
			return true;
		}
		return false;
	}

	// Buscar
	public List<Usuarios> buscarCPF(String cpf) {
		return usuariosRepository.findByCpf(cpf);
	}

	public List<Usuarios> buscarNome(String nome) {
		return usuariosRepository.findByNome(nome);
	}

	public List<Usuarios> buscarEmail(String email) {
		return usuariosRepository.findByEmail(email);
	}
	public List<Usuarios> buscarTudo(){
		return usuariosRepository.findAll();
	}
}
