/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.converter;

import br.com.sistemacreche.dao.DisposicaoDAO;
import br.com.sistemacreche.domain.Disposicao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Dmarcelino
 */
@FacesConverter("converterDisposicao")
public class ConverterDisposicao implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent componente, String valor) {
        try {

            Long id = Long.parseLong(valor);
            DisposicaoDAO dao = new DisposicaoDAO();
            Disposicao disposicao = dao.buscarPorId(id);

            return disposicao;
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {
        try {

            Disposicao disposicao = (Disposicao) objeto;
            Long id = disposicao.getId_Disposicao();

            return id.toString();
        } catch (RuntimeException e) {
            return null;
        }

    }

}