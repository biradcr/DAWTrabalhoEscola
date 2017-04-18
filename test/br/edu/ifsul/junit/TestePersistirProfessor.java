/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;


import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Professor;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Ubiratan
 */
public class TestePersistirProfessor {

    
    EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirProfessor() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW_EscolaPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    } 
    @Test
    public void teste() {
        boolean exception = false;
        try {
            Professor p = new Professor();
            p.setTitulacao("Doutorado");
            p.setEspecialidade(em.find(Especialidade.class, 4));
            p.setNome("Marcelo Borges");
            p.setEmail("marcelo.borges@hotmail.com");
            p.setNascimento(new GregorianCalendar(1981, 10, 16));
            p.setTopicosInteresse("Nada");
            
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}