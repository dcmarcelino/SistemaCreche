/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.Bean;

import br.com.sistemacreche.dao.Situacao_RefDAO;
import br.com.sistemacreche.domain.Situacao_Ref;
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
@ManagedBean(name = "MBSituacao_Ref")
@ViewScoped
public class Situacao_RefBean implements Serializable {

    private Situacao_Ref situacao_Ref;
    private List<Situacao_Ref> situacoes_Ref;
    private String acao;
    private Situacao_Ref itemSelecionado;

    public Situacao_Ref getSituacao_Ref() {
        if (situacao_Ref == null) {
            situacao_Ref = new Situacao_Ref();
        }
        return situacao_Ref;
    }

    public void setSituacao_Ref(Situacao_Ref situacao_Ref) {
        this.situacao_Ref = situacao_Ref;
    }

    public List<Situacao_Ref> getSituacoes_Ref() {
        return situacoes_Ref;
    }

    public void setSituacoes_Ref(List<Situacao_Ref> situacoes_Ref) {
        this.situacoes_Ref = situacoes_Ref;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Situacao_Ref getItemSelecionado() {
        return itemSelecionado;
    }

    public void setItemSelecionado(Situacao_Ref itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public void salvar() {

        try {
            Situacao_RefDAO dao = new Situacao_RefDAO();
            dao.salvar(situacao_Ref);

            JSFUtil.enviarMensagemSucesso("Situacao_Ref salva com sucesso!");

            situacao_Ref = new Situacao_Ref();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void editar() {

        try {
            Situacao_RefDAO dao = new Situacao_RefDAO();
            dao.editar(situacao_Ref);

            JSFUtil.enviarMensagemSucesso("Situacao_Ref editada com sucesso!");

            situacao_Ref = new Situacao_Ref();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void carregarCadastro() {
        try {
            // passa o parâmetro da ação para editar o item selecionado
            String valor = JSFUtil.getParam("forSituacao_Ref");

            //passa o parâmetro da ação para poder ocultar botões
            acao = JSFUtil.getParam("acaoSituacao_Ref");

            if (valor != null) {
                Long codigo = Long.parseLong(valor);

                Situacao_RefDAO dao = new Situacao_RefDAO();
                situacao_Ref = dao.buscarPorId(codigo);
            } else {
                situacao_Ref = new Situacao_Ref();
            }

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }
    }

    public void excluir(Long id) {
        try {
            Situacao_RefDAO dao = new Situacao_RefDAO();
            dao.excluir(id);

            JSFUtil.enviarMensagemSucesso("Situacao_Ref excluida com sucesso!");
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro("Não foi possível excluir a situacao_Ref" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listar() {
        try {
            Situacao_RefDAO dao = new Situacao_RefDAO();
            situacoes_Ref = dao.listar();
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();
        }
    }

    public void buscarObjeto() {
        String valor = JSFUtil.getParam("id");
        acao = JSFUtil.getParam("acaoSituacao_Ref");
        if (valor != null) {
            Long codigo = Long.parseLong(valor);

            Situacao_RefDAO dao = new Situacao_RefDAO();
            itemSelecionado = dao.buscarPorId(codigo);

        } else {
            itemSelecionado = new Situacao_Ref();
        }
    }

    public void redirecionar() throws IOException {

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);

        context.getExternalContext().redirect("SituacaoRefeicaoConsulta.xhtml");

    }
    
    public String nomearTitulo() {

        if (acao.equalsIgnoreCase("novo")) {
            return "Cadastro de Situacao_Ref";
    
        } else {
            return "Edição de Situacao_Ref";
        }
    }
    
}
