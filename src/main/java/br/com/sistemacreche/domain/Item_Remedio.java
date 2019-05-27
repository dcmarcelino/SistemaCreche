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
@Table (name= "Item_Remedio")
@NamedQueries({
@NamedQuery(name = "Item_Remedio.listar", query = "SELECT item FROM Item_Remedio item"),
@NamedQuery(name = "Item_Remedio.buscarPorId", query = "SELECT item FROM Item_Remedio item WHERE item.id_Item_Remedio = :id_Item_Remedio")})
public class Item_Remedio implements Serializable{

@GeneratedValue(strategy = GenerationType.AUTO)
@Id
@Column (name="id_Item_Remedio", nullable=false)
private long id_Item_Remedio;

@Temporal (value = TemporalType.TIMESTAMP)
@Column (name="Hora_Remedio", nullable=false)
private Date Hora_Remedio;

@Column (name="Remedio", length=60, nullable=true)
private String Remedio;

@Column (name="Dosagem", length=60, nullable=true)
private String Dosagem;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Relatorio_id_Relatorio", referencedColumnName = "id_Relatorio", nullable=false)
private Relatorio relatorio;

    public long getId_Item_Remedio() {
        return id_Item_Remedio;
    }

    public void setId_Item_Remedio(long id_Item_Remedio) {
        this.id_Item_Remedio = id_Item_Remedio;
    }

    public Date getHora_Remedio() {
        return Hora_Remedio;
    }

    public void setHora_Remedio(Date Hora_Remedio) {
        this.Hora_Remedio = Hora_Remedio;
    }

    public Relatorio getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    public String getRemedio() {
        return Remedio;
    }

    public void setRemedio(String Remedio) {
        this.Remedio = Remedio.toUpperCase();
    }

    public String getDosagem() {
        return Dosagem;
    }

    public void setDosagem(String Dosagem) {
        this.Dosagem = Dosagem.toUpperCase();
    }

    @Override
    public String toString() {
        return "Item_Remedio{" + "id_Item_Remedio=" + id_Item_Remedio + ", Hora_Remedio=" + Hora_Remedio + ", remedio=" + Remedio + ", relatorio=" + relatorio + '}';
    }
    

}
