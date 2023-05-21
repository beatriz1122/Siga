package br.edu.fateczl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateczl.model.entity.Faltas;
import br.edu.fateczl.service.FaltasService;

@RestController
@RequestMapping("/faltas")
public class FaltasController {

	@Autowired
	FaltasService service;

	@PostMapping("/add")
	public String adicionarFaltas(@Valid @RequestBody Faltas f) {
		service.adicionarFaltas(f.getRaAluno().getRa(), f.getCodigoDisciplina().getCodigo(), f.getPresenca());
		return "Falta adicionada com sucesso";
	}
}
