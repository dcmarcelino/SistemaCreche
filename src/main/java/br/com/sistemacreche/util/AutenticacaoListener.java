/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.util;

import br.com.sistemacreche.Bean.AutenticacaoBean;
import br.com.sistemacreche.domain.Usuario;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.omnifaces.util.Faces;

/**
 *
 * @author Marcelino
 */
public class AutenticacaoListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent pe) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String paginaAtual = Faces.getViewId();

        boolean paginaAutenticacao = paginaAtual.contains("Login.xhtml");

        if (!paginaAutenticacao) {

            AutenticacaoBean auth = (AutenticacaoBean) Faces.getSessionAttribute("MBAutenticacao");

            if (auth == null) {

                Faces.navigate("/pages/Login.xhtml");
                return;
            }

            Usuario usuario = auth.getUsuarioAutenticado();

            if (usuario == null) {

                Faces.navigate("/pages/Login.xhtml");
                return;

            }
        }
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PhaseId getPhaseId() {

        return PhaseId.RESTORE_VIEW;
    }

}
