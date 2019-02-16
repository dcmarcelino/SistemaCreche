/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.converter;

import br.com.sistemacreche.dao.MunicipioDAO;
import br.com.sistemacreche.domain.Municipio;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Dmarcelino
 */
@FacesConverter("converterMunicipio")
public class ConverterMunicipio implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent componente, String valor) {
        try {

            Long id = Long.parseLong(valor);
            MunicipioDAO dao = new MunicipioDAO();
            Municipio municipio = dao.buscarPorId(id);

            return municipio;
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {
        try {

            Municipio municipio = (Municipio) objeto;
            Long id = municipio.getId_Municipio();

            return id.toString();
        } catch (RuntimeException e) {
            return null;
        }

    }

}