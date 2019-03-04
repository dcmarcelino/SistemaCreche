/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.Bean;

import br.com.sistemacreche.dao.FuncionarioDAO;
import br.com.sistemacreche.dao.RelatorioDAO;
import br.com.sistemacreche.domain.Funcionario;
import br.com.sistemacreche.domain.Relatorio;
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
@ManagedBean(name = "MBRelatorio")
@ViewScoped
public class RelatorioBean implements Serializable {

    private Relatorio relatorio;
    private List<Relatorio> relatorios;
    private String acao;
    private List<Funcionario> funcionarios;
    private Relatorio itemSelecionado;

    public Relatorio getRelatorio() {
        if (relatorio == null) {
            relatorio = new Relatorio();
        }
        return relatorio;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    public List<Relatorio> getRelatorios() {
        return relatorios;
    }

    public void setRelatorios(List<Relatorio> relatorios) {
        this.relatorios = relatorios;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Relatorio getItemSelecionado() {
        return itemSelecionado;
    }

    public void setItemSelecionado(Relatorio itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    

    public void salvar() {

        try {
            RelatorioDAO dao = new RelatorioDAO();
            dao.salvar(relatorio);

            JSFUtil.enviarMensagemSucesso("Relatorio salvo com sucesso!");

            relatorio = new Relatorio();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void editar() {

        try {
            RelatorioDAO dao = new RelatorioDAO();
            dao.editar(relatorio);

            JSFUtil.enviarMensagemSucesso("Relatorio editado com sucesso!");

            relatorio = new Relatorio();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void carregarCadastro() {
        try {
            // passa o parâmetro da ação para editar o item selecionado
            String valor = JSFUtil.getParam("forRelatorio");

            //passa o parâmetro da ação para poder ocultar botões
            acao = JSFUtil.getParam("acaoRelatorio");

            if (valor != null) {
                Long codigo = Long.parseLong(valor);

                RelatorioDAO dao = new RelatorioDAO();
                relatorio = dao.buscarPorId(codigo);
                
            } else {
                relatorio = new Relatorio();
            }
            
            FuncionarioDAO fdao = new FuncionarioDAO();
            funcionarios = fdao.listar();
                 

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }
    }

    public void excluir(Long id) {
        try {
            RelatorioDAO dao = new RelatorioDAO();
            dao.excluir(id);

            JSFUtil.enviarMensagemSucesso("Relatorio excluido com sucesso!");
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro("Não foi possível excluir o relatorio" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listar() {
        try {
            RelatorioDAO dao = new RelatorioDAO();
            relatorios = dao.listar();
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();
        }
    }

    public void buscarObjeto() {
        String valor = JSFUtil.getParam("id");
        acao = JSFUtil.getParam("acaoRelatorio");
        if (valor != null) {
            Long codigo = Long.parseLong(valor);

            RelatorioDAO dao = new RelatorioDAO();
            itemSelecionado = dao.buscarPorId(codigo);

        } else {
            itemSelecionado = new Relatorio();
        }
    }

    public void redirecionar() throws IOException {

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);

        context.getExternalContext().redirect("RelatorioConsulta.xhtml");

    }
    
    public String nomearTitulo() {

        if (acao.equalsIgnoreCase("novo")) {
            return "Cadastro de Relatorio";
    
        } else {
            return "Edição de Relatorio";
        }
    }
    
}
