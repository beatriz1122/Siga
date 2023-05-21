package br.edu.fateczl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fateczl.repository.FaltasRepository;

@Service
public class FaltasService {

	@Autowired
	FaltasRepository repository;

	public void adicionarFaltas(Integer raAluno, String codigoDisciplina, Integer presenca) {
		repository.spInsertFaltas(raAluno, codigoDisciplina, presenca);
	}
}