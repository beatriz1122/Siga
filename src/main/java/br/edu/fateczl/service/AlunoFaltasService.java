package br.edu.fateczl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fateczl.model.entity.AlunoFaltas;
import br.edu.fateczl.repository.AlunoFaltasRepository;

@Service
public class AlunoFaltasService {

	@Autowired
	AlunoFaltasRepository repository;

	public List<AlunoFaltas> listarFaltas(String codigoDisciplina) {
		return repository.selectFaltas(codigoDisciplina);
	}
}
