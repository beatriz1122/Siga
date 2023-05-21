package br.edu.fateczl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fateczl.repository.NotasRepository;

@Service
public class NotasService {

	@Autowired
	NotasRepository repository;

	public void adicionarNotas(Integer raAluno, String codigoDisciplina, Integer codigoAvaliacao, Float nota) {
		repository.spInsertNotas(raAluno, codigoDisciplina, codigoAvaliacao, nota);
	}
}