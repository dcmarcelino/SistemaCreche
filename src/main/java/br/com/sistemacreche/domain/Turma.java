/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.domain;

import br.com.sistemacreche.util.CodificadorHex;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.commons.codec.DecoderException;





/**
 *
 * @author Marcelino
 */

@Entity
@Table (name= "Turma")
@NamedQueries({
@NamedQuery(name = "Turma.listar", query = "SELECT turma FROM Turma turma"),
@NamedQuery(name = "Turma.buscarPorId", query = "SELECT turma FROM Turma turma WHERE turma.id_Turma = :id_Turma")})
public class Turma implements Serializable{
    
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
@Column (name="id_Turma", nullable=false)
private long id_Turma; 


@Column (name="Tur_Descricao", length=45, nullable=false)
private String Tur_Descricao;  

@Column (name="Camera", length=500, nullable=true)
private String Camera = "";  

@OneToMany(mappedBy = "turma", targetEntity = Aluno.class, 
        cascade = CascadeType.ALL, fetch = FetchType.EAGER)
private List<Aluno> alunos;

    public long getId_Turma() {
        return id_Turma;
    }

    public void setId_Turma(long id_Turma) {
        this.id_Turma = id_Turma;
    }

    public String getTur_Descricao() {
        return Tur_Descricao;
    }

    public void setTur_Descricao(String Tur_Descricao) {
        this.Tur_Descricao = Tur_Descricao.toUpperCase();
    }

    public String getCamera() throws DecoderException, UnsupportedEncodingException {
        CodificadorHex cod = new CodificadorHex();
        return cod.toTexto(Camera);
    }

    public void setCamera(String Camera) {
         CodificadorHex cod = new CodificadorHex(); 
        this.Camera = cod.toHex(Camera);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.id_Turma ^ (this.id_Turma >>> 32));
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
        final Turma other = (Turma) obj;
        if (this.id_Turma != other.id_Turma) {
            return false;
        }
        return true;
    }


}


