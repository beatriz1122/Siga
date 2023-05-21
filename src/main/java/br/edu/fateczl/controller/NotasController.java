package br.edu.fateczl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateczl.model.entity.Notas;
import br.edu.fateczl.service.NotasService;

@RestController
@RequestMapping("/notas")
public class NotasController {

	@Autowired
	NotasService service;

	@PostMapping("/add")
	public String adicionarNota(@RequestBody Notas n) {
		service.adicionarNotas(n.getRaAluno().getRa(), n.getCodigoDisciplina().getCodigo(),
				n.getCodigoAvaliacao().getCodigo(), n.getNota());
		return "Nota adicionada com sucesso";
	}
}
