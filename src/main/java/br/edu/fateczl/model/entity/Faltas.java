package br.edu.fateczl.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import br.edu.fateczl.model.entity.id.FaltasId;

@Entity
@Table(name = "Faltas")
@IdClass(FaltasId.class)
@NamedStoredProcedureQuery(name = "Faltas.spInsertFaltas", procedureName = "sp_insertFaltas", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "ra_aluno", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "codigo_disciplina", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "presenca", type = Integer.class) })
public class Faltas implements Serializable {

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
	@Column(name = "data_falta")
	private String dataFalta;

	@Column
	private Integer presenca;

	public Faltas() {
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

	public String getDataFalta() {
		return dataFalta;
	}

	public void setDataFalta(String dataFalta) {
		this.dataFalta = dataFalta;
	}

	public Integer getPresenca() {
		return presenca;
	}

	public void setPresenca(Integer presenca) {
		this.presenca = presenca;
	}

	@Override
	public String toString() {
		return "Faltas{" + "raAluno=" + raAluno + ", codigoDisciplina=" + codigoDisciplina + ", dataFalta='" + dataFalta
				+ '\'' + ", presenca=" + presenca + '}';
	}
}