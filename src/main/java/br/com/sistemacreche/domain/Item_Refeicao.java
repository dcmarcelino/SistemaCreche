/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Dmarcelino
 */

@Entity
@Table (name= "Item_Refeicao")
@NamedQueries({
@NamedQuery(name = "Item_Refeicao.listar", query = "SELECT item FROM Item_Refeicao item"),
@NamedQuery(name = "Item_Refeicao.buscarPorId", query = "SELECT item FROM Item_Refeicao item WHERE item.id_Item_Ref = :id_Item_Ref")})
public class Item_Refeicao implements Serializable{

@GeneratedValue(strategy = GenerationType.AUTO)
@Id
@Column (name="id_Item_Ref", nullable=true)
private long id_Item_Ref;

@Temporal (value = TemporalType.TIMESTAMP)
@Column (name="Hora_Ref",  nullable=false)
private Date Hora_Ref;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Refeicao_id_Refeicao", referencedColumnName = "id_Refeicao", nullable=false)
private Refeicao refeicao;

@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn(name = "Relatorio_id_Relatorio", referencedColumnName = "id_Relatorio", nullable=false)
private Relatorio relatorio;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Situacao_Ref_id_Situacao_Ref", referencedColumnName = "id_Situacao_Ref", nullable=false)
private Situacao_Ref situacao;

    public long getId_Item_Ref() {
        return id_Item_Ref;
    }

    public void setId_Item_Ref(long id_Item_Ref) {
        this.id_Item_Ref = id_Item_Ref;
    }

    public Date getHora_Ref() {
        return Hora_Ref;
    }

    public void setHora_Ref(Date Hora_Ref) {
        this.Hora_Ref = Hora_Ref;
    }


    public Refeicao getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(Refeicao refeicao) {
        this.refeicao = refeicao;
    }

    public Relatorio getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    public Situacao_Ref getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao_Ref situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "Item_Refeicao{" + "id_Item_Ref=" + id_Item_Ref + ", Hora_Ref=" + Hora_Ref + ", refeicao=" + refeicao + ", relatorio=" + relatorio + ", situacao=" + situacao + '}';
    }

 

}