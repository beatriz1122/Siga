package br.edu.fateczl.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(
        name = "AlunoFaltas.selectFaltas",
        query = "SELECT * FROM fn_selectFaltas(?1)",
        resultClass = AlunoFaltas.class
)
public class AlunoFaltas {

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
    private String data1;
    @Column
    private String data2;
    @Column
    private String data3;
    @Column
    private String data4;
    @Column
    private String data5;
    @Column
    private String data6;
    @Column
    private String data7;
    @Column
    private String data8;
    @Column
    private String data9;
    @Column
    private String data10;
    @Column
    private String data11;
    @Column
    private String data12;
    @Column
    private String data13;
    @Column
    private String data14;
    @Column
    private String data15;
    @Column
    private String data16;
    @Column
    private String data17;
    @Column
    private String data18;
    @Column
    private String data19;
    @Column
    private String data20;
    @Column(name = "presenca_data1")
    private String presencaData1;
    @Column(name = "presenca_data2")
    private String presencaData2;
    @Column(name = "presenca_data3")
    private String presencaData3;
    @Column(name = "presenca_data4")
    private String presencaData4;
    @Column(name = "presenca_data5")
    private String presencaData5;
    @Column(name = "presenca_data6")
    private String presencaData6;
    @Column(name = "presenca_data7")
    private String presencaData7;
    @Column(name = "presenca_data8")
    private String presencaData8;
    @Column(name = "presenca_data9")
    private String presencaData9;
    @Column(name = "presenca_data10")
    private String presencaData10;
    @Column(name = "presenca_data11")
    private String presencaData11;
    @Column(name = "presenca_data12")
    private String presencaData12;
    @Column(name = "presenca_data13")
    private String presencaData13;
    @Column(name = "presenca_data14")
    private String presencaData14;
    @Column(name = "presenca_data15")
    private String presencaData15;
    @Column(name = "presenca_data16")
    private String presencaData16;
    @Column(name = "presenca_data17")
    private String presencaData17;
    @Column(name = "presenca_data18")
    private String presencaData18;
    @Column(name = "presenca_data19")
    private String presencaData19;
    @Column(name = "presenca_data20")
    private String presencaData20;
    @Column(name = "total_faltas")
    private Integer totalFaltas;

    public AlunoFaltas() { }

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

    public String getData1() {
        return data1;
    }

    public String getData2() {
        return data2;
    }

    public String getData3() {
        return data3;
    }

    public String getData4() {
        return data4;
    }

    public String getData5() {
        return data5;
    }

    public String getData6() {
        return data6;
    }

    public String getData7() {
        return data7;
    }

    public String getData8() {
        return data8;
    }

    public String getData9() {
        return data9;
    }

    public String getData10() {
        return data10;
    }

    public String getData11() {
        return data11;
    }

    public String getData12() {
        return data12;
    }

    public String getData13() {
        return data13;
    }

    public String getData14() {
        return data14;
    }

    public String getData15() {
        return data15;
    }

    public String getData16() {
        return data16;
    }

    public String getData17() {
        return data17;
    }

    public String getData18() {
        return data18;
    }

    public String getData19() {
        return data19;
    }

    public String getData20() {
        return data20;
    }

    public String getPresencaData1() {
        return presencaData1;
    }

    public String getPresencaData2() {
        return presencaData2;
    }

    public String getPresencaData3() {
        return presencaData3;
    }

    public String getPresencaData4() {
        return presencaData4;
    }

    public String getPresencaData5() {
        return presencaData5;
    }

    public String getPresencaData6() {
        return presencaData6;
    }

    public String getPresencaData7() {
        return presencaData7;
    }

    public String getPresencaData8() {
        return presencaData8;
    }

    public String getPresencaData9() {
        return presencaData9;
    }

    public String getPresencaData10() {
        return presencaData10;
    }

    public String getPresencaData11() {
        return presencaData11;
    }

    public String getPresencaData12() {
        return presencaData12;
    }

    public String getPresencaData13() {
        return presencaData13;
    }

    public String getPresencaData14() {
        return presencaData14;
    }

    public String getPresencaData15() {
        return presencaData15;
    }

    public String getPresencaData16() {
        return presencaData16;
    }

    public String getPresencaData17() {
        return presencaData17;
    }

    public String getPresencaData18() {
        return presencaData18;
    }

    public String getPresencaData19() {
        return presencaData19;
    }

    public String getPresencaData20() {
        return presencaData20;
    }

    public Integer getTotalFaltas() {
        return totalFaltas;
    }

    @Override
    public String toString() {
        return "AlunoFaltas{" +
                "raAluno=" + raAluno +
                ", nomeAluno='" + nomeAluno + '\'' +
                ", disciplina='" + disciplina + '\'' +
                ", turno='" + turno + '\'' +
                ", data1='" + data1 + '\'' +
                ", data2='" + data2 + '\'' +
                ", data3='" + data3 + '\'' +
                ", data4='" + data4 + '\'' +
                ", data5='" + data5 + '\'' +
                ", data6='" + data6 + '\'' +
                ", data7='" + data7 + '\'' +
                ", data8='" + data8 + '\'' +
                ", data9='" + data9 + '\'' +
                ", data10='" + data10 + '\'' +
                ", data11='" + data11 + '\'' +
                ", data12='" + data12 + '\'' +
                ", data13='" + data13 + '\'' +
                ", data14='" + data14 + '\'' +
                ", data15='" + data15 + '\'' +
                ", data16='" + data16 + '\'' +
                ", data17='" + data17 + '\'' +
                ", data18='" + data18 + '\'' +
                ", data19='" + data19 + '\'' +
                ", data20='" + data20 + '\'' +
                ", presencaData1='" + presencaData1 + '\'' +
                ", presencaData2='" + presencaData2 + '\'' +
                ", presencaData3='" + presencaData3 + '\'' +
                ", presencaData4='" + presencaData4 + '\'' +
                ", presencaData5='" + presencaData5 + '\'' +
                ", presencaData6='" + presencaData6 + '\'' +
                ", presencaData7='" + presencaData7 + '\'' +
                ", presencaData8='" + presencaData8 + '\'' +
                ", presencaData9='" + presencaData9 + '\'' +
                ", presencaData10='" + presencaData10 + '\'' +
                ", presencaData11='" + presencaData11 + '\'' +
                ", presencaData12='" + presencaData12 + '\'' +
                ", presencaData13='" + presencaData13 + '\'' +
                ", presencaData14='" + presencaData14 + '\'' +
                ", presencaData15='" + presencaData15 + '\'' +
                ", presencaData16='" + presencaData16 + '\'' +
                ", presencaData17='" + presencaData17 + '\'' +
                ", presencaData18='" + presencaData18 + '\'' +
                ", presencaData19='" + presencaData19 + '\'' +
                ", presencaData20='" + presencaData20 + '\'' +
                ", totalFaltas=" + totalFaltas +
                '}';
    }
}