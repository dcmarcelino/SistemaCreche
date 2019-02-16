package br.com.sistemacreche.Bean;

import br.com.sistemacreche.dao.UsuarioDAO;
import br.com.sistemacreche.domain.Usuario;
import br.com.sistemacreche.util.JSFUtil;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.bean.ViewScoped;
import javax.xml.ws.Service;
import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Dmarcelino
 */

@ManagedBean(name = "MBUsuario")
@ViewScoped
public class UsuarioBean implements Serializable {

    private Usuario usuario;
    private List<Usuario> usuarios;
    private String acao;
    private Usuario itemSelecionado;
    private UploadedFile file;

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Usuario getItemSelecionado() {
        return itemSelecionado;
    }

    public void setItemSelecionado(Usuario itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void salvar() throws IOException {

        try {
    
            usuario.setCod_Categoria(adicionaCodCategoria(usuario.getCategoria())); //seta o código da categoria no usuario
//            usuario.setImgUser(file.getContents()); //salva o arquivo como BLOB no banco
            UsuarioDAO dao = new UsuarioDAO();
            Usuario retorno = dao.salvar(usuario);
            Path origem = Paths.get(usuario.getCaminho());
            Path destino = Paths.get("C:/Workspace/uploads/" + retorno.getId_Usuario() + ".jpg");

            Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);

            Messages.addGlobalInfo("Usuário salvo com sucesso!");

            usuario = new Usuario();

        } catch (RuntimeException | IOException e) {
            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void editar() {

        try {
            usuario.setCod_Categoria(adicionaCodCategoria(usuario.getCategoria())); //seta o código da categoria no usuario
            UsuarioDAO dao = new UsuarioDAO();
            dao.editar(usuario);

            Messages.addGlobalInfo("Usuario editado com sucesso!");

            usuario = new Usuario();

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }

    }

    public void carregarCadastro() {
        try {
            // passa o parâmetro da ação para editar o item selecionado
            String valor = JSFUtil.getParam("forUsuario");

            //passa o parâmetro da ação para poder ocultar botões
            acao = JSFUtil.getParam("acaoUsuario");

            if (valor != null) {
                Long codigo = Long.parseLong(valor);

                UsuarioDAO dao = new UsuarioDAO();
                usuario = dao.buscarPorId(codigo);
            } else {
                usuario = new Usuario();
            }

        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }
    }

    public void excluir(Long id) {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.excluir(id);

            JSFUtil.enviarMensagemSucesso("Usuario excluida com sucesso!");
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro("Não foi possível excluir a usuario" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listar() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            usuarios = dao.listar();
        } catch (RuntimeException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();
        }
    }

    public void buscarObjeto() {
        String valor = JSFUtil.getParam("id");
        acao = JSFUtil.getParam("acaoUsuario");
        if (valor != null) {
            Long codigo = Long.parseLong(valor);

            UsuarioDAO dao = new UsuarioDAO();
            
            usuario = dao.buscarPorId(codigo);

        } else {
            usuario = new Usuario();
        }
    }

//    public void redirecionar() throws IOException {
//
//        FacesContext context = FacesContext.getCurrentInstance();
//        context.getExternalContext().getFlash().setKeepMessages(true);
//
//        context.getExternalContext().redirect("UsuarioConsulta.xhtml");
//
//    }

    public String nomearTitulo() {

        if (acao.equalsIgnoreCase("novo")) {
            return "Cadastro de Usuario";

        } else {
            return "Edição de Usuario";
        }
    }

    public char adicionaCodCategoria(String categoria) {
        char Codcategoria;
        if (categoria.equalsIgnoreCase("ADMINISTRADOR")) {
           Codcategoria = 'A';
           return Codcategoria;
        } else {
            if (categoria.equalsIgnoreCase("USUARIO")) {
                Codcategoria = 'U';
                return Codcategoria;
            } else {
                if (categoria.equalsIgnoreCase("FUNCIONARIO")) {
                    usuario.setCod_Categoria('F');
                    Codcategoria = 'F';
                    return Codcategoria;
                }
            }
        }
        return 0;
    }

    public void handleFileUpload(FileUploadEvent evento) throws IOException {
        try {
            file = evento.getFile(); //pega a imagem que o usuário inseriu e transforma em um array de Bytes e salva no atributo do usuario
            Path temp = Files.createTempFile(null, null); //cria variavel com o caminho onde foi salvo temporariamente
            Files.copy(file.getInputstream(), temp, StandardCopyOption.REPLACE_EXISTING ); //1º parametros arquivo, 2º local, 3º formato copia
            usuario.setCaminho(temp.toString()); // recupera o caminho onde foi salvo temporariamente, transforma em string e seta no atributo
            JSFUtil.enviarMensagemSucesso("Arquivo enviado com sucesso");

        } catch (IOException e) {
            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();
        }

    }

}
