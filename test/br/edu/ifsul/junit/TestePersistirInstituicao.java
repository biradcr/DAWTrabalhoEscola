/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;


import br.edu.ifsul.modelo.Instituicao;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author jorge
 */
public class TestePersistirInstituicao {

    
    EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirInstituicao() {
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
            Instituicao i = new Instituicao();
            i.setAnoFundacao(new GregorianCalendar(2016, 10, 05));
            i.setNome("Ifsul Passo Fundo");
           //v.setData(new GregorianCalendar(2016, 15, 45));            
            em.getTransaction().begin();
            em.persist(i);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}