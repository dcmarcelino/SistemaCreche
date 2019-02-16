/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.dao;

import br.com.sistemacreche.domain.Municipio;
import br.com.sistemacreche.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Dmarcelino
 */
public class MunicipioDAO {
    
    /* Todos os métodos de inserção, 
     exclusão ou alteração com o banco 
     deverão conter uma transação para saber 
     se foi ou não concluído com sucesso.*/
    Transaction transacao = null;

    public void salvar(Municipio municipio) {

        Session sessao = HibernateUtil.getSessionFactory().openSession(); //inicia a conexão com o banco

        try {
            transacao = sessao.beginTransaction();  //iniciando a transação
            sessao.save(municipio); // Salva o objeto no banco 
            transacao.commit(); //confirmando transacao

        } catch (RuntimeException e) {

            if (transacao != null) {
                transacao.rollback(); //caso de problema, desfaz a transação    
            }
            throw e;
        } finally {
            sessao.close(); //finaliza a conexão com o banco
        }
    }

    public List<Municipio> listar() {

        Session sessao = HibernateUtil.getSessionFactory().openSession(); //inicia a conexão com o banco
        List<Municipio> municipios = null;

        try {

            Query consulta = sessao.getNamedQuery("Municipio.listar"); //Executa query de listar
            municipios = consulta.list();

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
        return municipios;

    }

    public Municipio buscarPorId(Long id) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Municipio municipio = null;

        try {

            Query consulta = sessao.getNamedQuery("Municipio.buscarPorId");
            consulta.setLong("id_Municipio", id);
            municipio = (Municipio) consulta.uniqueResult();

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
        return municipio;
    }

    public void excluir(Municipio municipio) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(municipio);
            transacao.commit();

        } catch (RuntimeException e) {

            if (transacao != null) {
                transacao.rollback();
            }
            throw e;
        } finally {
            sessao.close();
        }
    }

    public void excluir(Long id) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            transacao = sessao.beginTransaction();
            Municipio municipio = buscarPorId(id);
            sessao.delete(municipio);

            transacao.commit();

        } catch (RuntimeException e) {

            if (transacao != null) {
                transacao.rollback();
            }
            throw e;
        } finally {
            sessao.close();
        }
    }

    public void editar(Municipio municipio) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            transacao = sessao.beginTransaction();
            sessao.update(municipio);
            transacao.commit();

        } catch (RuntimeException e) {

            if (transacao != null) {
                transacao.rollback();
            }
            throw e;
        } finally {
            sessao.close();
        }
    }
    
}
