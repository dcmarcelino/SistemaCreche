/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Dmarcelino
 */

@Entity
@Table (name= "Nivel_Escolar")
@NamedQueries({
@NamedQuery(name = "Nivel_Escolar.listar", query = "SELECT nivel FROM Nivel_Escolar nivel"),
@NamedQuery(name = "Nivel_Escolar.buscarPorId", query = "SELECT nivel FROM Nivel_Escolar nivel WHERE nivel.id_Nivel = :id_Nivel")})
public class Nivel_Escolar implements Serializable{
    
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
@Column (name="id_Nivel", nullable=false)
private long id_Nivel; 
    
@Column (name="Descricao_NE", length=45, nullable=false)
private String Descricao_NE;

    public long getId_Nivel() {
        return id_Nivel;
    }

    public void setId_Nivel(long id_Nivel) {
        this.id_Nivel = id_Nivel;
    }

    public String getDescricao_NE() {
        return Descricao_NE;
    }

    public void setDescricao_NE(String Descricao_NE) {
        this.Descricao_NE = Descricao_NE.toUpperCase();
    }

    @Override
    public String toString() {
        return "Nivel_Escolar{" + "id_Nivel=" + id_Nivel + ", Descricao_NE=" + Descricao_NE + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.id_Nivel ^ (this.id_Nivel >>> 32));
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
        final Nivel_Escolar other = (Nivel_Escolar) obj;
        if (this.id_Nivel != other.id_Nivel) {
            return false;
        }
        return true;
    }
    


}