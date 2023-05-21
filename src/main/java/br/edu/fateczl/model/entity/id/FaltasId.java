package br.edu.fateczl.model.entity.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.fateczl.model.entity.Aluno;
import br.edu.fateczl.model.entity.Disciplina;

public class FaltasId implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "ra_aluno")
	private Aluno raAluno;

	@ManyToOne
	@JoinColumn(name = "codigo_disciplina")
	private Disciplina codigoDisciplina;

	@Column(name = "data_falta")
	private String dataFalta;

	public FaltasId() {
	}

	public FaltasId(Aluno raAluno, Disciplina codigoDisciplina, String dataFalta) {
		this.raAluno = raAluno;
		this.codigoDisciplina = codigoDisciplina;
		this.dataFalta = dataFalta;
	}

	public Aluno getRaAluno() {
		return raAluno;
	}

	public Disciplina getCodigoDisciplina() {
		return codigoDisciplina;
	}
}