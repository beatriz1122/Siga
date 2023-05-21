package br.edu.fateczl.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(
        name = "AlunoNotas.selectNotas",
        query = "SELECT ra_aluno, nome_aluno, disciplina, turno, nota1, nota2, nota3, pre_exame, nota4, media, situacao " +
                "FROM fn_selectNotas(?1)",
        resultClass = AlunoNotas.class
)
public class AlunoNotas {

    @Id
    @Column(name = "ra_aluno")
    private Integer raAluno;

    @Column(name = "nome_aluno")
    private String nomeAluno;

    @Column
    private String disciplina;

    @Column
    private String turno;

    @Column
    private Float nota1;

    @Column
    private Float nota2;

    @Column
    private Float nota3;

    @Column(name = "pre_exame")
    private Float preExame;

    @Column
    private Float nota4;

    @Column
    private Float media;

    @Column
    private String situacao;

    public AlunoNotas() { }

    public Integer getRaAluno() {
        return raAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getTurno() {
        return turno;
    }

    public Float getNota1() {
        return nota1;
    }

    public Float getNota2() {
        return nota2;
    }

    public Float getNota3() {
        return nota3;
    }

    public Float getPreExame() {
        return preExame;
    }

    public Float getNota4() {
        return nota4;
    }

    public Float getMedia() {
        return media;
    }

    public String getSituacao() {
        return situacao;
    }

    @Override
    public String toString() {
        return "AlunoNotas{" +
                "raAluno=" + raAluno +
                ", nomeAluno='" + nomeAluno + '\'' +
                ", disciplina='" + disciplina + '\'' +
                ", turno='" + turno + '\'' +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", nota3=" + nota3 +
                ", preExame=" + preExame +
                ", nota4=" + nota4 +
                ", media=" + media +
                ", situacao='" + situacao + '\'' +
                '}';
    }
}
