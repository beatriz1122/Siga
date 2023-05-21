package br.edu.fateczl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fateczl.model.entity.Avaliacao;
import br.edu.fateczl.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	@Autowired
	AvaliacaoRepository repository;

	List<Avaliacao> selectAvaliacoes() {
		return repository.findAll();
	}
}