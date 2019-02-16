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
@Table (name= "Item_Banho")
@NamedQueries({
@NamedQuery(name = "Item_Banho.listar", query = "SELECT item FROM Item_Banho item"),
@NamedQuery(name = "Item_Banho.buscarPorId", query = "SELECT item FROM Item_Banho item WHERE item.id_Item_Banho = :id_Item_Banho")})
public class Item_Banho implements Serializable{

@GeneratedValue(strategy = GenerationType.AUTO)
@Id
@Column (name="id_Item_Banho", nullable=false)
private long id_Item_Banho;

@Temporal (value = TemporalType.TIMESTAMP)
@Column (name="Hora_Banho", nullable=false)
private Date Hora_Banho;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Relatorio_id_Relatorio", referencedColumnName = "id_Relatorio", nullable=false)
private Relatorio relatorio;

    public long getId_Item_Banho() {
        return id_Item_Banho;
    }

    public void setId_Item_Banho(long id_Item_Banho) {
        this.id_Item_Banho = id_Item_Banho;
    }

    public Date getHora_Banho() {
        return Hora_Banho;
    }

    public void setHora_Banho(Date Hora_Banho) {
        this.Hora_Banho = Hora_Banho;
    }

    public Relatorio getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    @Override
    public String toString() {
        return "Item_Banho{" + "id_Item_Banho=" + id_Item_Banho + ", Hora_Banho=" + Hora_Banho + ", relatorio=" + relatorio + '}';
    }
    

}
