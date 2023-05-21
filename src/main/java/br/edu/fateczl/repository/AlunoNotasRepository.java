package br.edu.fateczl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fateczl.model.entity.AlunoNotas;

@Repository
public interface AlunoNotasRepository extends JpaRepository<AlunoNotas, Integer> {
    List<AlunoNotas> selectNotas(String codigoDisciplina);
}
