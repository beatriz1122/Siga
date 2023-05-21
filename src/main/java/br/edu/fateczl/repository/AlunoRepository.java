package br.edu.fateczl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fateczl.model.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
