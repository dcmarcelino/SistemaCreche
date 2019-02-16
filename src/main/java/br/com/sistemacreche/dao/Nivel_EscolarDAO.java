/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.dao;

import br.com.sistemacreche.domain.Nivel_Escolar;
import br.com.sistemacreche.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Dmarcelino
 */
public class Nivel_EscolarDAO {
    
    /* Todos os métodos de inserção, 
     exclusão ou alteração com o banco 
     deverão conter uma transação para saber 
     se foi ou não concluído com sucesso.*/
    Transaction transacao = null;

    public void salvar(Nivel_Escolar nivel) {

        Session sessao = HibernateUtil.getSessionFactory().openSession(); //inicia a conexão com o banco

        try {
            transacao = sessao.beginTransaction();  //iniciando a transação
            sessao.save(nivel); // Salva o objeto no banco 
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

    public List<Nivel_Escolar> listar() {

        Session sessao = HibernateUtil.getSessionFactory().openSession(); //inicia a conexão com o banco
        List<Nivel_Escolar> niveis = null;

        try {

            Query consulta = sessao.getNamedQuery("Nivel_Escolar.listar"); //Executa query de listar
            niveis = consulta.list();

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
        return niveis;

    }

    public Nivel_Escolar buscarPorId(Long id) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Nivel_Escolar nivel = null;

        try {

            Query consulta = sessao.getNamedQuery("Nivel_Escolar.buscarPorId");
            consulta.setLong("id_Nivel", id);
            nivel = (Nivel_Escolar) consulta.uniqueResult();

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
        return nivel;
    }

    public void excluir(Nivel_Escolar nivel) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(nivel);
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
            Nivel_Escolar nivel = buscarPorId(id);
            sessao.delete(nivel);

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

    public void editar(Nivel_Escolar nivel) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            transacao = sessao.beginTransaction();
            sessao.update(nivel);
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
