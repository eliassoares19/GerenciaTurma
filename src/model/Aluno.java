package model;

import java.util.ArrayList;
import util.Logavel;

/**
 *
 * @author Elias
 */
public class Aluno implements Logavel{
    private String nome;
    private String matricula;
    private String senha;
    private ArrayList<FolhaResposta> respostas = new ArrayList<>();
    private ArrayList<FolhaResposta> respostasProva = new ArrayList<>();
    private ArrayList<FolhaResposta> respostasTrabalho = new ArrayList<>();
    
    public Aluno(String n, String m, String senha){ 
        nome = n;
        matricula = m;
        this.senha = senha;
        this.respostas = new ArrayList<FolhaResposta>();
    }    
    public String getNome() {
        return nome;
    }
    public String getMatricula() {
        return matricula;
    }
    @Override
    public boolean verificarSenha(String s){
        return senha.equals(s);
    }        
    @Override
    public boolean alterarSenha(String atual, String nova){
        if( senha.equals(atual) ){
            senha = nova;
            return true;
        }
        return false;
    }    
    //Aluno adiciona resposta
    public void addResposta(FolhaResposta resp){
        respostas.add(resp);
        resp.setAluno(this);
    }
    //Visualiza Folha de resposta
    public FolhaResposta getResposta(String ID){
        for(FolhaResposta fr : respostas){
            Avaliacao av = fr.getAval();
            if(av.getID().equals(ID))
                return fr;
        }
        return null;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    //Consultar nota
    public float consultaNota(String ID){
        FolhaResposta fr = this.getResposta(ID);
        return fr.getNota();
    }   
    public void preencherRespostaTrabalho(String ID, String texto){
        FolhaResposta fr = this.getResposta(ID);
        fr.preencherFolhaResposta(texto);
    }
    public void preencherRespostaProva(String ID, String resposta, int i){
        
        FolhaResposta fr = this.getResposta(ID);
        fr.preencherFolhaResposta(i, resposta);
    }
    //Visualizar prova
    public ArrayList<String> visualizaAvaliacaoProva(String ID){
        FolhaResposta fr = this.getResposta(ID);
        return fr.getAval().getQuestoesProva();
    }
    //Visualizar trabalho
    public String visualizaAvaliacaoTrabalho(String ID){
        for(FolhaResposta fr : respostas){
            Avaliacao av = fr.getAval();
            if(av.getID().equals(ID)){
                getResposta(ID);
                return fr.getAval().getQuestoesTrabalho();
            }
        }
        return null;
    }
}