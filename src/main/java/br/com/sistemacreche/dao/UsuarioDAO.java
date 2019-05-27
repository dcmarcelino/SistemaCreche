/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.dao;

import br.com.sistemacreche.domain.Usuario;
import br.com.sistemacreche.util.HibernateUtil;
import java.util.List;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dmarcelino
 */
public class UsuarioDAO {

    /* Todos os métodos de inserção, 
     exclusão ou alteração com o banco 
     deverão conter uma transação para saber 
     se foi ou não concluído com sucesso.*/
    Transaction transacao = null;

    public Usuario salvar(Usuario usuario) {

        Session sessao = HibernateUtil.getSessionFactory().openSession(); //inicia a conexão com o banco

        try {
            transacao = sessao.beginTransaction();  //iniciando a transação
            Usuario retorno = (Usuario) sessao.merge(usuario); // Salva o objeto no banco 
            transacao.commit(); //confirmando transacao
            return retorno;
        } catch (RuntimeException e) {

            if (transacao != null) {
                transacao.rollback(); //caso de problema, desfaz a transação    
            }
            throw e;
        } finally {
            sessao.close(); //finaliza a conexão com o banco
        }

    }

    public List<Usuario> listar() {

        Session sessao = HibernateUtil.getSessionFactory().openSession(); //inicia a conexão com o banco
        List<Usuario> usuarios = null;

        try {

            Query consulta = sessao.getNamedQuery("Usuario.listar"); //Executa query de listar
            usuarios = consulta.list();

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
        return usuarios;

    }

    public Usuario buscarPorId(Long id) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Usuario usuario = null;

        try {

            Query consulta = sessao.getNamedQuery("Usuario.buscarPorId");
            consulta.setLong("id_Usuario", id);
            usuario = (Usuario) consulta.uniqueResult();

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
        return usuario;
    }

    public void excluir(Usuario usuario) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(usuario);
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
            Usuario usuario = buscarPorId(id);
            sessao.delete(usuario);

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

    public void editar(Usuario usuario) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            transacao = sessao.beginTransaction();
            sessao.merge(usuario);
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

    public Usuario autenticar(String login, String senha) {

        Session sessao = HibernateUtil.getSessionFactory().openSession(); //inicia a conexão com o banco
        try {
            Criteria consulta = sessao.createCriteria(Usuario.class);
//            consulta.createAlias("usuario", "u");
            consulta.add(Restrictions.eq("Login", login));

            SimpleHash hash = new SimpleHash("SHA-1", senha);
            consulta.add(Restrictions.eq("Senha", hash.toHex()));
            Usuario resultado = (Usuario) consulta.uniqueResult();
            return resultado;
            
        } catch (Exception e) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw e;
        } finally {
            sessao.close();
        }
    }
}
