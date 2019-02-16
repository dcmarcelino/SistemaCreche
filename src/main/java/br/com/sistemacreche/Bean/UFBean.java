package br.com.sistemacreche.Bean;

import br.com.sistemacreche.dao.UFDAO;
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
@ManagedBean(name = "MBuf", eager = true)
@ViewScoped
public class UFBean implements Serializable {

    private UF uf;
    private List<UF> ufs;
    private String acao;
    private UF itemSelecionado;

    public UF getUf() {
//        if (uf == null) {
//            uf = new UF();
//        }
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public List<UF> getUfs() {
        return ufs;
    }

    public void setUfs(List<UF> ufs) {
        this.ufs = ufs;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public UF getItemSelecionado() {
        return itemSelecionado;
    }

    public void setItemSelecionado(UF itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public void salvar() throws IOException {
        try {
            UFDAO dao = new UFDAO();
            dao.salvar(uf);

            JSFUtil.enviarMensagemSucesso("UF salvo com sucesso!");
            uf = new UF();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }
    }

    public void editar() throws IOException {

        try {
            UFDAO dao = new UFDAO();
            dao.editar(uf);

            JSFUtil.enviarMensagemSucesso("UF editado com sucesso!");
            uf = new UF();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void carregarCadastro() {
        try {
            // passa o parâmetro da ação para editar o item selecionado
            String valor = JSFUtil.getParam("forUF");

            //passa o parâmetro da ação para poder ocultar botões
            acao = JSFUtil.getParam("acaoUF");

            if (valor != null) {
                Long codigo = Long.parseLong(valor);

                UFDAO dao = new UFDAO();
                uf = dao.buscarPorId(codigo);
            } else {
                uf = new UF();
            }
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }
    }

    public void excluir(Long id) {
        try {
            UFDAO dao = new UFDAO();
            dao.excluir(id);

            JSFUtil.enviarMensagemSucesso("UF excluido com sucesso!");
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro("Não foi possível excluir a UF" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listar() {
        try {
            UFDAO dao = new UFDAO();
            ufs = dao.listar();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();
        }
    }

    public void buscarObjeto() {
        String valor = JSFUtil.getParam("id");
        acao = JSFUtil.getParam("acaoUF");
        if (valor != null) {
            Long codigo = Long.parseLong(valor);

            UFDAO dao = new UFDAO();
            itemSelecionado = dao.buscarPorId(codigo);

        } else {
            itemSelecionado = new UF();
        }
    }

    public void redirecionar() throws IOException {

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);

        context.getExternalContext().redirect("UFConsulta.xhtml");

    }

    public String nomearTitulo() {

        if (acao.equalsIgnoreCase("novo")) {
            return "Cadastro de UF";

        } else {
            return "Edição de UF";
        }
    }

}
