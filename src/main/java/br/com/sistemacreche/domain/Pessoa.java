/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Marcelino
 */
@Entity
@Table(name = "Pessoa")
@NamedQueries({
    @NamedQuery(name = "Pessoa.listar", query = "SELECT pessoa FROM Pessoa pessoa")
    ,
@NamedQuery(name = "Pessoa.buscarPorId", query = "SELECT pessoa FROM Pessoa pessoa WHERE pessoa.id_Pessoa = :id_Pessoa")})
public class Pessoa implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id_Pessoa", nullable = false)
    private long id_Pessoa;

    @Column(name = "Nome", length = 45, nullable = false)
    private String Nome;

    @Column(name = "Dt_Nasc", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Dt_Nasc;

//    @CPF (message = "CPF Inválido!")
    @Column(name = "Cpf", unique = true, length = 11, nullable = false)
    private String Cpf;

    @Column(name = "Rg", unique = true, length = 10, nullable = true)
    private String Rg;

    @Column(name = "Rua", length = 45, nullable = false)
    private String Rua;

    @Column(name = "Numero", length = 8, nullable = false)
    private String Numero;

    @Column(name = "Complemento", length = 45, nullable = true)
    private String Complemento;

    @Column(name = "Bairro", length = 45, nullable = false)
    private String Bairro;

    @Column(name = "Telefone1", length = 11, nullable = false)
    private String Telefone1;

    @Column(name = "Telefone2", length = 11, nullable = false)
    private String Telefone2;

    @Column(name = "Cep", length = 9, nullable = false)
    private String Cep;

    @Column(name = "Situacao", columnDefinition = "TINYINT", length = 1, nullable = false)
    private boolean Situacao = true;

    @Column(name = "Imagem", nullable = true)
    private byte[] Imagem;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Municipio_id_Municipio", referencedColumnName = "id_Municipio", nullable = false)
    private Municipio municipio;

    @OneToOne(mappedBy = "pessoa", targetEntity = Usuario.class,
             fetch = FetchType.EAGER)
    private Usuario usuario;

    public Pessoa() {

    }

    public long getId_Pessoa() {
        return id_Pessoa;
    }

    public void setId_Pessoa(long id_Pessoa) {
        this.id_Pessoa = id_Pessoa;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome.toUpperCase();
    }

    public Date getDt_Nasc() {
        return Dt_Nasc;
    }

    public void setDt_Nasc(Date Dt_Nasc) {
        this.Dt_Nasc = Dt_Nasc;
    }

    public String getCpf() throws ParseException {
        MaskFormatter mask = new MaskFormatter("###.###.###-##");  //retorna o valor formatado quando solicitado
        mask.setValueContainsLiteralCharacters(false);
        return mask.valueToString(Cpf);
    }

    public void setCpf(String Cpf) {
        String cpf = Cpf.replaceAll("[-.()]", "");  //Retira mascara do cpf antes de salvar
        this.Cpf = cpf;
    }

    public String getRg() throws ParseException {
        MaskFormatter mask = new MaskFormatter("##.###.###-#");  //retorna o valor formatado quando solicitado
        mask.setValueContainsLiteralCharacters(false);
        return mask.valueToString(Rg);
    }

    public void setRg(String Rg) {
        String rg = Rg.replaceAll("[-.()]", "");  //Retira mascara do rg antes de salvar
        this.Rg = rg;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua.toUpperCase();
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
        this.Complemento = Complemento.toUpperCase();
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro.toUpperCase();
    }

    public String getTelefone1() throws ParseException {
        MaskFormatter mask = new MaskFormatter("(##)#####-####"); //retorna o valor formatado quando solicitado
        mask.setValueContainsLiteralCharacters(false);
        return mask.valueToString(Telefone1);
    }

    public void setTelefone1(String Telefone) {
        String tel = Telefone.replaceAll("[-.()]", "");  //Retira mascara do telefone antes de salvar
        this.Telefone1 = tel;
    }

    public String getTelefone2() throws ParseException {
        MaskFormatter mask = new MaskFormatter("(##)#####-####"); //retorna o valor formatado quando solicitado
        mask.setValueContainsLiteralCharacters(false);
        return mask.valueToString(Telefone2);
    }

    public void setTelefone2(String Telefone) {
        String tel = Telefone.replaceAll("[-.()]", "");  //Retira mascara do telefone antes de salvar
        this.Telefone2 = tel;
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

    public boolean getSituacao() {
        return Situacao;
    }

    public void setSituacao(boolean Situacao) {
        this.Situacao = Situacao;
    }

    public byte[] getImagem() {
        return Imagem;
    }

    public void setImagem(byte[] Imagem) {
        this.Imagem = Imagem;
    }

    @Transient
    public String getAtivoFormatado() {
        String ativoFormatado = "Inativo";
        if (Situacao) {
            ativoFormatado = "Ativo";
        }
        return ativoFormatado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    @Override
    public String toString() {
        return "Pessoa{" + "id_Pessoa=" + id_Pessoa + ", Nome=" + Nome + ", Dt_Nasc=" + Dt_Nasc + ", Cpf=" + Cpf + ", Rg=" + Rg + ", Rua=" + Rua + ", Numero=" + Numero + ", Complemento=" + Complemento + ", Bairro=" + Bairro + ", Telefone1=" + Telefone1 + ", Telefone2=" + Telefone2 + ", Cep=" + Cep + ", Situacao=" + Situacao + ", municipio=" + municipio + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (int) (this.id_Pessoa ^ (this.id_Pessoa >>> 32));
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
        final Pessoa other = (Pessoa) obj;
        if (this.id_Pessoa != other.id_Pessoa) {
            return false;
        }
        return true;
    }

}
