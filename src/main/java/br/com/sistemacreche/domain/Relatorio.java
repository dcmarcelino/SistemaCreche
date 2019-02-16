/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Dmarcelino
 */

@Entity
@Table (name= "Relatorio")
@NamedQueries({
@NamedQuery(name = "Relatorio.listar", query = "SELECT relatorio FROM Relatorio relatorio"),
@NamedQuery(name = "Relatorio.buscarPorId", query = "SELECT relatorio FROM Relatorio relatorio WHERE relatorio.id_Relatorio = :id_Relatorio")})
public class Relatorio implements Serializable{
    
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
@Column (name="id_Relatorio", nullable=false)
private long id_Relatorio;

@Temporal (value = TemporalType.DATE)
@Column (name="Data_Rel", nullable=false)
private Date Data_Rel;

@Temporal (value = TemporalType.TIMESTAMP)
@Column (name="Hora_Chegada", nullable=false)
private Date Hora_Chegada;

@Temporal (value = TemporalType.TIMESTAMP)
@Column (name="Hora_Saida", nullable=false)
private Date Hora_Saida;

@Column (name="Funcionario", length=45, nullable=false)
private String Funcionario;

@Column (name="Trazer", length=60, nullable=true)
private String Trazer;

@Column (name="Recado", length=45, nullable=true)
private String Recado;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Item_Refeicao_id_Item_Ref" , referencedColumnName = "id_Item_Ref", nullable=false)
private Item_Refeicao refeicao;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Item_Banho_id_Item_Banho" , referencedColumnName = "id_Item_Banho", nullable=false)
private Item_Banho banho;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Item_Fralda_id_Item_Fralda" , referencedColumnName = "id_Item_Fralda", nullable=false)
private Item_Fralda fralda;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Disposicao_id_Disposicao", referencedColumnName = "id_Disposicao", nullable=false)
private Disposicao disposicao;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Aluno_Matricula_Aluno", referencedColumnName = "Matricula_Aluno", nullable=false)
private Aluno aluno;

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public long getId_Relatorio() {
        return id_Relatorio;
    }

    public void setId_Relatorio(long id_Relatorio) {
        this.id_Relatorio = id_Relatorio;
    }

    public Date getData_Rel() {
        return Data_Rel;
    }

    public void setData_Rel(Date Data_Rel) {
        this.Data_Rel = Data_Rel;
    }

    public Date getHora_Chegada() {
        return Hora_Chegada;
    }

    public void setHora_Chegada(Date Hora_Chegada) {
        this.Hora_Chegada = Hora_Chegada;
    }

    public Date getHora_Saida() {
        return Hora_Saida;
    }

    public void setHora_Saida(Date Hora_Saida) {
        this.Hora_Saida = Hora_Saida;
    }


    public String getFuncionario() {
        return Funcionario;
    }

    public void setFuncionario(String Funcionario) {
        this.Funcionario = Funcionario;
    }

    public String getTrazer() {
        return Trazer;
    }

    public void setTrazer(String Trazer) {
        this.Trazer = Trazer;
    }

    public String getRecado() {
        return Recado;
    }

    public void setRecado(String Recado) {
        this.Recado = Recado;
    }

    public Item_Refeicao getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(Item_Refeicao refeicao) {
        this.refeicao = refeicao;
    }

    public Item_Banho getBanho() {
        return banho;
    }

    public void setBanho(Item_Banho banho) {
        this.banho = banho;
    }

    public Item_Fralda getFralda() {
        return fralda;
    }

    public void setFralda(Item_Fralda fralda) {
        this.fralda = fralda;
    }

    public Disposicao getDisposicao() {
        return disposicao;
    }

    public void setDisposicao(Disposicao disposicao) {
        this.disposicao = disposicao;
    }

    @Override
    public String toString() {
        return "Relatorio{" + "id_Relatorio=" + id_Relatorio + ", Data_Rel=" + Data_Rel + ", Hora_Chegada=" + Hora_Chegada + ", Hora_Saida=" + Hora_Saida + ", Funcionario=" + Funcionario + ", Trazer=" + Trazer + ", Recado=" + Recado + ", refeicao=" + refeicao + ", banho=" + banho + ", fralda=" + fralda + ", disposicao=" + disposicao + ", aluno=" + aluno + '}';
    }

 


}