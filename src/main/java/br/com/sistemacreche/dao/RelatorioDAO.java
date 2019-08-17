/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.dao;

import br.com.sistemacreche.domain.Relatorio;
import br.com.sistemacreche.domain.Usuario;
import br.com.sistemacreche.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Dmarcelino
 */
public class RelatorioDAO {

    /* Todos os métodos de inserção, 
     exclusão ou alteração com o banco 
     deverão conter uma transação para saber 
     se foi ou não concluído com sucesso.*/
    Transaction transacao = null;

    public void salvar(Relatorio relatorio) {

        Session sessao = HibernateUtil.getSessionFactory().openSession(); //inicia a conexão com o banco

        try {
            transacao = sessao.beginTransaction();  //iniciando a transação
            sessao.save(relatorio); // Salva o objeto no banco 
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

    public List<Relatorio> listar() {

        Session sessao = HibernateUtil.getSessionFactory().openSession(); //inicia a conexão com o banco
        List<Relatorio> relatorios = null;

        try {

            Query consulta = sessao.getNamedQuery("Relatorio.listar"); //Executa query de listar
            relatorios = consulta.list();

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
        return relatorios;

    }

    public Relatorio buscarPorId(Long id) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Relatorio relatorio = null;

        try {

            Query consulta = sessao.getNamedQuery("Relatorio.buscarPorId");
            consulta.setLong("id_Relatorio", id);
            relatorio = (Relatorio) consulta.uniqueResult();

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
        return relatorio;
    }

    public void excluir(Relatorio relatorio) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(relatorio);
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
            Relatorio relatorio = buscarPorId(id);
            sessao.delete(relatorio);

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

    public void editar(Relatorio relatorio) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            transacao = sessao.beginTransaction();
            sessao.update(relatorio);
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

    public List<Relatorio> listarPorData(Date data) {

        String hql = "FROM Relatorio \n"
                + "WHERE Data_Rel like :Data_Rel";

        Session sessao = HibernateUtil.getSessionFactory().openSession(); //inicia a conexão com o banco
        List<Relatorio> relatorios = null;

        try {
            relatorios = sessao.createQuery(hql).setParameter("Data_Rel", data).list();

//            Query consulta = sessao.getNamedQuery("Relatorio.listarPorData"); //Executa query de listar por data
//            consulta.setDate("Data_Rel", data);
//            relatorios = consulta.list();
        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
        return relatorios;

    }
//    public List<Relatorio> listarPorData(Date data, Usuario usuario) {
//
//        String hql = "FROM Relatorio AS relatorio \n"
//                + "inner join relatorio.aluno AS aluno \n"  
//                + "WHERE relatorio.Data_Rel like :Data_Rel AND aluno.pessoa.id_Pessoa like :id_Pessoa";
//
//        Session sessao = HibernateUtil.getSessionFactory().openSession(); //inicia a conexão com o banco
//        List<Relatorio> relatorios = null;
//
//        try {
//            relatorios = sessao.createQuery(hql).setParameter("Data_Rel", data)
//                                                .setParameter("id_Pessoa", usuario.getPessoa().getId_Pessoa()).list();
//
////            Query consulta = sessao.getNamedQuery("Relatorio.listarPorData"); //Executa query de listar por data
////            consulta.setDate("Data_Rel", data);
////            relatorios = consulta.list();
//        } catch (RuntimeException e) {
//            throw e;
//
//        } finally {
//            sessao.close();
//        }
//        return relatorios;
//
//    }
}
