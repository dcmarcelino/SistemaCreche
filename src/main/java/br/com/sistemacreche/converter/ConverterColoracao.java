/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.converter;

import br.com.sistemacreche.dao.ColoracaoDAO;
import br.com.sistemacreche.domain.Coloracao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Dmarcelino
 */
@FacesConverter("converterColoracao")
public class ConverterColoracao implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent componente, String valor) {
        try {

            Long id = Long.parseLong(valor);
            ColoracaoDAO dao = new ColoracaoDAO();
            Coloracao coloracao = dao.buscarPorId(id);

            return coloracao;
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {
        try {

            Coloracao coloracao = (Coloracao) objeto;
            Long id = coloracao.getId_Coloracao();

            return id.toString();
        } catch (RuntimeException e) {
            return null;
        }

    }

}