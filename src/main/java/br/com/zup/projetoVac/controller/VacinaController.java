package br.com.zup.projetoVac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.zup.projetoVac.domain.Vacina;
import br.com.zup.projetoVac.dto.VacinaRequest;
import br.com.zup.projetoVac.dto.VacinaResponse;
import br.com.zup.projetoVac.service.VacinaService;

@Controller
@RequestMapping(value = "/vacinacao/vacina")
public class VacinaController {

	@Autowired
	VacinaService vacinaService;

	

	@PostMapping
	public ResponseEntity<VacinaResponse> novaVacina(@Validated @RequestBody VacinaRequest vacinaRequest)
			throws Exception {

		Vacina entradaCadastroVacina = vacinaRequest.entradaVac();
		vacinaService.regrasVac(entradaCadastroVacina);
		VacinaResponse vacinaResponse = entradaCadastroVacina.respostaVacina();
		return ResponseEntity.status(HttpStatus.CREATED).body(vacinaResponse);
	}

}