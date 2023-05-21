package br.edu.fateczl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fateczl.model.entity.Aluno;
import br.edu.fateczl.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository repository;

	List<Aluno> selectAlunos() {

		return repository.findAll();
	}
}
