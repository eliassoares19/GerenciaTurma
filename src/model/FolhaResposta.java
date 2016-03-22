/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Elias
 */
public class FolhaResposta {
    private float nota;
    private Avaliacao aval = null;
    private Aluno aluno;
    
    public FolhaResposta(Avaliacao aval) {
        this.aval = aval;
    }
    public float getNota() {
        return nota;
    }
    public void setNota(float nota) {
        this.nota = nota;
    }
    public Avaliacao getAval() {
        return aval;
    } 
    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        if(aluno.getResposta(aval.getID()) == this)
            this.aluno = aluno;
    }
    public void preencherFolhaResposta(String texto){
        
    }
    public void preencherFolhaResposta(int i, String resposta){
        
    }
}
