/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;


import br.edu.ifsul.modelo.Aluno;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author jorge
 */
public class TestePersistirAluno {

    
    EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirAluno() {
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
//            Aluno i = new Aluno();
//            i.setNome("Marcia Tol");
//            i.setEmail("marcia.toledo@gmail");
//            i.setNascimento(new GregorianCalendar(1992, 12, 11));
            List<Aluno> list = em.createQuery("from Aluno order by nome").getResultList();
//            em.getTransaction().begin();
//            em.persist(i);
//            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}