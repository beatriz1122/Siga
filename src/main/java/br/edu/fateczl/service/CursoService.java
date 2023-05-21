package br.edu.fateczl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fateczl.model.entity.Curso;
import br.edu.fateczl.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	CursoRepository repository;

	List<Curso> selectCursos() {
		return repository.findAll();
	}

}
