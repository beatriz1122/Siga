package br.edu.fateczl.model.entity.id;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.fateczl.model.entity.Aluno;
import br.edu.fateczl.model.entity.Avaliacao;
import br.edu.fateczl.model.entity.Disciplina;

//@Embeddable
public class NotasId implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "ra_aluno")
	private Aluno raAluno;

	@ManyToOne
	@JoinColumn(name = "codigo_disciplina")
	private Disciplina codigoDisciplina;

	@ManyToOne
	@JoinColumn(name = "codigo_avaliacao")
	private Avaliacao codigoAvaliacao;

	public NotasId() {
	}

	public NotasId(Aluno raAluno, Disciplina codigoDisciplina, Avaliacao codigoAvaliacao) {
		this.raAluno = raAluno;
		this.codigoDisciplina = codigoDisciplina;
		this.codigoAvaliacao = codigoAvaliacao;
	}

	public Aluno getRaAluno() {
		return raAluno;
	}

	public Disciplina getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public Avaliacao getCodigoAvaliacao() {
		return codigoAvaliacao;
	}
}
