package br.edu.fateczl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fateczl.model.entity.AlunoNotas;
import br.edu.fateczl.repository.AlunoNotasRepository;

@Service
public class AlunoNotasService {

	@Autowired
	AlunoNotasRepository repository;

	public List<AlunoNotas> listarNotas(String codigoDisciplina) {
		return repository.selectNotas(codigoDisciplina);
	}
}
