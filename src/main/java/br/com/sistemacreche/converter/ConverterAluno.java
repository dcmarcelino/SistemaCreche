/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.converter;

import br.com.sistemacreche.dao.AlunoDAO;
import br.com.sistemacreche.domain.Aluno;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Dmarcelino
 */
@FacesConverter("converterAluno")
public class ConverterAluno implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent componente, String valor) {
        try {

            Long id = Long.parseLong(valor);
            AlunoDAO dao = new AlunoDAO();
            Aluno aluno = dao.buscarPorMat(id);

            return aluno;
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {
        try {

            Aluno aluno = (Aluno) objeto;
            Long id = aluno.getMatricula_Aluno();

            return id.toString();
        } catch (RuntimeException e) {
            return null;
        }

    }

}