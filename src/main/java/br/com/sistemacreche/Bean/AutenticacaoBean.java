package br.com.sistemacreche.Bean;

import br.com.sistemacreche.dao.PessoaDAO;
import br.com.sistemacreche.dao.UsuarioDAO;
import br.com.sistemacreche.domain.Pessoa;
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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.bean.ViewScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Service;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Dmarcelino
 */
@ManagedBean(name = "MBAutenticacao")
@SessionScoped
public class AutenticacaoBean implements Serializable {

    private Usuario usuario;
    private Usuario usuarioAutenticado = new Usuario();

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioAutenticado() {
//        if (usuarioAutenticado == null) {
////            usuarioAutenticado = new Usuario();
//        }
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    public void iniciarAuth() {
        usuario = new Usuario();

    }

    public void autenticarUsuario() {
        try {

            UsuarioDAO dao = new UsuarioDAO();
            usuarioAutenticado = dao.autenticar(usuario.getLogin(), usuario.getSenha());

            if (usuarioAutenticado == null) {
                JSFUtil.enviarMensagemErro("Login ou Senha incorretos!");

                return;
            }
            Faces.redirect("./faces/pages/Principal.xhtml");

            usuario = new Usuario();
        } catch (IOException e) {

            JSFUtil.enviarMensagemErro(e.getMessage());
            e.printStackTrace();

        }
    }

    public void logoutUsuario() throws IOException, ServletException {
        usuario = new Usuario();
        usuarioAutenticado = new Usuario();
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("#{AutenticacaoBean}");

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(true);
        session.invalidate();
        Faces.redirect("./faces/pages/Login.xhtml");
    }

    public String retornaImagem() {
        if (usuarioAutenticado.getCaminho() == null) {

            return "padrao";
        } else {
            return Long.toString(usuarioAutenticado.getId_Usuario());
        }
    }

    public boolean exibeConteudoUsuario() {
        if (usuarioAutenticado.getCod_Categoria() == 'U') {
            return false;
        } else {
            return true;
        }
    }

    public boolean exibeConteudoFuncionario() {
        if (usuarioAutenticado.getCod_Categoria() == 'F') {
            return false;
        } else {
            return true;
        }

    }

    public boolean exibeConteudoFuncUsuario() {
        if (usuarioAutenticado.getCod_Categoria() == 'F' || usuarioAutenticado.getCod_Categoria() == 'U') {
            return false;
        } else {
            return true;
        }
    }

    public boolean exibeConteudoFuncUsuDir() {
        return !(usuarioAutenticado.getCod_Categoria() == 'F'
                || usuarioAutenticado.getCod_Categoria() == 'U'
                || usuarioAutenticado.getCod_Categoria() == 'D');
    }
}
