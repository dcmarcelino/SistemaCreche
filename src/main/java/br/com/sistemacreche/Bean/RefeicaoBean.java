/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.Bean;

import br.com.sistemacreche.dao.RefeicaoDAO;
import br.com.sistemacreche.domain.Refeicao;
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
@ManagedBean(name = "MBRefeicao")
@ViewScoped
public class RefeicaoBean implements Serializable {

    private Refeicao refeicao;
    private List<Refeicao> refeicoes;
    private String acao;
    private Refeicao itemSelecionado;

    public Refeicao getRefeicao() {
        if (refeicao == null) {
            refeicao = new Refeicao();
        }
        return refeicao;
    }

    public void setRefeicao(Refeicao refeicao) {
        this.refeicao = refeicao;
    }

    public List<Refeicao> getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(List<Refeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Refeicao getItemSelecionado() {
        return itemSelecionado;
    }

    public void setItemSelecionado(Refeicao itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public void salvar() {

        try {
            RefeicaoDAO dao = new RefeicaoDAO();
            dao.salvar(refeicao);

            JSFUtil.enviarMensagemSucesso("Refeicao salva com sucesso!");

            refeicao = new Refeicao();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void editar() {

        try {
            RefeicaoDAO dao = new RefeicaoDAO();
            dao.editar(refeicao);

            JSFUtil.enviarMensagemSucesso("Refeicao editada com sucesso!");

            refeicao = new Refeicao();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void carregarCadastro() {
        try {
            // passa o parâmetro da ação para editar o item selecionado
            String valor = JSFUtil.getParam("forRefeicao");

            //passa o parâmetro da ação para poder ocultar botões
            acao = JSFUtil.getParam("acaoRefeicao");

            if (valor != null) {
                Long codigo = Long.parseLong(valor);

                RefeicaoDAO dao = new RefeicaoDAO();
                refeicao = dao.buscarPorId(codigo);
            } else {
                refeicao = new Refeicao();
            }

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }
    }

    public void excluir(Long id) {
        try {
            RefeicaoDAO dao = new RefeicaoDAO();
            dao.excluir(id);

            JSFUtil.enviarMensagemSucesso("Refeicao excluida com sucesso!");
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro("Não foi possível excluir a refeicao" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listar() {
        try {
            RefeicaoDAO dao = new RefeicaoDAO();
            refeicoes = dao.listar();
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();
        }
    }

    public void buscarObjeto() {
        String valor = JSFUtil.getParam("id");
        acao = JSFUtil.getParam("acaoRefeicao");
        if (valor != null) {
            Long codigo = Long.parseLong(valor);

            RefeicaoDAO dao = new RefeicaoDAO();
            itemSelecionado = dao.buscarPorId(codigo);

        } else {
            itemSelecionado = new Refeicao();
        }
    }

    public void redirecionar() throws IOException {

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);

        context.getExternalContext().redirect("RefeicaoConsulta.xhtml");

    }
    
    public String nomearTitulo() {

        if (acao.equalsIgnoreCase("novo")) {
            return "Cadastro de Refeicao";
    
        } else {
            return "Edição de Refeicao";
        }
    }
    
}
