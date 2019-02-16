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
@Table (name= "Textura")
@NamedQueries({
@NamedQuery(name = "Textura.listar", query = "SELECT textura FROM Textura textura"),
@NamedQuery(name = "Textura.buscarPorId", query = "SELECT textura FROM Textura textura WHERE textura.id_Textura = :id_Textura")})
public class Textura implements Serializable{
    
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
@Column (name="id_Textura", nullable=false)
private long id_Textura; 
    
@Column (name="Tex_Descricao", length=45, nullable=false)
private String Tex_Descricao; 

@Column (name="Tex_Observacao", length=150, nullable=false)
private String Tex_Observacao;

    public long getId_Textura() {
        return id_Textura;
    }

    public void setId_Textura(long id_Textura) {
        this.id_Textura = id_Textura;
    }

    public String getTex_Descricao() {
        return Tex_Descricao;
    }

    public void setTex_Descricao(String Tex_Descricao) {
        this.Tex_Descricao = Tex_Descricao.toUpperCase();
    }

    public String getTex_Observacao() {
        return Tex_Observacao;
    }

    public void setTex_Observacao(String Tex_Observacao) {
        this.Tex_Observacao = Tex_Observacao.toUpperCase();
    }

    @Override
    public String toString() {
        return "Textura{" + "id_Textura=" + id_Textura + ", Tex_Descricao=" + Tex_Descricao + ", Tex_Observacao=" + Tex_Observacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (this.id_Textura ^ (this.id_Textura >>> 32));
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
        final Textura other = (Textura) obj;
        if (this.id_Textura != other.id_Textura) {
            return false;
        }
        return true;
    }
    

  


}
