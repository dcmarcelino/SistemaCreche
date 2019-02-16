/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.Bean;

import br.com.sistemacreche.dao.FuncionarioDAO;
import br.com.sistemacreche.dao.MunicipioDAO;
import br.com.sistemacreche.domain.Funcionario;
import br.com.sistemacreche.domain.Municipio;
import br.com.sistemacreche.domain.Pessoa;
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
@ManagedBean(name = "MBFuncionario")
@ViewScoped
public class FuncionarioBean implements Serializable {

    private Funcionario funcionario;
    private List<Funcionario> funcionarios;
    private String acao;
    private Funcionario itemSelecionado;
    private Pessoa pessoa;
    private List<Municipio> municipios;

    public Funcionario getFuncionario() {
        if (funcionario == null) {
            funcionario = new Funcionario();
        }
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Funcionario getItemSelecionado() {
        return itemSelecionado;
    }

    public void setItemSelecionado(Funcionario itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public void salvar() {

        try {
            FuncionarioDAO dao = new FuncionarioDAO();
            dao.salvar(funcionario);

            JSFUtil.enviarMensagemSucesso("Funcionario salvo com sucesso!");

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();
        }

    }

    public void editar() {

        try {
            FuncionarioDAO dao = new FuncionarioDAO();
            dao.editar(funcionario);

            JSFUtil.enviarMensagemSucesso("Funcionario editado com sucesso!");
            funcionario = new Funcionario();
            pessoa = new Pessoa();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void carregarCadastro() {
        try {
            // passa o parâmetro da ação para editar o item selecionado
            String valor = JSFUtil.getParam("forFuncionario");

            //passa o parâmetro da ação para poder ocultar botões
            acao = JSFUtil.getParam("acaoFuncionario");

            if (valor != null) {                // caso tenha código a operação é edição
                Long codigo = Long.parseLong(valor);

                FuncionarioDAO dao = new FuncionarioDAO();

                funcionario = dao.buscarPorMat(codigo);

            } else {
                funcionario = new Funcionario(); // caso não tenha nenhum código a operação é de cadastro

            }

            MunicipioDAO mdao = new MunicipioDAO();
            municipios = mdao.listar();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }
    }

    public void excluir(Long id) {
        try {
            FuncionarioDAO dao = new FuncionarioDAO();
            dao.excluir(id);

            JSFUtil.enviarMensagemSucesso("Funcionario excluido com sucesso!");
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro("Não foi possível excluir o Funcionario" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listar() {
        try {
            FuncionarioDAO dao = new FuncionarioDAO();
            funcionarios = dao.listar();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();
        }

    }

    public void buscarObjeto() {
        String valor = JSFUtil.getParam("id");
        acao = JSFUtil.getParam("acaoFuncionario");
        if (valor != null) {
            Long codigo = Long.parseLong(valor);

            FuncionarioDAO dao = new FuncionarioDAO();
            itemSelecionado = dao.buscarPorMat(codigo);

        } else {
            itemSelecionado = new Funcionario();
        }
    }

    public void redirecionar() throws IOException {

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);

        context.getExternalContext().redirect("FuncionarioConsulta.xhtml");

    }

    public String nomearTitulo() {

        if (acao.equalsIgnoreCase("novo")) {
            return "Cadastro de Funcionário";

        } else {
            return "Edição de Funcionário";
        }
    }

}
