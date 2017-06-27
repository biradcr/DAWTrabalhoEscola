/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util;


import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Instituicao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;    
import java.util.Set;

/**
 *
 * @author ubiratan
 */
public class FabricaObjetos {
    
    public static List<Curso> carregarCursos(){
        List<Curso> lista = new ArrayList<>();
        Curso c = new Curso();
        Instituicao i = new Instituicao();
        
        c.setId(12);
        c.setNome("Tecnologia da Informação");
        c.setDescricao("Curso Técnico");
        c.setSigla("TI");
        c.setAtivo(true);
        c.setInstituicao(i);
        c.setInicioAtividades(Calendar.getInstance());        
        
        Disciplina d = new Disciplina();        
        d.setId(13);
        d.setNome("TOO");
        d.setDescricao("Tecnologia Orientada a Objeto");
        d.setConhecimentosMinimos("Algorítimo");
        d.setCargaHoraria(40.00);
        d.setCurso(c);
        c.addDisciplina(d);
        c.addDisciplina(d);        
        
        i.setId(908098);
        i.setNome("Anhanguera");
        i.setAnoFundacao(Calendar.getInstance());       
        
        lista.add(c);
        return lista;
    }    
    
}
