/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.dao;

import br.com.sistemacreche.domain.Aluno;
import br.com.sistemacreche.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Dmarcelino
 */
public class AlunoDAO {
    
    /* Todos os métodos de inserção, 
     exclusão ou alteração com o banco 
     deverão conter uma transação para saber 
     se foi ou não concluído com sucesso.*/
    Transaction transacao = null;

    public void salvar(Aluno aluno) {

        Session sessao = HibernateUtil.getSessionFactory().openSession(); //inicia a conexão com o banco

        try {
            transacao = sessao.beginTransaction();  //iniciando a transação
            sessao.save(aluno); // Salva o objeto no banco 
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

    public List<Aluno> listar() {

        Session sessao = HibernateUtil.getSessionFactory().openSession(); //inicia a conexão com o banco
        List<Aluno> alunos = null;

        try {

            Query consulta = sessao.getNamedQuery("Aluno.listar"); //Executa query de listar
            alunos = consulta.list();

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
        return alunos;

    }

    public Aluno buscarPorMat(Long matricula) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Aluno aluno = null;

        try {

            Query consulta = sessao.getNamedQuery("Aluno.buscarPorMat");
            consulta.setLong("Matricula_Aluno", matricula);
            aluno = (Aluno) consulta.uniqueResult();

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
        return aluno;
    }

    public void excluir(Aluno aluno) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(aluno);
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

    public void excluir(Long matricula) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            transacao = sessao.beginTransaction();
            Aluno aluno = buscarPorMat(matricula);
            sessao.delete(aluno);

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

    public void editar(Aluno aluno) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            transacao = sessao.beginTransaction();
            sessao.update(aluno);
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
