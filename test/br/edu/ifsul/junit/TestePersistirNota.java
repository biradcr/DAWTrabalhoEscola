/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;


import br.edu.ifsul.modelo.Nota;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Ubiratan
 */
public class TestePersistirNota {

    
    EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirNota() {
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
            Nota n = new Nota();
            n.setNota01(8.0);
            n.setNota02(9.0);
            n.setMedia(8.5);
            em.getTransaction().begin();
            em.persist(n);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}