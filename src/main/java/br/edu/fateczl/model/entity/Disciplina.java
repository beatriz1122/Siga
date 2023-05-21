package br.edu.fateczl.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Disciplina")
public class Disciplina {

	@Id
	@Column
	private String codigo;

	@Column
	private String nome;

	@Column
	private String sigla;

	@Column
	private String turno;

	@Column(name = "num_aulas")
	private Integer numAulas;

	@ManyToOne
	@JoinColumn(name = "codigo_curso")
	private Curso curso;

	public Disciplina() {
	}

	public Disciplina(String codigo, String nome, String sigla, String turno, Integer numAulas, Curso curso) {
		this.codigo = codigo;
		this.nome = nome;
		this.sigla = sigla;
		this.turno = turno;
		this.numAulas = numAulas;
		this.curso = curso;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Integer getNumAulas() {
		return numAulas;
	}

	public void setNumAulas(Integer numAulas) {
		this.numAulas = numAulas;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Disciplina{" + "codigo='" + codigo + '\'' + ", nome='" + nome + '\'' + ", sigla='" + sigla + '\''
				+ ", turno='" + turno + '\'' + ", numAulas=" + numAulas + ", curso=" + curso + '}';
	}
}
