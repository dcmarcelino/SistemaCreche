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
@Table (name= "Disposicao")
@NamedQueries({
@NamedQuery(name = "Disposicao.listar", query = "SELECT disposicao FROM Disposicao disposicao"),
@NamedQuery(name = "Disposicao.buscarPorId", query = "SELECT disposicao FROM Disposicao disposicao WHERE disposicao.id_Disposicao = :id_Disposicao")})
public class Disposicao implements Serializable {
    
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
@Column (name="id_Disposicao",  nullable=false)
private long id_Disposicao; 
    
@Column (name="Dis_Descricao", length=45, nullable=false)
private String Dis_Descricao;

    public long getId_Disposicao() {
        return id_Disposicao;
    }

    public void setId_Disposicao(long id_Disposicao) {
        this.id_Disposicao = id_Disposicao;
    }

    public String getDis_Descricao() {
        return Dis_Descricao;
    }

    public void setDis_Descricao(String Dis_Descricao) {
        this.Dis_Descricao = Dis_Descricao.toUpperCase();
    }

    @Override
    public String toString() {
        return "Disposicao{" + "id_Disposicao=" + id_Disposicao + ", Dis_Descricao=" + Dis_Descricao + '}';
    }
   

}