/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ubiratan
 */
@Entity
@Table(name = "nota")
public class Nota implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_nota", sequenceName = "seq_nota_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_nota", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "nota_01", columnDefinition = "numeric(10,2)")
    private Double nota01;
    @Column(name = "nota_02", columnDefinition = "numeric(10,2)")
    private Double nota02;
    @Column(name = "media", columnDefinition = "numeric(10,2)")
    private Double media;
    @NotNull(message = "O aluno não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false)
    private Aluno aluno;
    @NotNull(message = "A disciplina não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "disciplina", referencedColumnName = "id", nullable = false)
    private Disciplina disciplina;

    public Nota(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNota01() {
        return nota01;
    }

    public void setNota01(Double nota01) {
        this.nota01 = nota01;
    }

    public Double getNota02() {
        return nota02;
    }

    public void setNota02(Double nota02) {
        this.nota02 = nota02;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }
    
}
