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
@Table (name= "UF")
@NamedQueries({
@NamedQuery(name = "UF.listar", query = "SELECT uf FROM UF uf"),
@NamedQuery(name = "UF.buscarPorId", query = "SELECT uf FROM UF uf WHERE uf.id_UF = :id_UF")})
public class UF implements Serializable{
    
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
@Column (name="id_UF", nullable=false)
private long id_UF; 
    
@Column (name="UF_Descricao", length=45, nullable=false)
private String UF_Descricao;

@Column (name="UF_Sigla", length=2, nullable=false)
private String UF_Sigla;

    public long getId_UF() {
        return id_UF;
    }

    public void setId_UF(long id_UF) {
        this.id_UF = id_UF;
    }

    public String getUF_Descricao() {
        return UF_Descricao;
    }

    public void setUF_Descricao(String UF_Descricao) {
        this.UF_Descricao = UF_Descricao.toUpperCase();
    }

    public String getUF_Sigla() {
        return UF_Sigla;
    }

    public void setUF_Sigla(String UF_Sigla) {
        this.UF_Sigla = UF_Sigla.toUpperCase();
    }

    @Override
    public String toString() {
        return "UF{" + "id_UF=" + id_UF + ", UF_Descricao=" + UF_Descricao + ", UF_Sigla=" + UF_Sigla + '}';
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.id_UF ^ (this.id_UF >>> 32));
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
        final UF other = (UF) obj;
        if (this.id_UF != other.id_UF) {
            return false;
        }
        return true;
    }

    
}