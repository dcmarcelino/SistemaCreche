/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.domain;

import java.io.FileInputStream;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Dmarcelino
 */
@Entity
@Table(name = "Usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.listar", query = "SELECT usuario FROM Usuario usuario")
    ,
@NamedQuery(name = "Usuario.buscarPorId", query = "SELECT usuario FROM Usuario usuario WHERE usuario.id_Usuario = :id_Usuario")})
public class Usuario implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id_Usuario", nullable = false)
    private long id_Usuario;

    @Column(name = "Login", length = 45, nullable = false, unique = true)
    private String Login;

    @Column(name = "Senha", length = 100, nullable = false)
    private String Senha;

    @Column(name = "Categoria", length = 45, nullable = false)
    private String Categoria;

    @Column(name = "Cod_Categoria", length = 1, nullable = false)
    private char Cod_Categoria;

    @Lob
    @Column(name = "ImgUser", nullable = true)
    private byte[] ImgUser;

    @Transient
    private String caminho;
   
    public long getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(long id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public char getCod_Categoria() {
        return Cod_Categoria;
    }

    public void setCod_Categoria(char Cod_Categoria) {
        this.Cod_Categoria = Cod_Categoria;
    }

    public byte[] getImgUser() {
        return ImgUser;
    }

    public void setImgUser(byte[] ImgUser) {
        this.ImgUser = ImgUser;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_Usuario=" + id_Usuario + ", Login=" + Login + ", Senha=" + Senha + ", Categoria=" + Categoria + ", Cod_Categoria=" + Cod_Categoria + ", foto=" + ImgUser + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (int) (this.id_Usuario ^ (this.id_Usuario >>> 32));
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
        final Usuario other = (Usuario) obj;
        if (this.id_Usuario != other.id_Usuario) {
            return false;
        }
        return true;
    }

}
