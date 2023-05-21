package br.edu.fateczl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateczl.model.entity.AlunoFaltas;
import br.edu.fateczl.service.AlunoFaltasService;

@RestController
@RequestMapping("/faltas")
public class AlunoFaltasController {

	@Autowired
	AlunoFaltasService service;

	@GetMapping("/{codigoDisciplina}")
	public ResponseEntity<List<AlunoFaltas>> listarFaltas(
			@PathVariable(value = "codigoDisciplina") String codigoDisciplina) {

		List<AlunoFaltas> faltas = service.listarFaltas(codigoDisciplina);

		return ResponseEntity.ok().body(faltas);
	}
}