/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.Bean;

import br.com.sistemacreche.dao.Nivel_EscolarDAO;
import br.com.sistemacreche.domain.Nivel_Escolar;
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
@ManagedBean(name = "MBNivel_Escolar")
@ViewScoped
public class Nivel_EscolarBean implements Serializable {

    private Nivel_Escolar nivel;
    private List<Nivel_Escolar> niveis;
    private String acao;
    private Nivel_Escolar itemSelecionado;

    public Nivel_Escolar getNivel_Escolar() {
        if (nivel == null) {
            nivel = new Nivel_Escolar();
        }
        return nivel;
    }

    public void setNivel_Escolar(Nivel_Escolar nivel) {
        this.nivel = nivel;
    }

    public List<Nivel_Escolar> getNiveis() {
        return niveis;
    }
    
     public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Nivel_Escolar getNivel() {
        return nivel;
    }

    public void setNivel(Nivel_Escolar nivel) {
        this.nivel = nivel;
    }

    public Nivel_Escolar getItemSelecionado() {
        return itemSelecionado;
    }

    public void setItemSelecionado(Nivel_Escolar itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }
    
    
    public void salvar() {

        try {
            Nivel_EscolarDAO dao = new Nivel_EscolarDAO();
            dao.salvar(nivel);

            JSFUtil.enviarMensagemSucesso("Nivel Escolar salvo com sucesso!");

            nivel = new Nivel_Escolar();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro("e.getMessage()");
            e.printStackTrace();

        }

    }
    
    public void editar() {

        try {
            Nivel_EscolarDAO dao = new Nivel_EscolarDAO();
            dao.editar(nivel);

            JSFUtil.enviarMensagemSucesso("Nivel Escolar editado com sucesso!");

            nivel = new Nivel_Escolar();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro("e.getMessage()");
            e.printStackTrace();

        }

    }
    
    public void carregarCadastro() {
        try {
            // passa o parâmetro da ação para editar o item selecionado
            String valor = JSFUtil.getParam("forNivel");

            //passa o parâmetro da ação para poder ocultar botões
            acao = JSFUtil.getParam("acaoNivel");

            if (valor != null) {
                Long codigo = Long.parseLong(valor);

                Nivel_EscolarDAO dao = new Nivel_EscolarDAO();
                nivel = dao.buscarPorId(codigo);
            } else {
                nivel = new Nivel_Escolar();
            }
          
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }
    }

    public void excluir(Long id) {
        try {
            Nivel_EscolarDAO dao = new Nivel_EscolarDAO();
            dao.excluir(id);

            JSFUtil.enviarMensagemSucesso("Nivel Escolar excluido com sucesso!");
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro("Não foi possível excluir o Nivel Escolar" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listar() {
        Nivel_EscolarDAO dao = new Nivel_EscolarDAO();
        niveis = dao.listar();
    }

    public void buscarObjeto() {
        String valor = JSFUtil.getParam("id");
        acao = JSFUtil.getParam("acaoNivel");
        if (valor != null) {
            Long codigo = Long.parseLong(valor);

            Nivel_EscolarDAO dao = new Nivel_EscolarDAO();
            itemSelecionado = dao.buscarPorId(codigo);

        } else {
            itemSelecionado = new Nivel_Escolar();
        }
    }

    public void redirecionar() throws IOException {

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);

        context.getExternalContext().redirect("NivelConsulta.xhtml");

    }
    
    public String nomearTitulo() {

        if (acao.equalsIgnoreCase("novo")) {
            return "Cadastro de Nivel";
    
        } else {
            return "Edição de Nivel";
        }
    }

}
