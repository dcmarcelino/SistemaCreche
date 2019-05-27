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
@Table (name= "Item_Fralda")
@NamedQueries({
@NamedQuery(name = "Item_Fralda.listar", query = "SELECT item FROM Item_Fralda item"),
@NamedQuery(name = "Item_Fralda.buscarPorId", query = "SELECT item FROM Item_Fralda item WHERE item.id_Item_Fralda = :id_Item_Fralda")})
public class Item_Fralda implements Serializable{

@GeneratedValue(strategy = GenerationType.AUTO)
@Id
@Column (name="id_Item_Fralda", nullable=false)
private long id_Item_Fralda;

@Temporal (value = TemporalType.TIMESTAMP)
@Column (name="Hora_Fralda", nullable=false)
private Date Hora_Fralda;

@Column (name="Tipo", length=45, nullable=true)
private String tipo;

@Column (name="Obs_Fralda", length=400, nullable=true)
private String Obs_Fralda;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Relatorio_id_Relatorio", referencedColumnName = "id_Relatorio", nullable=false)
private Relatorio relatorio;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Textura_id_Textura", referencedColumnName = "id_Textura", nullable=false)
private Textura textura;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Coloracao_id_Coloracao", referencedColumnName = "id_Coloracao", nullable=false)
private Coloracao coloracao;

    public long getId_Item_Fralda() {
        return id_Item_Fralda;
    }

    public void setId_Item_Fralda(long id_Item_Fralda) {
        this.id_Item_Fralda = id_Item_Fralda;
    }

    public Date getHora_Fralda() {
        return Hora_Fralda;
    }

    public void setHora_Fralda(Date Hora_Fralda) {
        this.Hora_Fralda = Hora_Fralda;
    }

    public String getObs_Fralda() {
        return Obs_Fralda;
    }

    public void setObs_Fralda(String Obs_Fralda) {
        this.Obs_Fralda = Obs_Fralda.toUpperCase();
    }

    public Relatorio getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    public Textura getTextura() {
        return textura;
    }

    public void setTextura(Textura textura) {
        this.textura = textura;
    }

    public Coloracao getColoracao() {
        return coloracao;
    }

    public void setColoracao(Coloracao coloracao) {
        this.coloracao = coloracao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Item_Fralda{" + "id_Item_Fralda=" + id_Item_Fralda + ", Hora_Fralda=" + Hora_Fralda + ", Obs_Fralda=" + Obs_Fralda + ", relatorio=" + relatorio + ", textura=" + textura + ", coloracao=" + coloracao + '}';
    }
  

}