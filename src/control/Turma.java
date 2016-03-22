package control;

import java.util.ArrayList;
import model.Aluno;
import util.Logavel;
import model.Avaliacao;
import model.Prova;
import model.Trabalho;

/**
 *
 * @author Elias
 * Neste caso Turma faz o papel do Professor
 */
public class Turma implements Logavel {
    private String senha;
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
    
    public Turma(String s){
        senha = s;
    }
    
    public ArrayList<Aluno> getAlunos(){
        return alunos;
    }
    
    @Override
    public boolean verificarSenha(String senha){
        return this.senha.equals(senha);
    }
    public boolean verificarSenhaAluno(String mat, String senha){
        for(Aluno a : alunos){
            if(a.getMatricula().equals(mat)){
                return a.verificarSenha(senha);
            }
        }
        return false;
    }
    
    @Override
    public boolean alterarSenha(String atual, String nova){
        if( senha.equals(atual) ){
            senha = nova;
            return true;
        }
        return false;
    }
    //Dar nota pro aluno
    public void darNota(String matricula, String ID, float nota){
        for(Aluno a : alunos){
            if(a.getMatricula().equals(matricula)){
                a.getResposta(ID).setNota(nota);
            }
        }
    }
    public void incluirAvaliacaoTrabalho(String ID, String descricao){
        Avaliacao av = new Trabalho();
        av.setTexto(descricao);
        av.setID(ID);
        avaliacoes.add(av);
    }
    public void incluirAvaliacaoProva(String ID, ArrayList<String> questoes){
        Avaliacao av = new Prova();
        av.setTexto(questoes);
        av.setID(ID);
        avaliacoes.add(av);
    }
    public void criaAluno(String nome, String matricula, String senha){
        Aluno a = new Aluno(nome, matricula, senha);
        this.alunos.add(a);
    }
    public float consultaNota(String ID, String nome, String matricula, String senha){
        Aluno a = new Aluno(nome, matricula, senha);
        for(Avaliacao av : avaliacoes){
            if(av.getID().equals(ID)){
                return a.consultaNota(ID);
            }
        }
        return -1;
    }
    public ArrayList<String> visualizaFolhaRespostaProva(String ID, String mat){ 
        for(Aluno a : alunos){
            if(a.getMatricula().equals(mat)){
                for(Avaliacao av : avaliacoes){
                    if(av.getID().equals(ID)){
                        return a.visualizaAvaliacaoProva(ID);
                    }
                }
            }    
        } 
        return null;
    }
    public String visualizaFolhaRespostaTrabalho(String ID, String mat){
        for(Aluno a : alunos){
            if(a.getMatricula().equals(mat)){
                for(Avaliacao av : avaliacoes){
                    System.out.println(av.getID());
                    if(av.getID().equals(ID)){
                        return a.visualizaAvaliacaoTrabalho(ID);
                    }
                }
            }
        }    
        return null;
    }
    public void preencherRespostaTrabalho(String ID, String texto){
        for(Aluno a : alunos){
            for(Avaliacao av : avaliacoes){
                if(av.getID().equals(ID)){
                    a.preencherRespostaTrabalho(ID, texto);
                }
            }   
        }
    }
    public void preencherRespostaProva(String ID, String resposta, int i){
        for(Aluno a : alunos){
            for(Avaliacao av : avaliacoes){
                if(av.getID().equals(ID)){
                    a.preencherRespostaProva(ID, resposta, i);
                }
            }   
        }
    }
    public boolean comparaID(String ID){
        int i=0;
        for(Avaliacao av : avaliacoes){
            if(av.getID().equals(ID)){
                return true;
            }
        }
        return false;
    }
    public void criaAvaliacao(int tipo){
        Avaliacao av = Avaliacao.criaAvaliacao(tipo);
    }
}