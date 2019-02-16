/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.dao;

import br.com.sistemacreche.domain.Empresa;
import br.com.sistemacreche.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Dmarcelino
 */
public class EmpresaDAO {
    
     /* Todos os métodos de inserção, 
     exclusão ou alteração com o banco 
     deverão conter uma transação para saber 
     se foi ou não concluído com sucesso.*/
    Transaction transacao = null;

    public void salvar(Empresa empresa) {

        Session sessao = HibernateUtil.getSessionFactory().openSession(); //inicia a conexão com o banco

        try {
            transacao = sessao.beginTransaction();  //iniciando a transação
            sessao.save(empresa); // Salva o objeto no banco 
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

    public List<Empresa> listar() {

        Session sessao = HibernateUtil.getSessionFactory().openSession(); //inicia a conexão com o banco
        List<Empresa> empresas = null;

        try {

            Query consulta = sessao.getNamedQuery("Empresa.listar"); //Executa query de listar
            empresas = consulta.list();

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
        return empresas;

    }

    public Empresa buscarPorId(Long id) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Empresa empresa = null;

        try {

            Query consulta = sessao.getNamedQuery("Empresa.buscarPorId");
            consulta.setLong("id_Empresa", id);
            empresa = (Empresa) consulta.uniqueResult();

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
        return empresa;
    }

    public void excluir(Empresa empresa) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(empresa);
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
            Empresa empresa = buscarPorId(id);
            sessao.delete(empresa);

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

    public void editar(Empresa empresa) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            transacao = sessao.beginTransaction();
            sessao.update(empresa);
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
