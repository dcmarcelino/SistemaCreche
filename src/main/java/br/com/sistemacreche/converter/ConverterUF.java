/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.converter;

import br.com.sistemacreche.dao.UFDAO;
import br.com.sistemacreche.domain.UF;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Dmarcelino
 */
@FacesConverter("converterUF")
public class ConverterUF implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent componente, String valor) {
        try {

            Long id = Long.parseLong(valor);
            UFDAO dao = new UFDAO();
            UF uf = dao.buscarPorId(id);

            return uf;
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {
        try {

            UF uf = (UF) objeto;
            Long id = uf.getId_UF();

            return id.toString();
        } catch (RuntimeException e) {
            return null;
        }

    }

}
