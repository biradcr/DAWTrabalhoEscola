/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;


import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Curso;
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
public class TestePersistirCurso {

    
    EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirCurso() {
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
            Curso c = new Curso();
            c.setNome("Religião");
            c.setSigla("RE");
            c.setDescricao("Matéria voltada para iniciantes");
            c.setAtivo(true);
            c.setInicioAtividades(new GregorianCalendar(2016, 04, 10));            
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}