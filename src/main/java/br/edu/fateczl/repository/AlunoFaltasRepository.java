package br.edu.fateczl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fateczl.model.entity.AlunoFaltas;

@Repository
public interface AlunoFaltasRepository extends JpaRepository<AlunoFaltas, Integer> {
	List<AlunoFaltas> selectFaltas(String codigoDisciplina);
}