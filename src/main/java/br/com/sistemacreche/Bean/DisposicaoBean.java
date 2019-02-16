/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.Bean;

import br.com.sistemacreche.dao.DisposicaoDAO;
import br.com.sistemacreche.domain.Disposicao;
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
@ManagedBean(name = "MBDisposicao")
@ViewScoped
public class DisposicaoBean implements Serializable {

    private Disposicao disposicao;
    private List<Disposicao> disposicoes;
    private String acao;
    private Disposicao itemSelecionado;

    public Disposicao getDisposicao() {
        if (disposicao == null) {
            disposicao = new Disposicao();
        }
        return disposicao;
    }

    public void setDisposicao(Disposicao disposicao) {
        this.disposicao = disposicao;
    }

    public List<Disposicao> getDisposicoes() {
        return disposicoes;
    }

    public void setDisposicoes(List<Disposicao> disposicoes) {
        this.disposicoes = disposicoes;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Disposicao getItemSelecionado() {
        return itemSelecionado;
    }

    public void setItemSelecionado(Disposicao itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public void salvar() {

        try {
            DisposicaoDAO dao = new DisposicaoDAO();
            dao.salvar(disposicao);

            JSFUtil.enviarMensagemSucesso("Disposiçao salva com sucesso!");

            disposicao = new Disposicao();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void editar() {

        try {
            DisposicaoDAO dao = new DisposicaoDAO();
            dao.editar(disposicao);

            JSFUtil.enviarMensagemSucesso("Disposiçao editada com sucesso!");

            disposicao = new Disposicao();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void carregarCadastro() {
        try {
            // passa o parâmetro da ação para editar o item selecionado
            String valor = JSFUtil.getParam("forDisposicao");

            //passa o parâmetro da ação para poder ocultar botões
            acao = JSFUtil.getParam("acaoDisposicao");

            if (valor != null) {
                Long codigo = Long.parseLong(valor);

                DisposicaoDAO dao = new DisposicaoDAO();
                disposicao = dao.buscarPorId(codigo);
            } else {
                disposicao = new Disposicao();
            }

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }
    }

    public void excluir(Long id) {
        try {
            DisposicaoDAO dao = new DisposicaoDAO();
            dao.excluir(id);

            JSFUtil.enviarMensagemSucesso("Disposição excluida com sucesso!");
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro("Não foi possível excluir a disposição" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listar() {
        try {
            DisposicaoDAO dao = new DisposicaoDAO();
            disposicoes = dao.listar();
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();
        }
    }

    public void buscarObjeto() {
        String valor = JSFUtil.getParam("id");
        acao = JSFUtil.getParam("acaoDisposicao");
        if (valor != null) {
            Long codigo = Long.parseLong(valor);

            DisposicaoDAO dao = new DisposicaoDAO();
            itemSelecionado = dao.buscarPorId(codigo);

        } else {
            itemSelecionado = new Disposicao();
        }
    }

    public void redirecionar() throws IOException {

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);

        context.getExternalContext().redirect("DisposicaoConsulta.xhtml");

    }

    public String nomearTitulo() {

        if (acao.equalsIgnoreCase("novo")) {
            return "Cadastro de Disposição";
    
        } else {
            return "Edição de Disposição";
        }
    }
    
}
