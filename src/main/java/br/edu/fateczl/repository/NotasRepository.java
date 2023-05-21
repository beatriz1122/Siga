package br.edu.fateczl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.fateczl.model.entity.Notas;
import br.edu.fateczl.model.entity.id.NotasId;

@Repository
public interface NotasRepository extends JpaRepository<Notas, NotasId> {
    @Procedure(name = "Notas.spInsertNotas")
    void spInsertNotas(@Param("ra_aluno") Integer raAluno,
                       @Param("codigo_disciplina") String codigoDisciplina,
                       @Param("codigo_avaliacao") Integer codigoAvaliacao,
                       @Param("nota") Float nota);
}
