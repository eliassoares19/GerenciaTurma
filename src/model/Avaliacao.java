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
public abstract class Avaliacao {
    private ArrayList<FolhaResposta> respostas;

    public abstract String getID();
    public abstract void setID(String ID);
    public abstract void setTexto(String descricao);
    public abstract void setTexto(ArrayList<String> questoes);
    public abstract String getQuestoesTrabalho();
    public abstract ArrayList<String> getQuestoesProva();
    public static Avaliacao criaAvaliacao(int tipo){
        switch(tipo){
            case 1: return new Prova();
            case 2: return new Trabalho();
            default: return null;
        }
    }
}
