/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.Bean;

import br.com.sistemacreche.dao.AlunoDAO;
import br.com.sistemacreche.dao.ColoracaoDAO;
import br.com.sistemacreche.dao.DisposicaoDAO;
import br.com.sistemacreche.dao.FuncionarioDAO;
import br.com.sistemacreche.dao.Item_BanhoDAO;
import br.com.sistemacreche.dao.Item_FraldaDAO;
import br.com.sistemacreche.dao.Item_RefeicaoDAO;
import br.com.sistemacreche.dao.Item_RemedioDAO;
import br.com.sistemacreche.dao.RefeicaoDAO;
import br.com.sistemacreche.dao.RelatorioDAO;
import br.com.sistemacreche.dao.Situacao_RefDAO;
import br.com.sistemacreche.dao.TexturaDAO;
import br.com.sistemacreche.domain.Aluno;
import br.com.sistemacreche.domain.Coloracao;
import br.com.sistemacreche.domain.Disposicao;
import br.com.sistemacreche.domain.Funcionario;
import br.com.sistemacreche.domain.Item_Banho;
import br.com.sistemacreche.domain.Item_Fralda;
import br.com.sistemacreche.domain.Item_Refeicao;
import br.com.sistemacreche.domain.Item_Remedio;
import br.com.sistemacreche.domain.Refeicao;
import br.com.sistemacreche.domain.Relatorio;
import br.com.sistemacreche.domain.Situacao_Ref;
import br.com.sistemacreche.domain.Textura;
import br.com.sistemacreche.domain.UF;
import br.com.sistemacreche.util.JSFUtil;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.ObjectNotFoundException;

/**
 *
 * @author Dmarcelino
 */
@ManagedBean(name = "MBRelatorio")
@ViewScoped
public class RelatorioBean implements Serializable {

    private String acao;
    private Relatorio itemSelecionado;

    private Relatorio relatorio;
    private List<Relatorio> relatorios;

    private Funcionario funcionario;
    private List<Funcionario> funcionarios;

    private Aluno aluno;
    private List<Aluno> alunos;

    private Item_Refeicao item_refeicao;
    private List<Item_Refeicao> itens_refeicoes;

    private Item_Fralda item_fralda;
    private List<Item_Fralda> itens_fraldas;

    private Coloracao coloracao;
    private List<Coloracao> coloracoes;

    private Textura textura;
    private List<Textura> texturas;

    private Item_Banho item_banho;
    private List<Item_Banho> itens_banhos;

    private Item_Remedio item_remedio;
    private List<Item_Remedio> itens_remedios;

    private Disposicao disposicao;
    private List<Disposicao> disposicoes;

    private Refeicao refeicao;
    private List<Refeicao> refeicoes;

    private Situacao_Ref situacao_ref;
    private List<Situacao_Ref> situacoes_ref;

    private Date horaRefeicao;
    private Date dataRelatorio;
    private Date horaChegada;
    private Date horaSaida;

    private Date horaFralda;
    private String tipo = "";
    private String obs = "";

    private Date horaBanho;
    private Date horaRemedio;
    private String Remedio;
    private String Dosagem;
    private Date dataPesquisa = new Date();
    private String dataTemp, horaSaidaTemp, horaChegadaTemp;

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

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Disposicao> getDisposicoes() {
        return disposicoes;
    }

    public void setDisposicoes(List<Disposicao> disposicoes) {
        this.disposicoes = disposicoes;
    }

    public List<Item_Fralda> getItens_fraldas() {
        return itens_fraldas;
    }

    public void setFraldas(List<Item_Fralda> itens_fraldas) {
        this.itens_fraldas = itens_fraldas;
    }

    public List<Item_Banho> getItens_banhos() {
        return itens_banhos;
    }

    public void setItens_banhos(List<Item_Banho> itens_banhos) {
        this.itens_banhos = itens_banhos;
    }

    public Item_Remedio getItem_remedio() {
        if (item_remedio == null) {
            item_remedio = new Item_Remedio();
        }
        return item_remedio;
    }

    public void setItem_remedio(Item_Remedio item_remedio) {
        this.item_remedio = item_remedio;
    }

    public List<Item_Remedio> getItens_remedios() {
        return itens_remedios;
    }

    public void setItens_remedios(List<Item_Remedio> itens_remedios) {
        this.itens_remedios = itens_remedios;
    }

    public Refeicao getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(Refeicao refeicao) {
        this.refeicao = refeicao;
    }

    public Item_Refeicao getItem_refeicao() {
        if (item_refeicao == null) {
            item_refeicao = new Item_Refeicao();
        }
        return item_refeicao;
    }

    public void setItem_refeicao(Item_Refeicao item_refeicao) {
        this.item_refeicao = item_refeicao;
    }

    public List<Item_Refeicao> getItens_refeicoes() {
        return itens_refeicoes;
    }

    public void setItens_refeicoes(List<Item_Refeicao> itens_refeicoes) {
        this.itens_refeicoes = itens_refeicoes;
    }

    public List<Refeicao> getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(List<Refeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }

    public List<Situacao_Ref> getSituacoes_ref() {
        return situacoes_ref;
    }

    public void setSituacoes_ref(List<Situacao_Ref> situacoes_ref) {
        this.situacoes_ref = situacoes_ref;
    }

    public Situacao_Ref getSituacao_ref() {
        return situacao_ref;
    }

    public void setSituacao_ref(Situacao_Ref situacao_ref) {
        this.situacao_ref = situacao_ref;
    }

    public Date getHoraRefeicao() {
        return horaRefeicao;
    }

    public Funcionario getFuncionario() {
        if (funcionario == null) {
            funcionario = new Funcionario();
        }
        return funcionario;

    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setHoraRefeicao(Date horaRefeicao) {
        this.horaRefeicao = horaRefeicao;
    }

    public Disposicao getDisposicao() {
        return disposicao;
    }

    public void setDisposicao(Disposicao disposicao) {
        this.disposicao = disposicao;
    }

    public Date getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(Date horaChegada) {
        this.horaChegada = horaChegada;
    }

    public Date getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Date horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Date getDataRelatorio() {
        return dataRelatorio;
    }

    public void setDataRelatorio(Date dataRelatorio) {
        this.dataRelatorio = dataRelatorio;
    }

    public Item_Fralda getItem_fralda() {
        if (item_fralda == null) {
            item_fralda = new Item_Fralda();
        }
        return item_fralda;
    }

    public void setItem_fralda(Item_Fralda item_fralda) {
        this.item_fralda = item_fralda;
    }

    public Coloracao getColoracao() {
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

    public Textura getTextura() {
        return textura;
    }

    public void setTextura(Textura textura) {
        this.textura = textura;
    }

    public List<Textura> getTexturas() {
        return texturas;
    }

    public void setTexturas(List<Textura> texturas) {
        this.texturas = texturas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getHoraFralda() {
        return horaFralda;
    }

    public void setHoraFralda(Date horaFralda) {
        this.horaFralda = horaFralda;
    }

    public Item_Banho getItem_banho() {
        if (item_banho == null) {
            item_banho = new Item_Banho();
        }
        return item_banho;
    }

    public void setItem_banho(Item_Banho item_banho) {
        this.item_banho = item_banho;
    }

    public Date getHoraBanho() {
        return horaBanho;
    }

    public void setHoraBanho(Date horaBanho) {
        this.horaBanho = horaBanho;
    }

    public Date getHoraRemedio() {
        return horaRemedio;
    }

    public void setHoraRemedio(Date horaRemedio) {
        this.horaRemedio = horaRemedio;
    }

    public String getRemedio() {
        return Remedio;
    }

    public void setRemedio(String Remedio) {
        this.Remedio = Remedio;
    }

    public String getDosagem() {
        return Dosagem;
    }

    public void setDosagem(String Dosagem) {
        this.Dosagem = Dosagem;
    }

    public Date getDataPesquisa() {
        return dataPesquisa;
    }

    public void setDataPesquisa(Date dataPesquisa) {
        this.dataPesquisa = dataPesquisa;
    }

    public String getDataTemp() {
        return dataTemp;
    }

    public void setDataTemp(String dataTemp) {
        this.dataTemp = dataTemp;
    }

    public String getHoraSaidaTemp() {
        return horaSaidaTemp;
    }

    public void setHoraSaidaTemp(String horaSaidaTemp) {
        this.horaSaidaTemp = horaSaidaTemp;
    }

    public String getHoraChegadaTemp() {
        return horaChegadaTemp;
    }

    public void setHoraChegadaTemp(String horaChegadaTemp) {
        this.horaChegadaTemp = horaChegadaTemp;
    }

    public void salvar() {

        try {
            RelatorioDAO dao = new RelatorioDAO();
            Item_RefeicaoDAO idao = new Item_RefeicaoDAO();
            Item_FraldaDAO fdao = new Item_FraldaDAO();
            Item_BanhoDAO bdao = new Item_BanhoDAO();
            Item_RemedioDAO rdao = new Item_RemedioDAO();

            relatorio.setAluno(aluno);
            relatorio.setFuncionario(funcionario);
            relatorio.setData_Rel(dataRelatorio);
            relatorio.setHora_Chegada(horaChegada);
            relatorio.setHora_Saida(horaSaida);
            relatorio.setDisposicao(disposicao);
            dao.salvar(relatorio);

            if (itens_refeicoes != null) {
                for (Item_Refeicao item : itens_refeicoes) {
                    item.setRelatorio(relatorio);
                    idao.salvar(item);
                }
            }

            if (itens_fraldas != null) {
                for (Item_Fralda item : itens_fraldas) {
                    item.setRelatorio(relatorio);
                    fdao.salvar(item);
                }
            }

            if (itens_banhos != null) {
                for (Item_Banho item : itens_banhos) {
                    item.setRelatorio(relatorio);
                    bdao.salvar(item);
                }
            }

            if (itens_remedios != null) {
                for (Item_Remedio item : itens_remedios) {
                    item.setRelatorio(relatorio);
                    rdao.salvar(item);
                }
            }

            relatorio = new Relatorio();
            itens_refeicoes = new ArrayList<>();
            itens_fraldas = new ArrayList<>();

            JSFUtil.enviarMensagemSucesso("Relatorio salvo com sucesso!");
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
            String valor = JSFUtil.getParam("forAluno");

            //passa o parâmetro da ação para poder ocultar botões
            acao = JSFUtil.getParam("acaoRelatorio");

            if (valor != null) {
                Long codigo = Long.parseLong(valor);

//                RelatorioDAO dao = new RelatorioDAO();
//                relatorio = dao.buscarPorId(codigo);
                AlunoDAO adao = new AlunoDAO();

                aluno = adao.buscarPorMat(codigo);

                DisposicaoDAO ddao = new DisposicaoDAO();
                disposicoes = ddao.listar();

            } else {
                relatorio = new Relatorio();
            }

            FuncionarioDAO fdao = new FuncionarioDAO();
            funcionarios = fdao.listar();

            AlunoDAO adao = new AlunoDAO();
            alunos = adao.listar();

            RefeicaoDAO rdao = new RefeicaoDAO();
            refeicoes = rdao.listar();

            Situacao_RefDAO sdao = new Situacao_RefDAO();
            situacoes_ref = sdao.listar();

            TexturaDAO tdao = new TexturaDAO();
            texturas = tdao.listar();

            ColoracaoDAO cdao = new ColoracaoDAO();
            coloracoes = cdao.listar();

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
//            RelatorioDAO dao = new RelatorioDAO();
//            relatorios = dao.listar();

            AlunoDAO adao = new AlunoDAO();
            alunos = adao.listar();

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
            dataTemp = getDataFormatada(itemSelecionado.getData_Rel());
            horaChegadaTemp = getHoraFormatada(itemSelecionado.getHora_Chegada());
            horaSaidaTemp = getHoraFormatada(itemSelecionado.getHora_Saida());

        } else {
            itemSelecionado = new Relatorio();
        }
    }

    public void redirecionar() throws IOException {

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);

        context.getExternalContext().redirect("RelacaoAlunos.xhtml");

    }

    public String nomearTitulo() {

        if (acao.equalsIgnoreCase("novo")) {
            return "Cadastro de Relatorio";

        } else {
            return "Edição de Relatorio";
        }
    }

    public void incluirItemRefeicao() {

        try {
            if (itens_refeicoes == null) {
                itens_refeicoes = new ArrayList<>();
            }

            Item_Refeicao item_refeicao = new Item_Refeicao();

            item_refeicao.setHora_Ref(horaRefeicao);
            item_refeicao.setRefeicao(refeicao);
            item_refeicao.setSituacao(situacao_ref);

            itens_refeicoes.add(item_refeicao);

            // instanciando as classes depois de salvas para limpar os campos do formulario
            horaRefeicao = null;
            item_refeicao = new Item_Refeicao();
            situacao_ref = new Situacao_Ref();
            refeicao = new Refeicao();

            JSFUtil.enviarMensagemSucesso("Item incluído com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.enviarMensagemErro("Não foi possível incluir o item" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void incluirItemFralda() {

        try {
            if (itens_fraldas == null) {
                itens_fraldas = new ArrayList<>();
            }

            Item_Fralda item_fralda = new Item_Fralda();

            item_fralda.setHora_Fralda(horaFralda);
            item_fralda.setColoracao(coloracao);
            item_fralda.setTextura(textura);
            item_fralda.setObs_Fralda(obs);
            item_fralda.setTipo(tipo);

            itens_fraldas.add(item_fralda);

            // instanciando as classes depois de salvas para limpar os campos do formulario
            horaFralda = null;
            item_fralda = new Item_Fralda();
            textura = new Textura();
            coloracao = new Coloracao();
            obs = "";
            tipo = "";

            JSFUtil.enviarMensagemSucesso("Item incluído com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.enviarMensagemErro("Não foi possível incluir o item" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void incluirItemBanho() {

        try {
            if (itens_banhos == null) {
                itens_banhos = new ArrayList<>();
            }

            item_banho.setHora_Banho(horaBanho);

            itens_banhos.add(item_banho);

            // instanciando as classes depois de salvas para limpar os campos do formulario
            horaBanho = null;
            item_banho = new Item_Banho();

            JSFUtil.enviarMensagemSucesso("Item incluído com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.enviarMensagemErro("Não foi possível incluir o item" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void incluirItemRemedio() {

        try {
            if (itens_remedios == null) {
                itens_remedios = new ArrayList<>();
            }

            item_remedio.setHora_Remedio(horaRemedio);
            item_remedio.setRemedio(Remedio);
            item_remedio.setDosagem(Dosagem);

            itens_remedios.add(item_remedio);

            // instanciando as classes depois de salvas para limpar os campos do formulario
            horaRemedio = null;
            Remedio = "";
            Dosagem = "";
            item_remedio = new Item_Remedio();

            JSFUtil.enviarMensagemSucesso("Item incluído com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.enviarMensagemErro("Não foi possível incluir o item" + e.getMessage());
            e.printStackTrace();
        }

    }

    public String getHoraFormatada(Date hora) {
        SimpleDateFormat sdf;
        if (hora == null) {
            return "";
        } else {
            sdf = new SimpleDateFormat("HH:mm");
            sdf.setLenient(false);
        }
        return sdf.format(hora);
    }

    public String getDataFormatada(Date data) {
        SimpleDateFormat sdf;
        if (data == null) {
            return "";
        } else {
            sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
        }
        return sdf.format(data);

    }
//    public void removerRefeicao(Item_Refeicao item_refeicao) {
//        try {
//            for (Item_Refeicao item : itens_refeicoes) {
//                if (item.equals(item_refeicao)) {
//                    itens_refeicoes.remove(item);
//                }
//            }
//            JSFUtil.enviarMensagemSucesso("Item removido com sucesso!");
//
//        } catch (RuntimeException e) {
//            JSFUtil.enviarMensagemErro("Não foi possível remover o item" + e.getMessage());
//            e.printStackTrace();
//
//        }
//    }

    public boolean isCadastrado(Aluno a) {
        boolean temp = false;
        int x;
        RelatorioDAO rdao = new RelatorioDAO();
        List<Relatorio> relatorios = new ArrayList();

        relatorios = rdao.listarPorData(dataPesquisa);

        for (Relatorio rel : relatorios) {
            x = getDataFormatada(rel.getData_Rel()).compareTo(getDataFormatada(dataPesquisa));
            if (rel.getAluno().equals(a) && x == 0) {
                temp = true;
            }
        }
        return temp;
    }
//
//    public String buscarPorIdeData(Aluno a) {
//        Long temp = 0L;
//        int x;
//        RelatorioDAO rdao = new RelatorioDAO();
//        List<Relatorio> relatorios = new ArrayList();
//
//        relatorios = rdao.listarPorData(dataPesquisa);
//
//        for (Relatorio rel : relatorios) {
//            x = getDataFormatada(rel.getData_Rel()).compareTo(getDataFormatada(dataPesquisa));
//            if (rel.getAluno().equals(a) && x == 0) {
//                temp = rel.getId_Relatorio();
//            }
//        }
//        return temp.toString();
//    }

    public void buscarPorData() {
        try {
            RelatorioDAO rdao = new RelatorioDAO();
            relatorios = rdao.listarPorData(dataPesquisa);
        } catch (ObjectNotFoundException e) {
            JSFUtil.enviarMensagemErro("Nenhum relatório cadastrado com a data informada");
            e.printStackTrace();
        }

    }

    public void obsFraldas(Item_Fralda item) {
        obs = item.getTextura().getTex_Observacao();
        tipo = item.getObs_Fralda();
    }
}
