/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.Bean;

import br.com.sistemacreche.dao.AlunoDAO;
import br.com.sistemacreche.dao.MunicipioDAO;
import br.com.sistemacreche.dao.TurnoDAO;
import br.com.sistemacreche.domain.Aluno;
import br.com.sistemacreche.domain.Municipio;
import br.com.sistemacreche.domain.Pessoa;
import br.com.sistemacreche.domain.Turno;
import br.com.sistemacreche.util.JSFUtil;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.Path;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Dmarcelino
 */
@ManagedBean(name = "MBAluno")
@ViewScoped

public class AlunoBean implements Serializable {

    private Aluno aluno;
    private List<Aluno> alunos;
    private String acao;
    private Aluno itemSelecionado;
    private Pessoa pessoa;
    private List<Municipio> municipios;
    private List<Turno> turnos;
    private UploadedFile file;
    private String sit;

    public Aluno getAluno() {
        if (aluno == null) {
            aluno = new Aluno();
        }
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Aluno getItemSelecionado() {
        return itemSelecionado;
    }

    public void setItemSelecionado(Aluno itemSelecionado) {
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

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getFoto() {
        return sit;
    }

    public void setFoto(String sit) {
        this.sit = sit;
    }

    public void salvar() {

        try {
//            if (file != null) {

//                Pessoa pessoa = aluno.getPessoa();
//                pessoa.setSituacao('A');  //setando valor default como A ao cadastrar
//                aluno.setPessoa(pessoa);

                AlunoDAO dao = new AlunoDAO();
                dao.salvar(aluno);

                JSFUtil.enviarMensagemSucesso("Aluno salvo com sucesso!");
                this.file = null;
//            }
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();
        }

    }

    public void editar() {

        try {

            aluno.setPessoa(pessoa);
            AlunoDAO dao = new AlunoDAO();
            dao.editar(aluno);

            JSFUtil.enviarMensagemSucesso("Aluno editado com sucesso!");
            aluno = new Aluno();    
            pessoa = new Pessoa();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void carregarCadastro() {
        try {
            // passa o parâmetro da ação para editar o item selecionado
            String valor = JSFUtil.getParam("forAluno");

            //passa o parâmetro da ação para poder ocultar botões
            acao = JSFUtil.getParam("acaoAluno");

            if (valor != null) {                // caso tenha código a operação é edição
                Long codigo = Long.parseLong(valor);

                AlunoDAO dao = new AlunoDAO();

                aluno = dao.buscarPorMat(codigo);
                pessoa = aluno.getPessoa();

            } else {
                aluno = new Aluno(); // caso não tenha nenhum código a operação é de cadastro

            }

            TurnoDAO tdao = new TurnoDAO();
            turnos = tdao.listar();

            MunicipioDAO mdao = new MunicipioDAO();
            municipios = mdao.listar();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }
    }

    public void excluir(Long id) {
        try {
            AlunoDAO dao = new AlunoDAO();
            dao.excluir(id);

            JSFUtil.enviarMensagemSucesso("Aluno excluido com sucesso!");
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro("Não foi possível excluir o Aluno" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listar() {
        try {
            AlunoDAO dao = new AlunoDAO();
            alunos = dao.listar();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();
        }

    }

    public void buscarObjeto() {
        String valor = JSFUtil.getParam("id");
        acao = JSFUtil.getParam("acaoAluno");
        if (valor != null) {
            Long codigo = Long.parseLong(valor);

            AlunoDAO dao = new AlunoDAO();
            itemSelecionado = dao.buscarPorMat(codigo);

        } else {
            itemSelecionado = new Aluno();
        }
    }

    public void redirecionar() throws IOException {

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);

        context.getExternalContext().redirect("AlunoConsulta.xhtml");

    }

    public String nomearTitulo() {   //retorna o nome a ser exibido no cadastro ou alteração

        if (acao.equalsIgnoreCase("novo")) {
            return "Cadastro de Aluno";

        } else {
            return "Edição de Aluno";
        }
    }

//    public void gerarImagem() {
//
//        try {
//            if (itemSelecionado.getPessoa().getImagem() != null) {
//
//                java.nio.file.Path path = Paths.get(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/").toString() + "/temp/carro");
//
//                if (!Files.exists(path)) {
//                    Files.createDirectories(path);
//                }
//
//                path = Paths.get(path.toRealPath() + "/" + itemSelecionado.getMatricula_Aluno() + ".jpg");
//                if (!Files.exists(path)) {
//                    FileOutputStream fos = new FileOutputStream(path.toString());
//                    fos.write(itemSelecionado.getPessoa().getImagem());
//                    fos.close();
//                }
//
//                foto = "../temp/carro/" + itemSelecionado.getMatricula_Aluno() + ".jpg";
//
//            } else {
//
//                foto = null;
//
//            }
//        } catch (IOException e) {
//
//            JSFUtil.enviarMensagemErro(e.getMessage());
//            foto = null;
//
//        }
//
//    }
}
