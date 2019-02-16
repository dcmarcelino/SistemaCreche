/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.domain;

import java.io.Serializable;
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

/**
 *
 * @author Dmarcelino
 */

@Entity
@Table (name= "Municipio")
@NamedQueries({
@NamedQuery(name = "Municipio.listar", query = "SELECT municipio FROM Municipio municipio"),
@NamedQuery(name = "Municipio.buscarPorId", query = "SELECT municipio FROM Municipio municipio WHERE municipio.id_Municipio = :id_Municipio")})
public class Municipio implements Serializable{
    
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
@Column (name="id_Municipio", nullable=false)
private long id_Municipio; 
    
@Column (name="Mun_Descricao", length=45, nullable=false)
private String Mun_Descricao;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "UF_id_UF", referencedColumnName = "id_UF", nullable=false)
private UF uf;      

    public long getId_Municipio() {
        return id_Municipio;
    }

    public void setId_Municipio(long id_Municipio) {
        this.id_Municipio = id_Municipio;
    }

    public String getMun_Descricao() {
        return Mun_Descricao;
    }

    public void setMun_Descricao(String Mun_Descricao) {
        this.Mun_Descricao = Mun_Descricao.toUpperCase();
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Municipio{" + "id_Municipio=" + id_Municipio + ", Mun_Descricao=" + Mun_Descricao + ", uf=" + uf + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (int) (this.id_Municipio ^ (this.id_Municipio >>> 32));
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
        final Municipio other = (Municipio) obj;
        if (this.id_Municipio != other.id_Municipio) {
            return false;
        }
        return true;
    }

}