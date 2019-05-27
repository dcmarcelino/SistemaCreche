/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.converter;

import br.com.sistemacreche.dao.FuncionarioDAO;
import br.com.sistemacreche.domain.Funcionario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Dmarcelino
 */
@FacesConverter("converterFuncionario")
public class ConverterFuncionario implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent componente, String valor) {
        try {

            Long id = Long.parseLong(valor);
            FuncionarioDAO dao = new FuncionarioDAO();
            Funcionario funcionario = dao.buscarPorMat(id);

            return funcionario;
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {
        try {

            Funcionario funcionario = (Funcionario) objeto;
            Long id = funcionario.getMatricula_Func();

            return id.toString();
        } catch (RuntimeException e) {
            return null;
        }

    }

}