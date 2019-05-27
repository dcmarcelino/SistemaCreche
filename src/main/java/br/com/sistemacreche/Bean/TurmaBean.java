package br.com.sistemacreche.Bean;

import br.com.sistemacreche.dao.TurmaDAO;
import br.com.sistemacreche.domain.Turma;
import br.com.sistemacreche.util.JSFUtil;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.codec.DecoderException;

/**
 *
 * @author Dmarcelino
 */
@ManagedBean(name = "MBTurma", eager = true)
@ViewScoped
public class TurmaBean implements Serializable {

    private Turma turma;
    private List<Turma> turmas;
    private String acao;
    private Turma itemSelecionado;

    public Turma getTurma(){
        if (turma == null) {
            turma = new Turma();
        }
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public Turma getItemSelecionado() {
        return itemSelecionado;
    }

    public void setItemSelecionado(Turma itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public void salvar() {

        try {
            TurmaDAO dao = new TurmaDAO();
            dao.salvar(turma);

            JSFUtil.enviarMensagemSucesso("Turma salvo com sucesso!");
            turma = new Turma();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void editar() {

        try {
            TurmaDAO dao = new TurmaDAO();
            dao.editar(turma);

            JSFUtil.enviarMensagemSucesso("Turma editado com sucesso!");
            turma = new Turma();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void carregarCadastro() {
        try {
            // passa o parâmetro da ação para editar o item selecionado
            String valor = JSFUtil.getParam("forTurma");

            //passa o parâmetro da ação para poder ocultar botões
            acao = JSFUtil.getParam("acaoTur");

            if (valor != null) {
                Long codigo = Long.parseLong(valor);

                TurmaDAO dao = new TurmaDAO();
                turma = dao.buscarPorId(codigo);
            } else {
                turma = new Turma();
            }
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }
    }

    public void excluir(Long id) {
        try {
            TurmaDAO dao = new TurmaDAO();
            dao.excluir(id);

            JSFUtil.enviarMensagemSucesso("Turma excluido com sucesso!");
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro("Não foi possível excluir o Turma" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listar() {
        try {
            TurmaDAO dao = new TurmaDAO();
            turmas = dao.listar();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();
        }
    }

    public void buscarObjeto() {
        String valor = JSFUtil.getParam("id");
        acao = JSFUtil.getParam("acaoTur");
        if (valor != null) {
            Long codigo = Long.parseLong(valor);

            TurmaDAO dao = new TurmaDAO();
            itemSelecionado = dao.buscarPorId(codigo);

        } else {
            itemSelecionado = new Turma();
        }
    }

    public void redirecionar() throws IOException {

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);

        context.getExternalContext().redirect("TurmaConsulta.xhtml");

    }

    public String nomearTitulo() {

        if (acao.equalsIgnoreCase("novo")) {
            return "Cadastro de Turma";

        } else {
            return "Edição de Turma";
        }
    }

    public boolean isCadastrado(String Camera) {
        if (Camera == null || Camera.equals("")) {
            return false;
        } else {
        }
        return true;
    }

    public String nomeCamera() throws DecoderException, UnsupportedEncodingException {
       int x = turma.getCamera().compareTo("");
        if (x == 0 && turma.getId_Turma() > 1) {
            return "Câmera Não Cadastrada";
        }else{
            return "";
        }
        
    }

}
