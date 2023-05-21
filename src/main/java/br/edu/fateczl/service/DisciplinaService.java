package br.edu.fateczl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fateczl.model.entity.Disciplina;
import br.edu.fateczl.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	DisciplinaRepository repository;

	List<Disciplina> selectDisciplinas() {
		return repository.findAll();
	}
}