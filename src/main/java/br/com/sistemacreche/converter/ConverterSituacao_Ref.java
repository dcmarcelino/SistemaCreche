/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.converter;

import br.com.sistemacreche.dao.Situacao_RefDAO;
import br.com.sistemacreche.domain.Situacao_Ref;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Dmarcelino
 */
@FacesConverter("converterSituacao_Ref")
public class ConverterSituacao_Ref implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent componente, String valor) {
        try {

            Long id = Long.parseLong(valor);
            Situacao_RefDAO dao = new Situacao_RefDAO();
            Situacao_Ref situacao_ref = dao.buscarPorId(id);

            return situacao_ref;
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {
        try {

            Situacao_Ref situacao_ref = (Situacao_Ref) objeto;
            Long id = situacao_ref.getId_Situacao_Ref();

            return id.toString();
        } catch (RuntimeException e) {
            return null;
        }

    }

}