/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.converter;

import br.com.sistemacreche.dao.TexturaDAO;
import br.com.sistemacreche.domain.Textura;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Dmarcelino
 */
@FacesConverter("converterTextura")
public class ConverterTextura implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent componente, String valor) {
        try {

            Long id = Long.parseLong(valor);
            TexturaDAO dao = new TexturaDAO();
            Textura refeicao = dao.buscarPorId(id);

            return refeicao;
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {
        try {

            Textura refeicao = (Textura) objeto;
            Long id = refeicao.getId_Textura();

            return id.toString();
        } catch (RuntimeException e) {
            return null;
        }

    }

}