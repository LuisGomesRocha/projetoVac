package br.com.zup.projetoVac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.zup.projetoVac.domain.Usuarios;

import br.com.zup.projetoVac.dto.UsuariosRequest;
import br.com.zup.projetoVac.dto.UsuariosResponse;

import br.com.zup.projetoVac.service.UsuariosService;

@Controller
@RequestMapping(value = "/api/usuarios")
public class UsuariosController {

	@Autowired
	UsuariosService usuariosService;

	@PostMapping
	public ResponseEntity<UsuariosResponse> novoUsuario(@Validated @RequestBody UsuariosRequest usuariosRequest)
			throws Exception {

		Usuarios entradaCadastro = usuariosRequest.entrada();
		usuariosService.regras(entradaCadastro);
		UsuariosResponse usuariosResponse = entradaCadastro.resposta();
		return ResponseEntity.status(HttpStatus.CREATED).body(usuariosResponse);
	}


}


