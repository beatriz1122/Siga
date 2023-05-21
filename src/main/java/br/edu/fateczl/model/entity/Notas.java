package br.edu.fateczl.model.entity;

import javax.persistence.*;

import br.edu.fateczl.model.entity.id.NotasId;

import java.io.Serializable;

@Entity
@Table(name = "Notas")
@IdClass(NotasId.class)
@NamedStoredProcedureQuery(name = "Notas.spInsertNotas", procedureName = "sp_insertNotas", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "ra_aluno", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "codigo_disciplina", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "codigo_avaliacao", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "nota", type = Float.class),

}
)
public class Notas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "ra_aluno")
	private Aluno raAluno;

	@Id
	@ManyToOne
	@JoinColumn(name = "codigo_disciplina")
	private Disciplina codigoDisciplina;

	@Id
	@ManyToOne
	@JoinColumn(name = "codigo_avaliacao")
	private Avaliacao codigoAvaliacao;

	@Column
	private Float nota;

	@Column
	private Float peso;

	public Notas() {
	}

	public Aluno getRaAluno() {
		return raAluno;
	}

	public void setRaAluno(Aluno raAluno) {
		this.raAluno = raAluno;
	}

	public Disciplina getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(Disciplina codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public Avaliacao getCodigoAvaliacao() {
		return codigoAvaliacao;
	}

	public void setCodigoAvaliacao(Avaliacao codigoAvaliacao) {
		this.codigoAvaliacao = codigoAvaliacao;
	}

	public Float getNota() {
		return nota;
	}

	public void setNota(Float nota) {
		this.nota = nota;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Notas{" + "raAluno=" + raAluno + ", codigoDisciplina=" + codigoDisciplina + ", codigoAvaliacao="
				+ codigoAvaliacao + ", nota=" + nota + ", peso=" + peso + '}';
	}
}