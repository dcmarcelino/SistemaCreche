/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.Bean;

import br.com.sistemacreche.dao.TexturaDAO;
import br.com.sistemacreche.domain.Textura;
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
@ManagedBean(name = "MBTextura")
@ViewScoped
public class TexturaBean implements Serializable {

    private Textura textura;
    private List<Textura> texturas;
    private String acao;
    private Textura itemSelecionado;

    public Textura getTextura() {
        if (textura == null) {
            textura = new Textura();
        }
        return textura;
    }

    public void setTextura(Textura textura) {
        this.textura = textura;
    }

    public List<Textura> getTexturas() {
        return texturas;
    }

    public void setTexturas(List<Textura> texturas) {
        this.texturas = texturas;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Textura getItemSelecionado() {
        return itemSelecionado;
    }

    public void setItemSelecionado(Textura itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public void salvar() {

        try {
            TexturaDAO dao = new TexturaDAO();
            dao.salvar(textura);

            JSFUtil.enviarMensagemSucesso("Textura salva com sucesso!");

            textura = new Textura();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void editar() {

        try {
            TexturaDAO dao = new TexturaDAO();
            dao.editar(textura);

            JSFUtil.enviarMensagemSucesso("Textura editada com sucesso!");

            textura = new Textura();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void carregarCadastro() {
        try {
            // passa o parâmetro da ação para editar o item selecionado
            String valor = JSFUtil.getParam("forTextura");

            //passa o parâmetro da ação para poder ocultar botões
            acao = JSFUtil.getParam("acaoTextura");

            if (valor != null) {
                Long codigo = Long.parseLong(valor);

                TexturaDAO dao = new TexturaDAO();
                textura = dao.buscarPorId(codigo);
            } else {
                textura = new Textura();
            }

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }
    }

    public void excluir(Long id) {
        try {
            TexturaDAO dao = new TexturaDAO();
            dao.excluir(id);

            JSFUtil.enviarMensagemSucesso("Textura excluida com sucesso!");
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro("Não foi possível excluir a textura" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listar() {
        try {
            TexturaDAO dao = new TexturaDAO();
            texturas = dao.listar();
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();
        }
    }

    public void buscarObjeto() {
        String valor = JSFUtil.getParam("id");
        acao = JSFUtil.getParam("acaoTextura");
        if (valor != null) {
            Long codigo = Long.parseLong(valor);

            TexturaDAO dao = new TexturaDAO();
            itemSelecionado = dao.buscarPorId(codigo);

        } else {
            itemSelecionado = new Textura();
        }
    }

    public void redirecionar() throws IOException {

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);

        context.getExternalContext().redirect("TexturaConsulta.xhtml");

    }
    
    public String nomearTitulo() {

        if (acao.equalsIgnoreCase("novo")) {
            return "Cadastro de Textura";
    
        } else {
            return "Edição de Textura";
        }
    }
    
}
