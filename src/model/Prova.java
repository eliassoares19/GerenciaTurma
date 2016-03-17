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
public class Prova extends Avaliacao {
    private ArrayList<String> questoes;
    //private int maximo;
    private String ID;
    
    public Prova(){
    }
    
    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }
    
    public void adicionarQuestao(String q){
        questoes.add(q);
    }
    @Override
    public void setTexto(ArrayList<String> questoes){
        for(String q : questoes){
           this.adicionarQuestao(q);
        }
    }

    @Override
    public ArrayList<String> getQuestoesProva(){
        return questoes;
    }

    @Override
    public void setTexto(String descricao) {
    }

    @Override
    public String getQuestoesTrabalho() {
        return null;
    }
}
