package br.com.zup.projetoVac.service;

import java.util.List;

import br.com.zup.projetoVac.domain.Usuarios;
import br.com.zup.projetoVac.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import br.com.zup.projetoVac.domain.Vacina;
import br.com.zup.projetoVac.repository.VacinaRepository;

@Service
public class VacinaService {

	@Autowired
	public VacinaRepository vacinaRepository;

	@Autowired
	UsuariosRepository usuariosRepository;
	
	public Vacina regrasVac(Vacina condicao) throws Exception {
		if (!existeEmail(condicao.getEmail())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail não cadastrado na base de dados.");
		}
		return vacinaRepository.save(condicao);
	}

	public boolean existeEmail(String email) {
		List<Usuarios> buscaEmail = usuariosRepository.findByEmail(email);
		if ((buscaEmail != null) && (!buscaEmail.isEmpty())) {
			return true;
		}
		return false;
	}

	public List<Vacina> buscarEmail(String email) {
		return vacinaRepository.findByEmail(email);
	}
	
 
}