/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.converter;

import br.com.sistemacreche.dao.PessoaDAO;
import br.com.sistemacreche.domain.Pessoa;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Dmarcelino
 */
@FacesConverter("converterPessoa")
public class ConverterPessoa implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent componente, String valor) {
        try {

            Long id = Long.parseLong(valor);
            PessoaDAO dao = new PessoaDAO();
            Pessoa pessoa = dao.buscarPorId(id);

            return pessoa;
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {
        try {

            Pessoa pessoa = (Pessoa) objeto;
            Long id = pessoa.getId_Pessoa();

            return id.toString();
        } catch (RuntimeException e) {
            return null;
        }

    }

}