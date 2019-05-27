/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.converter;

import br.com.sistemacreche.dao.TurmaDAO;
import br.com.sistemacreche.domain.Turma;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Dmarcelino
 */
@FacesConverter("converterTurma")
public class ConverterTurma implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent componente, String valor) {
        try {

            Long id = Long.parseLong(valor);
            TurmaDAO dao = new TurmaDAO();
            Turma turma = dao.buscarPorId(id);

            return turma;
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {
        try {

            Turma turma = (Turma) objeto;
            Long id = turma.getId_Turma();

            return id.toString();
        } catch (RuntimeException e) {
            return null;
        }

    }

}