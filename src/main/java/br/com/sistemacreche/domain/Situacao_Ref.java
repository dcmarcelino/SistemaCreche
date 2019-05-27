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
 * @author Marcelino
 */

@Entity
@Table (name= "Situacao_Ref")
@NamedQueries({
@NamedQuery(name = "Situacao_Ref.listar", query = "SELECT situacao FROM Situacao_Ref situacao"),
@NamedQuery(name = "Situacao_Ref.buscarPorId", query = "SELECT situacao FROM Situacao_Ref situacao WHERE situacao.id_Situacao_Ref = :id_Situacao_Ref")})
public class Situacao_Ref implements Serializable{
    
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
@Column (name="id_Situacao_Ref", nullable=false)
private long id_Situacao_Ref; 
    
@Column (name="Sit_Descricao", length=45, nullable=false)
private String Sit_Descricao;  

    public long getId_Situacao_Ref() {
        return id_Situacao_Ref;
    }

    public void setId_Situacao_Ref(long id_Situacao_Ref) {
        this.id_Situacao_Ref = id_Situacao_Ref;
    }

    public String getSit_Descricao() {
        return Sit_Descricao;
    }

    public void setSit_Descricao(String Sit_Descricao) {
        this.Sit_Descricao = Sit_Descricao.toUpperCase();
    }

    @Override
    public String toString() {
        return "Situacao_Ref{" + "id_Situacao_Ref=" + id_Situacao_Ref + ", Sit_Descricao=" + Sit_Descricao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.id_Situacao_Ref ^ (this.id_Situacao_Ref >>> 32));
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
        final Situacao_Ref other = (Situacao_Ref) obj;
        if (this.id_Situacao_Ref != other.id_Situacao_Ref) {
            return false;
        }
        return true;
    }


}