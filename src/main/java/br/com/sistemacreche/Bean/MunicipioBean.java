/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.Bean;

import br.com.sistemacreche.dao.MunicipioDAO;
import br.com.sistemacreche.dao.UFDAO;
import br.com.sistemacreche.domain.Municipio;
import br.com.sistemacreche.domain.UF;
import br.com.sistemacreche.util.JSFUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dmarcelino
 */
@ManagedBean(name = "MBMunicipio")
@ViewScoped
public class MunicipioBean implements Serializable {

    private Municipio municipio;
    private List<Municipio> municipios;
    private List<UF> ufs;
    private UF uf;
    private String acao;
    private Municipio itemSelecionado;

    public Municipio getMunicipio() {
        if (municipio == null) {
            municipio = new Municipio();
        }
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public List<UF> getUfs() {
        return ufs;
    }

    public void setUfs(List<UF> ufs) {
        this.ufs = ufs;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Municipio getItemSelecionado() {
        return itemSelecionado;
    }

    public void setItemSelecionado(Municipio itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public void salvar() {

        try {
            MunicipioDAO dao = new MunicipioDAO();
            dao.salvar(municipio);

            JSFUtil.enviarMensagemSucesso("Municipio salvo com sucesso!");

            municipio = new Municipio();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void editar() {

        try {
            MunicipioDAO dao = new MunicipioDAO();
            dao.editar(municipio);

            JSFUtil.enviarMensagemSucesso("Municipio editado com sucesso!");
            municipio = new Municipio();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void carregarCadastro() {
        try {
            // passa o parâmetro da ação para editar o item selecionado
            String valor = JSFUtil.getParam("forMunicipio");

            //passa o parâmetro da ação para poder ocultar botões
            acao = JSFUtil.getParam("acaoMunicipio");

            if (valor != null) {
                Long codigo = Long.parseLong(valor);

                MunicipioDAO dao = new MunicipioDAO();
                municipio = dao.buscarPorId(codigo);
            } else {
                municipio = new Municipio();
            }
            UFDAO udao = new UFDAO();
            ufs = udao.listar();
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }
    }

    public void excluir(Long id) {
        try {
            MunicipioDAO dao = new MunicipioDAO();
            dao.excluir(id);

            JSFUtil.enviarMensagemSucesso("Municipio excluido com sucesso!");
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro("Não foi possível excluir o Municipio" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listar() {
        try {
            MunicipioDAO dao = new MunicipioDAO();
            municipios = dao.listar();

            UFDAO udao = new UFDAO();
            ufs = udao.listar();
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();
        }

    }
    
    public void buscarObjeto() {
        String valor = JSFUtil.getParam("id");
        acao = JSFUtil.getParam("acaoMunicipio");
        if (valor != null) {
            Long codigo = Long.parseLong(valor);

            MunicipioDAO dao = new MunicipioDAO();
            itemSelecionado = dao.buscarPorId(codigo);

        } else {
            itemSelecionado = new Municipio();
        }
    }

    public void redirecionar() throws IOException {

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);

        context.getExternalContext().redirect("MunicipioConsulta.xhtml");

    }
    
    public String nomearTitulo() {

        if (acao.equalsIgnoreCase("novo")) {
            return "Cadastro de Municipio";
    
        } else {
            return "Edição de Municipio";
        }
    }

}