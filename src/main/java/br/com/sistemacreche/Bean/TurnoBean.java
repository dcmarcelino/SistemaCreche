package br.com.sistemacreche.Bean;

import br.com.sistemacreche.dao.TurnoDAO;
import br.com.sistemacreche.domain.Turno;
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
@ManagedBean(name = "MBTurno", eager = true)
@ViewScoped
public class TurnoBean implements Serializable {

    private Turno turno;
    private List<Turno> turnos;
    private String acao;
    private Turno itemSelecionado;

    public Turno getTurno() {

        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public Turno getItemSelecionado() {
        return itemSelecionado;
    }

    public void setItemSelecionado(Turno itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public void salvar() {

        try {
            TurnoDAO dao = new TurnoDAO();
            dao.salvar(turno);

            JSFUtil.enviarMensagemSucesso("Turno salvo com sucesso!");
            turno = new Turno();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void editar() {

        try {
            TurnoDAO dao = new TurnoDAO();
            dao.editar(turno);

            JSFUtil.enviarMensagemSucesso("Turno editado com sucesso!");
            turno = new Turno();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void carregarCadastro() {
        try {
            // passa o parâmetro da ação para editar o item selecionado
            String valor = JSFUtil.getParam("forTurno");

            //passa o parâmetro da ação para poder ocultar botões
            acao = JSFUtil.getParam("acaoTur");

            if (valor != null) {
                Long codigo = Long.parseLong(valor);

                TurnoDAO dao = new TurnoDAO();
                turno = dao.buscarPorId(codigo);
            } else {
                turno = new Turno();
            }
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }
    }

    public void excluir(Long id) {
        try {
            TurnoDAO dao = new TurnoDAO();
            dao.excluir(id);

            JSFUtil.enviarMensagemSucesso("Turno excluido com sucesso!");
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro("Não foi possível excluir o Turno" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listar() {
        try {
            TurnoDAO dao = new TurnoDAO();
            turnos = dao.listar();

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

            TurnoDAO dao = new TurnoDAO();
            itemSelecionado = dao.buscarPorId(codigo);

        } else {
            itemSelecionado = new Turno();
        }
    }

    public void redirecionar() throws IOException {

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);

        context.getExternalContext().redirect("TurnoConsulta.xhtml");

    }

    public String nomearTitulo() {

        if (acao.equalsIgnoreCase("novo")) {
            return "Cadastro de Turno";

        } else {
            return "Edição de Turno";
        }
    }

}
