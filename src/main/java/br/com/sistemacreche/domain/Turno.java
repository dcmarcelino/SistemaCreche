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
@Table (name= "Turno")
@NamedQueries({
@NamedQuery(name = "Turno.listar", query = "SELECT turno FROM Turno turno"),
@NamedQuery(name = "Turno.buscarPorId", query = "SELECT turno FROM Turno turno WHERE turno.id_Turno = :id_Turno")})
public class Turno implements Serializable{
    
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
@Column (name="id_Turno", nullable=false)
private long id_Turno; 


@Column (name="Tur_Descricao", length=45, nullable=false)
private String Tur_Descricao;  

    public long getId_Turno() {
        return id_Turno;
    }

    public void setId_Turno(long id_Turno) {
        this.id_Turno = id_Turno;
    }

    public String getTur_Descricao() {
        return Tur_Descricao;
    }

    public void setTur_Descricao(String Tur_Descricao) {
        this.Tur_Descricao = Tur_Descricao.toUpperCase();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.id_Turno ^ (this.id_Turno >>> 32));
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
        final Turno other = (Turno) obj;
        if (this.id_Turno != other.id_Turno) {
            return false;
        }
        return true;
    }


}


