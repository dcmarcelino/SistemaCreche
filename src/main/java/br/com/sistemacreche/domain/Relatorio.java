/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author Dmarcelino
 */

@Entity
@Table (name= "Relatorio")
@NamedQueries({
@NamedQuery(name = "Relatorio.listar", query = "SELECT relatorio FROM Relatorio relatorio"),
@NamedQuery(name = "Relatorio.buscarPorId", query = "SELECT relatorio FROM Relatorio relatorio WHERE relatorio.id_Relatorio = :id_Relatorio"),
@NamedQuery(name = "Relatorio.listarPorData", query = "SELECT relatorio FROM Relatorio relatorio WHERE relatorio.Data_Rel = :Data_Rel")})
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

@Column (name="Trazer", length=60, nullable=true)
private String Trazer;

@Column (name="Recado", length=250, nullable=true)
private String Recado;

@OneToMany(mappedBy = "relatorio", targetEntity = Item_Refeicao.class, 
        cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
private List<Item_Refeicao> refeicoes;

@OneToMany(mappedBy = "relatorio", targetEntity = Item_Banho.class, 
        cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
private List<Item_Banho> banhos;

@OneToMany(mappedBy = "relatorio", targetEntity = Item_Fralda.class, 
        cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
private List<Item_Banho> fraldas;

@OneToMany(mappedBy = "relatorio", targetEntity = Item_Remedio.class, 
        cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
private List<Item_Remedio> remedios;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Disposicao_id_Disposicao", referencedColumnName = "id_Disposicao", nullable=false)
private Disposicao disposicao;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Aluno_Matricula_Aluno", referencedColumnName = "Matricula_Aluno", nullable=false)
private Aluno aluno;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Funcionario_Matricula_Func" , referencedColumnName = "Matricula_Func", nullable=false)
private Funcionario Funcionario;

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


    public Funcionario getFuncionario() {
        return Funcionario;
    }

    public void setFuncionario(Funcionario Funcionario) {
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

    public List<Item_Refeicao> getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(List<Item_Refeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }

    public List<Item_Banho> getBanhos() {
        return banhos;
    }

    public void setBanhos(List<Item_Banho> banhos) {
        this.banhos = banhos;
    }

    public List<Item_Banho> getFraldas() {
        return fraldas;
    }

    public void setFraldas(List<Item_Banho> fraldas) {
        this.fraldas = fraldas;
    }

    public Disposicao getDisposicao() {
        return disposicao;
    }

    public void setDisposicao(Disposicao disposicao) {
        this.disposicao = disposicao;
    }

    public List<Item_Remedio> getRemedios() {
        return remedios;
    }

    public void setRemedios(List<Item_Remedio> remedios) {
        this.remedios = remedios;
    }

    @Override
    public String toString() {
        return "Relatorio{" + "id_Relatorio=" + id_Relatorio + ", Data_Rel=" + Data_Rel + ", Hora_Chegada=" + Hora_Chegada + ", Hora_Saida=" + Hora_Saida + ", Funcionario=" + Funcionario + ", Trazer=" + Trazer + ", Recado=" + Recado + ", refeicao=" + refeicoes + ", banho=" + banhos + ", fralda=" + fraldas + ", disposicao=" + disposicao + ", aluno=" + aluno + '}';
    }

    
}