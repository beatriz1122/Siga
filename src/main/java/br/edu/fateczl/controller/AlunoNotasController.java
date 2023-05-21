package br.edu.fateczl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateczl.model.entity.AlunoNotas;
import br.edu.fateczl.service.AlunoNotasService;

@RestController
@RequestMapping("/notas")
public class AlunoNotasController {

	@Autowired
	AlunoNotasService service;

	@GetMapping("/{codigoDisciplina}")
	public ResponseEntity<List<AlunoNotas>> listarNotas(
			@PathVariable(value = "codigoDisciplina") String codigoDisciplina) {

		List<AlunoNotas> notas = service.listarNotas(codigoDisciplina);
		return ResponseEntity.ok().body(notas);
	}
}
