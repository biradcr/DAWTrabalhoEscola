/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;


import br.edu.ifsul.modelo.Disciplina;
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
public class TestePersistirDisciplina {

    
    EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirDisciplina() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW_Escola");
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
            Disciplina d = new Disciplina();
            d.setNome("Matemática");
            d.setDescricao("Matéria voltada para iniciantes");
            d.setCargaHoraria(150.00);
            d.setConhecimentosMinimos("Saber as operações fundamentais da matemática");
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}