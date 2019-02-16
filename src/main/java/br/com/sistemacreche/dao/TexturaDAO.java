/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.dao;

import br.com.sistemacreche.domain.Textura;
import br.com.sistemacreche.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Dmarcelino
 */
public class TexturaDAO {
    
    /* Todos os métodos de inserção, 
     exclusão ou alteração com o banco 
     deverão conter uma transação para saber 
     se foi ou não concluído com sucesso.*/
    Transaction transacao = null;

    public void salvar(Textura textura) {

        Session sessao = HibernateUtil.getSessionFactory().openSession(); //inicia a conexão com o banco

        try {
            transacao = sessao.beginTransaction();  //iniciando a transação
            sessao.save(textura); // Salva o objeto no banco 
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

    public List<Textura> listar() {

        Session sessao = HibernateUtil.getSessionFactory().openSession(); //inicia a conexão com o banco
        List<Textura> texturas = null;

        try {

            Query consulta = sessao.getNamedQuery("Textura.listar"); //Executa query de listar
            texturas = consulta.list();

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
        return texturas;

    }

    public Textura buscarPorId(Long id) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Textura textura = null;

        try {

            Query consulta = sessao.getNamedQuery("Textura.buscarPorId");
            consulta.setLong("id_Textura", id);
            textura = (Textura) consulta.uniqueResult();

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
        return textura;
    }

    public void excluir(Textura textura) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(textura);
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
            Textura textura = buscarPorId(id);
            sessao.delete(textura);

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

    public void editar(Textura textura) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            transacao = sessao.beginTransaction();
            sessao.update(textura);
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
