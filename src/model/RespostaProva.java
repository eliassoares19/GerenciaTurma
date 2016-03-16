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
public class RespostaProva extends FolhaResposta {
    private ArrayList<String> respostas;
    
    public RespostaProva(Avaliacao av){
        super(av);   
    }
    public void preencherFolhaResposta(int i, String resposta){
        this.respostas.set(i, resposta);
    }
}
