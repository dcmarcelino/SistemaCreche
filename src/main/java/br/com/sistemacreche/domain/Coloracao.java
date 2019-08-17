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
@NamedQueries({
@NamedQuery(name = "Coloracao.listar", query = "SELECT coloracao FROM Coloracao coloracao"),
@NamedQuery(name = "Coloracao.buscarPorId", query = "SELECT coloracao FROM Coloracao coloracao WHERE coloracao.id_Coloracao = :id_Coloracao")})
public class Coloracao implements Serializable{
    
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@GeneratedValue(strategy = GenerationType.AUTO)
@Id
@Column (name="id_Coloracao", nullable=false)
private long id_Coloracao; 
    
@Column (name="Col_Descricao", length=45, nullable=false)
private String Col_Descricao;  

    public long getId_Coloracao() {
        return id_Coloracao;
    }

    public void setId_Coloracao(long id_Coloracao) {
        this.id_Coloracao = id_Coloracao;
    }

    public String getCol_Descricao() {
        return Col_Descricao;
    }

    public void setCol_Descricao(String Col_Descricao) {
        this.Col_Descricao = Col_Descricao.toUpperCase();
    }

    @Override
    public String toString() {
        return "Coloracao{" + "id_Coloracao=" + id_Coloracao + ", Col_Descricao=" + Col_Descricao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.id_Coloracao ^ (this.id_Coloracao >>> 32));
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
        final Coloracao other = (Coloracao) obj;
        if (this.id_Coloracao != other.id_Coloracao) {
            return false;
        }
        return true;
    }


}

