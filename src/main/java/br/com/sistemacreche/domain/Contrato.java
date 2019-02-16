/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table (name= "Contrato")
@NamedQueries({
@NamedQuery(name = "Contrato.listar", query = "SELECT contrato FROM Contrato contrato"),
@NamedQuery(name = "Contrato.buscarPorId", query = "SELECT contrato FROM Contrato contrato WHERE contrato.id_Contrato = :id_Contrato")})
public class Contrato implements Serializable{
    
    
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
@Column (name="id_Contrato", length=50, nullable=false)
private long id_Contrato;   

@Temporal (value = TemporalType.DATE)
@Column (name="Data_Inicio", nullable=false)
private Date Data_Inicio;

@Temporal (value = TemporalType.DATE)
@Column (name="Data_Fim",  nullable=false)
private Date Data_Fim;

@Column (name="Mensalidade", scale = 2, precision = 7 , nullable=false)
private BigDecimal Mensalidade;

@Column (name="Dt_Vencimento", length=02, nullable=false)
private String Dt_Vencimento;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Aluno_Matricula_Aluno", referencedColumnName = "Matricula_Aluno", nullable=false)
private Aluno aluno;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Empresa_id_Empresa", referencedColumnName = "id_Empresa", nullable=false)
private Empresa empresa;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Nivel_Escolar_id_Nivel", referencedColumnName = "id_Nivel", nullable=false)
private Nivel_Escolar nivel;

    public long getId_Contrato() {
        return id_Contrato;
    }

    public void setId_Contrato(long id_Contrato) {
        this.id_Contrato = id_Contrato;
    }

    public Date getData_Inicio() {
        return Data_Inicio;
    }

    public void setData_Inicio(Date Data_Inicio) {
        this.Data_Inicio = Data_Inicio;
    }

    public Date getData_Fim() {
        return Data_Fim;
    }

    public void setData_Fim(Date Data_Fim) {
        this.Data_Fim = Data_Fim;
    }

    public BigDecimal getMensalidade() {
        return Mensalidade;
    }

    public void setMensalidade(BigDecimal Mensalidade) {
        this.Mensalidade = Mensalidade;
    }

    public String getDt_Vencimento() {
        return Dt_Vencimento;
    }

    public void setDt_Vencimento(String Dt_Vencimento) {
        this.Dt_Vencimento = Dt_Vencimento;
    }


    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Nivel_Escolar getNivel() {
        return nivel;
    }

    public void setNivel(Nivel_Escolar nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Contrato{" + "id_Contrato=" + id_Contrato + ", Data_Inicio=" + Data_Inicio + ", Data_Fim=" + Data_Fim + ", Mensalidade=" + Mensalidade + ", Dt_Vencimento=" + Dt_Vencimento + ", aluno=" + aluno + ", empresa=" + empresa + ", nivel=" + nivel + '}';
    }
    
      
}