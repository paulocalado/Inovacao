package com.example.paulo.inovacao.entidades;

import java.util.ArrayList;

/**
 * Created by Paulo on 27/10/2015.
 */
public class Diarista {
   private String nome;
    private String login;
    private String senha;
    private String preco;
    private String servicos;
    private String idade;

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    private boolean ocupada;

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    private String regiao;

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

    public Diarista(String nome, String login, String preco, String servicos, String idade, int imagem, String regiao){
            this.nome = nome;
            this.login = login;
            this.preco = preco;
            this.servicos = servicos;
            this.idade = idade;
            this.imagem = imagem;
            this.regiao = regiao;
            this.ocupada = false;
    }
}
