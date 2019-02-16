/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Dmarcelino
 */
//Classe criada para carregar o hibernate quando executa o projeto, fazendo com que fique mais rápido os acessos
public class ContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateUtil.getSessionFactory().close();
    }
    
}
