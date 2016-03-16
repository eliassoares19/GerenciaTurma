/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Elias
 */
public class RespostaTrabalho extends FolhaResposta{
    private String texto;
    
    public RespostaTrabalho(Avaliacao av){
        super(av);
    }
    public void preencherFolhaResposta(String texto){
        this.texto = texto;
    }
}
