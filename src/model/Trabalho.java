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
public class Trabalho extends Avaliacao{
    private String descricao;
    private String ID;
    
    public Trabalho(){
    }
    
    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }
    
    //Incluir trabalho
    @Override
    public void setTexto(String descricao){
        this.descricao = descricao;
    }
    @Override
    public void setTexto(ArrayList<String> questoes) {
    }

    @Override
    public String getQuestoesTrabalho() {
        return descricao;    
    }

    @Override
    public ArrayList<String> getQuestoesProva() {
        return null;
    }
}
