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
@Table (name= "Empresa")
@NamedQueries({
@NamedQuery(name = "Empresa.listar", query = "SELECT empresa FROM Empresa empresa"),
@NamedQuery(name = "Empresa.buscarPorId", query = "SELECT empresa FROM Empresa empresa WHERE empresa.id_Empresa = :id_Empresa")})
public class Empresa implements Serializable{
      
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
@Column (name="id_Empresa", nullable=false)
private long id_Empresa;   

@Column (name="Razao_Social", length=45, nullable=false)
private String Razao_Social;

@Column (name="Cnpj", length=14, nullable=false)
private String Cnpj;

@Column (name="Rua", length=45, nullable=false)
private String Rua;

@Column (name="Numero", length=8, nullable=false)
private String Numero;

@Column (name="Complemento", length=45, nullable=false)
private String Complemento;

@Column (name="Bairro", length=45, nullable=false)
private String Bairro;

@Column (name="Cep", length=9, nullable=false)
private String Cep;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "Municipio_id_Municipio", referencedColumnName = "id_Municipio", nullable=false)
private Municipio municipio;


    public long getId_Empresa() {
        return id_Empresa;
    }

    public void setId_Empresa(long id_Empresa) {
        this.id_Empresa = id_Empresa;
    }

    public String getRazao_Social() {
        return Razao_Social;
    }

    public void setRazao_Social(String Razao_Social) {
        this.Razao_Social = Razao_Social;
    }

    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String Cnpj) {
        this.Cnpj = Cnpj;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String Cep) {
        this.Cep = Cep;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        return "Empresa{" + "id_Empresa=" + id_Empresa + ", Razao_Social=" + Razao_Social + ", Cnpj=" + Cnpj + ", Rua=" + Rua + ", Numero=" + Numero + ", Complemento=" + Complemento + ", Bairro=" + Bairro + ", Cep=" + Cep + ", municipio=" + municipio + '}';
    }
    
}