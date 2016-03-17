package view;

import control.Turma;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Elias
 */
public class GerenciaTurma {
    private ArrayList<Turma> turmas;
    Scanner ler = new Scanner(System.in);

    public int menu1() {
        int op;
        System.out.println("----------------------MENU1---------------------");
        System.out.println("O que você é?");
        System.out.println("1- Aluno");
        System.out.println("2- Professor");
        System.out.println("3- Sair");
        System.out.println("----------------------MENU1---------------------");
        System.out.println("Digite a opção desejada: ");
        op = ler.nextInt();
        return op;
    }

    public int menu2() {
        int op;
        System.out.println("----------------------MENU2---------------------");
        System.out.println("1- Visualizar as avaliações");
        System.out.println("2- Preencher folhas de resposta de Prova");
        System.out.println("3- Preencher folhas de reposta de Trabalho");
        System.out.println("4- Consultar nota");
        System.out.println("5- Sair");
        System.out.println("----------------------MENU2---------------------");
        System.out.println("Digite a opção desejada: ");
        op = ler.nextInt();
        return op;
    }

    public int menu3() {
        int op;
        System.out.println("----------------------MENU3---------------------");
        System.out.println("1- Criar uma turma");
        System.out.println("2- Adicionar aluno");
        System.out.println("3- Visualizar a folha de resposta de um aluno");
        System.out.println("4- Dar nota para um aluno");
        System.out.println("5- Incluir questões de uma Prova (Avaliação)");
        System.out.println("6- Incluir Trabalho (Avaliação)");
        System.out.println("7- Sair");
        System.out.println("----------------------MENU3---------------------");
        System.out.println("Digite a opção desejada: ");
        op = ler.nextInt();
        return op;
    }

    //Main Gerencia Turma que lida diretamente com a classe Turma
    //A classe Turma (control) que faz a ligação com as outras classes
    public static void main(String[] args) throws Exception {
        GerenciaTurma gt = new GerenciaTurma();
        Scanner ler = new Scanner(System.in);
        Turma t1 = new Turma("12345"); //cria a turma definindo a senha
        String senhaAluno;
        String senhaProfessor;
        //----------------------------------------------------------------------
        int result1;
        result1 = gt.menu1(); //Menu1 para escolher entre Aluno ou Professor

        while (result1 != 3) {
            switch (result1) {
                case 1: //Aluno
                    System.out.println("Digite sua matricula: ");
                    String mat = ler.next();
                    System.out.println("Digite sua senha: ");
                    senhaAluno = ler.next();
                    if (t1.verificarSenhaAluno(mat, senhaAluno) == true) {
                        System.out.println("Seja Bem-Vindo!");
                        int result2 = gt.menu2();  //Menu2 de opções do Aluno
                        while (result2 != 5) {
                            switch (result2) {
                                case 1: { //Visualizar as avaliações
                                    char answer;
                                    do{
                                        System.out.println("Digite o ID da avaliação: ");
                                        String ID = ler.next();
                                        if(t1.comparaID(ID) == false){
                                            System.out.println("Avaliação não encontrada!");
                                            break;
                                        }
                                        System.out.println("Digite a matricula: ");
                                        mat = ler.next();
                                        System.out.println("Visualizar Trabalho(1) ou Prova(2)? ");
                                        int result = ler.nextInt();
                                        if(result == 1){
                                            System.out.println(t1.visualizaFolhaRespostaTrabalho(ID, mat));
                                        }
                                        else if(result == 2){
                                            ArrayList<String> view = t1.visualizaFolhaRespostaProva(ID, mat);
                                            for(int i=0; i<view.size(); i++){
                                                System.out.println(view.get(i));
                                            }
                                        }
                                        else{
                                            System.out.println("Opção inválida!");
                                        }
                                        System.out.println("Quer visualizar outra avaliaçao? [S ou N?]");
                                        answer = (char) System.in.read();
                                    }while(answer == 'S' || answer == 's');
                                    break;
                                }
                                case 2: { //Preencher folhas de resposta de Prova
                                    char answer;
                                    do{ 
                                        System.out.println("Digite o ID da avaliação: ");
                                        String ID = ler.next();
                                        if(t1.comparaID(ID) == false){
                                            System.out.println("Avaliação não encontrada!");
                                            break;
                                        }
                                        System.out.println("Qual o número da questão que você deseja adicionar? ");
                                        int numQuest = ler.nextInt();
                                        System.out.println("Digite a sua resposta para esta questão: ");
                                        String resp = ler.next();
                                        t1.preencherRespostaProva(ID, resp, numQuest);
                                        System.out.println("Resposta da prova adicionada com sucesso!");
                                        System.out.println("Quer adicionar mais questões nesta prova? [S ou N?]");
                                        answer = (char) System.in.read();
                                    } while(answer == 'S' || answer == 's');
                                    break;
                                }
                                case 3: { //Preencher folhas de resposta de Trabalho
                                    System.out.println("Digite o ID da avaliação: ");
                                    String ID = ler.next();
                                    if(t1.comparaID(ID) == false){
                                            System.out.println("Avaliação não encontrada!");
                                            break;
                                        }
                                    System.out.println("Digite a sua resposta para o trabalho: ");
                                    String resp = ler.next();
                                    t1.preencherRespostaTrabalho(ID, resp);
                                    System.out.println("Resposta do trabalho adicionada com sucesso!");
                                    break;
                                }
                                case 4: { // Consultar nota
                                    char answer;
                                    do{
                                        System.out.println("Digite seu nome: ");
                                        String name = ler.next();
                                        System.out.println("Digite sua matricula: ");
                                        mat = ler.next();
                                        System.out.println("Digite sua senha: ");
                                        senhaAluno = ler.next();
                                        System.out.println("Digite o ID da avaliação: ");
                                        String ID = ler.next();
                                        if(t1.comparaID(ID) == false){
                                            System.out.println("Avaliação não encontrada!");
                                            break;
                                        }
                                        float nota = t1.consultaNota(ID, name, mat, senhaAluno);
                                        System.out.println("A nota é: " + nota);
                                        System.out.println("Quer consultar nota de outro aluno [S ou N?]");
                                        answer = (char)System.in.read();
                                    } while(answer == 'S' || answer == 's');
                                    break;
                                }
                                case 5: //Sair
                                    break;
                            }
                            result2 = gt.menu2();
                        }
                    } else {
                        System.out.println("Senha incorreta!");
                        gt.menu1();
                    }
                    break;
                    case 2: //Professor
                        char answer = 'N';
                        int result3 = gt.menu3();  //Menu3 de opções do Professor
                        while (result3 != 7) {
                            System.out.println("Digite sua senha: ");
                            senhaProfessor = ler.next();
                            switch (result3) {
                                case 1: { //Criando uma turma
                                    if (t1.verificarSenha(senhaProfessor) == false) {
                                        System.out.println("Senha inválida!");
                                        break;
                                    } else{
                                    System.out.println("Turma criada com sucesso!");
                                    System.out.println("-------------------------------------------");
                                    System.out.println("Quer adicionar aluno(s) na turma? [S ou N?]");
                                    answer = (char) System.in.read();
                                    while (answer == 'S' || answer == 's') {
                                        System.out.println("Digite o nome do aluno: ");
                                        String name = ler.next();
                                        System.out.println("Digite a matrícula do aluno: ");
                                        mat = ler.next();
                                        System.out.println("Digite a senha do aluno: ");
                                        senhaAluno = ler.next();
                                        t1.criaAluno(name, mat, senhaAluno);                                        
                                        System.out.println("Quer adicionar aluno(s) na turma? [S ou N?]");
                                        answer = (char) System.in.read();
                                    }
                                    gt.menu3();
                                    break;
                                    }
                                }
                                case 2: { //Adicionar aluno
                                    System.out.println("Digite sua senha: ");
                                    senhaProfessor = ler.next();
                                    if (t1.verificarSenha(senhaProfessor) == true) {
                                        do {
                                            System.out.println("Digite o nome do aluno: ");
                                            String name = ler.next();
                                            System.out.println("Digite a matrícula do aluno: ");
                                            mat = ler.next();
                                            System.out.println("Digite a senha do aluno: ");
                                            senhaAluno = ler.next();
                                            if(t1.verificarSenha(senhaAluno) == true){
                                                t1.criaAluno(name, mat, senhaAluno);
                                            }
                                            System.out.println("Deseja adicionar outro aluno [S ou N?]");
                                            answer = (char) System.in.read();
                                        } while (answer == 'S' || answer == 's');
                                    }
                                }
                                case 3: { //Visualizar a folha de resposta de um aluno
                                    System.out.println("Digite o ID da avaliação: ");
                                    String ID = ler.next();
                                    if(t1.comparaID(ID) == false){
                                            System.out.println("Avaliação não encontrada!");
                                            break;
                                    }
                                    System.out.println("Digite a matricula: ");
                                    mat = ler.next();
                                    System.out.println("Visualizar Trabalho(1) ou Prova(2)? ");
                                    int result = ler.nextInt();
                                    if(result == 1){
                                        System.out.println(t1.visualizaFolhaRespostaTrabalho(ID, mat));
                                    }
                                    else if(result == 2){
                                        ArrayList<String> view = t1.visualizaFolhaRespostaProva(ID, mat);
                                        for(int i=0; i<view.size(); i++){
                                            System.out.println(view.get(i));
                                        }
                                    }
                                    else{
                                        System.out.println("Opção inválida!");
                                    }
                                    break;
                                }
                                case 4: {  //Dar nota para um aluno
                                    System.out.println("Digite a matricula do aluno: ");
                                    mat = ler.next();
                                    System.out.println("Qual o ID da avaliação? ");
                                    String ID = ler.next();
                                    if(t1.comparaID(ID) == false){
                                            System.out.println("Avaliação não encontrada!");
                                            break;
                                    }
                                    System.out.println("Digite a nota: ");
                                    float nota = ler.nextFloat();
                                    t1.darNota(mat, ID, nota);
                                    break;
                                }
                                case 5: { //Incluir questões de uma Prova (Avaliação)
                                    char resp;
                                    do {
                                        ArrayList<String> questoes = new ArrayList<>();
                                        System.out.println("Digite o ID da avaliação: ");
                                        String ID = ler.next();
                                        if(t1.comparaID(ID) == false){
                                            System.out.println("Avaliação não encontrada!");
                                            System.out.println("Deseja criar uma Prova [S ou N?]");
                                            resp = (char) System.in.read();
                                            if(resp == 'N' || resp == 'n'){
                                                break;
                                            }
                                            if(resp == 'S' || resp == 's'){
                                                t1.criaAvaliacao(1);
                                                do {
                                                    System.out.println("Digite a questão: ");
                                                    String questao = ler.next();
                                                    questoes.add(questao);
                                                    System.out.println("Questao da Prova adicionada!");
                                                    System.out.println("Quer adicionar mais uma questão nesta Prova [S ou N]? ");
                                                    resp = (char) System.in.read();
                                                } while (resp == 'S' || resp == 's');
                                                t1.incluirAvaliacaoProva(ID, questoes);
                                            }
                                            break;
                                        }else{
                                            do {
                                                System.out.println("Digite a questão: ");
                                                String questao = ler.next();
                                                questoes.add(questao);
                                                System.out.println("Questao da Prova adicionada!");
                                                System.out.println("Quer adicionar mais uma questão nesta Prova [S ou N]? ");
                                                resp = (char) System.in.read();
                                            } while (resp == 'S' || resp == 's');
                                            t1.incluirAvaliacaoProva(ID, questoes);
                                        }
                                    } while (answer == 'S' || answer == 's');
                                    break;
                                }
                                case 6: { //Incluir Trabalho (Avaliação)
                                    char resp;
                                    System.out.println("Digite o ID da avaliação: ");
                                    String ID = ler.next();
                                    if(t1.comparaID(ID) == false){
                                        System.out.println("Avaliação não encontrada!");
                                        System.out.println("Deseja criar um Trabalho [S ou N?]");
                                        resp = (char) System.in.read();
                                        if(resp == 'S' || resp == 's'){
                                            System.out.println("Digite a descrição do Trabalho: ");
                                            String descricao = ler.next();
                                            t1.criaAvaliacao(2);
                                            t1.incluirAvaliacaoTrabalho(ID, descricao);
                                            System.out.println("Questao do Trabalho adicionada!");
                                        }
                                        break;
                                    }else{
                                        System.out.println("Digite a descrição do Trabalho: ");
                                        String descricao = ler.next();
                                        t1.incluirAvaliacaoTrabalho(ID, descricao);
                                        System.out.println("Questao do Trabalho adicionada!");
                                        break;
                                    }
                                }
                                case 7: { //Sair
                                    break;
                                }
                            }
                            result3 = gt.menu3();
                        }
                        break;
                    case 3: //Sair
                        System.exit(0);
                }
            result1 = gt.menu1();
        }
    }
}