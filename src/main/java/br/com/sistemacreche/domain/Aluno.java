/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Dmarcelino
 */
@Entity
@Table(name = "Aluno")
@NamedQueries({
    @NamedQuery(name = "Aluno.listar", query = "SELECT aluno FROM Aluno aluno")
    ,
    @NamedQuery(name = "Aluno.buscarPorMat", query = "SELECT aluno FROM Aluno aluno WHERE aluno.Matricula_Aluno = :Matricula_Aluno")})
public class Aluno implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "Matricula_Aluno", nullable = false)
    private long Matricula_Aluno;

    @Column(name = "Nome_Mae", length = 45, nullable = false)
    private String Nome_Mae;

    @Column(name = "Cpf_Mae", length = 11, nullable = false)
    private String Cpf_Mae;

    @Column(name = "Nome_Pai", length = 45, nullable = false)
    private String nome_pai;

    @Column(name = "Cpf_Pai", length = 11, nullable = false)
    private String Cpf_Pai;

    @Column(name = "Rest_Alimentar", length = 50, nullable = true)
    private String Rest_Alimentar;

    @Column(name = "Rest_Medicamento", length = 50, nullable = true)
    private String Rest_Medicamento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Pessoa_id_Pessoa", referencedColumnName = "id_Pessoa", nullable = false)
    private Pessoa pessoa;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Turno_id_Turno", referencedColumnName = "id_Turno", nullable = false)
    private Turno turno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Turma_id_Turma", referencedColumnName = "id_Turma", nullable = true)
    private Turma turma;

    public Aluno() {
        pessoa = new Pessoa(); //instancia o atributo pessoa para nao aparecer null na view
    }

    public long getMatricula_Aluno() {
        return Matricula_Aluno;
    }

    public void setMatricula_Aluno(long Matricula_Aluno) {
        this.Matricula_Aluno = Matricula_Aluno;
    }

    public String getNome_Mae() {
        return Nome_Mae;
    }

    public void setNome_Mae(String Nome_Mae) {
        this.Nome_Mae = Nome_Mae.toUpperCase();
    }

    public String getCpf_Mae() throws ParseException {
        MaskFormatter mask = new MaskFormatter("###.###.###-##");  //retorna o valor formatado quando solicitado
        mask.setValueContainsLiteralCharacters(false);
        return mask.valueToString(Cpf_Mae);
    }

    public void setCpf_Mae(String Cpf_Mae) {
        String cpf_Mae = Cpf_Mae.replaceAll("[-.()]", "");  //Retira mascara do cpf antes de salvar
        this.Cpf_Mae = cpf_Mae;
    }

    public String getNome_pai() {
        return nome_pai;
    }

    public void setNome_pai(String nome_pai) {
        this.nome_pai = nome_pai.toUpperCase();
    }

    public String getCpf_Pai() throws ParseException {
        MaskFormatter mask = new MaskFormatter("###.###.###-##");  //retorna o valor formatado quando solicitado
        mask.setValueContainsLiteralCharacters(false);
        return mask.valueToString(Cpf_Pai);
    }

    public void setCpf_Pai(String Cpf_Pai) {
        String cpf_Pai = Cpf_Pai.replaceAll("[-.()]", "");  //Retira mascara do cpf antes de salvar
        this.Cpf_Pai = cpf_Pai;
    }

    public String getRest_Alimentar() {
        return Rest_Alimentar;
    }

    public void setRest_Alimentar(String Rest_Alimentar) {
        this.Rest_Alimentar = Rest_Alimentar.toUpperCase();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getRest_Medicamento() {
        return Rest_Medicamento;
    }

    public void setRest_Medicamento(String Rest_Medicamento) {
        this.Rest_Medicamento = Rest_Medicamento.toUpperCase();
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "Aluno{" + "Matricula_Aluno=" + Matricula_Aluno + ", Nome_Mae=" + Nome_Mae + ", Cpf_Mae=" + Cpf_Mae + ", nome_pai=" + nome_pai + ", Cpf_Pai=" + Cpf_Pai + ", Rest_Alimentar=" + Rest_Alimentar + ", pessoa=" + pessoa + ", turno=" + turno + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + (int) (this.Matricula_Aluno ^ (this.Matricula_Aluno >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (this.Matricula_Aluno != other.Matricula_Aluno) {
            return false;
        }
        return true;
    }

}
