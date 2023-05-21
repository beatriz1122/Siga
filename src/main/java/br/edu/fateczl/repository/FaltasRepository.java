package br.edu.fateczl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.fateczl.model.entity.Faltas;
import br.edu.fateczl.model.entity.id.FaltasId;

@Repository
public interface FaltasRepository extends JpaRepository<Faltas, FaltasId> {
    @Procedure(name = "Faltas.spInsertFaltas")
    void spInsertFaltas(@Param("ra_aluno") Integer raAluno,
                        @Param("codigo_disciplina") String codigoDisciplina,
                        @Param("presenca") Integer presenca);
}