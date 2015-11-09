package com.example.paulo.inovacao;

/**
 * Created by Paulo on 27/10/2015.
 */
public class Diarista {
   private String nome, login, senha, preco, servicos, idade;
    int imagem;


    public int getImagem(){
        return imagem;
    }

    public void setImagem(int imagem){
        this.imagem = imagem;
    }

    public String getIdade(){
        return idade;
    }

    public void setIdade(String idade){
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getServicos() {
        return servicos;
    }

    public void setServicos(String servicos) {
        this.servicos = servicos;
    }

    public Diarista(String nome, String login, String preco, String servicos, String idade, int imagem){
            this.nome = nome;
            this.login = login;
            this.preco = preco;
            this.servicos = servicos;
            this.idade = idade;
            this.imagem = imagem;
    }
}
