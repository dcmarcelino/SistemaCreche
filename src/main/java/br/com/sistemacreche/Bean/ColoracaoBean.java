/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.Bean;

import br.com.sistemacreche.dao.ColoracaoDAO;
import br.com.sistemacreche.domain.Coloracao;
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
@ManagedBean(name = "MBColoracao")
@ViewScoped
public class ColoracaoBean implements Serializable {

    private Coloracao coloracao;
    private List<Coloracao> coloracoes;
    private String acao;
    private Coloracao itemSelecionado;

    public Coloracao getColoracao() {
        if (coloracao == null) {
            coloracao = new Coloracao();
        }
        return coloracao;
    }

    public void setColoracao(Coloracao coloracao) {
        this.coloracao = coloracao;
    }

    public List<Coloracao> getColoracoes() {
        return coloracoes;
    }

    public void setColoracoes(List<Coloracao> coloracoes) {
        this.coloracoes = coloracoes;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Coloracao getItemSelecionado() {
        return itemSelecionado;
    }

    public void setItemSelecionado(Coloracao itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public void salvar() {

        try {
            ColoracaoDAO dao = new ColoracaoDAO();
            dao.salvar(coloracao);

            JSFUtil.enviarMensagemSucesso("Coloração salva com sucesso!");

            coloracao = new Coloracao();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void editar() {

        try {
            ColoracaoDAO dao = new ColoracaoDAO();
            dao.editar(coloracao);

            JSFUtil.enviarMensagemSucesso("Coloracao editada com sucesso!");

            coloracao = new Coloracao();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void carregarCadastro() {
        try {
            // passa o parâmetro da ação para editar o item selecionado
            String valor = JSFUtil.getParam("forColoracao");

            //passa o parâmetro da ação para poder ocultar botões
            acao = JSFUtil.getParam("acaoColoracao");

            if (valor != null) {
                Long codigo = Long.parseLong(valor);

                ColoracaoDAO dao = new ColoracaoDAO();
                coloracao = dao.buscarPorId(codigo);
            } else {
                coloracao = new Coloracao();
            }

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }
    }

    public void excluir(Long id) {
        try {
            ColoracaoDAO dao = new ColoracaoDAO();
            dao.excluir(id);

            JSFUtil.enviarMensagemSucesso("Coloracao excluida com sucesso!");
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro("Não foi possível excluir a coloracao" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listar() {
        try {
            ColoracaoDAO dao = new ColoracaoDAO();
            coloracoes = dao.listar();
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();
        }
    }

    public void buscarObjeto() {
        String valor = JSFUtil.getParam("id");
        acao = JSFUtil.getParam("acaoColoracao");
        if (valor != null) {
            Long codigo = Long.parseLong(valor);

            ColoracaoDAO dao = new ColoracaoDAO();
            itemSelecionado = dao.buscarPorId(codigo);

        } else {
            itemSelecionado = new Coloracao();
        }
    }

    public void redirecionar() throws IOException {

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);

        context.getExternalContext().redirect("ColoracaoConsulta.xhtml");

    }
    
    public String nomearTitulo() {

        if (acao.equalsIgnoreCase("novo")) {
            return "Cadastro de Coloração";
    
        } else {
            return "Edição de Coloração";
        }
    }
    
}
