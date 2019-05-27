/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.converter;

import br.com.sistemacreche.dao.RefeicaoDAO;
import br.com.sistemacreche.domain.Refeicao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Dmarcelino
 */
@FacesConverter("converterRefeicao")
public class ConverterRefeicao implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent componente, String valor) {
        try {

            Long id = Long.parseLong(valor);
            RefeicaoDAO dao = new RefeicaoDAO();
            Refeicao refeicao = dao.buscarPorId(id);

            return refeicao;
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {
        try {

            Refeicao refeicao = (Refeicao) objeto;
            Long id = refeicao.getId_Refeicao();

            return id.toString();
        } catch (RuntimeException e) {
            return null;
        }

    }

}