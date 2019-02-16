/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.converter;

import br.com.sistemacreche.dao.TurnoDAO;
import br.com.sistemacreche.domain.Turno;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Dmarcelino
 */
@FacesConverter("converterTurno")
public class ConverterTurno implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent componente, String valor) {
        try {

            Long id = Long.parseLong(valor);
            TurnoDAO dao = new TurnoDAO();
            Turno turno = dao.buscarPorId(id);

            return turno;
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {
        try {

            Turno turno = (Turno) objeto;
            Long id = turno.getId_Turno();

            return id.toString();
        } catch (RuntimeException e) {
            return null;
        }

    }

}