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
@Table (name= "Refeicao")
@NamedQueries({
@NamedQuery(name = "Refeicao.listar", query = "SELECT refeicao FROM Refeicao refeicao"),
@NamedQuery(name = "Refeicao.buscarPorId", query = "SELECT refeicao FROM Refeicao refeicao WHERE refeicao.id_Refeicao = :id_Refeicao")})
public class Refeicao implements Serializable{

@GeneratedValue(strategy = GenerationType.AUTO)
@Id
@Column (name="id_Refeicao", nullable=false)
private long id_Refeicao;

@Column (name="Ref_Descricao", length=45, nullable=false)
private String Ref_Descricao;

    public long getId_Refeicao() {
        return id_Refeicao;
    }

    public void setId_Refeicao(long id_Refeicao) {
        this.id_Refeicao = id_Refeicao;
    }

    public String getRef_Descricao() {
        return Ref_Descricao;
    }

    public void setRef_Descricao(String Ref_Descricao) {
        this.Ref_Descricao = Ref_Descricao.toUpperCase();
    }

    @Override
    public String toString() {
        return "Refeicao{" + "id_Refeicao=" + id_Refeicao + ", Ref_Descricao=" + Ref_Descricao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (this.id_Refeicao ^ (this.id_Refeicao >>> 32));
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
        final Refeicao other = (Refeicao) obj;
        if (this.id_Refeicao != other.id_Refeicao) {
            return false;
        }
        return true;
    }
    
    
}